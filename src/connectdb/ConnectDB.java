package connectdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectDB {
	public static Connection con = null;
//	}
	public void connect() throws SQLException {		
			String databaseName = "HieuThuoc";
			String url = "jdbc:sqlserver://localhost:1433;databasename="+databaseName;
			String user = "sa";
			String password = "sa";
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
