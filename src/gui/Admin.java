package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnTrangChu;
	private JMenu mnThuoc;
	private JMenuItem mntmQuanLiThuoc;
	private JMenuItem mntmTimThuoc;
	private JMenuItem mntmThemthuoc;
	private JMenuItem mntmThongke;
	private JMenu mnHoaDon;
	private JMenuItem mntmQuanLiHD;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmTimKiemHD;
	private JMenu mnKhachHang;
	private JMenuItem mntmQuanLiKH;
	private JMenuItem mntmThemKH;
	private JMenuItem mntmTimKH;
	private JMenu mnNhanVien;
	private JMenuItem mntmQuanLiNV;
	private JMenuItem mntmThemNv;
	private JMenuItem mntmTimKiemNV;
	private JMenu mnTaiKhoan;
	private JMenuItem mntmQuanLiTK;
	private JMenuItem mntmThemTK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		mnTrangChu = new JMenu("Trang chủ");
		menuBar.add(mnTrangChu);
		
		mnThuoc = new JMenu("Thuốc");
		menuBar.add(mnThuoc);
		
		mntmQuanLiThuoc = new JMenuItem("Quản lí thuốc");
		mnThuoc.add(mntmQuanLiThuoc);
		
		mntmTimThuoc = new JMenuItem("Tìm thuốc");
		mnThuoc.add(mntmTimThuoc);
		
		mntmThemthuoc = new JMenuItem("Thêm thuốc");
		mnThuoc.add(mntmThemthuoc);
		
		mntmThongke = new JMenuItem("Thống kê thuốc");
		mnThuoc.add(mntmThongke);
		
		mnHoaDon = new JMenu("Hóa đơn");
		menuBar.add(mnHoaDon);
		
		mntmQuanLiHD = new JMenuItem("Quản lí hóa đơn");
		mnHoaDon.add(mntmQuanLiHD);
		
		mntmNewMenuItem = new JMenuItem("Thêm hóa đơn");
		mnHoaDon.add(mntmNewMenuItem);
		
		mntmTimKiemHD = new JMenuItem("Tìm kiếm hóa đơn");
		mnHoaDon.add(mntmTimKiemHD);
		
		mnKhachHang = new JMenu("Khách hàng");
		menuBar.add(mnKhachHang);
		
		mntmQuanLiKH = new JMenuItem("Quản lí Khách hàng");
		mnKhachHang.add(mntmQuanLiKH);
		
		mntmThemKH = new JMenuItem("Thêm khách hàng");
		mnKhachHang.add(mntmThemKH);
		
		mntmTimKH = new JMenuItem("Tìm kiếm khách hàng");
		mnKhachHang.add(mntmTimKH);
		
		mnNhanVien = new JMenu("Nhân viên");
		menuBar.add(mnNhanVien);
		
		mntmQuanLiNV = new JMenuItem("Quản lí nhân viên");
		mnNhanVien.add(mntmQuanLiNV);
		
		mntmThemNv = new JMenuItem("Thêm nhân viên");
		mnNhanVien.add(mntmThemNv);
		
		mntmTimKiemNV = new JMenuItem("Tìm kiếm nhân viên");
		mnNhanVien.add(mntmTimKiemNV);
		
		mnTaiKhoan = new JMenu("Khách hàng");
		menuBar.add(mnTaiKhoan);
		
		mntmQuanLiTK = new JMenuItem("Quản lí tài khoản");
		mnTaiKhoan.add(mntmQuanLiTK);
		
		mntmThemTK = new JMenuItem("Thêm tài khoản");
		mnTaiKhoan.add(mntmThemTK);
	}

}
