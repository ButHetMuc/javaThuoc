package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectdb.ConnectDB;
import entity.LoaiThuoc;
import entity.NhaCungCap;

public class LoaiThuoc_dao {
private ArrayList<LoaiThuoc> dsLoaiThuoc;
	
	public ArrayList<LoaiThuoc> getDsLoaiThuoc(){
		Connection con = ConnectDB.getConnection();
		String sql = "select * from LoaiThuoc";
		dsLoaiThuoc = new ArrayList<LoaiThuoc>();
		try {
			Statement stmt= con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.next()) {
				return null;
			}
			else {
				int ma =0;
				String ten = "";
				while(rs.next()) {
					ma = rs.getInt("maLoaiThuoc");
					ten = rs.getString("tenLoai");
					LoaiThuoc loaiThuoc = new LoaiThuoc(ma, ten);
					dsLoaiThuoc.add(loaiThuoc);
				}
			
			}
			return dsLoaiThuoc;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
	}
}
