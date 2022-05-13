package entity;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import dao.KhachHang_dao;

import dao.NhanVien_dao;


public class HoaDon {
	
	private int maHD;
	private Date ngayLap;
	private double tongTien;
	
	
	public NhanVien nhanVien;
	public KhachHang khachHang;
	public ArrayList<ChiTietHoaDon> chiTietHoaDons = new ArrayList<ChiTietHoaDon>();
	
	
	public HoaDon() {
		super();
	}

	public HoaDon(int maHD) {
		super();
		this.maHD = maHD;
	}
	
	public HoaDon(NhanVien nhanVien, KhachHang khachHang,
			ArrayList<ChiTietHoaDon> chiTietHoaDons) {
		super();
		
		this.ngayLap = new Date(new java.util.Date().getTime());
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.chiTietHoaDons = chiTietHoaDons;
		this.tongTien = tinhTongTien();
	}
	
	public HoaDon(int maHD, Date ngayLap, double tongTien, NhanVien nhanVien, KhachHang khachHang,
			ArrayList<ChiTietHoaDon> chiTietHoaDons) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.chiTietHoaDons = chiTietHoaDons;
	}
	
	public HoaDon(ResultSet rs) throws SQLException {
		this.maHD = rs.getInt("maHoaDon");
		this.ngayLap = rs.getDate("ngayLap");
		this.tongTien = rs.getDouble("tongTien");
		try {
			this.nhanVien = new NhanVien(rs);
		}catch (Exception e) {
			this.nhanVien = new NhanVien_dao().findNhanVienById(rs.getString("maNhanVien"));
		}
		try {
			this.khachHang = new KhachHang(rs);
		}catch (Exception e) {
			this.khachHang = new KhachHang_dao().getKhachHang(rs.getInt("maKhachHang"));
		}
		
	}
	
	private int maThuoc;
	private String tenThuoc;
	private int soLuong;
	
	public int getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(int maThuoc) {
		this.maThuoc = maThuoc;
	}

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	private String hsd;
	public HoaDon(int maThuoc, String tenThuoc, int soLuong, double tongTien,String hanSuDung) {
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
		this.hsd = hanSuDung;
	}

	public String getHsd() {
		return hsd;
	}

	public void setHsd(String hsd) {
		this.hsd = hsd;
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public ArrayList<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public void setChiTietHoaDons(ArrayList<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maHD;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		if (maHD != other.maHD)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + ", nhanVien=" + nhanVien
				+ ", khachHang=" + khachHang + ", chiTietHoaDons=" + chiTietHoaDons + "]";
	}

	public double tinhTongTien() {
		double tongTien = 0;
		for(int i=0; i<chiTietHoaDons.size(); i++) {
			tongTien += chiTietHoaDons.get(i).tinhThanhTien();
		}
		return tongTien;
		
	}
	
}
