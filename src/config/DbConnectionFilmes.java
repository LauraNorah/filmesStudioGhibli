package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionFilmes {
    private static final String URL = "jdbc:mysql://localhost:3306/filmesStudioGhibli?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Carregar o driver do MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (Exception e){
                System.out.println("Driver do MySQL não encontrado.");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void disconnect(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error disconnection the database", e);
        }
    }
}
