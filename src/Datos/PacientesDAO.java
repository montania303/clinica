
package Datos;

import Modelo.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PacientesDAO  implements IDAO{

    Connection con = null;
    ArrayList lista = new ArrayList();
    ArrayList lista2 = new ArrayList();
    Paciente paciente = null;
   
    public PacientesDAO(){
        con = new Conexion().conectar();
    }
     
    @Override
    public ArrayList listar(String condicion) {
        try {
            String SSQL = "SELECT * FROM pacientes " + condicion;
            PreparedStatement ps = con.prepareStatement(SSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               paciente = new Paciente(
                        rs.getInt("idpaciente"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("sexo"),
                        rs.getString("telefono"),
                        rs.getString("ci"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("nacionalidad"),
                        rs.getString("ciudad_de_origen"),
                        rs.getString("ciudad_actual"),
                        rs.getString("estado_civil"),
                        rs.getInt("edad"),
                        rs.getString("conyugue"),
                        rs.getString("tipo_sangre"),
                        rs.getDate("fecha_ingresada")
                );
                lista.add(paciente);
            }
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    @Override
    public void insertar(Object obj) {
        try {
            paciente = (Paciente) obj;
            String SSQL = "INSERT INTO pacientes "
                    + "(idpaciente,nombres,apellidos,sexo,telefono,ci,"
                    + "fecha_nacimiento,nacionalidad,ciudad_de_origen,"
                    + "ciudad_actual,estado_civil,edad,conyugue, tipo_sangre,"
                    + "fecha_ingresada)"
                    + "VALUES "
                    + "(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SSQL);
            JOptionPane.showMessageDialog(null, SSQL);
            ps.setInt(1, paciente.getId());
            ps.setString(2, paciente.getNombres());
            ps.setString(3, paciente.getApellidos());
            ps.setString(4, paciente.getSexo());
            ps.setString(5, paciente.getTelefono());
            ps.setString(6, paciente.getCI());
            ps.setDate(7, new Date (paciente.getFecha_nacimiento().getTime()));
            ps.setString(8, paciente.getNacionalidad());
            ps.setString(9, paciente.getCiudad_de_origen());
            ps.setString(10, paciente.getCiudad_actual());
            ps.setString(11, paciente.getEstado_civil());
            ps.setInt(12, paciente.getEdad());
            ps.setString(13, paciente.getConyugue());
            ps.setString(14, paciente.getTipo_sangre());
            ps.setDate(15, new Date (paciente.getFecha_ingresada().getTime()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro insertado con Exito!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void modificar(Object obj) {
        try {
             paciente = (Paciente) obj;
            //cargo = (Cargos) cargosControl.listar("Where descripcion ='"+funcionario.getCargo()+"'").get(0);
            String SSQL = "UPDATE pacientes SET "
                    + "nombres=?, "
                    + "apellidos=?, "
                    + "sexo=?, "
                    + "telefono=?, "
                    + "ci=?, "
                    + "fecha_nacimiento=?,"
                    + "nacionalidad=?,"
                    + "ciudad_de_origen=?,"
                    + "ciudad_actual=?,"
                    + "estado_civil=?,"
                    + "edad=?,"
                    + "conyugue=?,"
                    + "tipo_sangre=?,"
                    + "fecha_ingresada=? WHERE idpaciente=?";
            PreparedStatement ps = con.prepareStatement(SSQL);
            ps.setString(1, paciente.getNombres());
            ps.setString(2, paciente.getApellidos());
            ps.setString(3, paciente.getSexo());
            ps.setString(4, paciente.getTelefono());
            ps.setString(5, paciente.getCI()); 
            ps.setDate(6, new Date(paciente.getFecha_nacimiento().getTime()));
            ps.setString(7, paciente.getNacionalidad());
            ps.setString(8, paciente.getCiudad_de_origen());
            ps.setString(9, paciente.getCiudad_actual());
            ps.setString(10, paciente.getEstado_civil());
            ps.setInt(11, paciente.getEdad());
            ps.setString(12, paciente.getConyugue());
            ps.setString(13, paciente.getTipo_sangre());
            ps.setDate(14, new Date(paciente.getFecha_ingresada().getTime()));
            ps.setInt(15, paciente.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualizacion de datos realizada exitosamente..!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "Se produjo algun error al intentar actualizar los datos");
        }
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList buscar(String nombres){ 
        try {
            String sql = "SELECT * FROM pacientes WHERE nombres like '%" + nombres + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               paciente = new Paciente(
                        rs.getInt("idpaciente"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("sexo"),
                        rs.getString("telefono"),
                        rs.getString("ci"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("nacionalidad"),
                        rs.getString("ciudad_de_origen"),
                        rs.getString("ciudad_actual"),
                        rs.getString("estado_civil"),
                        rs.getInt("edad"),
                        rs.getString("conyugue"),
                        rs.getString("tipo_sangre"),
                        rs.getDate("fecha_ingresada")
                );
                lista2.add(paciente);
            }
            return lista2;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "No existe Registro");
            
        }
        return null;
    }

    @Override
    public ArrayList buscar(Integer codigo) {
        try {
            String sql = "SELECT * FROM pacientes WHERE idpaciente = '" + codigo + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               paciente = new Paciente(
                        rs.getInt("idpaciente"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("sexo"),
                        rs.getString("telefono"),
                        rs.getString("ci"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("nacionalidad"),
                        rs.getString("ciudad_de_origen"),
                        rs.getString("ciudad_actual"),
                        rs.getString("estado_civil"),
                        rs.getInt("edad"),
                        rs.getString("conyugue"),
                        rs.getString("tipo_sangre"),
                        rs.getDate("fecha_ingresada")
                );
                lista2.add(paciente);
            }
            return lista2;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "No existe Registro");
            
        }
        return null;
    }
}