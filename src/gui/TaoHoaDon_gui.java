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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import dao.HoaDon_dao;
import dao.KhachHang_dao;
import dao.NhanVien_dao;
import dao.Thuoc_dao;
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
	private NhanVien nhanVien = new NhanVien_dao().getNhanVienByMaNV(1);

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
		JTable tblThuoc = new JTable(modelThuoc);
		JScrollPane scrollPane = new JScrollPane(tblThuoc);
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
		
		renderKhachHang();
		renderData();
		
		cboKH.addActionListener((e) -> {
			int idx = cboKH.getSelectedIndex();
			if(idx != -1) {
				idx--;
				if(idx == -1) {
					txtMaKH.setText("");
					txtSDT.setText("");
					return;
				}
				txtMaKH.setText(String.valueOf(dskh.get(idx).getMaKhachHang()));
				txtSDT.setText(dskh.get(idx).getSoDienThoai());
			}
		});
		
		btnThemThuoc.addActionListener((e) -> {
			
			int idx;
			Thuoc thuoc = null;
			if(tblThuoc.getSelectedRow() != -1) {
				idx = tblThuoc.getSelectedRow();
				thuoc = dsThuoc.get(idx); // Thuốc
			}
			int soLuong = 0;
			try {
				soLuong = Integer.parseInt(txtSoLuong.getText());
			}catch (Exception e2) {
				JOptionPane.showMessageDialog(contentPane, "Số lượng phải lớn hơn 0");
				txtSoLuong.requestFocus();
				return;
			}
			
			if(soLuong > thuoc.getSoLuong()) {
				JOptionPane.showMessageDialog(contentPane, "Số lượng không đủ");
				txtSoLuong.requestFocus();
				return;
			}
			
			
//			kiểm tra xem đã có thuốc đó trong giỏ chưa
			int vt = -1;
			for(int i=0; i<dscthd.size(); i++) {
				if(dscthd.get(i).getThuoc().getMaThuoc() == thuoc.getMaThuoc())
					vt = i;
			}
			if(vt != -1) { // thêm số lượng
				dscthd.get(vt).setSoLuong(dscthd.get(vt).getSoLuong() + soLuong);
			}else { // thêm thuốc
				ChiTietHoaDon cthd = new ChiTietHoaDon(thuoc, soLuong);
				dscthd.add(cthd);
			}
			tinhTongTien();
			
			try {
				renderData();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		});
		
		
		btnBoThuoc.addActionListener((e) -> {
			int idx = tblThuocTGH.getSelectedRow();
			if(idx != -1) {
				int soLuong = 0;
				try {
					soLuong = Integer.parseInt(txtSoLuong.getText());
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane, "Số lượng phải lớn hơn 0");
					txtSoLuong.requestFocus();
					return;
				}
				
				if(soLuong > dscthd.get(idx).getSoLuong()) {
					JOptionPane.showMessageDialog(contentPane, "Số lượng không hợp lệ");
					txtSoLuong.requestFocus();
					return;
				}else if(soLuong == dscthd.get(idx).getSoLuong()) {	
					dscthd.remove(idx);
				}else {
					dscthd.get(idx).setSoLuong(dscthd.get(idx).getSoLuong() - soLuong);
				}
				
				tinhTongTien();
				try {
					renderData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnThemHD.addActionListener((e) -> {
			int idx = cboKH.getSelectedIndex(); 
			if(idx <= 0) {
				JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn khách hàng");
				return;
			}
			
			if(dscthd.size() == 0) {
				JOptionPane.showMessageDialog(contentPane, "Vui lòng thêm hàng vào giỏ");
				return;
			}
			
			int choose = JOptionPane.showConfirmDialog(contentPane, "Chắc chắn tạo hóa đơn");
			if(choose == 0) {
				HoaDon hd = new HoaDon(this.nhanVien, dskh.get(idx-1), dscthd);
				try {
					HoaDon_dao hoaDonDao = new HoaDon_dao();
					if(hoaDonDao.themHoaDon(hd)) {
						
						
						int choose2 = JOptionPane.showConfirmDialog(contentPane, "Đã thêm hóa đơn thành công, bạn có muốn xuất hóa đơn không ?");
						if(choose2 == 0) {
							hd.setMaHD(hoaDonDao.getLastestMaHD());
							XuatHoaDon_gui xuaHoaDonGUI = new XuatHoaDon_gui();
							xuaHoaDonGUI.setHoaDon(hd);
							xuaHoaDonGUI.setVisible(true);
							xuaHoaDonGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						}
						dscthd.clear();
						tinhTongTien();
						renderData();
					}else {
						JOptionPane.showMessageDialog(contentPane, hoaDonDao.getError());
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}
	

	public void renderKhachHang() throws SQLException {
		dskh = new KhachHang_dao().getAll();
		modelKH.addElement("");
		cboKH.setSelectedIndex(0);
		
		dskh.forEach(kh -> {
			modelKH.addElement("#"+ kh.getMaKhachHang()+ " " + kh.getTenKhachHang());
		});
		cboKH.revalidate();
		cboKH.repaint();
	}
	
	private void renderData() throws SQLException {
		// TODO Auto-generated method stub
		dsThuoc = new Thuoc_dao().getDsThuoc();
		modelThuoc.getDataVector().removeAllElements();
		for(int i=0; i<dsThuoc.size(); i++) {
			boolean flag = true;
			for(int j=0; j<dscthd.size(); j++) {
				if(dscthd.get(j).getThuoc().getMaThuoc() == dsThuoc.get(i).getMaThuoc()) {
					dsThuoc.get(i).setSoLuong(dsThuoc.get(i).getSoLuong() - dscthd.get(j).getSoLuong());
				}
			}
			if(dsThuoc.get(i).getSoLuong() != 0) {
				modelThuoc.addRow(new Object[] {
						dsThuoc.get(i).getTenThuoc(), 
						formatNumberForMoney(dsThuoc.get(i).getDonGia()), 
						dsThuoc.get(i).getSoLuong(),
						dsThuoc.get(i).getNhaCungCap().getTenNhaCungCap()
					});
			}else {
				dsThuoc.remove(i);
				i--;
			}
			
		}
//		Thuốc trong giỏ hàng
		tblThuocTGH.clearSelection();
		modelThuocTGH.getDataVector().removeAllElements();
		dscthd.forEach(cthd -> {
			modelThuocTGH.addRow(new Object[] {cthd.getThuoc().getTenThuoc(), formatNumberForMoney(cthd.getThuoc().getDonGia()), cthd.getSoLuong(),formatNumberForMoney(cthd.tinhThanhTien())});
		});
		tblThuocTGH.revalidate();
		tblThuocTGH.repaint();
	}

	private String formatNumberForMoney(double money) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	    String str1 = currencyVN.format(Math.round(money));
	    str1 = str1.substring(0,str1.length() - 2);
	    return str1 + " đồng";
	}

	public void tinhTongTien() {
		double tongTien = 0;
		for(int i=0; i<dscthd.size(); i++) {
			tongTien += dscthd.get(i).tinhThanhTien();
		}
		txtTongTien.setText(formatNumberForMoney(tongTien));
	}
	
	
	public JPanel getContentPane() {
		return this.contentPane;
	}

}