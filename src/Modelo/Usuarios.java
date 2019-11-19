
package Modelo;

public class Usuarios {
   String nombre = " ";
   String contrasenha = " ";
   String tipo = " ";
   Integer id = 0;
    
    public Usuarios () {
        
    }
    
    public Usuarios (String nombre,String contrasenha,String tipo, Integer id) {
        this.nombre = nombre;
        this.contrasenha= contrasenha;
        this.tipo = tipo;
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", contrasenha=" + contrasenha + '}';
    }
}
