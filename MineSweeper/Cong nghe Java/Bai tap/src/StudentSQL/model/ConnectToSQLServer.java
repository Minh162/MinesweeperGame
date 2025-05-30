package StudentSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectToSQLServer {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=STUDENT;";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "1236";

    public static ResultSet rs = null;

    public void getData() {
        try {
            //Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Connect
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            //Create statement
            Statement st = conn.createStatement();
            //Get data
            rs = st.executeQuery("select * from SinhVien");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
