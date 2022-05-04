package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

//import org.jdesktop.swingx.prompt.PromptSupport;
//
//import dao.KhachHangDAO;
//import dao.NhanVienDAO;
import entity.KhachHang;
import entity.NhanVien;
//import util.Placeholder;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class KhachHang_gui extends JFrame {

	private JPanel contentPane;
	private JPanel out;
	private JTextField txtNhapLieu;
	private JTable tblKhachHang;
	private JTextField txtMaKh,txtTenKh,txtSdt;
	private DefaultTableModel model;
	private List<NhanVien> dskh;  
	private JButton btnSuaKh,btnLamMoi,btnTimKiem,btnLayToanBoDuLieu;
	private DefaultComboBoxModel cboLoaiTimKiem;
	private JComboBox cmbLoaiTimKiem;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang_gui frame = new KhachHang_gui();
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
	public KhachHang_gui() throws SQLException {
		setTitle("Khách hàng");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		out = new JPanel();
		out.setLayout(new BoxLayout(out,BoxLayout.Y_AXIS));
		setContentPane(out);
		
		
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel title = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		top.add(title);
		out.add(top);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		out.add(bottom);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		bottom.add(contentPane,BorderLayout.CENTER);
		JPanel pnLeft = new JPanel();
		Border compound = BorderFactory.createCompoundBorder(
				BorderFactory.createBevelBorder(BevelBorder.RAISED),
				BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		pnLeft.setBorder(compound);
		contentPane.add(pnLeft);
		
		JPanel pnThongTinKh = new JPanel();
		pnLeft.add(pnThongTinKh);
		pnThongTinKh.setLayout(new BoxLayout(pnThongTinKh, BoxLayout.Y_AXIS));
		
		Component verticalStrut_2 = Box.createVerticalStrut(35);
		pnThongTinKh.add(verticalStrut_2);
		
		JPanel pnTieuDe = new JPanel();
		pnThongTinKh.add(pnTieuDe);
		
		JLabel lblTieuDe = new JLabel("Thông tin Khách hàng");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnTieuDe.add(lblTieuDe);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		pnThongTinKh.add(verticalStrut_1);
		
		JPanel pnMaKh = new JPanel();
		FlowLayout fl_pnMaKh = (FlowLayout) pnMaKh.getLayout();
		fl_pnMaKh.setAlignment(FlowLayout.LEFT);
		pnThongTinKh.add(pnMaKh);
		
		JLabel lblMaKh = new JLabel("Mã KH             ");
		lblMaKh.setPreferredSize(new Dimension(100, 14));
		pnMaKh.add(lblMaKh);
		
		txtMaKh = new JTextField();
		txtMaKh.setEnabled(false);
		txtMaKh.setPreferredSize(new Dimension(7, 30));
		pnMaKh.add(txtMaKh);
		txtMaKh.setColumns(20);
		
		JPanel pnTenKh = new JPanel();
		FlowLayout fl_pnTenKh = (FlowLayout) pnTenKh.getLayout();
		fl_pnTenKh.setAlignment(FlowLayout.LEFT);
		pnThongTinKh.add(pnTenKh);
		
		JLabel lblTenKh = new JLabel("Tên KH");
		lblTenKh.setPreferredSize(new Dimension(100, 14));
		pnTenKh.add(lblTenKh);
		
		txtTenKh = new JTextField();
		txtTenKh.setPreferredSize(new Dimension(7, 30));
		txtTenKh.setColumns(20);
		pnTenKh.add(txtTenKh);
		
		JPanel pnSoDienThoai = new JPanel();
		FlowLayout fl_pnSoDienThoai = (FlowLayout) pnSoDienThoai.getLayout();
		fl_pnSoDienThoai.setAlignment(FlowLayout.LEFT);
		pnThongTinKh.add(pnSoDienThoai);
		
		JLabel lblSdt = new JLabel("Số điện thoại");
		lblSdt.setPreferredSize(new Dimension(100, 14));
		pnSoDienThoai.add(lblSdt);
		
		txtSdt = new JTextField();
		txtSdt.setPreferredSize(new Dimension(7, 30));
		txtSdt.setColumns(20);
		pnSoDienThoai.add(txtSdt);
		
		


		
		Component verticalStrut = Box.createVerticalStrut(20);
		pnThongTinKh.add(verticalStrut);
		
		JPanel pnChucNang = new JPanel();
		pnThongTinKh.add(pnChucNang);
		pnChucNang.setLayout(new GridLayout(0, 1, 0, 5));
		
		btnSuaKh = new JButton("Sửa");
		btnSuaKh.setBackground(Color.WHITE);
		btnSuaKh.setIcon(new ImageIcon("data\\images\\repairing-service.png"));
//		btnSuaKh.setIconTextGap(30);
		pnChucNang.add(btnSuaKh);

		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setIcon(new ImageIcon("data\\images\\refresh.png"));
//		btnLamMoi.setIconTextGap(10);
		pnChucNang.add(btnLamMoi);
		
		JPanel pnRight = new JPanel();
		contentPane.add(pnRight);
		pnRight.setLayout(new BorderLayout(0, 0));
		
		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBorder(new CompoundBorder(
				new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		pnRight.add(pnTimKiem, BorderLayout.NORTH);

		cboLoaiTimKiem = new DefaultComboBoxModel<String>();
		cmbLoaiTimKiem = new JComboBox(cboLoaiTimKiem);
		cmbLoaiTimKiem.setToolTipText("tìm kiếm theo");
		cmbLoaiTimKiem.setBackground(Color.WHITE);
		cmbLoaiTimKiem.setPreferredSize(new Dimension(130, 22));
		pnTimKiem.add(cmbLoaiTimKiem);
		cboLoaiTimKiem.addElement((String) "Tên KH");
		cboLoaiTimKiem.addElement((String) "Số điện thoại");
				
		txtNhapLieu = new JTextField();
		txtNhapLieu.setPreferredSize(new Dimension(7, 25));
		pnTimKiem.add(txtNhapLieu);
		txtNhapLieu.setColumns(30);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setPreferredSize(new Dimension(130, 25));
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setIcon(new ImageIcon("data\\images\\search_16.png"));
		pnTimKiem.add(btnTimKiem);
		
		btnLayToanBoDuLieu = new JButton("Lấy tất cả");
		btnLayToanBoDuLieu.setPreferredSize(new Dimension(130, 25));
		btnLayToanBoDuLieu.setBackground(Color.WHITE);
		btnLayToanBoDuLieu.setIcon(new ImageIcon("data\\images\\search_16.png"));
		pnTimKiem.add(btnLayToanBoDuLieu);
		
		
		JPanel pnTableKh = new JPanel();
		pnRight.add(pnTableKh, BorderLayout.CENTER);
		pnTableKh.setLayout(new BorderLayout(0, 0));
		
		String[] cols_dskh = {"Mã Khách hàng", "Tên Khách hàng", "Số điện thoại"};
		model = new DefaultTableModel(cols_dskh, 0);
		tblKhachHang = new JTable(model);
		JScrollPane scrTableNhanVien = new JScrollPane(tblKhachHang);
		scrTableNhanVien.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrTableNhanVien.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTableKh.add(scrTableNhanVien);
		

		
		renderData();
		setDisable();
		
		addEvents();
	}

	private void renderData() {
		// TODO Auto-generated method stub
		
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		tblKhachHang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int idx = tblKhachHang.getSelectedRow();
				if(idx == -1 && txtTenKh.getText().equals("")) {
					setDisable();
				}
				if(idx != -1) {
					setEnable();
					
					
				}
			}
		});
		
		btnSuaKh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tblKhachHang.clearSelection();
				
				int maNV = Integer.parseInt(txtMaKh.getText());
				String tenNV = txtTenKh.getText();
				String sdt = txtSdt.getText();
				
				if(tenNV.equals("")|| kiemTraSo(tenNV)) {
					JOptionPane.showMessageDialog(contentPane, "Tên không hợp lệ");
					return;
				}
				
				boolean ktSdt  = sdt.matches("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$");	
				if(ktSdt == false) {
					JOptionPane.showMessageDialog(contentPane, "Số điện thoại không hợp lệ");
					return;
				}

				setDisable();
			}
		});
	}
	
	public void setDisable() {
		btnSuaKh.setEnabled(false);
	}
	public void setEnable() {
		btnSuaKh.setEnabled(true);
	}

	
	public boolean kiemTraSo(String ten) {
		char arrTen[] = ten.toCharArray();
		for(int i=0;i<ten.length();i++) {
			String cTen = String.valueOf(arrTen[i]);
			if(cTen.matches("[0-9]"))
				return true;
		}
		return false;
	}
	
	public JPanel getContentPane() {
		 return this.out;
	 }
}
