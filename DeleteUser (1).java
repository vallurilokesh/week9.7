import java.sql.*;

public class DeleteUser {

    // Step 2: JDBC connection constants
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        // Step 4: DELETE query with a placeholder
        String deleteSql = "DELETE FROM users WHERE id = ?";
        int userId = 2; // hardcoded user ID

        // Step 3: try-with-resources for Connection and PreparedStatement
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {

            // Step 5: Set the parameter
            preparedStatement.setInt(1, userId);

            // Step 6: Execute and capture rows affected
            int rowsAffected = preparedStatement.executeUpdate();

            // Step 7: Display result message
            if (rowsAffected > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No rows were deleted.");
            }

        } catch (SQLException e) {
            // Step 8: Handle SQLException
            System.err.println("SQL Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
        // Step 9: Resources closed automatically
    }
}
