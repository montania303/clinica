
package Controlador;
import Datos.IDAO;
import Datos.PacientesDAO;
import java.util.ArrayList;

public class PacienteController implements IDAO{

    @Override
    public ArrayList listar(String condicion) {
        return new PacientesDAO().listar( condicion );
    }

    @Override
    public void insertar(Object obj) {
        new PacientesDAO().insertar(obj);
    }

    @Override
    public void modificar(Object obj) {
        new PacientesDAO().modificar(obj);
    }

    @Override
    public void eliminar(Integer id) {
        new PacientesDAO().eliminar( id );
    }

    @Override
    public ArrayList buscar(String nombre) {
         return new PacientesDAO().buscar(nombre );
    }

    @Override
    public ArrayList buscar(Integer codigo) {
        return new PacientesDAO().buscar(codigo);
    }
    
}
