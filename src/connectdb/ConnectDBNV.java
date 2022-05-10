package connectdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectDBNV {
	public static Connection con = null;
	private static ConnectDBNV instance = new ConnectDBNV();	
	public static ConnectDBNV getInstance() {
		return instance;
	}
	public void connect() throws SQLException {				
			String url = "jdbc:sqlserver://localhost:1433;databasename=HieuThuoc3";
			String user = "sa";
			String password = "bl050720082002";
			con = DriverManager.getConnection(url, user, password);		
	}
	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {	e.printStackTrace();			}
	}
	public static Connection getConnection() {
		return con;
	}

}
