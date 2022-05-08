package entity;

import java.sql.Date;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class NhanVien {
	private int maNhanVien;
	private String tenNhanVien;
	private String chungMinhNhanDan;
	private String diaChi;
	private String soDienThoai;
	private Date ngaySinh;
	private boolean gioiTinh;
	private double tienLuong;
	private CaLam caLam;
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return maNhanVien == other.maNhanVien;
	}
	public NhanVien() {
		super();
	}
	public NhanVien(String tenNhanVien, String chungMinhNhanDan, String diaChi, String soDienThoai, Date ngaySinh,
			boolean gioiTinh, double tienLuong, CaLam caLam) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.chungMinhNhanDan = chungMinhNhanDan;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.tienLuong = tienLuong;
		this.caLam = caLam;
	}
	public NhanVien(int maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	public NhanVien(int maNhanVien, String tenNhanVien, String chungMinhNhanDan, String diaChi, String soDienThoai,
			Date ngaySinh, boolean gioiTinh, double tienLuong, CaLam caLam) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.chungMinhNhanDan = chungMinhNhanDan;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.tienLuong = tienLuong;
		this.caLam = caLam;
	}
	public int getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getChungMinhNhanDan() {
		return chungMinhNhanDan;
	}
	public void setChungMinhNhanDan(String chungMinhNhanDan) {
		this.chungMinhNhanDan = chungMinhNhanDan;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public double getTienLuong() {
		return tienLuong;
	}
	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}
	public CaLam getCaLam() {
		return caLam;
	}
	public void setCaLam(CaLam caLam) {
		this.caLam = caLam;
	}

	
}

