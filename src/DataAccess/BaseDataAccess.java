package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDataAccess {
    private static final String URL = "jdbc:mysql://localhost:3306/onlineshop";
    private static final String USERNAME = "neda";
    private static final String PASSWORD = "13730203@Neda";
    protected Connection connection;

    public BaseDataAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
