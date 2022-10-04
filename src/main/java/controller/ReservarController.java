package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Reservar;
import connection.DBConnection;

public class ReservarController implements IReservarController {

    
    @Override
    public String listarReservas(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "SELECT l.id_habitacion, u.username, a.pago, a.fecha_Ingreso, a.fecha_salida from FROM habitacion AS l  "
                + "INNER JOIN reservar as a INNER JOIN usuario as u on a.username = u.username "
                + "where a.username = '" + username + "'";

        List<String> reservas = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id_habitacion = rs.getInt("id_habitacion");
                String pago = rs.getString("pago");
                Date fecha_ingreso = rs.getDate("fecha_ingreso");
                Date fecha_salida = rs.getDate("fecha_salida");

                Reservar reservar = new Reservar(id_habitacion, username, pago, fecha_ingreso, fecha_salida);

                reservas.add(gson.toJson(reservar));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(reservas);
    }
}

