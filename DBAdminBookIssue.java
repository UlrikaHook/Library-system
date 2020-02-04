import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBAdminBookIssue {

    private PreparedStatement prepStmt;
    private PreparedStatement prepStmt2;
    private Connection conn;

    public DBAdminBookIssue() throws SQLException {
        this.conn = DatabaseConnection.getInstance().getConn();
    }

    public int regIssue(String userId, String copyId) throws SQLException{
        prepStmt = conn.prepareStatement("insert into book_loan (date_borrowed, date_to_return, user_id, copy_id) " +
                "values (curdate(), (select adddate(curdate(), interval 30 day)), (select user_id from user where uuid = ?), (select copy_id from book_copy where uuid =?))");
        prepStmt.setString(1, userId);
        prepStmt.setString(2, copyId);
        int affectedRows = prepStmt.executeUpdate();

        prepStmt2 = conn.prepareStatement("update book_copy set available = 0 where uuid = ?");
        prepStmt2.setString(1, copyId);
        affectedRows += prepStmt2.executeUpdate();
        prepStmt.close();
        prepStmt2.close();
        conn.close();
        return affectedRows;
    }
}
