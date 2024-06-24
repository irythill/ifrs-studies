import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TitleDAO {
    public int insert(Title b) {
        try {
            Connection conn = Conexao.getConnectionSQL();
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO Titles(ISBN, Title, EditionNumber, Copyright) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, b.getISBN());
            ps.setString(2, b.getTitle());
            ps.setString(3, b.getEditionNumber());
            ps.setString(4, b.getCopyright());

            int rowCount = ps.executeUpdate();
            conn.close();

            return rowCount;

        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public Title read(int isbn) {
        try {
            Connection conn = Conexao.getConnectionSQL();
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM Titles WHERE ISBN = ?"
            );
            ps.setInt(1, isbn);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String title = rs.getString(2);
                String editionNumber = rs.getString(3);
                String copyright = rs.getString(4);
                Title book = new Title(isbn, title, editionNumber, copyright);

                return book;
            }
            conn.close();

        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public ArrayList<Title> list() {
        ArrayList<Title> myList = new ArrayList<>();

        try {
            Connection conn = Conexao.getConnectionSQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Titles");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int isbn = rs.getInt(1);
                String title = rs.getString(2);
                String editionNumber = rs.getString(3);
                String copyright = rs.getString(4);
                Title book = new Title(isbn, title, editionNumber, copyright);
                myList.add(book);
            }
            conn.close();

        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return myList;
    }

    public int update(Title b) {
        try {
            Connection conn = Conexao.getConnectionSQL();

            PreparedStatement ps = conn.prepareStatement("UPDATE Titles SET Title = ?, EditionNumber = ?, Copyright = ? WHERE ISBN = ?");
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getEditionNumber());
            ps.setString(3, b.getCopyright());

            int rowCount = ps.executeUpdate();
            conn.close();
            return rowCount;

        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int delete(int isbn) {
        try {
            Connection conn = Conexao.getConnectionSQL();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM Titles WHERE ISBN = ?");
            ps.setInt(1, isbn);

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
