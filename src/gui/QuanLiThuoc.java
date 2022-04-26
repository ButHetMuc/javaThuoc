package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.Box;

public class QuanLiThuoc extends JFrame {

	private JPanel contentPane;
	private JComboBox cboLoaiThuoc;
	private JTextField txtMaThuoc;
	private JTextField txtTenThuoc;
	private JComboBox cboNhaCC;
	private JTable tblDsThuoc;
	private DefaultTableModel modelDsThuoc;
	private JTextField txtTimKiem;
	private JTextField txtNgaySanXuat;
	private JTextField txtHanSuDung;
	private JTextField txtDonGia;
	private JTextField txtSoLuong;
	private JButton btnThemMoi;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnLamMoi;
	private JComboBox cboLoaiThuoc2;
	private JButton btnTimThuoc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiThuoc frame = new QuanLiThuoc();
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
	public QuanLiThuoc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnTop = new JPanel();
		pnTop.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		pnTop.setFont(new Font("Tahoma", Font.BOLD, 20));
		FlowLayout flowLayout = (FlowLayout) pnTop.getLayout();
		contentPane.add(pnTop, BorderLayout.NORTH);
		
		JLabel lblTieuDe = new JLabel("Quản Lí Thuốc");
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnTop.add(lblTieuDe);
		
		JPanel pnLeft = new JPanel();
		pnLeft.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		contentPane.add(pnLeft, BorderLayout.WEST);
		pnLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pnThongTin = new JPanel();
		pnLeft.add(pnThongTin);
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		
		JPanel pnLblThongTin = new JPanel();
		pnLblThongTin.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnThongTin.add(pnLblThongTin);
		
		JLabel lblTitile = new JLabel("Thông Tin Thuốc");
		lblTitile.setFont(new Font("Tahoma", Font.BOLD, 17));
		pnLblThongTin.add(lblTitile);
		
		JPanel pnLoaiTimKiem = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnLoaiTimKiem.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		pnThongTin.add(pnLoaiTimKiem);
		
