package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String url="jdbc:postgresql://localhost:5432/tekpyramid";
    private static final String user="postgres";
    private static final String pswd="123";

    public static Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, pswd);
        } catch (Exception e) {
            System.out.println("DB Connection Error: " + e.getMessage());
            return null;
        }
    }
}
