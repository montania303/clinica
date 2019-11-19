/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.IDAO;
import Datos.ReservaDAO;
import java.util.ArrayList;

/**
 *
 * @author Moises
 */
public class ReservaController implements IDAO {

    @Override
    public ArrayList listar(String condicion) {
        return new ReservaDAO().listar( condicion );
    }

    @Override
    public void insertar(Object obj) {
        new ReservaDAO().insertar(obj);
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
        return new ReservaDAO().buscar(nombre );
    }

    @Override
    public ArrayList buscar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
