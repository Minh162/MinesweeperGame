package Model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// class dùng để thiết lập kết nối
public class ConnectDB {
    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLKhachHang";
            String user = "Hoang";
            String password = "07102003";
            try {
                connection = DriverManager.getConnection("jdbc:sqlserver://PHAMHUYHOANG\\SQLEXPRESS:1433;databaseName=QLKhachHang;user=Hoang;password=07102003;encrypt=true;trustServerCertificate=true;");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
}
