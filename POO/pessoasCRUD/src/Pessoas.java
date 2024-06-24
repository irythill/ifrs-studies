import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
import java.util.Scanner;

public class Pessoas {
    public static Connection useDB() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/crud",
                "root",
                "1234"
        );
    }

    public static Statement useStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    public static PreparedStatement usePreparedStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public static ResultSet useResultSet(Statement statement, String sql) throws SQLException {
        return statement.executeQuery(sql);
    }

    public static Scanner useScanner() {
        return new Scanner(System.in);
    }

    public static void create() {
        try {
            Connection connection = useDB();
            // Statement statement = useStatement(connection);
            Scanner scanner = useScanner();

            System.out.println("Type the person's name:");
            String name = scanner.nextLine();
            System.out.println("Type the person's age:");
            Integer age = Integer.parseInt(scanner.nextLine());

            String createQuery = "INSERT INTO Pessoas (nome, idade) VALUES (?, ?)";
            PreparedStatement preparedStatement = usePreparedStatement(connection, createQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);

            int rowCount = preparedStatement.executeUpdate();

            if (rowCount > 0) {
                System.out.println("Success!\n");
            } else {
                System.out.println("Failed!\n");
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect! Error: " + e);
        }
    }

    public static void read() {
        try {
            Connection connection = useDB();
            Statement statement = useStatement(connection);

            String readQuery = "SELECT * FROM Pessoas";
            ResultSet resultSet = useResultSet(statement, readQuery);

            while (resultSet.next()) {
                System.out.println("\nID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("nome"));
                System.out.println("Age: " + resultSet.getInt("idade"));
            }

        } catch (SQLException e) {
            System.out.println("Failed to connect! Error: " + e);
        }
    }

    public static void update() {
        try {
            Connection connection = useDB();
            Statement statement = useStatement(connection);
            Scanner scanner = useScanner();

            System.out.println("Pick a person from the list below to UPDATE:");
            String readQuery = "SELECT * FROM Pessoas";
            ResultSet resultSet = useResultSet(statement, readQuery);

            while (resultSet.next()) {
                System.out.println("\nID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("nome"));
                System.out.println("Age: " + resultSet.getInt("idade"));
            }

            System.out.println("\nInform the person's ID to UPDATE:");
            Integer id = Integer.parseInt(scanner.nextLine());
            System.out.println("Write their new name:");
            String name = scanner.nextLine();
            System.out.println("Write their new age:");
            Integer age = Integer.parseInt(scanner.nextLine());

            String updateQuery = "UPDATE Pessoas SET nome = ?, idade = ? WHERE id = ?";
            PreparedStatement preparedStatement = usePreparedStatement(connection, updateQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, id);

            int rowCount = preparedStatement.executeUpdate();

            if (rowCount > 0) {
                System.out.println("Success!\n");
            } else {
                System.out.println("Failed!\n");
            }

        } catch (SQLException e) {
            System.out.println("Failed to connect! Error: " + e);
        }
    }

    public static void delete() {
        try {
            Connection connection = useDB();
            Statement statement = useStatement(connection);
            Scanner scanner = useScanner();

            System.out.println("Pick a person from the list below to DELETE:");
            String readQuery = "SELECT * FROM Pessoas";
            ResultSet resultSet = useResultSet(statement, readQuery);

            while (resultSet.next()) {
                System.out.println("\nID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("nome"));
                System.out.println("Age: " + resultSet.getInt("idade"));
            }

            System.out.println("\nInform the person's ID to DELETE:");
            Integer id = Integer.parseInt(scanner.nextLine());

            String deleteQuery = "DELETE FROM Pessoas WHERE ID = ?";
            PreparedStatement preparedStatement = usePreparedStatement(connection, deleteQuery);
            preparedStatement.setInt(1, id);

            int rowCount = preparedStatement.executeUpdate();

            if (rowCount > 0) {
                System.out.println("Success!\n");
            } else {
                System.out.println("Failed!\n");
            }

        } catch (SQLException e) {
            System.out.println("Failed to connect! Error: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = useScanner();

        boolean fecharMenu = false;

        do {
            System.out.println("CRUD // PERSONS\n");
            System.out.println("0 - Exit");
            System.out.println("1 - Create");
            System.out.println("2 - Read");
            System.out.println("3 - Update");
            System.out.println("4 - Delete");

            System.out.println("Pick an option from above");
            Integer opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 0 -> {
                    System.out.println("Leaving...");
                    fecharMenu = true;
                }

                case 1 -> {
                    System.out.println("\n-- Create --");
                    create();
                    break;
                }

                case 2 -> {
                    System.out.println("\n-- Read --");
                    read();
                    break;
                }

                case 3 -> {
                    System.out.println("\n-- Update --\n");
                    update();
                    break;
                }

                case 4 -> {
                    System.out.println("\n-- Delete --\n");
                    delete();
                    break;
                }
            }
        } while (!fecharMenu);
    }
}