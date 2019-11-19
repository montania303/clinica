
package Controlador;

import Datos.MedicosDAO;
import Datos.IDAO;
import java.util.ArrayList;

public class MedicosController implements IDAO{

    @Override
    public ArrayList listar(String condicion) {
        return new MedicosDAO().listar (condicion );
    }

    @Override
    public void insertar(Object obj) {
        new MedicosDAO().insertar(obj);
    }

    @Override
    public void modificar(Object obj) {
        new MedicosDAO().modificar(obj);
    }

    @Override
    public void eliminar(Integer id) {
        new MedicosDAO().eliminar(id);
    
    }

    @Override
    public ArrayList buscar(String nombre) {
        return new MedicosDAO().buscar(nombre);
    }

    @Override
    public ArrayList buscar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
