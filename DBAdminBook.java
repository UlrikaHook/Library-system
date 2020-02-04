import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBAdminBook implements IAdminColumns{
    private PreparedStatement prepStmt;
    private Connection conn;

    public DBAdminBook() throws SQLException {
        this.conn = DatabaseConnection.getInstance().getConn();
    }

    @Override
    public int insert(Object obj) throws SQLException {
        prepStmt = conn.prepareStatement("insert into book " +
                "(isbn, title, author_firstname, author_lastname, edition, publisher, publish_year, pages, language) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        prepStmt.setString(1, ((Book)obj).getIsbn());
        prepStmt.setString(2, ((Book)obj).getTitle());
        prepStmt.setString(3, ((Book)obj).getAuthorFirstName());
        prepStmt.setString(4, ((Book)obj).getAuthorLastName());
        prepStmt.setInt(5, ((Book)obj).getEdition());
        prepStmt.setString(6, ((Book)obj).getPublisher());
        prepStmt.setInt(7, ((Book)obj).getPublishYear());
        prepStmt.setInt(8, ((Book)obj).getPages());
        prepStmt.setString(9, ((Book)obj).getLanguage());
        int insertedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
        return insertedRows;
    }

    @Override
    public int delete(String id) throws SQLException {
        prepStmt = conn.prepareStatement("delete from book where isbn = ?");
        prepStmt.setString(1, id);
        int deletedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
        return deletedRows;
    }

    @Override
    public int edit(String id, String newColumn, EditColumns column) throws SQLException {
        prepStmt = conn.prepareStatement("update book set " + column + " = ? where isbn = ?");
        prepStmt.setString(1, newColumn);
        prepStmt.setString(2, id);
        int editedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
        return editedRows;
    }
}
