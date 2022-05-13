package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import entity.TaiKhoan;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Admin extends JFrame  {

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
	private JMenuItem mntmTimKiemHD;
	private JMenu mnKhachHang;
	private JMenuItem mntmQuanLiKH;
	private JMenuItem mntmThemKH;
	private JMenuItem mntmTimKH;
	private JMenu mnNhanVien;
	private JMenuItem mntmQuanLiNV;
	private JMenu mnDoanhThu;
	private JMenuItem mntmDoanhThu;
	private JMenuItem mntmThemTK;
	
	private DangNhap_gui dangNhapGui = new DangNhap_gui();
	private DoanhThu_gui doanhThuGui = new DoanhThu_gui();
	private HoaDon_gui hoaDonGui = new HoaDon_gui();
	private KhachHang_gui khachHangGui = new KhachHang_gui();
	private NhanVien_gui nhanVienGui = new NhanVien_gui();
	private QuanLiThuoc_gui quanLiThuocGui = new QuanLiThuoc_gui();
	private TaoHoaDon_gui taoHoaDonGui = new TaoHoaDon_gui();
	private TimKiemHoaDon_gui timKiemHoaDonGui = new TimKiemHoaDon_gui();
	private TimKiemThuoc timKiemThuocGui = new TimKiemThuoc();
	private TrangChu_gui trangChuGui = new TrangChu_gui();
	private JMenuItem mntmThemHoaDon;
	private ImageIcon icon;
	
	

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
	public Admin() throws SQLException {
		setTitle("Quản lí hiệu thuốc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1300, 700);
		icon = new ImageIcon("data/images/snakelogo1.png");
		setIconImage(icon.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		renderMain(dangNhapGui.getContentPane(), "Trang chủ");
		loginUser();
//		appMenu();
		
		
		
	}
	public void appMenu() {
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		mnTrangChu = new JMenu("Trang chủ");
		menuBar.add(mnTrangChu);
		
		mnThuoc = new JMenu("Thuốc");
		menuBar.add(mnThuoc);
		
		mntmQuanLiThuoc = new JMenuItem("Quản lí thuốc");
		mnThuoc.add(mntmQuanLiThuoc);
		
		
		mntmThongke = new JMenuItem("Thống kê thuốc");
		mnThuoc.add(mntmThongke);
		
		mnHoaDon = new JMenu("Hóa đơn");
		menuBar.add(mnHoaDon);
		
		mntmQuanLiHD = new JMenuItem("Quản lí hóa đơn");
		mnHoaDon.add(mntmQuanLiHD);
		
		mntmThemHoaDon = new JMenuItem("Thêm hóa đơn");
		mnHoaDon.add(mntmThemHoaDon);
		
		mntmTimKiemHD = new JMenuItem("Tìm kiếm hóa đơn");
		mnHoaDon.add(mntmTimKiemHD);
		
		mnKhachHang = new JMenu("Khách hàng");
		menuBar.add(mnKhachHang);
		
		mntmQuanLiKH = new JMenuItem("Quản lí Khách hàng");
		mnKhachHang.add(mntmQuanLiKH);
				
		mnNhanVien = new JMenu("Nhân viên");
		menuBar.add(mnNhanVien);
		
		mntmQuanLiNV = new JMenuItem("Quản lí nhân viên");
		mnNhanVien.add(mntmQuanLiNV);
		
		mnDoanhThu = new JMenu("Doanh thu");
		menuBar.add(mnDoanhThu);
		
		mntmDoanhThu = new JMenuItem("Xem doanh thu");
		mnDoanhThu.add(mntmDoanhThu);
		
		mnTrangChu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				renderMain(trangChuGui.getContentpane(), "Trang chủ");
				
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		mntmQuanLiThuoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain(quanLiThuocGui.getContentpane(),"quan li thuoc");
			}
		});
		mntmQuanLiKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain(khachHangGui.getContentPane(), "quan li khach hang");
			}
		});
		mntmQuanLiNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain((JPanel)nhanVienGui.getContentPane(), "quan li nhan vien");
			}
		});
		mntmQuanLiHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain(hoaDonGui.getContentPane(), "quan li hoa don");
			}
		});
		mntmThemHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain(taoHoaDonGui.getContentPane(), "tao hoa don");
			}
		});
		mntmTimKiemHD.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					renderMain(timKiemHoaDonGui.getContentPane(), "tim hoa don");
				}
			});
			

		mntmDoanhThu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain(doanhThuGui.getContenpain(), "doanh thu");
			}
		});
		
	}
	
	public void renderMain(JPanel contentPane, String tab) {
		this.remove(this.contentPane);
		this.revalidate();
		this.repaint();
		this.contentPane = contentPane;
		this.setContentPane(contentPane);
		this.revalidate();
		this.repaint();


	}
	public void loginUser() {
		dangNhapGui.btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dangNhapGui.checkPassword()) {					
					renderMain(trangChuGui.getContentpane(), "chao mung");
					appMenu();
					menuBar.setVisible(true);
					menuBar.revalidate();
					menuBar.repaint();

					dangNhapGui.clear();

				} 
			}
		});

	}
}
