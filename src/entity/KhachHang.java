package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import dao.KhachHang_dao;

public class KhachHang {
	private int maKhachHang;
	private String tenKhachHang;
	private String soDienThoai;
	
	public KhachHang(int maKhachHang, String tenKhachHang, String soDienThoai) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
	}
	
	public KhachHang(ResultSet rs) throws SQLException {
		try {
			this.maKhachHang = rs.getInt("MaKhachHang");
		}catch (Exception e) {
			
		}
		try {
			this.tenKhachHang = rs.getString("TenKhachHang");
			this.soDienThoai = rs.getString("SoDienThoai");
			
		}catch (Exception e) {
			KhachHang tmp = new KhachHang_dao().getKhachHang(this.maKhachHang);
			this.tenKhachHang = tmp.getTenKhachHang();
			this.soDienThoai = tmp.getSoDienThoai();
			try {
			}catch(Exception ex) {
				//ex.printStackTrace();
			}
			
			}
		}
	
	public KhachHang(String tenKhachHang, String soDienThoai) {
		super();
		this.maKhachHang = 0;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
	}


	public KhachHang() {
		super();
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return maKhachHang == other.maKhachHang;
	}
	
	
	
}
