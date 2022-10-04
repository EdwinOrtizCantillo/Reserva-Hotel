package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.gson.Gson;
import beans.Habitacion;
import connection.DBConnection;

public class HabitacionController implements IHabitacionController {
    
    
    @Override
   public String register(int id_habitacion, String piso, String tipo, String ciudad, int precio_dia, boolean novedad) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into habitacion values('" + id_habitacion + "', '" + piso + "', '" + tipo
                + "', '" + ciudad + "', '" + precio_dia + "', '" + id_habitacion + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Habitacion habitaciones = new Habitacion(id_habitacion, piso, tipo, ciudad,  precio_dia, novedad);

            st.close();

            return gson.toJson(habitaciones);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

   
    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from habitacion";

        if (ordenar == true) {
            sql += " order by tiso " + orden;
        }

        List<String> habitacion = new ArrayList<String>();

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

                Habitacion habitaciones = new Habitacion(id_habitacion, piso, tipo, ciudad, precio_dia, novedad);

                Habitacion.add(gson.toJson(habitaciones));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(habitacion);

    }

    
       
    @Override
    public String reservar(int id_habitacion, String username, String pago, Date fecha_ingreso, Date fecha_salida ) {

        DBConnection con = new DBConnection();
        String sql = "Insert into reservar values ('" + id_habitacion + "', '" + username + "', '" + pago + "', '" + fecha_ingreso + "', '" + fecha_salida + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            String modificar = modificar(id_habitacion);

            if (modificar.equals("true")) {
                return "true";
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }
        return "false";
    }
    
    @Override
    public String modificar(int id_habitacion) {

        DBConnection con = new DBConnection();
        String sql = "Update peliculas set piso = (piso - 1) where id_habitacion = " + id_habitacion;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";

    }
   
}
