package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Thuoc {
	private int maThuoc;
	private String tenThuoc;
	private NhaCungCap nhaCungCap;
	private LoaiThuoc loaiThuoc;
	private String ngaySanXuat;
	private String ngayHetHan;
	private String donViTinh;
	private double donGia;
	private int soLuong;
	
	public Thuoc(int maThuoc, String tenThuoc, NhaCungCap nhaCungCap, LoaiThuoc loaiThuoc, String ngaySanXuat,
			String ngayHetHan, String donViTinh, double donGia, int soLuong) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.nhaCungCap = nhaCungCap;
		this.loaiThuoc = loaiThuoc;
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHan = ngayHetHan;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public Thuoc() {
		super();
	}

	public Thuoc(int maThuoc) {
		super();
		this.maThuoc = maThuoc;
	}
	
	public Thuoc(ResultSet rs) throws NumberFormatException, SQLException {
		super();
		this.maThuoc = rs.getInt("maThuoc");
		this.nhaCungCap = new NhaCungCap(rs.getInt("maNhaCungCap"),rs.getString("tenNhaCungCap"));
		this.tenThuoc = rs.getString("tenThuoc");
		this.loaiThuoc = new LoaiThuoc(rs.getInt("maLoaiThuoc"),rs.getString("tenLoai"));
		this.ngaySanXuat = rs.getString("ngaySanXuat");
		this.ngayHetHan = rs.getString("hanSuDung");
		this.donViTinh = rs.getString("donViTinh");
		this.donGia = rs.getDouble("donGia");
		this.soLuong = rs.getInt("soLuong");
	}

	

	public Thuoc(LoaiThuoc loaiThuoc, String tenThuoc, NhaCungCap nhaCungCap, String ngaySX, String hanSD,
			double donGia, int soLuong) {
		this.loaiThuoc = loaiThuoc;
		this.tenThuoc = tenThuoc;
		this.nhaCungCap = nhaCungCap;
		this.ngaySanXuat = ngaySX;
		this.ngayHetHan = hanSD;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public Thuoc(int maThuoc, LoaiThuoc loaiThuoc, String tenThuoc, NhaCungCap nhaCungCap, String ngaySX,
			String hanSD, double donGia, int soLuong) {
		this.maThuoc = maThuoc;
		this.loaiThuoc = loaiThuoc;
		this.tenThuoc = tenThuoc;
		this.nhaCungCap = nhaCungCap;
		this.ngaySanXuat = ngaySX;
		this.ngayHetHan = hanSD;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

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

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public LoaiThuoc getLoaiThuoc() {
		return loaiThuoc;
	}

	public void setLoaiThuoc(LoaiThuoc loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
	}

	public String getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(String ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public String getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(String ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maThuoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thuoc other = (Thuoc) obj;
		return maThuoc == other.maThuoc;
	}

	@Override
	public String toString() {
		return "maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", nhaCungCap=" + nhaCungCap + ", loaiThuoc="
				+ loaiThuoc + ", ngaySanXuat=" + ngaySanXuat + ", ngayHetHan=" + ngayHetHan + ", donViTinh=" + donViTinh
				+ ", donGia=" + donGia + ", soLuong=" + soLuong ;
	}
	
	

}
