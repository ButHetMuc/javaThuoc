package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection con = null;
	public ConnectDB() throws SQLException {
		String databaseName = "HieuThuoc";
		String url = "jdbc:sqlserver://localhost:1433;databasename = "+databaseName;
		String userName = "sa";
		String password = "sapassword";
		this.con = DriverManager.getConnection(url,userName,password);
	}
	public void disconnect() {
		if(con != null) { 
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() {
		return con;
	}

}
