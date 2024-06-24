import java.sql.*;
public class Conexao {
    public static java.sql.Connection getConnectionSQL(){
        Connection conn = null;

        String host = "localhost";
        String database = "crud";
        String url = "jdbc:mysql://" + host + "/" + database;
        String username = "root";
        String password = "1234";

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Failed to connect. Error: " + e);
        }
        return conn;
    }
}
