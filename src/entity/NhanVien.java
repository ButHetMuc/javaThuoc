package entity;

import java.sql.Date;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class NhanVien {
	private int maNhanVien;
	private TaiKhoan taiKhoan;
	private CaLam caLam;
	private String tenNhanVien;
	private String CMND;
	private String soDienThoai;
	private String diaChi;
	private Date ngaySinh;
	private boolean gioiTinh;
	private BigDecimal luong;
	public NhanVien( TaiKhoan taiKhoan, CaLam caLam, String tenNhanVien, String cMND, String soDienThoai,
			String diaChi, Date ngaySinh, boolean gioiTinh, BigDecimal luong) {
		super();
		this.taiKhoan = taiKhoan;
		this.caLam = caLam;
		this.tenNhanVien = tenNhanVien;
		CMND = cMND;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.luong = luong;
	}
	
	
	public NhanVien(int maNhanVien, TaiKhoan taiKhoan, CaLam caLam, String tenNhanVien, String cMND, String soDienThoai,
			String diaChi, Date ngaySinh, boolean gioiTinh, BigDecimal luong) {
		this.maNhanVien = maNhanVien;
		this.taiKhoan = taiKhoan;
		this.caLam = caLam;
		this.tenNhanVien = tenNhanVien;
		CMND = cMND;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.luong = luong;
	}


	public NhanVien(int maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public CaLam getCaLam() {
		return caLam;
	}

	public void setCaLam(CaLam caLam) {
		this.caLam = caLam;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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

	public BigDecimal getLuong() {
		return luong;
	}

	public void setLuong(BigDecimal luong) {
		this.luong = luong;
	}


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

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", taiKhoan=" + taiKhoan + ", caLam=" + caLam + ", tenNhanVien="
				+ tenNhanVien + ", CMND=" + CMND + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", ngaySinh="
				+ ngaySinh + ", gioiTinh=" + gioiTinh + ", luong=" + luong + "]";
	}
	
	}