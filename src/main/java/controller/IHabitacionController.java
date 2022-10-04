
package controller;

import java.util.Date;

/**
 *
 * @author Edwin Ortiz
 */
public interface IHabitacionController {
    
    public String listar(boolean ordenar, String orden);
    public String register(int id_habitacion, String piso, String tipo, String ciudad, int precio_dia, boolean novedad);
    public String reservar(int id_habitacion, String username, String pago, Date fecha_ingreso, Date fecha_salida);
    public String modificar(int id_habitacion);
    
}
