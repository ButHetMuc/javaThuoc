package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDB;

public class DoanhThu_dao {
	public int layNamCuNhat() {
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT YEAR(MIN(ngayLap)) as yea FROM HoaDon");
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
				
			}else {
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int layNamMoiNhat() {
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT YEAR(MAX(ngayLap)) FROM HoaDon");
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
				
			}else {
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public ResultSet layDoanhThuTheoNam(int nam) {
		
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(""
					+ "SELECT Thuoc.maThuoc, Thuoc.tenThuoc, Sum(tongTien) as TongTien, Sum(a.soluong) as SoLuong "
					+ "FROM HoaDon "
					+ "JOIN ChiTietHoaDon as a ON HoaDon.maHoaDon = a.maHoaDon "
					+ "		join Thuoc on Thuoc.maThuoc = a.maThuoc "
					+ "where YEAR(HoaDon.ngayLap) = ? "
					+ "group by Thuoc.maThuoc, Thuoc.tenThuoc order by (soLuong) desc ");
			ps.setInt(1, nam);
			
			ResultSet rs = ps.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public ResultSet layDoanhThuTheoThang(int nam, int thang) {
		// TODO Auto-generated method stub
		
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(""
					+ "SELECT Thuoc.maThuoc, Thuoc.tenThuoc, Sum(tongTien) as TongTien, Sum(a.soluong) as SoLuong "
					+ "FROM HoaDon "
					+ "JOIN ChiTietHoaDon as a ON HoaDon.maHoaDon = a.maHoaDon "
					+ "		join Thuoc on Thuoc.maThuoc = a.maThuoc "
					+ "where YEAR(HoaDon.ngayLap) = ? AND MONTH(HoaDon.ngayLap) = ? "
					+ "group by Thuoc.maThuoc, Thuoc.tenThuoc order by (soLuong) desc ");
			ps.setInt(1, nam);
			ps.setInt(2, thang);
			
			ResultSet rs = ps.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet layDoanhThuTheoNgay(int nam, int thang, int ngay) {
		// TODO Auto-generated method stub
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(""
					+ "SELECT Thuoc.maThuoc, Thuoc.tenThuoc, Sum(tongTien) as TongTien, Sum(a.soluong) as SoLuong "
					+ "FROM HoaDon "
					+ "JOIN ChiTietHoaDon as a ON HoaDon.maHoaDon = a.maHoaDon "
					+ "		join Thuoc on Thuoc.maThuoc = a.maThuoc "
					+ "where YEAR(HoaDon.ngayLap) = ? AND MONTH(HoaDon.ngayLap) = ? AND DAY(HoaDon.ngayLap) = ? "
					+ "group by Thuoc.maThuoc, Thuoc.tenThuoc order by (soLuong) desc ");
			ps.setInt(1, nam);
			ps.setInt(2, thang);
			ps.setInt(3, ngay);
			
			ResultSet rs = ps.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet layDoanhThuTheoQuy(int nam, int quy) {
		// TODO Auto-generated method stub
		Connection con = ConnectDB.getConnection();
		int monthEnd = quy * 3;
		int monthStart = monthEnd - 2;
		try {
			PreparedStatement ps = con.prepareStatement(""
					+ "SELECT Thuoc.maThuoc, Thuoc.tenThuoc, Sum(tongTien) as TongTien, Sum(a.soluong) as SoLuong "
					+ "FROM HoaDon "
					+ "JOIN ChiTietHoaDon as a ON HoaDon.maHoaDon = a.maHoaDon "
					+ "		join Thuoc on Thuoc.maThuoc = a.maThuoc "
					+ "where YEAR(HoaDon.ngayLap) = ? AND MONTH(HoaDon.ngayLap) >= ? AND MONTH(HoaDon.ngayLap) <= ? "
					+ "group by Thuoc.maThuoc, Thuoc.tenThuoc order by (soLuong) desc ");
			ps.setInt(1, nam);
			ps.setInt(2, monthStart);
			ps.setInt(3, monthEnd);
			
			ResultSet rs = ps.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
