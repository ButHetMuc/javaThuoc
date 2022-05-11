package entity;

import java.util.Objects;

public class LoaiThuoc {
	private int maLoai;
	private String tenLoai;

	public LoaiThuoc(String ma) {
		
	}

	public LoaiThuoc(int maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}

	public LoaiThuoc() {
		super();
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiThuoc other = (LoaiThuoc) obj;
		return maLoai == other.maLoai;
	}

	@Override
	public String toString() {
		return "maLoai=" + maLoai + ", tenLoai=" + tenLoai;
	}
	

}
