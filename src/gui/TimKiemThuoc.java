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
import java.sql.SQLException;

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

public class TimKiemThuoc extends JFrame {

	private JPanel contentPane;
	private JComboBox cboLoaiThuoc;
	private JTextField txtTenThuoc;
	private JTextField txtMaThuoc;
	private JButton btnLamMoi;
	private JComboBox cboNhaCC;
	private JButton btnTim;
	private JTable tblDsThuoc;
	private DefaultTableModel modelDsThuoc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemThuoc frame = new TimKiemThuoc();
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
	public TimKiemThuoc() throws SQLException {
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
		
		JLabel lblTieuDe = new JLabel("Tìm Kiếm Thuốc");
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
		
		JLabel lblTitile = new JLabel("Thông tin tìm kiếm");
		lblTitile.setFont(new Font("Tahoma", Font.BOLD, 17));
		pnLblThongTin.add(lblTitile);
		
		JPanel pnLoaiTimKiem = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnLoaiTimKiem.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		pnThongTin.add(pnLoaiTimKiem);
		
		JLabel lblLoaiTimKiem = new JLabel("Tìm chính xác");
		lblLoaiTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		pnLoaiTimKiem.add(lblLoaiTimKiem);
		
		JPanel pnLoaiThuoc = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) pnLoaiThuoc.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnLoaiThuoc);
		
		JLabel lblLoaiThuoc = new JLabel("Loại thuốc");
		lblLoaiThuoc.setPreferredSize(new Dimension(80, 14));
		pnLoaiThuoc.add(lblLoaiThuoc);
		
		cboLoaiThuoc = new JComboBox();
		cboLoaiThuoc.setPreferredSize(new Dimension(204, 22));
		pnLoaiThuoc.add(cboLoaiThuoc);
		
		JPanel pnTenThuoc = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) pnTenThuoc.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnTenThuoc);
		
		JLabel lblTenThuoc = new JLabel("Tên thuốc");
		lblTenThuoc.setPreferredSize(new Dimension(80, 14));
		pnTenThuoc.add(lblTenThuoc);
		
		txtTenThuoc = new JTextField();
		pnTenThuoc.add(txtTenThuoc);
		txtTenThuoc.setColumns(22);
		
		JCheckBox chkTenThuoc = new JCheckBox("");
		chkTenThuoc.setActionCommand("");
		pnTenThuoc.add(chkTenThuoc);
		
		JPanel pnMaThuoc = new JPanel();
		FlowLayout fl_pnMaThuoc = (FlowLayout) pnMaThuoc.getLayout();
		fl_pnMaThuoc.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnMaThuoc);
		
		JLabel lblMaThuoc = new JLabel("Mã thuốc");
		lblMaThuoc.setPreferredSize(new Dimension(80, 14));
		pnMaThuoc.add(lblMaThuoc);
		
		txtMaThuoc = new JTextField();
		pnMaThuoc.add(txtMaThuoc);
		txtMaThuoc.setColumns(22);
		
		JCheckBox chkMaThuoc = new JCheckBox("");
		pnMaThuoc.add(chkMaThuoc);
		
		JPanel pnNhaCC = new JPanel();
		FlowLayout fl_pnNhaCC = (FlowLayout) pnNhaCC.getLayout();
		fl_pnNhaCC.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnNhaCC);
		
		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp");
		lblNhaCungCap.setPreferredSize(new Dimension(80, 14));
		pnNhaCC.add(lblNhaCungCap);
		
		cboNhaCC = new JComboBox();
		cboNhaCC.setPreferredSize(new Dimension(204, 22));
		pnNhaCC.add(cboNhaCC);
		
		JPanel pnChucNang = new JPanel();
		pnThongTin.add(pnChucNang);
		pnChucNang.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnTim = new JButton("Tìm");
		btnTim.setBackground(Color.WHITE);
		btnTim.setPreferredSize(new Dimension(74, 23));
		pnChucNang.add(btnTim);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setPreferredSize(new Dimension(100, 23));
		pnChucNang.add(btnLamMoi);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), 
				new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		contentPane.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnCenter.add(pnCenterTop, BorderLayout.NORTH);
		
		JLabel lblKetQua = new JLabel("Kết quả tìm kiếm");
		lblKetQua.setFont(new Font("Tahoma", Font.BOLD, 17));
		pnCenterTop.add(lblKetQua);
		
		JPanel pnCenterMiddle = new JPanel();
		pnCenter.add(pnCenterMiddle, BorderLayout.SOUTH);
		
		String[] cols = {"Mã thuốc","Tên thuốc","Loại","Ngày sản xuất","Hạn sử dụng","Đơn giá","số lượng"};
		modelDsThuoc = new DefaultTableModel(cols,0);
		tblDsThuoc = new JTable(modelDsThuoc);
		JScrollPane scrtbl = new JScrollPane(tblDsThuoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		pnCenter.add(scrtbl, BorderLayout.CENTER);
	}
	
	public JPanel getContentpane() {
		return this.contentPane;
	}

}
