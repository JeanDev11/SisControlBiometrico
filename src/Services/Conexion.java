package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Conexion hacia una BD PostgreSQL
public class Conexion {
    private final String host;
    private final String puerto;
    private final String db;
    private final String user;
    private final String password;
    
    private Connection conexion = null;
    
    public Conexion() {
        // Cargar variables de entorno
        EnvLoader envLoader = new EnvLoader();
        this.host = envLoader.getProperty("DB_HOST");
        this.puerto = envLoader.getProperty("DB_PORT");
        this.db = envLoader.getProperty("DB_NAME");
        this.user = envLoader.getProperty("DB_USER");
        this.password = envLoader.getProperty("DB_PASSWORD");
    }
    
    public Connection getConexion(){
        //Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://"+host+":"+puerto+"/"+db;
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa.");
        } catch (Exception e) {
            System.out.println("Conexion fallida.");
        }
        return conexion;
    }
    
    public void desconexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
