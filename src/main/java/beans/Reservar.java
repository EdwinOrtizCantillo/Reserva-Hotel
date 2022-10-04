package beans;

import java.sql.Date;

public class Reservar {

    private int id_habitacion;
    private String username;
    private String pago;
    private Date fecha_ingreso;
    private Date fecha_salida;

    public Reservar(int id_habitacion, String username, String pago, Date fecha_ingreso, Date fecha_salida) {
        this.id_habitacion = id_habitacion;
        this.username = username;
        this.pago = pago;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        
    }

    
    
    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

 }