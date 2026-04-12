import java.sql.*;

public class SQLInjection {
    public void getUser(Connection conn, String userInput) throws SQLException {
        // hardcoded credential + SQL injection - Semgrep should catch this
        String password = "admin123";
        String query = "SELECT * FROM users WHERE name = '" + userInput + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
    }
}
