
package Controlador;

import Datos.IDAO;
import Datos.UsuariosDAO;
import java.util.ArrayList;


public class UsuariosController implements IDAO{

    @Override
    public ArrayList listar(String condicion) {
        return new UsuariosDAO().listar(condicion);
    }

    @Override
    public void insertar(Object obj) {
        new UsuariosDAO().insertar(obj);
    }

    @Override
    public void modificar(Object obj) {
        new UsuariosDAO().modificar(obj);
    }

    @Override
    public void eliminar(Integer id) {
        new UsuariosDAO().eliminar(id);
    }   

    @Override
    public ArrayList buscar(String nombre) {
        return new UsuariosDAO().buscar(nombre);
    }

    @Override
    public ArrayList buscar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
