
package Modelo;

public class Medicos{
    Integer id;
    String especialidad,nombres, apellidos,telefono;

    public Medicos(Integer id, String nombres, String apellidos, 
                   String telefono, String especialidad ) {
        this.id = id;
        this.especialidad = especialidad;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Medicos{" + "id=" + id + ", especialidad=" + especialidad + 
               ", nombres=" + nombres + ", apellidos=" + apellidos + 
               ", telefono=" + telefono + '}';
    }
    
    
    
    
    
}
