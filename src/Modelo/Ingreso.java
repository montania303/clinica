
package Modelo;

import java.util.Date;

public class Ingreso {
   Integer nro_ingreso, habitacion ,codigo_paciente , codigo_medico;
   String cama;
   Date fecha_ingreso;

    public Ingreso(Integer nro_ingreso, Integer habitacion, String cama, 
                   Date fecha_ingreso, Integer codigo_paciente, 
                   Integer codigo_medico) {
        this.nro_ingreso = nro_ingreso;
        this.habitacion = habitacion;
        this.cama = cama;
        this.fecha_ingreso = fecha_ingreso;
        this.codigo_paciente = codigo_paciente;
        this.codigo_medico = codigo_medico;
    }

    public Ingreso() {
        
    }

    public Integer getNro_ingreso() {
        return nro_ingreso;
    }

    public void setNro_ingreso(Integer nro_ingreso) {
        this.nro_ingreso = nro_ingreso;
    }

    public Integer getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Integer habitacion) {
        this.habitacion = habitacion;
    }

    public Integer getCodigo_paciente() {
        return codigo_paciente;
    }

    public void setCodigo_paciente(Integer codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }

    public Integer getCodigo_medico() {
        return codigo_medico;
    }

    public void setCodigo_medico(Integer codigo_medico) {
        this.codigo_medico = codigo_medico;
    }

    public String getCama() {
        return cama;
    }

    public void setCama(String cama) {
        this.cama = cama;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    @Override
    public String toString() {
        return "Ingreso{" + "nro_ingreso=" + nro_ingreso + ", habitacion=" 
               + habitacion + ", codigo_paciente=" + codigo_paciente + 
               ", codigo_medico=" + codigo_medico + ", cama=" + cama + 
                ", fecha_ingreso=" + fecha_ingreso + '}';
    }
}
