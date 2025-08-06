import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/expense_db"; // Your DB name
    private static final String USER = "root";  // Change if needed
    private static final String PASSWORD = "Adhithya_07";  // Change if you set a password

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            return conn;
        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
    }
}