		JPanel pnLoaiThuoc = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) pnLoaiThuoc.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnLoaiThuoc);
		
		JLabel lblLoaiThuoc = new JLabel("Loại thuốc");
		lblLoaiThuoc.setPreferredSize(new Dimension(80, 14));
		pnLoaiThuoc.add(lblLoaiThuoc);
		
		cboLoaiThuoc = new JComboBox();
		cboLoaiThuoc.setPreferredSize(new Dimension(204, 23));
		pnLoaiThuoc.add(cboLoaiThuoc);
		
		JPanel pnMaThuoc = new JPanel();
		FlowLayout fl_pnMaThuoc = (FlowLayout) pnMaThuoc.getLayout();
		fl_pnMaThuoc.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnMaThuoc);
		
		JLabel lblMaThuoc = new JLabel("Mã thuốc");
		lblMaThuoc.setPreferredSize(new Dimension(80, 14));
		pnMaThuoc.add(lblMaThuoc);
		
		txtMaThuoc = new JTextField();
		txtMaThuoc.setPreferredSize(new Dimension(7, 23));
		pnMaThuoc.add(txtMaThuoc);
		txtMaThuoc.setColumns(22);
		
		JPanel pnTenThuoc = new JPanel();
		FlowLayout fl_pnTenThuoc = (FlowLayout) pnTenThuoc.getLayout();
		fl_pnTenThuoc.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnTenThuoc);
		
		JLabel lblTenThuoc = new JLabel("Tên thuốc");
		lblTenThuoc.setPreferredSize(new Dimension(80, 14));
		pnTenThuoc.add(lblTenThuoc);
		
		txtTenThuoc = new JTextField();
		txtTenThuoc.setPreferredSize(new Dimension(7, 23));
		pnTenThuoc.add(txtTenThuoc);
		txtTenThuoc.setColumns(22);
		
		JPanel pnNhaCC = new JPanel();
		FlowLayout fl_pnNhaCC = (FlowLayout) pnNhaCC.getLayout();
		fl_pnNhaCC.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnNhaCC);
		
		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp");
		lblNhaCungCap.setPreferredSize(new Dimension(80, 14));
		pnNhaCC.add(lblNhaCungCap);
		
		cboNhaCC = new JComboBox();
		cboNhaCC.setPreferredSize(new Dimension(204, 23));
		pnNhaCC.add(cboNhaCC);
		
		JPanel pnNgaySanXuat = new JPanel();
		pnThongTin.add(pnNgaySanXuat);
		
		JLabel lblNgaySanXuat = new JLabel("Ngày sản xuất");
		lblNgaySanXuat.setPreferredSize(new Dimension(80, 14));
		pnNgaySanXuat.add(lblNgaySanXuat);
		
		txtNgaySanXuat = new JTextField();
		txtNgaySanXuat.setPreferredSize(new Dimension(7, 23));
		txtNgaySanXuat.setColumns(22);
		pnNgaySanXuat.add(txtNgaySanXuat);
		
		JPanel pnHanSuDung = new JPanel();
		pnThongTin.add(pnHanSuDung);
		
		JLabel lblHanSuDung = new JLabel("Hạn sử dụng");
		lblHanSuDung.setPreferredSize(new Dimension(80, 14));
		pnHanSuDung.add(lblHanSuDung);
		
		txtHanSuDung = new JTextField();
		txtHanSuDung.setPreferredSize(new Dimension(7, 23));
		txtHanSuDung.setColumns(22);
		pnHanSuDung.add(txtHanSuDung);
		
		JPanel pnDonGia = new JPanel();
		pnThongTin.add(pnDonGia);
		
		JLabel lblDonGia = new JLabel("Đơn giá");
		lblDonGia.setPreferredSize(new Dimension(80, 14));
		pnDonGia.add(lblDonGia);
		
		txtDonGia = new JTextField();
		txtDonGia.setPreferredSize(new Dimension(7, 23));
		txtDonGia.setColumns(22);
		pnDonGia.add(txtDonGia);
		
		JPanel pnSoLuong = new JPanel();
		pnThongTin.add(pnSoLuong);
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setPreferredSize(new Dimension(80, 14));
		pnSoLuong.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setPreferredSize(new Dimension(7, 23));
		txtSoLuong.setColumns(22);
		pnSoLuong.add(txtSoLuong);
		
		JPanel pnChucNang = new JPanel();
		pnThongTin.add(pnChucNang);
		pnChucNang.setLayout(new GridLayout(0, 2, 0, 0));
		
		Box horizontalBox = Box.createHorizontalBox();
		pnChucNang.add(horizontalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		pnChucNang.add(horizontalBox_1);
		
		btnThemMoi = new JButton("Thêm mới");
		btnThemMoi.setBackground(Color.WHITE);
		pnChucNang.add(btnThemMoi);
		
		btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.WHITE);
		pnChucNang.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.WHITE);
		pnChucNang.add(btnXoa);
		
		btnLamMoi = new JButton("làm mới");
		btnLamMoi.setBackground(Color.WHITE);
		pnChucNang.add(btnLamMoi);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), 
				new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		contentPane.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnCenter.add(pnCenterTop, BorderLayout.NORTH);
		
		JLabel lblttLoaiThuoc = new JLabel("Loại thuốc");
		pnCenterTop.add(lblttLoaiThuoc);
		
	
		cboLoaiThuoc2 = new JComboBox();
		cboLoaiThuoc2.setPreferredSize(new Dimension(100, 23));
		pnCenterTop.add(cboLoaiThuoc2);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setPreferredSize(new Dimension(7, 23));
		pnCenterTop.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnTimThuoc = new JButton("Tìm");
		btnTimThuoc.setBackground(Color.WHITE);
		pnCenterTop.add(btnTimThuoc);
		
		JPanel pnCenterMiddle = new JPanel();
		pnCenter.add(pnCenterMiddle, BorderLayout.SOUTH);
		
		String[] cols = {"Mã thuốc","Tên thuốc","Loại","Ngày sản xuất","Hạn sử dụng","Đơn giá","số lượng"};
		modelDsThuoc = new DefaultTableModel(cols,0);
		tblDsThuoc = new JTable(modelDsThuoc);
		JScrollPane scrtbl = new JScrollPane(tblDsThuoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		pnCenter.add(scrtbl, BorderLayout.CENTER);
	}

}
