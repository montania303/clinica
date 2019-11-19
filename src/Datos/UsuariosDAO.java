package Datos;

import Modelo.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuariosDAO implements IDAO{
    Connection con = null;
    ArrayList lista = new ArrayList();
    ArrayList lista2 = new ArrayList();
    Usuarios usuario = null;
    
    public UsuariosDAO () {
        con = new Conexion().conectar();
    }
    @Override
    public ArrayList listar(String condicion) {
        try {
            String SSQL = "SELECT * FROM usuarios " + condicion;
            PreparedStatement ps = con.prepareStatement(SSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new Usuarios (
                    rs.getString("nombre"),
                    rs.getString("contrasenha"),
                    rs.getString("tipo"), 
                    rs.getInt("id")
                );
                lista.add(usuario);
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
            usuario = (Usuarios) obj;
            String SSQL = "INSERT INTO usuarios" 
               +"(nombre, contrasenha, tipo, id)"
               + "VALUES "
               + "(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SSQL);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContrasenha());
            ps.setString(3, usuario.getTipo());
            ps.setInt(4, usuario.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void modificar(Object obj) {
        try {
            usuario = (Usuarios) obj;
            String SSQL = "UPDATE usuarios SET"
               + " nombre=?,"
               + " contrasenha=?,"
               + " tipo=? WHERE id=? ";
            PreparedStatement ps = con.prepareStatement(SSQL);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContrasenha());
            ps.setString(3, usuario.getTipo());
            ps.setInt(4, usuario.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override 
    public void eliminar(Integer id) {
        
        try {
            String SSQL = "DELETE FROM usuarios WHERE id = ? ";
            PreparedStatement ps = con.prepareStatement(SSQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }   

    @Override
    public ArrayList buscar(String nombre) {
        try {
            String sql = "SELECT * FROM usuarios WHERE nombre like '%" + nombre + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               usuario = new Usuarios(
                    rs.getString("nombre"),
                    rs.getString("contrasenha"),
                    rs.getString("tipo"),
                    rs.getInt("id")
                );
                lista2.add(usuario);
            }
            return lista2;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "No existe Registro");
            
        }
        return null;
    }
    public Usuarios logueo(String username, String password) throws Exception{
        Usuarios user = new Usuarios();
        String sql = "SELECT * FROM usuarios WHERE nombre=? AND contrasenha=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user.setNombre(rs.getString("nombre"));
            user.setContrasenha(rs.getString("contrasenha"));
            user.setTipo(rs.getString("tipo")); 
            user.setId(rs.getInt("id"));
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario");
            return null;
        }
         return user;
    }

    @Override
    public ArrayList buscar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
