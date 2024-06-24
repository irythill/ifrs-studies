import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorTitleDAO {
    public void associarAutorLivro(int idAutor, int idLivro) {
        try {
            Connection conn = Conexao.getConnectionSQL();

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO AuthorTitle(atAuthorsID, atISBN) VALUES (?, ?)"
            );
            ps.setInt(1, idAutor);
            ps.setInt(2, idLivro);
            ps.executeUpdate();

        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void desassociarAutorLivro(int idAutor, int idLivro) {
        try {
            Connection conn = Conexao.getConnectionSQL();

            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM AuthorTitle WHERE atAuthorsID = ? AND atISBN = ?"
            );
            ps.setInt(1, idAutor);
            ps.setInt(2, idLivro);
            ps.executeUpdate();

        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<Author> buscarAuthorsPorTitle(int idLivro) {
        ArrayList<Author> authors = new ArrayList<>();

        try {
            Connection conn = Conexao.getConnectionSQL();
            PreparedStatement ps = conn.prepareStatement("SELECT Authors.*, AuthorTitle.atISBN FROM AuthorTitle " +
                    "JOIN Authors ON AuthorTitle.atAuthorsID = Authors.authorsID WHERE AuthorTitle.atISBN = ?"
            );
            ps.setInt(1, idLivro);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Author author = new Author(rs.getInt(1), rs.getString(2), rs.getString(3));
                authors.add(author);
            }

        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return authors;
    }

    public ArrayList<Title> buscarTitlesPorAuthor(int idAutor) {
        ArrayList<Title> titles = new ArrayList<Title>();

        try {
            Connection conn = Conexao.getConnectionSQL();
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT Titles.*, AuthorTitle.atAuthorsID FROM AuthorTitle "  +
                            "JOIN Titles ON AuthorTitle.atISBN = Titles.ISBN WHERE AuthorTitle.atAuthorsID = ?"
            );
            ps.setInt(1, idAutor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Title title = new Title(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
                titles.add(title);
            }
        } catch (SQLException e) {
            // System.out.println("Failed. Error: " + e);
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return titles;
    }
}
