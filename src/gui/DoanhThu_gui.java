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

import connectdb.ConnectDB;
import dao.KhachHang_dao;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

public class DoanhThu_gui extends JFrame implements ActionListener, MouseListener, KeyListener{

	private JPanel contentPane;
	private JPanel out;
	private JTextField txtNhapLieu;
	private JTable tblKhachHang;
	private JTextField txtMaKh,txtSoNam,txtSdt;
	private DefaultTableModel model;
	private ArrayList<KhachHang> dskh;  
	private JButton btnSuaKh,btnLayToanBoDuLieu,btnLuu;
	
	private DefaultComboBoxModel<String> modelLoaiThongKe;
	private JComboBox<String> cbbLoaiThongKe;
	
	private DefaultComboBoxModel<String> modelSoNam;
	private JComboBox<String> cbbSoNam;
	
	private DefaultComboBoxModel<String> modelSoThang;
	private JComboBox<String> cbbSoThang;
	
	private DefaultComboBoxModel<String> modelSoNgay;
	private JComboBox<String> cbbSoNgay;
	
	private DefaultComboBoxModel<String> modelSoKi;
	private JComboBox<String> cbbSoKi;
	
	private KhachHang_dao kh_dao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoanhThu_gui frame = new DoanhThu_gui();
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
	public DoanhThu_gui() throws SQLException {
		// khởi tạo kết nối đến CSDL
				try {
					new connectdb.ConnectDB().connect();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		kh_dao = new KhachHang_dao();	
		
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
		
		JPanel pnThongTinThongKe = new JPanel();
		pnLeft.add(pnThongTinThongKe);
		pnThongTinThongKe.setLayout(new BoxLayout(pnThongTinThongKe, BoxLayout.Y_AXIS));
//		
//		Component verticalStrut_2 = Box.createVerticalStrut(35);
//		pnThongTinThongKe.add(verticalStrut_2);

	
		JPanel pnLoaiThongKe = new JPanel();
		pnThongTinThongKe.add(pnLoaiThongKe);
		
		JLabel lblLoaiThongKe = new JLabel("Thống ke theo: ");
		lblLoaiThongKe.setPreferredSize(new Dimension(100, 14));
		pnLoaiThongKe.add(lblLoaiThongKe);
		
		modelLoaiThongKe = new DefaultComboBoxModel<>();
		modelLoaiThongKe.addElement("Năm");
		modelLoaiThongKe.addElement("Kì");
		modelLoaiThongKe.addElement("Tháng");
		modelLoaiThongKe.addElement("Ngày");
		
		cbbLoaiThongKe = new JComboBox<String>(modelLoaiThongKe);
		cbbLoaiThongKe.setPreferredSize(new Dimension(100, 30) );
		pnLoaiThongKe.add(cbbLoaiThongKe);
		
		// so nam
		JPanel pnSoNam = new JPanel();
		pnThongTinThongKe.add(pnSoNam);
		JLabel lblSoNam = new JLabel("Năm: ");
		lblSoNam.setPreferredSize(new Dimension(100, 14));
		pnSoNam.add(lblSoNam);
		
		modelSoNam = new DefaultComboBoxModel<>();
		modelSoNam.addElement("2000");
		modelSoNam.addElement("2001");
		modelSoNam.addElement("2002");
		modelSoNam.addElement("2003");
		
		cbbSoNam = new JComboBox<String>(modelSoNam);
		cbbSoNam.setPreferredSize(new Dimension(100, 30) );
		pnSoNam.add(cbbSoNam);
		
		
		// so thang
				JPanel pnSoThang = new JPanel();
				pnThongTinThongKe.add(pnSoThang);
				JLabel lblSoThang = new JLabel("Tháng: ");
				lblSoThang.setPreferredSize(new Dimension(100, 14));
				pnSoThang.add(lblSoThang);
				
				modelSoThang = new DefaultComboBoxModel<>();
				modelSoThang.addElement("1");
				modelSoThang.addElement("2");
				modelSoThang.addElement("3");
				modelSoThang.addElement("4");
				modelSoThang.addElement("5");
				modelSoThang.addElement("6");
				modelSoThang.addElement("7");
				modelSoThang.addElement("8");
				modelSoThang.addElement("9");
				modelSoThang.addElement("10");
				modelSoThang.addElement("11");
				modelSoThang.addElement("12");
				
				cbbSoThang = new JComboBox<String>(modelSoThang);
				cbbSoThang.setPreferredSize(new Dimension(100, 30) );
				pnSoThang.add(cbbSoThang);
		
// số ngày
				JPanel pnSoNgay = new JPanel();
				pnThongTinThongKe.add(pnSoNgay);
				JLabel lblSoNgay = new JLabel("Ngày: ");
				lblSoNgay.setPreferredSize(new Dimension(100, 14));
				pnSoNgay.add(lblSoNgay);
				
				modelSoNgay = new DefaultComboBoxModel<>();
				modelSoNgay.addElement("1");
				modelSoNgay.addElement("2");
				modelSoNgay.addElement("3");
				modelSoNgay.addElement("4");
				modelSoNgay.addElement("5");
				modelSoNgay.addElement("6");
				modelSoNgay.addElement("7");
				modelSoNgay.addElement("8");
				modelSoNgay.addElement("9");
				modelSoNgay.addElement("10");
				modelSoNgay.addElement("11");
				modelSoNgay.addElement("12");
				
				cbbSoNgay = new JComboBox<String>(modelSoNgay);
				cbbSoNgay.setPreferredSize(new Dimension(100, 30) );
				pnSoNgay.add(cbbSoNgay);
				
// theo ki
				JPanel pnSoKi = new JPanel();
				pnThongTinThongKe.add(pnSoKi);
				JLabel lblSoKi = new JLabel("Kì: ");
				lblSoKi.setPreferredSize(new Dimension(100, 14));
				pnSoKi.add(lblSoKi);
				
				modelSoKi = new DefaultComboBoxModel<>();
				modelSoKi.addElement("I");
				modelSoKi.addElement("II");
				modelSoKi.addElement("III");
				modelSoKi.addElement("IV");
				
				cbbSoKi = new JComboBox<String>(modelSoKi);
				cbbSoKi.setPreferredSize(new Dimension(100, 30) );
				pnSoKi.add(cbbSoKi);

		
		Component verticalStrut = Box.createVerticalStrut(20);
		pnThongTinThongKe.add(verticalStrut);
		
		JPanel pnChucNang = new JPanel();
		pnThongTinThongKe.add(pnChucNang);
		pnChucNang.setLayout(new GridLayout(0, 1, 0, 5));
		
		btnSuaKh = new JButton("Sửa");
		btnSuaKh.setBackground(Color.WHITE);
		btnSuaKh.setIcon(new ImageIcon("data\\images\\repairing-service.png"));
		btnSuaKh.setEnabled(false);
//		btnSuaKh.setIconTextGap(30);
		pnChucNang.add(btnSuaKh);
		
		
		JPanel pnRight = new JPanel();
		contentPane.add(pnRight);
		pnRight.setLayout(new BorderLayout(0, 0));


		

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

		// add event
//		cbbLoaiThongKe.addItemListener(this);
		cbbLoaiThongKe.addActionListener(this);
		// load data from database
		loadAllData();
		renderData();
		
	}
	
	private void loadAllData() {
	}

	private void renderData() {
		// TODO Auto-generated method stub
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
	
	public void renderLeftSide(String loaiThongKe) {
		if(loaiThongKe.equals("Năm")) {
			cbbSoNam.setEnabled(true);
			cbbSoThang.setEnabled(false);
			cbbSoKi.setEnabled(false);
			cbbSoNgay.setEnabled(false);
		}else if(loaiThongKe.equals("Tháng")) {
			cbbSoNam.setEnabled(true);
			cbbSoThang.setEnabled(true);
			cbbSoKi.setEnabled(false);
			cbbSoNgay.setEnabled(false);
		}else if(loaiThongKe.equals("Ngày")) {
			cbbSoNam.setEnabled(true);
			cbbSoThang.setEnabled(true);
			cbbSoKi.setEnabled(false);
			cbbSoNgay.setEnabled(true);
		}else if(loaiThongKe.equals("Kì")) {
			cbbSoNam.setEnabled(true);
			cbbSoKi.setEnabled(true);
			cbbSoThang.setEnabled(false);
			cbbSoNgay.setEnabled(false);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(cbbLoaiThongKe)) {
			renderLeftSide(cbbLoaiThongKe.getSelectedItem().toString());
		}
	
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

}
