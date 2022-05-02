package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class QuanLiKhachHang_gui extends JFrame implements ActionListener {
	
	private JTextField txtName;
	private JTextField txtPhonenumber;
	private JTextField txtFindPhoneNumber;
	private JTextField txtFindId;

	private JButton btnEdit;
	private JButton btnClose;
	private JButton btnFindByPhoneNumber;
	private JButton btnFindById;
	private JButton btnGetAllCustomer;
	
	private DefaultTableModel tableModel;
	private JTable table;
	
	
	public QuanLiKhachHang_gui () {
		createGUI();
	}
	
	private void createGUI() {
		setTitle("Quản lí thông tin khách hàng");
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// variable common use
		Dimension dimensionLabel = new Dimension(50,22);
		Dimension dimensionTextField = new Dimension(200,22);
		
		// panel container
		JPanel pnSouth = new JPanel();
		JPanel pnWest = new JPanel();
		JPanel pnHeading = new JPanel();
		JPanel pnEast = new JPanel();
		
		// Heading
		pnHeading = new JPanel();
		JLabel lblHeading = new JLabel("Quản lí thông tin khách hàng");
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		pnHeading.add(lblHeading);
		
		// West 
		pnWest.setLayout(new BorderLayout());
		pnWest.setPreferredSize(new Dimension(320,0));
		JPanel pnWestSub = new JPanel();
		pnWest.add(pnWestSub, BorderLayout.NORTH);
		pnWestSub.setBorder(new TitledBorder("Nhập thông tin"));
		pnWestSub.setLayout(new BoxLayout(pnWestSub, BoxLayout.Y_AXIS));
		
		txtName = new JTextField(20);
		txtName.setPreferredSize(dimensionTextField);
		JLabel lblName = new JLabel("Tên KH");
		lblName.setPreferredSize(dimensionLabel);
		pnWestSub.add(createPanelCombine(lblName, txtName));
		
		txtPhonenumber = new JTextField(20);
		txtPhonenumber.setPreferredSize(dimensionTextField);
		JLabel lblPhonenumber = new JLabel("Số ĐT");
		lblPhonenumber.setPreferredSize(dimensionLabel);
		pnWestSub.add(createPanelCombine(lblPhonenumber, txtPhonenumber));
		
		btnEdit = new JButton("Chỉnh sửa");
		btnClose = new JButton("Hủy");
		btnClose.setVisible(false);
		pnWestSub.add(createPanelCombine(btnEdit, btnClose));
		
		
		// Find panel
		JPanel pnFind = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnWest.add(pnFind,BorderLayout.CENTER);
		pnFind.setBorder(new TitledBorder("Tìm kiếm khách hàng"));

		btnGetAllCustomer = new JButton("Lấy danh sách tất cả khách hàng");
		pnFind.add(btnGetAllCustomer);
		
		txtFindId = new JTextField(18);
		txtFindId.setPreferredSize(dimensionTextField);
		JLabel lblFindId = new JLabel("Mã KH");
		lblFindId.setPreferredSize(dimensionLabel);
		btnFindById = new JButton("Tìm kiếm");
		ImageIcon icon_timkiem = new ImageIcon("data/images/search_16.png");
		btnFindById = new JButton("", icon_timkiem);
		btnFindById.setPreferredSize(new Dimension(26,20));
		pnFind.add(createPanelCombine(lblFindId, txtFindId,btnFindById));
		
		txtFindPhoneNumber = new JTextField(18);
		txtFindPhoneNumber.setPreferredSize(dimensionTextField);
		JLabel lblFindPhoneNumber = new JLabel("Số ĐT");
		lblFindPhoneNumber.setPreferredSize(dimensionLabel);
		btnFindByPhoneNumber = new JButton("", icon_timkiem);
		btnFindByPhoneNumber.setPreferredSize(new Dimension(26,20));
		pnFind.add(createPanelCombine(lblFindPhoneNumber, txtFindPhoneNumber,btnFindByPhoneNumber));
		
		
		
		
		
		
		
		
		// table
		String cols[] = {"Mã khách hàng", "Tên khách hàng", "Số điện thoại"};
		tableModel = new DefaultTableModel(cols, 0);
		table = new JTable(tableModel);
		JScrollPane scrollTabel = new JScrollPane(table);
		scrollTabel.setBorder(new TitledBorder("Thông tin chi tiết"));
		
		
		
		// add panel container to frame
		add(pnHeading,BorderLayout.NORTH);
		add(pnWest, BorderLayout.WEST);
		add(scrollTabel, BorderLayout.CENTER);
		
		txtName.addActionListener(this);
		txtPhonenumber.addActionListener(this);
		txtFindId.addActionListener(this);
		txtFindPhoneNumber.addActionListener(this);
		btnEdit.addActionListener(this);
		btnClose.addActionListener(this);
		btnFindByPhoneNumber.addActionListener(this);
		btnFindById.addActionListener(this);
		btnGetAllCustomer.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new QuanLiKhachHang_gui().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// function support create ui
	private JPanel createPanelCombine(Component lbl, Component txt) {
		JPanel pn = new JPanel();
		pn.add(lbl);
		pn.add(txt);
		return pn;
		
	}
	
	private JPanel createPanelCombine(Component lbl, Component txt, Component btn) {
		JPanel pn = new JPanel();
		pn.add(lbl);
		pn.add(txt);
		pn.add(btn);
		return pn;
		
	}

}
