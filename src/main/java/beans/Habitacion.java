
package beans;

import java.sql.Date;

public class Habitacion {
    private int id_habitacion;
    private String piso;
    private String tipo;
    private String descripcion;
    private String ciudad;
    private int precio_dia;
    private boolean novedad;
    private Date fecha_ingreso;

    public Habitacion(int id_habitacion, String piso, String tipo, String descripcion, String ciudad, int precio_dia, boolean novedad, Date fecha_ingreso) {
        this.id_habitacion = id_habitacion;
        this.piso = piso;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.precio_dia = precio_dia;
        this.novedad = novedad;
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPrecio_dia() {
        return precio_dia;
    }

    public void setPrecio_dia(int precio_dia) {
        this.precio_dia = precio_dia;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    
    
    @Override
    public String toString() {
        return "Habitacion{" + "id_habitacion= " + id_habitacion + ", piso= " + piso + ", tipo= " + tipo +", descripcion= " + descripcion + ", ciudad= " + ciudad + ", precio_dia= " + precio_dia + ", novedad= " + novedad + ", fecha_ingreso= " + fecha_ingreso + '}';
    }
}