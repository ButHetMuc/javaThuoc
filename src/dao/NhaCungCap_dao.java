package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectdb.ConnectDB;
import entity.NhaCungCap;

public class NhaCungCap_dao {
	
	private ArrayList<NhaCungCap> dsNhaCC;
	
	public ArrayList<NhaCungCap> getDsNhaCC(){
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhaCungCap";
		dsNhaCC = new ArrayList<NhaCungCap>();
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
					ma = rs.getInt("maNhaCungCap");
					ten = rs.getString("tenNhaCungCap");
					NhaCungCap ncc = new NhaCungCap(ma,ten);
					dsNhaCC.add(ncc);
				}
			
			}
			return dsNhaCC;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
	}
	

}
