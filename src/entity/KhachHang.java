package entity;

import java.util.Objects;

public class KhachHang {
	private int maKhachHang;
	private int tenKhachHang;
	private int diaChi;
	
	public KhachHang() {
		super();
	}
	public KhachHang(int maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}
	public KhachHang(int maKhachHang, int tenKhachHang, int diaChi) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
	}
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public int getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(int tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public int getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(int diaChi) {
		this.diaChi = diaChi;
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
