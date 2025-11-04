package librarymanagementsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";          // change this
    private static final String PASSWORD = "password";  // change this

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println(" Database connection error: " + e.getMessage());
        }
        return conn;
    }}