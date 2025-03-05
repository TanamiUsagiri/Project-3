package beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/K22CNT2_NguyenPhongTan_2210900123_Project3";
    private static final String USER = "root";
    private static final String PASSWORD = "28042004";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database connection failed!");
        }
        return conn;
        
    }
    
}
