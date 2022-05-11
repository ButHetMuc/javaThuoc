package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectdb.ConnectDB;
import entity.Thuoc;

public class Thuoc_dao  {
	ArrayList<Thuoc> dst ;
	public ArrayList<Thuoc> getDsThuoc(){
		dst = new ArrayList<Thuoc>();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from Thuoc a join NhaCungCap b on "
				+ "a.maNhaCungCap = b.maNhaCungCap join LoaiThuoc c "
				+ "on a.maLoaiThuoc = c.maLoaiThuoc";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs == null) 
				return null;
			else {
				while(rs.next()) {
					Thuoc th = new Thuoc(rs);
					dst.add(th);
				}
				return dst;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
//	public boolean themThuoc(Thuoc th) {
//		Connection con = ConnectDB.getConnection();
//		String sql = "insert Thuoc values (?,?,?,?,?)";
//	}

}
