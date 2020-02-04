import java.sql.*;

public class DatabaseConnection {

    //Singleton class to create database connection
    private static DatabaseConnection instance;
    private static Connection conn = null;

    private DatabaseConnection() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library" + "?serverTimezone=UTC", "student", "123");
    }

    public Connection getConn() {
        return conn;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if(instance == null){
            instance = new DatabaseConnection();
        } else if (instance.getConn().isClosed()){
            instance = new DatabaseConnection();
        }
        return instance;
    }

}
