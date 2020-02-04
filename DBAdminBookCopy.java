import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBAdminBookCopy implements IAdminColumns{
    private PreparedStatement prepStmt;
    private Connection conn;


    public DBAdminBookCopy() throws SQLException {
        this.conn = DatabaseConnection.getInstance().getConn();
    }

    @Override
    public int insert(Object obj) throws SQLException {
        prepStmt = conn.prepareStatement("insert into book_copy " +
                "(uuid, available, book_id) " +
                "values (?, ?, (select book_id from book where isbn = ?))");
        prepStmt.setString(1, ((BookCopy)obj).getId());
        prepStmt.setInt(2, (((BookCopy)obj).isAvailable() ? 1 : 0));
        prepStmt.setString(3, ((BookCopy)obj).getIsbn());
        int insertedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
        return insertedRows;
    }

    @Override
    public int delete(String id) throws SQLException {
        prepStmt = conn.prepareStatement("delete from book_copy where uuid = ?");
        prepStmt.setString(1, id);
        int deletedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
        return deletedRows;
    }

    @Override
    public int edit(String id, String newColumn, EditColumns column) throws SQLException {
        prepStmt = conn.prepareStatement("update book_copy set " + column + " = ? where uuid = ?");
        prepStmt.setString(1, newColumn);
        prepStmt.setString(2, id);
        int editedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
        return editedRows;
    }
}
