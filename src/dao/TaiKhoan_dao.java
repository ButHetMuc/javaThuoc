package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectdb.ConnectDB;

public class TaiKhoan_dao {
	public String getMatKhau(String tenTaiKhoan) {
		String matKhau = "";
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.TaiKhoan where tenTaiKhoan = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tenTaiKhoan);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next())
                return null;
            matKhau = rs.getString("matKhau");          
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return matKhau;
	}

}
