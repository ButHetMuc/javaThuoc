package entity;

import java.sql.SQLException;

public class ChiTietHoaDon {
	public HoaDon hoaDon;
	public Thuoc thuoc;
	
	private int soLuong;
	private double donGia;
	
	

	public ChiTietHoaDon(HoaDon hoaDon, Thuoc thuoc, int soLuong, double donGia) {
		super();
		this.hoaDon = hoaDon;
		this.thuoc = thuoc;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	

	public ChiTietHoaDon(HoaDon hoaDon, Thuoc thuoc, int soLuong) {
		super();
		this.hoaDon = hoaDon;
		this.thuoc = thuoc;
		this.soLuong = soLuong;
	}



	public ChiTietHoaDon(Thuoc thuoc, int soLuong) {
		super();
		this.thuoc = thuoc;
		this.soLuong = soLuong;
	}



	public HoaDon getHoaDon() {
		return hoaDon;
	}



	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}



	public Thuoc getThuoc() {
		return thuoc;
	}



	public void setThuoc(Thuoc thuoc) {
		this.thuoc = thuoc;
	}



	public int getSoLuong() {
		return soLuong;
	}



	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}



	public double getDonGia() {
		return donGia;
	}



	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}



	public ChiTietHoaDon(HoaDon hoaDon) {
		super();
		this.hoaDon = hoaDon;
	}



	public ChiTietHoaDon() {
		super();
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoaDon == null) ? 0 : hoaDon.hashCode());
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
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		if (hoaDon == null) {
			if (other.hoaDon != null)
				return false;
		} else if (!hoaDon.equals(other.hoaDon))
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", thuoc=" + thuoc + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ "]";
	}



	public double tinhThanhTien() {
		return this.donGia * this.soLuong;
	}

		
}
