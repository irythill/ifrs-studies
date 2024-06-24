import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MinhaConexao {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/DB_Inventory";
    private static final String USUARIO = "Manager_Silva";
    private static final String SENHA = "GHHSE$&(SB\\GJ";

    private Connection connection;

    public MinhaConexao() {
        try {
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void fecharConexao() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
