package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connectdb.ConnectDB;
import entity.CaLam;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;

public class NhanVien_dao {
    public ArrayList<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
         
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "Select * from NhanVien";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int maNhanVien = rs.getInt(1);
                String tenTaiKhoan = rs.getString(2);
                TaiKhoan tK = new TaiKhoan(tenTaiKhoan);
                int maCaLam = rs.getInt(3);
                CaLam caL = new CaLam(maCaLam);
                String tenNhanVien = rs.getString(4);
                String CMND = rs.getString(5);
                String soDienThoai = rs.getString(6);
                String diaChi = rs.getString(7);
                Date ngaySinh = rs.getDate(8);
                boolean gioiTinh = rs.getBoolean(9);
                BigDecimal luong = rs.getBigDecimal(10);
                NhanVien nv = new NhanVien(maNhanVien, tK, caL, tenNhanVien, CMND, soDienThoai, diaChi, ngaySinh, gioiTinh, luong);
                dsnv.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnv;
    }

    public boolean craete(NhanVien nv) {
         
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("insert into NhanVien values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, nv.getTaiKhoan().getTenTaiKhoan());
            ps.setInt(2, nv.getCaLam().getMaCaLam());
            ps.setString(3, nv.getTenNhanVien());
            ps.setString(4, nv.getCMND());
            ps.setString(5, nv.getSoDienThoai());
            ps.setString(6, nv.getDiaChi());
            ps.setDate(7, nv.getNgaySinh());
            ps.setBoolean(8, nv.isGioiTinh());
            ps.setBigDecimal(9, nv.getLuong());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return n > 0;

    }

    public boolean update(NhanVien nv) {
         
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            //thieu dau phay
            ps = con.prepareStatement("update NhanVien set tenTaiKhoan = ?,"
            		+ " maCaLam = ?, tenNhanVien=?, CMND=?,soDienThoai=?,"
            		+ "diaChi=?,ngaySinh=?,gioiTinh=?,luong=? where maNhanVien=?");
            ps.setString(1, nv.getTaiKhoan().getTenTaiKhoan());
            ps.setInt(2, nv.getCaLam().getMaCaLam());
            ps.setString(3, nv.getTenNhanVien());
            ps.setString(4, nv.getCMND());
            ps.setString(5, nv.getSoDienThoai());
            ps.setString(6, nv.getDiaChi());
            ps.setDate(7, nv.getNgaySinh());
            ps.setBoolean(8, nv.isGioiTinh());
            ps.setBigDecimal(9, nv.getLuong());
            ps.setInt(10, nv.getMaNhanVien());
            
            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return n > 0;

    }
    public Boolean deleteNhanVienByID(String maNhanVien){
         
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM NhanVien WHERE maNhanVien=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                assert ps != null;
                ps.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return true;
    }
    public NhanVien findNhanVienById(String maNV){
        NhanVien nv = null;
         
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "SELECT * from NhanVien WHERE maNhanVien=?";
             ps  =  con.prepareStatement(sql);
             ps.setString(1,maNV);
             ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int maNhanVien = rs.getInt(1);
                String tenTaiKhoan = rs.getString(2);
                TaiKhoan tK = new TaiKhoan(tenTaiKhoan);
                int maCaLam = rs.getInt(3);
                CaLam caL = new CaLam(maCaLam);
                String tenNhanVien = rs.getString(4);
                String CMND = rs.getString(5);
                String soDienThoai = rs.getString(6);
                String diaChi = rs.getString(7);
                Date ngaySinh = rs.getDate(8);
                boolean gioiTinh = rs.getBoolean(9);
                BigDecimal luong = rs.getBigDecimal(10);
   
                nv = new NhanVien(maNhanVien, tK, caL, tenNhanVien, CMND, soDienThoai, diaChi, ngaySinh, gioiTinh, luong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return nv;
        }
        return nv;
    }

    public ArrayList<NhanVien> findListNV(String value, String type) {
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from nhanvien where " + type + " like ?");
			ps.setString(1,"%" + value + "%");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int maNhanVien = rs.getInt(1);
                String tenTaiKhoan = rs.getString(2);
                TaiKhoan tK = new TaiKhoan(tenTaiKhoan);
                int maCaLam = rs.getInt(3);
                CaLam caL = new CaLam(maCaLam);
                String tenNhanVien = rs.getString(4);
                String CMND = rs.getString(5);
                String soDienThoai = rs.getString(6);
                String diaChi = rs.getString(7);
                Date ngaySinh = rs.getDate(8);
                boolean gioiTinh = rs.getBoolean(9);
                BigDecimal luong = rs.getBigDecimal(10);
                NhanVien nv = new NhanVien(maNhanVien, tK, caL, tenNhanVien, CMND, soDienThoai, diaChi, ngaySinh, gioiTinh, luong);
                list.add(nv);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}