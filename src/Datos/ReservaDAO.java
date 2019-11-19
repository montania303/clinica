/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Ingreso;
import Modelo.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
    
public class ReservaDAO implements IDAO{
    Connection con = null;
    ArrayList lista = new ArrayList();
    Ingreso ingreso = new Ingreso();
    Reserva reserva = new Reserva();
    
    public ReservaDAO(){
        con = new Conexion().conectar();
    }

    @Override
    public ArrayList listar(String condicion) {
        try {
            String SSQL = "SELECT * FROM ingreso " + condicion;
            PreparedStatement ps = con.prepareStatement(SSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               ingreso = new Ingreso(
                        rs.getInt("nro_ingreso"),
                        rs.getInt("habitacion"),
                        rs.getString("cama"),
                        rs.getDate("fecha_ingreso"),
                        rs.getInt("codigo_paciente"),
                        rs.getInt("codigo_medico")
                );
                lista.add(ingreso);
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
            reserva = (Reserva) obj;
            String SSQL = "INSERT INTO reserva "
                    + "(idpaciente, nombres, apellidos, sexo, telefono, ci,"
                    + "fecha_nacimiento, nacionalidad, ciudad_de_origen,"
                    + "ciudad_actual, estado_civil, edad, conyugue, tipo_sangre,"
                    + "idmedico,medico,especialidad,fecha_reserva,turno, nro_ingreso) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SSQL);
            ps.setInt(1, reserva.getId());
            ps.setString(2, reserva.getNombres());
            ps.setString(3, reserva.getApellidos());
            ps.setString(4, reserva.getSexo());
            ps.setString(5, reserva.getTelefono());
            ps.setString(6, reserva.getCi());
            ps.setDate(7, new Date (reserva.getFecha_nacimiento().getTime()));
            ps.setString(8, reserva.getNacionalidad());
            ps.setString(9, reserva.getCiudad_de_origen());
            ps.setString(10, reserva.getCiudad_actual());
            ps.setString(11, reserva.getEstado_civil());
            ps.setInt(12, reserva.getEdad());
            ps.setString(13, reserva.getConyugue());
            ps.setString(14, reserva.getTipo_sangre());
            ps.setInt(15, reserva.getIdmedico());
            ps.setString(16, reserva.getMedico());
            ps.setString(17, reserva.getEspecialidad());
            ps.setDate(18, new Date (reserva.getFecha_reserva().getTime()));
            ps.setString(19, reserva.getTurno());
            ps.setInt(20, reserva.getNro_ingreso());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reserva realizada con Exito!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
        
    public ArrayList insertar_ingreso(Object obj){
        try {
            ingreso = (Ingreso) obj;
            String SSQL = "INSERT INTO ingreso "
                    + "(nro_ingreso, habitacion, cama, fecha_ingreso, codigo_paciente, codigo_medico)"
                    + "VALUES "
                    + "(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SSQL);
            ps.setInt(1, ingreso.getNro_ingreso());
            ps.setInt(2, ingreso.getHabitacion());
            ps.setString(3, ingreso.getCama());
            ps.setDate(4, new Date (ingreso.getFecha_ingreso().getTime()));
            ps.setInt(5, ingreso.getCodigo_paciente());
            ps.setInt(6, ingreso.getCodigo_medico());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        return null;
    }
    
    @Override
    public void modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList buscar(String nombre) {
            try {
            String sql = "SELECT nro_ingreso, "
                       + "habitacion, "
                       + "cama,"
                       + "fecha_ingreso, "
                       + "codigo_paciente,"
                       + "codigo_medico "
                       + "FROM ingreso, "
                       + "medicos "
                       + "WHERE ingreso.codigo_medico = medicos.idmedico "
                       + "and medicos.especialidad = '" + nombre + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               ingreso = new Ingreso(
                        rs.getInt("nro_ingreso"),
                        rs.getInt("habitacion"),
                        rs.getString("cama"),
                        rs.getDate("fecha_ingreso"),
                        rs.getInt("codigo_paciente"),
                        rs.getInt("codigo_medico")
                );
                lista.add(ingreso);
            }
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());            
        }
        return null;
    }

    @Override
    public ArrayList buscar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList Filtro(java.util.Date Inicio, java.util.Date Fin) {
            try {
                String sql = "SELECT * FROM reserva WHERE fecha_reserva  BETWEEN'"  + Inicio + "'"
                         + " AND '" + Fin + "'";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                   reserva = new Reserva(
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
                            rs.getInt("idmedico"),
                            rs.getString("medico"),
                            rs.getString("especialidad"),
                            rs.getDate("fecha_reserva"),
                            rs.getString("turno"),
                            rs.getInt("nro_ingreso")
                    );
                lista.add(reserva);
            }
            return lista; 
        } catch (Exception e) {
        }
        return null;
    }
    
}
