
package connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    Connection connection;
    static String bd = "reserva_hotel";
    static String port = "3307";
    static String login = "root";
    static String password = "admin";
    
    
    public DBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:" + this.port + "/" + this.bd;
            connection = DriverManager.getConnection(url, this.login, this.password);
            //System.out.println("conexion establecida");
           if (connection == null){
                System.out.println("conexion fallida");
            }
            else {
                System.out.println("conexion Exitosa");
            }
            
        } catch (Exception ex) {
           System.out.println("conexion fallida");             
        }
    }

    public Connection getConnection() {
        return connection;
    }
    public void desconectar(){
        connection = null;
    }
}