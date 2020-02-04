import java.sql.SQLException;

public interface IAdminColumns {
    public int insert(Object obj) throws SQLException;
    public int delete(String id) throws SQLException;
    public int edit(String id, String newColumn, EditColumns column) throws SQLException;
}
