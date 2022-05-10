package entity;

import java.util.Objects;

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
	
	
	public KhachHang(String tenKhachHang, String soDienThoai) {
		super();
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
