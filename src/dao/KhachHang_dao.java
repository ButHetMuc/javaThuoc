package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectdb.ConnectDB;
import entity.KhachHang;

public class KhachHang_dao {
	
	public ArrayList<KhachHang> getAll() {
		ArrayList<KhachHang> list = new ArrayList<>();
		
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from khachHang";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				int maKhachHang = rs.getInt(1);
				String tenKhachHang = rs.getString(2);
				String sdt = rs.getString(3);
				list.add(new KhachHang(maKhachHang,tenKhachHang,sdt));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean update(KhachHang kh) {
		Connection con = ConnectDB.getConnection();
		int n = 0;
		
		try {
			PreparedStatement statement = con.prepareStatement("update khachhang set tenKhachHang=?,soDienThoai=? where maKhachHang=?");
			statement.setString(1,kh.getTenKhachHang());
			statement.setString(2, kh.getSoDienThoai());
			statement.setInt(3, kh.getMaKhachHang());
			
			n = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n>0;
	}
	
	public ArrayList<KhachHang> findListKH(String tenKH, String type) {
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from khachhang where " + type + " like ?");
			ps.setString(1, tenKH + "%");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int ma = rs.getInt(1);
				String ten= rs.getString(2);
				String sdt = rs.getString(3);
				list.add(new KhachHang(ma,ten,sdt));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	public boolean create(KhachHang kh) {
		
		Connection con = ConnectDB.getConnection();
		int n = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into khachHang (tenKhachHang, soDienThoai) values(?,?)");
			ps.setString(1, kh.getTenKhachHang());
			ps.setString(2, kh.getSoDienThoai());
			
			n = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n> 0;
	}

	public boolean deleteByMaKH(int maKh) {
		Connection con = ConnectDB.getConnection();
		int n = 0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from khachHang where maKhachHang=?");
			ps.setInt(1, maKh);
			
			n = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n> 0;
	}
}
