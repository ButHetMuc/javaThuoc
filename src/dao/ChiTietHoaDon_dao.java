package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectdb.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Thuoc;

public class ChiTietHoaDon_dao extends ConnectDB{

	public ChiTietHoaDon_dao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean themChiTietHoaDon(ChiTietHoaDon cthd, int maHD) {
		PreparedStatement stmt = null;
		try {
			
		    String sql = "INSERT INTO dbo.ChiTietHoaDon (maHoaDon, maThuoc, soLuong, donGia) values(?, ?, ?, ?)";
		    stmt = this.con.prepareStatement(sql);
		    stmt.setInt(1, maHD);
		    stmt.setInt(2, cthd.getThuoc().getMaThuoc());
		    stmt.setInt(3, cthd.getSoLuong());
		    stmt.setDouble(4, cthd.getDonGia());
		    int n = stmt.executeUpdate();
		    
		    return n > 0;
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        stmt.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		return false;	
	}

	public ArrayList<ChiTietHoaDon> getDSChiTietHD(int maHD){
		ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
		PreparedStatement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.ChiTietHoaDon where maHoaDon = ?";
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, maHD);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            maHD = rs.getInt(1);
            HoaDon hd = new HoaDon(maHD);
            int mathuoc = rs.getInt(2);
            
            Thuoc thuoc = new Thuoc_dao().findByMaThuoc(mathuoc);
            int soluong = rs.getInt(3);
            dscthd.add(new ChiTietHoaDon(hd, thuoc, soluong));
            
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dscthd;
	}
	
	public boolean xoaHetChiTietHD(int maHD) {
		PreparedStatement stmt = null;
        try {
            String sql = "DELETE from dbo.ChiTietHoaDon where maHoaDon = ?";
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, maHD);
            
            int n = stmt.executeUpdate();
//            
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
	}
	
	
}
