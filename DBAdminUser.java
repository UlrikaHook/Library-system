import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBAdminUser implements IAdminColumns{
    private PreparedStatement prepStmt;
    private Connection conn;


    public DBAdminUser() throws SQLException {
        this.conn = DatabaseConnection.getInstance().getConn();
    }

    @Override
    public int insert(Object obj) throws SQLException {
        prepStmt = conn.prepareStatement("insert into user (uuid, firstname, lastname, phone, email) values (?, ?, ?, ?, ?)");
        prepStmt.setString(1, ((User)obj).getId());
        prepStmt.setString(2, ((User)obj).getFirstName());
        prepStmt.setString(3, ((User)obj).getLastname());
        prepStmt.setString(4, ((User)obj).getPhoneNumber());
        prepStmt.setString(5, ((User)obj).getEmail());
        int insertedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
        return insertedRows;
    }

    @Override
    public int delete(String id) throws SQLException {
        prepStmt = conn.prepareStatement("delete from user where uuid = ?");
        prepStmt.setString(1, id);
        int deletedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
        return deletedRows;
    }

    @Override
    public int edit(String id, String newColumn, EditColumns column) throws SQLException {
        prepStmt = conn.prepareStatement("update user set " + column + " = ? where uuid = ?");
        prepStmt.setString(1, newColumn);
        prepStmt.setString(2, id);
        int editedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
        return editedRows;
    }
}
