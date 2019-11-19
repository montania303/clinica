
package Modelo;


public class Persona {
    Integer  id;
    String nombres = " ", apellidos = " ",sexo= " ", telefono = " ";

    public Persona(Integer id, String nombres, 
              String apellidos,String sexo, String telefono) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.telefono = telefono;
    }

    public Persona() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String Sexo) {
        this.sexo = Sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombres=" + nombres + 
               ", apellidos=" + apellidos + ", Sexo=" + sexo + 
               ", telefono=" + telefono + '}';
    }


    
    
}
