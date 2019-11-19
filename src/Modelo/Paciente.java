/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;


public class Paciente extends Persona {
    Integer edad = 0;
    String ci =" ", nacionalidad = " ",
            ciudad_de_origen = " ",ciudad_actual = " ",estado_civil = " ",
            conyugue = " ", tipo_sangre = " ";
    Date fecha_ingresada,fecha_nacimiento;

    public Paciente(Integer id, String nombres, String apellidos, 
                    String sexo,String telefono, String ci,
                    Date fecha_nacimiento, String nacionalidad, 
                    String ciudad_de_origen,String ciudad_actual, 
                    String estado_civil,Integer edad,String conyugue, 
                    String tipo_sangre, Date fecha_ingresada) {
        super(id, nombres, apellidos,sexo, telefono);
          this.edad = edad;
          this.ci = ci;
          this.fecha_nacimiento = fecha_nacimiento;
          this.nacionalidad = nacionalidad;
          this.ciudad_de_origen = ciudad_de_origen;
          this.ciudad_actual = ciudad_actual;
          this.estado_civil = estado_civil;
          this.conyugue = conyugue;
          this.tipo_sangre = tipo_sangre;
          this.fecha_ingresada = fecha_ingresada;
    }

    public Paciente() {
    
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String Sexo) {
        this.sexo = Sexo;
    }

    public String getCI() {
        return ci;
    }

    public void setCI(String CI) {
        this.ci = ci;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public Date getFecha_ingresada() {
        return fecha_ingresada;
    }

    public void setFecha_ingresada(Date fecha_ingresada) {
        this.fecha_ingresada = fecha_ingresada;
    }

    @Override
    public String toString() {
        return "Paciente{" + "edad=" + edad + ", ci=" + ci + ", nacionalidad=" + nacionalidad + ", ciudad_de_origen=" + ciudad_de_origen + ", ciudad_actual=" + ciudad_actual + ", estado_civil=" + estado_civil + ", conyugue=" + conyugue + ", tipo_sangre=" + tipo_sangre + ", fecha_ingresada=" + fecha_ingresada + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }





    
    
    
}
