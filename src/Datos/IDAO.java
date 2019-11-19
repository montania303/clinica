
package Datos;

import java.util.ArrayList;

public interface IDAO {
    public ArrayList listar( String condicion );
    public void insertar( Object obj );
    public void modificar( Object obj );
    public void eliminar( Integer id );
    public ArrayList buscar( String nombre );
    public ArrayList buscar( Integer codigo );
}
