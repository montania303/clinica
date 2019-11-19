
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    public String db = "SISTEMA_clinico";
    
    // postgreSql
    public String url = "jdbc:postgresql://localhost:5432/"+db; 
    public String user = "postgres";
    public String pass = "metallica";
    public String driver = "org.postgresql.Driver";    
    
    
    public Connection conectar(){
        Connection link = null;
        try {
            // postgreSql            
            Class.forName(driver);
            link = (Connection) DriverManager.getConnection(this.url
                    , this.user, this.pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }
    
    
}

