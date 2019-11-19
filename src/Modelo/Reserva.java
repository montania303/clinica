
package Modelo;

import java.util.Date;

public class Reserva {
    Integer edad,idmedico,id,nro_ingreso;
    String nombres, apellidos, sexo, telefono, ci, nacionalidad, ciudad_de_origen,
           ciudad_actual, estado_civil, conyugue, tipo_sangre,medico,
           especialidad,turno;
    Date fecha_reserva,fecha_nacimiento;

    public Reserva(Integer id, String nombres, String apellidos, String sexo, 
                   String telefono, String ci, Date fecha_nacimiento,
                   String nacionalidad, String ciudad_de_origen, 
                   String ciudad_actual, String estado_civil, Integer edad, 
                   String conyugue, String tipo_sangre, Integer idmedico, 
                   String medico, String especialidad, 
                   Date fecha_reserva, String turno, Integer nro_ingreso ) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.telefono = telefono;
        this.ci = ci;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.ciudad_de_origen = ciudad_de_origen;
        this.ciudad_actual = ciudad_actual;
        this.estado_civil = estado_civil;
        this.edad = edad;
        this.conyugue = conyugue;
        this.tipo_sangre = tipo_sangre;
        this.idmedico = idmedico;        
        this.medico = medico;
        this.especialidad = especialidad;
        this.fecha_reserva = fecha_reserva;
        this.turno = turno;
        this.nro_ingreso = nro_ingreso;
    }

    public Reserva() {
    
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNro_ingreso() {
        return nro_ingreso;
    }

    public void setNro_ingreso(Integer nro_ingreso) {
        this.nro_ingreso = nro_ingreso;
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

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCiudad_de_origen() {
        return ciudad_de_origen;
    }

    public void setCiudad_de_origen(String ciudad_de_origen) {
        this.ciudad_de_origen = ciudad_de_origen;
    }

    public String getCiudad_actual() {
        return ciudad_actual;
    }

    public void setCiudad_actual(String ciudad_actual) {
        this.ciudad_actual = ciudad_actual;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getConyugue() {
        return conyugue;
    }

    public void setConyugue(String conyugue) {
        this.conyugue = conyugue;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Reserva{" + "edad=" + edad + ", idmedico=" + idmedico + 
               ", id=" + id + ", nro_ingreso=" + nro_ingreso + ", nombres=" + 
               nombres + ", apellidos=" + apellidos + ", sexo=" + sexo + 
               ", telefono=" + telefono + ", ci=" + ci + ", nacionalidad=" + 
               nacionalidad + ", ciudad_de_origen=" + ciudad_de_origen + 
               ", ciudad_actual=" + ciudad_actual + ", estado_civil=" + 
               estado_civil + ", conyugue=" + conyugue + ", tipo_sangre=" + 
               tipo_sangre + ", medico=" + medico + ", especialidad=" + 
               especialidad + ", turno=" + turno + ", fecha_reserva=" + 
               fecha_reserva + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }

}
