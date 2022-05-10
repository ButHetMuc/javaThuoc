package entity;

import java.sql.Time;
import java.util.Objects;

public class CaLam {
	private int maCaLam;
	private String tenCaLam;
	private Time thoiGianBatDau;
	private Time thoiGianKetThuc;
	public CaLam(int maCaLam, String tenCaLam, Time thoiGianBatDau, Time thoiGianKetThuc) {
		super();
		this.maCaLam = maCaLam;
		this.tenCaLam = tenCaLam;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	
	public CaLam(int maCaLam) {

		super();
		this.maCaLam = maCaLam;
	}

	public CaLam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMaCaLam() {
		return maCaLam;
	}

	public void setMaCaLam(int maCaLam) {

		this.maCaLam = maCaLam;
	}

	public String getTenCaLam() {
		return tenCaLam;
	}

	public void setTenCaLam(String tenCaLam) {
		this.tenCaLam = tenCaLam;
	}

	public Time getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Time thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Time getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Time thoiGianKetThuc) {

		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	@Override
	public String toString() {
		return " Ca làm: " + maCaLam+"\n"+ " Tên ca làm: " + tenCaLam +"\n"+ " Thời gian bắt đầu: " + thoiGianBatDau
				+ "\n Thời gian kết thúc: " + thoiGianKetThuc+"";
	}
	
}