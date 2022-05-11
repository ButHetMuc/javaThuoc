package entity;

import java.util.Objects;

public class NhaCungCap {
	
	private int maNhaCungCap;
	private String tenNhaCungCap;
	
	public NhaCungCap(int maNhaCungCap, String tenNhaCungCap) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
	}
	
	public NhaCungCap() {
		super();
	}
	
	public NhaCungCap(int maNhaCungCap) {
		super();
		this.maNhaCungCap = maNhaCungCap;
	}
	
	public int getMaNhaCungCap() {
		return maNhaCungCap;
	}
	
	public void setMaNhaCungCap(int maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}
	
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maNhaCungCap);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		return maNhaCungCap == other.maNhaCungCap;
	}
	
	@Override
	public String toString() {
		return "maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap;
	}
	
	

}
