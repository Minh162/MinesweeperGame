package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GameData {
	
	public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/btl_java";
	public static final String USER = "root";
	public static final String PASSWORD = "";
	
	public static void saveDataToSQL(DataHolder dh) {
		String level = dh.getLevel();
		float timeFinished = dh.getTime();
		String datePlay = dh.getDate();
		
		
		if(level.equalsIgnoreCase("Custom")) {
			return;
		}
		
		String sql_code = "UPDATE scoreboard SET date=?, time=? WHERE mode=? AND (time IS NULL OR time>?)";
		try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(sql_code)) {
			Class.forName(DRIVER_CLASS);
			pstmt.setString(1, datePlay);
			pstmt.setFloat(2, timeFinished);
			pstmt.setString(3, level);
			pstmt.setFloat(4, timeFinished);
			pstmt.executeUpdate();
		} catch (Exception e) {
			return;
		}
	}
	
	public static ArrayList<DataHolder> getDataFromSQL() {
		ArrayList<DataHolder> listData = new ArrayList<DataHolder>();
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName(DRIVER_CLASS);
			
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = con.createStatement();
			
			String sql_query = "Select * From scoreboard Order By mode";
			
			ResultSet rs = stmt.executeQuery(sql_query);	
	
			while(rs.next()) {
				float time = rs.getFloat("time");
				String date = rs.getString("date");
				String level = rs.getString("mode");
				DataHolder dh = new DataHolder(date, time, level);
				listData.add(dh);
			}
		} catch (Exception e) {
			return null;
		}
		return listData;
	}
}
