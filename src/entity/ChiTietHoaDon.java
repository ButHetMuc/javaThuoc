package entity;

public class ChiTietHoaDon {
	private int maChiTietHoaDon;
	private int soLuong;
	private double donGia;
	public HoaDon hoaDon;
	public Thuoc thuoc;
	
	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(int maChiTietHoaDon) {
		super();
		this.maChiTietHoaDon = maChiTietHoaDon;
	}

	public ChiTietHoaDon(int maChiTietHoaDon, int soLuong, double donGia, HoaDon hoaDon, Thuoc thuoc) {
		super();
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.hoaDon = hoaDon;
		this.thuoc = thuoc;
	}

	public int getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}

	public void setMaChiTietHoaDon(int maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maChiTietHoaDon;
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
		if (maChiTietHoaDon != other.maChiTietHoaDon)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [maChiTietHoaDon=" + maChiTietHoaDon + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ ", hoaDon=" + hoaDon + ", thuoc=" + thuoc + "]";
	}
	
	
	
	
}
