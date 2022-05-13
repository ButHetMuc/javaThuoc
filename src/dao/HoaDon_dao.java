package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import connectdb.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thuoc;


public class HoaDon_dao extends ConnectDB{

	private String error;

	public HoaDon_dao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean themHoaDon(HoaDon hd) throws SQLException {
		PreparedStatement stmt = null;
		boolean flag = true;
        try {
        	ArrayList<ChiTietHoaDon> dscthd = hd.getChiTietHoaDons();
        	
        // thêm khách hàng trước
        KhachHang kh = hd.getKhachHang();
        if(kh.getMaKhachHang() == 0) {
        	// khách hàng mới
        	boolean isSuccess = new KhachHang_dao().create(kh);
        	if(isSuccess) {
        		int maKH = new KhachHang_dao().findKhBySdt(kh.getSoDienThoai()).getMaKhachHang();
        		kh.setMaKhachHang(maKH);
        	}else {
        		return false;
        	}	
        }
        
        
//    	thêm hóa đơn
        String sql = "INSERT INTO dbo.HoaDon (maNhanVien, maKhachHang, tongTien) values(?, ?, ?)";
        stmt = this.con.prepareStatement(sql);
        stmt.setInt(1, hd.getNhanVien().getMaNhanVien());
        stmt.setInt(2, kh.getMaKhachHang());
        stmt.setDouble(3, hd.getTongTien());
        
        int n = stmt.executeUpdate();
        if(n == 0) {
        	this.error = "Có lỗi xảy ra";
    		return false;
    	}
        
//        thêm chi tiết hóa đơn
        for(ChiTietHoaDon cthd: dscthd) {
        	flag = new ChiTietHoaDon_dao().themChiTietHoaDon(cthd, getLastestMaHD());
        	flag = new Thuoc_dao().minusThuoc(cthd.getThuoc().getMaThuoc(), cthd.getSoLuong());
        	if(!flag) {
        		break;
        	}
        }
    
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
    }
	return flag;
}

	
	public HoaDon getHD(int maHD) {
        int id = 0;
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM dbo.HoaDon where maHoaDon = "+maHD;
            stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery(sql);
            if(!rs.next())
            	return null;
          
            HoaDon hd = new HoaDon(rs);
            hd.setChiTietHoaDons(new ChiTietHoaDon_dao().getDSChiTietHD(hd.getMaHD()));
            return hd;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
	}
	
	public int getLastestMaHD() {
        int id = 0;
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM dbo.HoaDon";
            stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery(sql);
            rs.last();
            id = rs.getInt("MaHoaDon");
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
	}
	
	public ArrayList<HoaDon> getDSHD(){
		ArrayList<HoaDon> hoaDonList = new ArrayList<HoaDon>();
        Statement stmt = null;
        try {

            String sql = "SELECT * FROM dbo.HoaDon";
            stmt = this.con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	HoaDon hd = new HoaDon(rs);
            	hd.setChiTietHoaDons(new ChiTietHoaDon_dao().getDSChiTietHD(hd.getMaHD()));
            	hoaDonList.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return hoaDonList;
	}
	
	public List<HoaDon> timKiem(String key, String val) {
    	Statement stmt = null;
    	List<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
            String sql = "SELECT * FROM dbo.HoaDon inner join dbo.KhachHang on dbo.HoaDon.maKhachHang = dbo.KhachHang.maKhachHang where "+ key +" like N'%"+ val + "%'";
            stmt = this.con.createStatement();
          
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
            	HoaDon hd = new HoaDon(rs);
            	hd.setChiTietHoaDons(new ChiTietHoaDon_dao().getDSChiTietHD(hd.getMaHD()));
            	dshd.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    	
    	return dshd;
    }
	
	public List<HoaDon> timKiem(String where) {
    	Statement stmt = null;
    	List<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
            String sql = "SELECT * FROM dbo.HoaDon inner join dbo.KhachHang on dbo.HoaDon.maKhachHang = dbo.KhachHang.maKhachHang where "+ where;
            stmt = this.con.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            
            while(rs.next()) {

            	HoaDon hd = new HoaDon(rs);
            	hd.setChiTietHoaDons(new ChiTietHoaDon_dao().getDSChiTietHD(hd.getMaHD()));
            	dshd.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    	
    	return dshd;
    }
	
	public boolean xoaHD(int maHD) {
		PreparedStatement stmt = null;
		int n = 0;

        try {
        	
        	String sql = "DELETE from dbo.HoaDon WHERE maHoaDon = ?";
        	PreparedStatement prpStmt = this.con.prepareStatement(sql);
        	
        	prpStmt.setInt(1, maHD);
            n = prpStmt.executeUpdate();
               
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    	
    	return n>0;
	}
	
	public String getError() {
		return this.error;
	}
	
	public ArrayList<HoaDon> findHoaDon(String value, String type) {
		ArrayList<HoaDon> dshd = new ArrayList<>();
		
		if(type.equals("tenKhachHang") || type.equals("soDienThoai")) {
			try {
	            PreparedStatement ps = this.con.prepareStatement("SELECT maHoaDon, a.maKhachHang, maNhanVien, tongTien, ngayLap, tenKhachHang "
	            		+ "FROM dbo.HoaDon as a "
	            		+ "join KhachHang as b on a.maKhachHang = b.maKhachHang where " + type + " like ? ");
	            ps.setString(1,"%" +  value + "%");
	            
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	HoaDon hd = new HoaDon(rs);
	            	hd.setChiTietHoaDons(new ChiTietHoaDon_dao().getDSChiTietHD(hd.getMaHD()));
	            	dshd.add(hd);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
		}else {
			try {
	            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM dbo.HoaDon where " + type + " like ? ");
	            ps.setString(1,"%" +  value + "%");
	            
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	HoaDon hd = new HoaDon(rs);
	            	hd.setChiTietHoaDons(new ChiTietHoaDon_dao().getDSChiTietHD(hd.getMaHD()));
	            	dshd.add(hd);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
		}
		return dshd;
	}
	
	public ArrayList<HoaDon> thuocBanChay(){
		Connection con = ConnectDB.getConnection();
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		String sql = " select top 5 a.maThuoc,sum(a.soLuong) as soLuong ,sum(b.tongTien) as tongTien,c.tenThuoc,c.hanSuDung from ChiTietHoaDon a join HoaDon b on a.maHoaDon = b.maHoaDon "
				+ "	join Thuoc c on a.maThuoc = c.maThuoc "
				+ "	group by a.maThuoc, c.tenThuoc,c.hanSuDung "
				+ "	order by soLuong DESC";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				HoaDon hoadon = new HoaDon(rs.getInt("maThuoc"),rs.getString("tenThuoc"),rs.getInt("soLuong"),rs.getDouble("tongTien"),rs.getString("hanSuDung"));
				dshd.add(hoadon);
			}
			return dshd;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return dshd;
		
	}
	
	
	

	
	
}