package test;

import beans.Habitacion;
import connection.DBConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {

    public static void main(String[] args) {
       actualizarHabitacion(1, "terror/Sharickjode"); // para actualiza la el documento en la BD
       listarHabitacion();
    }

    public static void actualizarHabitacion(int id_habitacion, String tipo) {
        DBConnection con = new DBConnection();
        String sql = "UPDATE habitacion SET tipo = '" + tipo + "' WHERE id_habitacion = " + id_habitacion;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void listarHabitacion() {
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM habitacion";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id_habitacion = rs.getInt("id_habitacion");
                String piso = rs.getString("piso");
                String tipo = rs.getString("tipo");
                String ciudad = rs.getString("ciudad");
                int precio_dia = rs.getInt("precio_dia");
                boolean novedad = rs.getBoolean("novedad");

                Habitacion habitacion = new Habitacion(id_habitacion, piso, tipo, ciudad, precio_dia, novedad);
                System.out.println(habitacion.toString());
            }
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

}