import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorDAO {
    public int create(Author a) {
        try {
            Connection conn = Conexao.getConnectionSQL();
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO authors(firstName, lastName) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, a.getFirstName());
            ps.setString(2, a.getLastName());

            int rowCount = ps.executeUpdate();
            conn.close();

            return rowCount;

        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public Author read(int id) {
        try {
            Connection conn = Conexao.getConnectionSQL();
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM Authors WHERE authorsID = ?"
            );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Author author = new Author(id, firstName, lastName);

                return author;
            }
            conn.close();
        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public ArrayList<Author> list() {
        ArrayList<Author> myList = new ArrayList<>();

        try {
            Connection conn = Conexao.getConnectionSQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Authors");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Author author = new Author(id, firstName, lastName);
                myList.add(author);
            }
            conn.close();

        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return myList;
    }

    public int update(Author a) {
        try {
            Connection conn = Conexao.getConnectionSQL();

            PreparedStatement ps = conn.prepareStatement("UPDATE authors SET firstName = ?, lastName = ? WHERE authorsID = ?");
            ps.setString(1, a.getFirstName());
            ps.setString(2, a.getLastName());
            ps.setInt(3, a.getAuthorsId());

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int delete(int id) {
        try {
            Connection conn = Conexao.getConnectionSQL();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM authors WHERE authorsID = ?");
            ps.setInt(1, id);

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
}
