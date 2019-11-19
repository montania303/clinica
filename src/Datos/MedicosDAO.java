
package Datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Modelo.Medicos;

public class MedicosDAO implements IDAO{
    Connection con = null;
    ArrayList lista = new ArrayList ();
    ArrayList lista2 = new ArrayList ();
    Medicos medico = null;
    
    public MedicosDAO (){
        con = new Conexion ().conectar();
    }
    
    @Override
    public ArrayList listar (String condicion){
        try {
            String SSQL = "Select * FROM medicos " + condicion;
            PreparedStatement ps = con.prepareStatement(SSQL);
            ResultSet rs = ps.executeQuery();       
            while (rs.next()){
                medico = new Medicos (
                    rs.getInt("idmedico"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("telefono"),
                    rs.getString("especialidad")
                );
                lista.add(medico); 
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
            medico = (Medicos) obj;
            String SSQL = "INSERT INTO medicos "
                    + "(idmedico, nombres, apellidos, telefono, especialidad) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?) ";
            PreparedStatement ps = con.prepareStatement(SSQL);
            ps.setInt(1, medico.getId());
            ps.setString(2, medico.getNombres());
            ps.setString(3, medico.getApellidos());
            ps.setString(4, medico.getTelefono());
            ps.setString(5, medico.getEspecialidad());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medico Registrado con exito");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void modificar(Object obj) {
        try {
            medico = (Medicos) obj;
            String SSQL = "UPDATE medicos SET "
                    + "nombres=?, "
                    + "apellidos=?, "
                    + "telefono=?, "
                    + "especialidad=? WHERE Idmedico=?";
            PreparedStatement ps = con.prepareStatement(SSQL);
            ps.setString(1, medico.getNombres());
            ps.setString(2, medico.getApellidos());
            ps.setString(3, medico.getTelefono());
            ps.setString(4, medico.getEspecialidad());
            ps.setInt (5, medico.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            String SSQL = "DELETE FROM medicos WHERE idmedico=?";
            PreparedStatement ps = con.prepareStatement(SSQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    public ArrayList buscar(String nombre) {
        try {
            String sql = "SELECT * FROM medicos WHERE nombres like '%" + nombre + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               medico = new Medicos(
                        rs.getInt("idmedico"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getString("especialidad")
                );
                lista2.add(medico);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
