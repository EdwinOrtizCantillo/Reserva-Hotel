package beans;

public class Reservar {

    private int id_habitacion;
    private String username;
    private String tipo;
    private String piso;
    private String descripcion;
    private String ciudad;
    private boolean novedad;

    public Reservar(int id_habitacion, String username, String tipo, String piso, String descripcion, String ciudad, boolean novedad){
        this.id_habitacion= id_habitacion;
        this.username = username;
        this.tipo = tipo;     
        this.piso = piso;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.novedad = novedad;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
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

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    @Override
    public String toString() {
        return "Reservar{" + "id_habitacion= " + id_habitacion + ", username= " + username + ", tipo= " + tipo +", piso= " + piso +", descripcion= " + descripcion + ", novedad= " + novedad + '}';
    }
}