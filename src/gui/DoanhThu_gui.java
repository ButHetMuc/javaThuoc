package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
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
import java.awt.LayoutManager;
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
	private DefaultTableModel modelHD;
	String[] colsHD = { "Mã hoá đơn", "Mã khách hàng","Tên khách hàng","Số điện thoại","Địa chỉ","Tổng tiền", "Ngày lập"};
	private ArrayList<KhachHang> dskh;  
	private JButton btnThongKe;
	
	private DefaultComboBoxModel<String> modelLoaiThongKe;
	private JComboBox<String> cbbLoaiThongKe;
	
	private DefaultComboBoxModel<String> modelSoNam;
	private JComboBox<String> cbbSoNam;
	
	private DefaultComboBoxModel<String> modelSoThang;
	private JComboBox<String> cbbSoThang;
	
	private DefaultComboBoxModel<String> modelSoNgay;
	private JComboBox<String> cbbSoNgay;
	
	private DefaultComboBoxModel<String> modelSoQuy;
	private JComboBox<String> cbbSoQuy;
	
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
					new connectdb.ConnectDB();
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
		JLabel title = new JLabel("QUẢN LÝ DOANH THU");
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
		pnLeft.setBorder(new TitledBorder("Lựa chọn thông số"));
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
		modelLoaiThongKe.addElement("Quý");
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
				renderCbbNgay();
				
				cbbSoNgay = new JComboBox<String>(modelSoNgay);
				cbbSoNgay.setPreferredSize(new Dimension(100, 30) );
				pnSoNgay.add(cbbSoNgay);
				
// theo ki
				JPanel pnSoQuy = new JPanel();
				pnThongTinThongKe.add(pnSoQuy);
				JLabel lblSoQuy = new JLabel("Quý: ");
				lblSoQuy.setPreferredSize(new Dimension(100, 14));
				pnSoQuy.add(lblSoQuy);
				
				modelSoQuy = new DefaultComboBoxModel<>();
				modelSoQuy.addElement("I");
				modelSoQuy.addElement("II");
				modelSoQuy.addElement("III");
				modelSoQuy.addElement("IV");
				
				cbbSoQuy = new JComboBox<String>(modelSoQuy);
				cbbSoQuy.setPreferredSize(new Dimension(100, 30) );
				pnSoQuy.add(cbbSoQuy);

		
		Component verticalStrut = Box.createVerticalStrut(20);
		pnThongTinThongKe.add(verticalStrut);
		
		JPanel pnChucNang = new JPanel();
		pnThongTinThongKe.add(pnChucNang);
		pnChucNang.setLayout(new GridLayout(0, 1, 0, 5));
		
		btnThongKe = new JButton("Thống kê doanh thu");
		btnThongKe.setBackground(Color.WHITE);
		btnThongKe.setIcon(new ImageIcon("data\\images\\repairing-service.png"));
//		btnThongKe.setIconTextGap(30);
		pnChucNang.add(btnThongKe);
		
// right side
		
		JPanel pnRight = new JPanel();
		pnRight.setBorder(new TitledBorder("Kết quả thống kê"));
		contentPane.add(pnRight);
		pnRight.setLayout(new BorderLayout());
		
		JTable tableHD;
		modelHD = new DefaultTableModel(colsHD, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
				// Không cho chỉnh sửa trên table
			}
		};

		tableHD = new JTable(modelHD);
		JScrollPane scHD = new JScrollPane(tableHD, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scHD.setBounds(10, 67, 875, 260);
		pnRight.add(scHD,BorderLayout.CENTER);

		JPanel pn_detail = new JPanel();
		pn_detail.setLayout(new BoxLayout(pn_detail, BoxLayout.Y_AXIS));
		pnRight.add(pn_detail,BorderLayout.SOUTH);
		
		JPanel pn_2 = new JPanel();
		FlowLayout fl_2 = (FlowLayout) pn_2.getLayout();
		fl_2.setAlignment(FlowLayout.LEFT);
		pn_detail.add(pn_2);
		JLabel lblSum = new JLabel("Tổng doanh thu: ");
		JLabel lblSumValue = new JLabel("12.000.000 đồng");
		pn_2.add(lblSum);
		pn_2.add(lblSumValue);
		
		
		JPanel pn_3 = new JPanel();
		FlowLayout fl_3 = (FlowLayout) pn_3.getLayout();
		fl_3.setAlignment(FlowLayout.LEFT);
		pn_detail.add(pn_3);
		JLabel lblMod = new JLabel("Thuốc bán nhiều nhất: ");
		JLabel lblModeValue = new JLabel("Thuốc tiêu chảy VAD");
		pn_3.add(lblMod);
		pn_3.add(lblModeValue);
		
		
		
		cbbSoThang.setEnabled(false);
		cbbSoQuy.setEnabled(false);
		cbbSoNgay.setEnabled(false);

		// add event
		cbbLoaiThongKe.addActionListener(this);
		cbbSoNam.addActionListener(this);
		cbbSoThang.addActionListener(this);
		// load data from database
		loadAllData();
		renderData();
		
	}
	
	private void renderCbbNgay() {
		// TODO Auto-generated method stub
		int nam = Integer.parseInt(cbbSoNam.getSelectedItem().toString());
		int thang = Integer.parseInt(cbbSoThang.getSelectedItem().toString());
		modelSoNgay.removeAllElements();
		
		if(nam % 4 == 0 && nam % 100 != 0 || nam % 400 == 0) {
			// nam nhuan
			if(thang == 2) {
				for(int i = 1; i <=29 ; i++) {
					modelSoNgay.addElement(i + "");
				}
			}
		}else {
			if(thang == 2) {
				for(int i = 1; i <=28 ; i++) {
					modelSoNgay.addElement(i + "");
				}
			}
		}
		
		if(thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12) {
			for(int i = 1; i <=31 ; i++) {
				modelSoNgay.addElement(i + "");
			}
		}else if(thang != 2) {
			for(int i = 1; i <=30 ; i++) {
				modelSoNgay.addElement(i + "");
			}
		}
		
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
			cbbSoQuy.setEnabled(false);
			cbbSoNgay.setEnabled(false);
		}else if(loaiThongKe.equals("Tháng")) {
			cbbSoNam.setEnabled(true);
			cbbSoThang.setEnabled(true);
			cbbSoQuy.setEnabled(false);
			cbbSoNgay.setEnabled(false);
		}else if(loaiThongKe.equals("Ngày")) {
			cbbSoNam.setEnabled(true);
			cbbSoThang.setEnabled(true);
			cbbSoQuy.setEnabled(false);
			cbbSoNgay.setEnabled(true);
		}else if(loaiThongKe.equals("Quý")) {
			cbbSoNam.setEnabled(true);
			cbbSoQuy.setEnabled(true);
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
		}else if(o.equals(cbbSoNam)) {
			renderCbbNgay();
		}else if(o.equals(cbbSoThang)) {
			renderCbbNgay();
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
