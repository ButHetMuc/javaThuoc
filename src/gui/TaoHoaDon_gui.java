package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thuoc;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;

public class TaoHoaDon_gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField textField_4;
	private JButton btnThemThuoc;
	private JButton btnBoThuoc;
	

	private DefaultComboBoxModel<String> modelKH;
	private JComboBox cboKH;
	
	private DefaultTableModel modelThuoc;
	private DefaultTableModel modelThuocTGH;
	private JTable tblThuoc;
	
	private ArrayList<KhachHang> dskh;
	private ArrayList<Thuoc> dsThuoc;
	private ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
	private JTextField txtSoLuong;
	private JButton btnThemHD; 
	private JTextField txtTongTien;
	private JTable tblThuocTGH;
	private NhanVien nhanVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaoHoaDon_gui frame = new TaoHoaDon_gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TaoHoaDon_gui() throws SQLException {
		GUI();
	}
	
	public TaoHoaDon_gui(NhanVien nhanVien) throws SQLException {
		this.nhanVien = nhanVien;
		GUI();
	}
			
	public void GUI() throws SQLException {
		setTitle("Tạo hóa đơn");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnThongTinKH = new JPanel();
		contentPane.add(pnThongTinKH, BorderLayout.WEST);
		
		JPanel pnThongTinKH2 = new JPanel();
		pnThongTinKH.add(pnThongTinKH2);
		pnThongTinKH2.setLayout(new BorderLayout(0, 0));
		
		JPanel pnTTKH = new JPanel();
		pnTTKH.setBorder(new EmptyBorder(40, 0, 0, 0));
		pnThongTinKH2.add(pnTTKH, BorderLayout.NORTH);
		
		JLabel lblTTKH = new JLabel("Thông tin khách hàng");
		lblTTKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTTKH.add(lblTTKH);
		
		JPanel pnThongTin = new JPanel();
		pnThongTinKH2.add(pnThongTin, BorderLayout.CENTER);
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		
		JPanel pnMaKH = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnMaKH.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnMaKH);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng");
		lblMaKH.setPreferredSize(new Dimension(100, 20));
		pnMaKH.add(lblMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setPreferredSize(new Dimension(7, 30));
		pnMaKH.add(txtMaKH);
		txtMaKH.setColumns(20);
		
		JPanel pnTenKH = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnTenKH.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnTenKH);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setPreferredSize(new Dimension(100, 20));
		pnTenKH.add(lblTenKH);
		
		modelKH = new DefaultComboBoxModel<String>();
		cboKH = new JComboBox(modelKH);
		cboKH.setPreferredSize(new Dimension(170, 30));
		pnTenKH.add(cboKH);
		
		JPanel pnSoDienThoai = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnSoDienThoai.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnSoDienThoai);
		
		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setPreferredSize(new Dimension(100, 20));
		pnSoDienThoai.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setPreferredSize(new Dimension(7, 30));
		txtSDT.setColumns(20);
		pnSoDienThoai.add(txtSDT);
		
		JPanel pnDiaChi = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnDiaChi.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnDiaChi);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setPreferredSize(new Dimension(100, 20));
		pnDiaChi.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setPreferredSize(new Dimension(7, 30));
		txtDiaChi.setColumns(20);
		pnDiaChi.add(txtDiaChi);
		
		JPanel pnTongTien = new JPanel();
		pnThongTin.add(pnTongTien);
		
		JLabel lblTongTien = new JLabel("Tổng tiền");
		lblTongTien.setPreferredSize(new Dimension(100, 20));
		pnTongTien.add(lblTongTien);
		
		txtTongTien = new JTextField("0");
		txtTongTien.setPreferredSize(new Dimension(7, 30));
		txtTongTien.setEditable(false);
		txtTongTien.setColumns(20);
		pnTongTien.add(txtTongTien);
		
		JPanel pnBtn = new JPanel();
		pnThongTin.add(pnBtn);
		
		btnThemHD = new JButton("Thêm hóa đơn", new ImageIcon("data/images/blueAdd_16.png"));
		btnThemHD.setBackground(Color.WHITE);
		pnBtn.add(btnThemHD);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Thuốc");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(lblNewLabel);
		
		
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		String[] cols = {"Tên Thuốc", "Đơn giá", "Số lượng", "Nhà cung cấp"};
		modelThuoc = new DefaultTableModel(cols, 0);
		JTable tblSach = new JTable(modelThuoc);
		JScrollPane scrollPane = new JScrollPane(tblSach);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_7.add(scrollPane);
		
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(250);
		panel_5.add(verticalStrut);
		
		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		
		btnThemThuoc = new JButton(">>");
		btnThemThuoc.setBackground(Color.WHITE);
		btnThemThuoc.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_9.add(btnThemThuoc);
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoLuong.setText("1");
		txtSoLuong.setPreferredSize(new Dimension(49, 30));
		txtSoLuong.setColumns(4);
		panel_10.add(txtSoLuong);
		
		JPanel panel_11 = new JPanel();
		panel_8.add(panel_11);
		
		btnBoThuoc = new JButton("<<");
		btnBoThuoc.setBackground(Color.WHITE);
		btnBoThuoc.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_11.add(btnBoThuoc);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách thuốc trong giỏ hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_1);
		
		String[] cols3 = {"Tên thuốc", "Đơn giá", "Số lượng", "Thành tiền"};
		modelThuocTGH = new DefaultTableModel(cols3, 0);
		tblThuocTGH = new JTable(modelThuocTGH);
		JScrollPane scrollPane_1 = new JScrollPane(tblThuocTGH);
		scrollPane_1.setPreferredSize(new Dimension(450, 500));
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
	}
	public JPanel getContentpane() {
		return this.contentPane;
	}

}

