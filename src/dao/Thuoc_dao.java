package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public boolean themThuoc(Thuoc th) {
		Connection con = ConnectDB.getConnection();
		String sql = "insert Thuoc values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, th.getNhaCungCap().getMaNhaCungCap());
			stmt.setString(2, th.getTenThuoc());
			stmt.setInt(3, th.getSoLuong());
			stmt.setInt(4, th.getNhaCungCap().getMaNhaCungCap());
			stmt.setString(5, th.getNgaySanXuat());
			stmt.setString(6, th.getNgayHetHan());
			stmt.setString(7, "");
			stmt.setDouble(8, th.getDonGia());
			
			int n = stmt.executeUpdate();
			if(n>0) {
				return true;
			}
			else
				return false;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateThuoc(Thuoc th) {
		Connection con = ConnectDB.getConnection();
		String sql = "update Thuoc set maNhaCungCap = ?, tenThuoc = ?, soLuong = ?,"
				+ "maLoaiThuoc =?,ngaySanXuat=?,hanSuDung =?,donViTinh = ?,donGia =? where maThuoc = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, th.getNhaCungCap().getMaNhaCungCap());
			stmt.setString(2, th.getTenThuoc());
			stmt.setInt(3, th.getSoLuong());
			stmt.setInt(4, th.getLoaiThuoc().getMaLoai());
			stmt.setString(5, th.getNgaySanXuat());
			stmt.setString(6, th.getNgayHetHan());
			stmt.setString(7, "");
			stmt.setDouble(8, th.getDonGia());
			stmt.setInt(9, th.getMaThuoc());
			
			int n = stmt.executeUpdate();
			if(n>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean xoaThuoc(Thuoc th) {
		Connection con = ConnectDB.getConnection();
		String sql = "delete from Thuoc where maThuoc = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, th.getMaThuoc());
		
			int n = stmt.executeUpdate();
			if(n>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Thuoc> TimThuoc(String column,String key){
		dst = new ArrayList<Thuoc>();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from Thuoc a join NhaCungCap b on "
				+ "a.maNhaCungCap = b.maNhaCungCap join LoaiThuoc c"
				+ " on a.maLoaiThuoc = c.maLoaiThuoc  where "+column+ " like "+"'%"+key+"%'";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Thuoc th = new Thuoc(rs);
				dst.add(th);
			}
			return dst;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public Thuoc findByMaThuoc(int maThuoc) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select * from Thuoc a join NhaCungCap b on "
					+ "a.maNhaCungCap = b.maNhaCungCap join LoaiThuoc c "
					+ "on a.maLoaiThuoc = c.maLoaiThuoc where a.maThuoc = ? " );
			ps.setInt(1, maThuoc);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Thuoc t = new Thuoc(rs);
				return t;
			}

			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}


	public ArrayList<Thuoc> thuocHetHan() {
		dst = new ArrayList<Thuoc>();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from Thuoc a join NhaCungCap b on "
				+ " a.maNhaCungCap = b.maNhaCungCap join LoaiThuoc c "
				+ " on a.maLoaiThuoc = c.maLoaiThuoc where hanSuDung < GETDATE()";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Thuoc th = new Thuoc(rs);
				dst.add(th);
			}
			return dst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dst;
	}

	public boolean minusThuoc(int maThuoc, int minusValue) {
		int n = 0;
		PreparedStatement ps;
		try {
			ps = ConnectDB.getConnection().prepareStatement("update thuoc set soLuong = soLuong - ? where maThuoc = ?");
			ps.setInt(1, minusValue);
			ps.setInt(2, maThuoc);
			
			n = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
}
