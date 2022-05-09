package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;

import connectdb.ConnectDBNV;
import dao.CaLam_dao;
import dao.NhanVien_dao;
import entity.CaLam;
import entity.NhanVien;
import entity.TaiKhoan;

public class NhanVien_gui extends JFrame implements ActionListener {
	private JTextField txtTen;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtNgaySinh;
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnXoa;
	private DefaultTableModel dataModel;
	private JTable table;
	private JButton btnTimKiem;
	private JTextField lblTimKiem;
	private JTextField txtTimKiem;
	private JComboBox<String> cbCaLam;
	private NhanVien_dao NhanVien;
	private JLabel lblMauTin;
	private int mauTinHienHanh;
	private int tongSoMauTin;
	private JCheckBox ckGioiTinh;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;
	private JTextField txtTienLuong;

	private NhanVien_dao nv_dao;
	private CaLam_dao cl_dao;
	private JTextField txtMess;
	private JButton btnXemCTCL;
	private JTextField txtTenTaiKhoan;
	private JTextComponent txtMaNV;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien_gui frame = new NhanVien_gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NhanVien_gui() {
		// TODO Auto-generated constructor stub
		// khởi tạo kết nối đến CSDL
		try {
			ConnectDBNV.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		nv_dao = new NhanVien_dao();
		cl_dao = new CaLam_dao();

		setTitle("Thông tin nhan vien");
		setBounds(0, 0, 1300, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnNorth = new JPanel();
		JPanel pnQLNV = new JPanel();
		JLabel lblQLNV;
		pnQLNV.add(lblQLNV = new JLabel("QUẢN LÝ NHÂN VIÊN", JLabel.CENTER));
		lblQLNV.setFont(new Font("Arial", Font.BOLD, 26));
		pnNorth.add(pnQLNV);
		add(pnNorth, BorderLayout.NORTH);

		JPanel pnWest = new JPanel(new GridLayout(16, 0));
		add(pnWest, BorderLayout.WEST);

		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe;
		pnTieuDe.add(lblTieuDe = new JLabel("Thông tin nhân viên", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		pnWest.add(lblTieuDe);

		JLabel lblMaNV;
		lblMaNV = new JLabel("Mã nhân viên");
		txtMaNV = new JTextField(11);

		JPanel pnTaiKhoan = new JPanel();
		JLabel lblTenTaiKhoan;
		pnTaiKhoan.add(lblTenTaiKhoan = new JLabel("Tên tài khoản"));
		pnTaiKhoan.add(txtTenTaiKhoan = new JTextField(11));
		pnWest.add(pnTaiKhoan);

		JPanel pnCaLam = new JPanel();
		JLabel lblCalam;
		pnCaLam.add(lblCalam = new JLabel("Ca làm"));
		pnCaLam.add(cbCaLam = new JComboBox<String>());
		cbCaLam.setPreferredSize(new Dimension(114, 20));
		pnWest.add(pnCaLam);

		JPanel pnTen = new JPanel();
		JLabel lblTen;
		pnTen.add(lblTen = new JLabel("Tên nhân viên"));
		pnTen.add(txtTen = new JTextField(11));
		pnWest.add(pnTen);

		JPanel pnCMND = new JPanel();
		JLabel lblCMND;
		pnCMND.add(lblCMND = new JLabel("CMND"));
		pnCMND.add(txtCMND = new JTextField(11));
		pnWest.add(pnCMND);

		JPanel pnSDT = new JPanel();
		JLabel lblSDT;
		pnSDT.add(lblSDT = new JLabel("Số điên thoại"));
		pnSDT.add(txtSDT = new JTextField(11));
		pnWest.add(pnSDT);

		JPanel pnDiaChi = new JPanel();
		JLabel lblDiaChi;
		pnDiaChi.add(lblDiaChi = new JLabel("Địa chỉ"));
		pnDiaChi.add(txtDiaChi = new JTextField(11));
		pnWest.add(pnDiaChi);



		JPanel pnNgaySinh = new JPanel();
		JLabel lblNgaySinh;
		pnNgaySinh.add(lblNgaySinh = new JLabel("Ngày sinh"));
		pnNgaySinh.add(txtNgaySinh = new JTextField(11));
		pnWest.add(pnNgaySinh);

		JPanel pnGioiTinh = new JPanel();
		JLabel lblGioiTinh;
		pnGioiTinh.add(lblGioiTinh = new JLabel("Giới tính"));
		pnGioiTinh.add(radNam = new JRadioButton("Nam"));
		pnGioiTinh.add(Box.createRigidArea(new Dimension(14, 0)));
		pnGioiTinh.add(radNu = new JRadioButton("Nu"));
		pnWest.add(pnGioiTinh);
		ButtonGroup groupGT = new ButtonGroup();
		groupGT.add(radNam);
		groupGT.add(radNu);

		JPanel pnTienLuong = new JPanel();
		JLabel lblTienLuong;
		pnTienLuong.add(lblTienLuong = new JLabel("TienLuong"));
		pnTienLuong.add(txtTienLuong = new JTextField(11));
		pnWest.add(pnTienLuong);


		pnWest.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

		JPanel pnThem = new JPanel();
		pnThem.add(btnThem = new JButton("Thêm"));
		pnWest.add(pnThem);

		JPanel pnLuu = new JPanel();
		pnLuu.add(btnLuu = new JButton("Lưu"));
		pnWest.add(pnLuu);

		JPanel pnXoa = new JPanel();
		pnXoa.add(btnXoa = new JButton("Xóa"));
		pnWest.add(pnXoa);


		JPanel pnSua = new JPanel();
		pnSua.add(btnSua = new JButton("Sửa"));
		pnWest.add(pnSua);

		btnThem.setPreferredSize(new Dimension(246, 24));
		btnLuu.setPreferredSize(new Dimension(246, 24));
		btnXoa.setPreferredSize(new Dimension(246, 24));
		btnSua.setPreferredSize(new Dimension(246, 24));

		lblTenTaiKhoan.setPreferredSize(lblTen.getPreferredSize());
		lblCMND.setPreferredSize(lblTen.getPreferredSize());
		lblSDT.setPreferredSize(lblTen.getPreferredSize());
		lblDiaChi.setPreferredSize(lblTen.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblTen.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblTen.getPreferredSize());
		lblTienLuong.setPreferredSize(lblTen.getPreferredSize());
		lblCalam.setPreferredSize(lblTen.getPreferredSize());

		Border bdwest = BorderFactory.createLineBorder(Color.GRAY, 1);
		TitledBorder TittleWest = new TitledBorder(bdwest, "");
		pnWest.setBorder(TittleWest);

		JPanel pnCenter = new JPanel(new BorderLayout());
		JPanel pnNorth_New = new JPanel();

		pnNorth_New.add(btnDau = new JButton(new ImageIcon("data/images/go-first.png")));
		pnNorth_New.add(btnTruoc = new JButton(new ImageIcon("data/images/go-previous.png")));
		pnNorth_New.add(lblMauTin = new JLabel());
		pnNorth_New.add(btnSau = new JButton(new ImageIcon("data/images/go-next.png")));
		pnNorth_New.add(btnCuoi = new JButton(new ImageIcon("data/images/go-last.png")));
		pnNorth_New.add(txtTimKiem = new JTextField(20));
		pnNorth_New.add(btnTimKiem = new JButton("Tìm kiếm"));
		btnTimKiem.setBackground(Color.WHITE);
		pnCenter.add(pnNorth_New, BorderLayout.NORTH);

		String[] headers = {"Mã nhân viên", "Tên tài khoản ", "Tên ca Làm","Tên nhân viên","CMND", 
				"Số điện thoại","Địa chỉ", "Ngày sinh", "Giới tính", "Tiền Lương"};
		dataModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll;
		pnCenter.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));
		add(pnCenter, BorderLayout.CENTER);
		Border bdCenter = BorderFactory.createLineBorder(Color.GRAY, 1);
		TitledBorder TittleCenter = new TitledBorder(bdCenter, "");
		pnCenter.setBorder(TittleCenter);

		JPanel pnSouth = new JPanel();
		add(pnSouth, BorderLayout.SOUTH);
		pnSouth.add(Box.createHorizontalStrut(1000));
		pnSouth.add(btnXemCTCL = new JButton("Xem chi tiết ca làm"));
		btnXemCTCL.setForeground(Color.red);
		nv_dao = new NhanVien_dao();

		nv_dao = new NhanVien_dao();
		table.setRowHeight(25);
		for (NhanVien nv : nv_dao.getAllNhanVien()) {
			Object[] rowData = {nv.getMaNhanVien(),
					nv.getTaiKhoan().getTenTaiKhoan(),
					nv.getCaLam().getMaCaLam(),
					nv.getTenNhanVien(),
					nv.getCMND(),
					nv.getSoDienThoai(),
					nv.getDiaChi(),
					nv.getNgaySinh(),
					nv.isGioiTinh(),
					nv.getLuong(),
			};
			dataModel.addRow(rowData);
		}

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					mauTinHienHanh = row;
					capNhatThongTinMauTin(mauTinHienHanh);
					napLopHocVaoTextfields();
				}
			}
		});
		mauTinHienHanh = -1;
		tongSoMauTin = table.getRowCount();
		if (tongSoMauTin > 0) {
			mauTinHienHanh = 0; // Khởi tạo là mẫu tin đầu tiên
			capNhatThongTinMauTin(mauTinHienHanh);
		}

		btnDau.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnSau.addActionListener(this);
		btnCuoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXemCTCL.addActionListener(this);

		moKhoaTextfields(false);
		moKhoaGioiTinh(false);
		btnLuu.setEnabled(false);
		loadCombox();
		napLopHocVaoTextfields();
		//find NhanVien by manhanvien
		serchEmployee();
	}
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}
	private void napLopHocVaoTextfields() {
		int row = table.getSelectedRow();
		if (row >= 0) {
			txtMaNV.setText(dataModel.getValueAt(row, 0).toString());
			txtTenTaiKhoan.setText(dataModel.getValueAt(row, 1).toString());
			if (dataModel.getValueAt(row, 2) != null) {
				String calam = dataModel.getValueAt(row, 2).toString();
				cbCaLam.setSelectedItem(calam);
			} else cbCaLam.setSelectedIndex(0);
			txtTen.setText(dataModel.getValueAt(row, 3).toString());
			txtCMND.setText(dataModel.getValueAt(row, 4).toString());
			txtSDT.setText(dataModel.getValueAt(row, 5).toString());
			txtDiaChi.setText(dataModel.getValueAt(row, 6).toString());

			txtNgaySinh.setText(dataModel.getValueAt(row, 7).toString());
			Boolean gioiTinh = (Boolean) dataModel.getValueAt(row, 8);
			if (gioiTinh) {
				radNam.setSelected(true);
			} else {
				radNu.setSelected(true);
			}
			txtTienLuong.setText(dataModel.getValueAt(row, 9).toString());

		}
	}

	public void loadCombox() {
		try {

			Connection con = ConnectDBNV.getConnection();
			//get all macalam from database
			PreparedStatement ps = con.prepareStatement("Select macalam from calam");
			ResultSet rs = ps.executeQuery();
			// insert macalam into ours jcombobox
			while (rs.next()) {
				cbCaLam.addItem(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void capNhatThongTinMauTin(int n) {
		table.setRowSelectionInterval(n, n);
		lblMauTin.setText(mauTinHienHanh + 1 + "/" + tongSoMauTin);
	}

	private void moKhoaControls(boolean b) {

		btnThem.setEnabled(b);
		btnLuu.setEnabled(b);
		btnSua.setEnabled(b);
		btnXoa.setEnabled(b);

	}

	private void moKhoaGioiTinh(boolean b) {
		radNam.setEnabled(b);
		radNu.setEnabled(b);

	}


	private void moKhoaTextfields(boolean b) {
		txtTenTaiKhoan.setEditable(b);
		txtTen.setEditable(b);
		txtCMND.setEditable(b);
		txtDiaChi.setEditable(b);
		txtSDT.setEditable(b);
		txtNgaySinh.setEditable(b);
		txtTienLuong.setEditable(b);
	}

	private void xoaRongTextfields() {
		txtTienLuong.setText("");
		txtTen.setText("");
		txtCMND.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtNgaySinh.setText("");
		txtTenTaiKhoan.setText("");
		txtTenTaiKhoan.requestFocus();

	}
	private boolean validData() {
		String ten = txtTen.getText();
		String cmnd = txtCMND.getText();
		String diaChi = txtDiaChi.getText();
		String sodt = txtSDT.getText();
		boolean phai = radNam.isSelected();
		String luong  = txtTienLuong.getText();
		String caLam = cbCaLam.getSelectedItem().toString();


		// Có ký tự đầu là ký tự đầu của tựa sách, theo sau là 3 ký số
		//		if (!(ma.length() > 0 && ma.matches("[A-Z]\\d{3}"))) {
		//			JOptionPane.showMessageDialog(null, "Error: Mã sách theo mẫu: [A-Z]\\d{3}");
		//			return false;
		//		}
		//		// Tựa sách, và tác giả không được để trống,
		//		// có thể gồm nhiều từ ngăn cách bởi khoảng trắng.
		//		// Không chứa ký số hoặc các ký tự đặc biệt khác, ngoại trừ ký tự ‘
		if (!(sodt.length() > 0 && sodt.matches("^0[98753]{1}\\d{8}$"))) {
			showMessage("Error: nhấp lại số điện thoại", txtSDT);
			return false;
		}

		if (luong.length() > 0) {
			try {
				BigDecimal gia = new BigDecimal(luong);
				int i = gia.intValue();
				if (i <= 0) {
					showMessage("Error: Tiền lương phải nhập số dương", txtTienLuong);
					txtTienLuong.requestFocus();
					return false;
				}
			} catch (NumberFormatException ex) {
				showMessage("Error: Tiền lương phải nhập số", txtTienLuong);
				return false;
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		// onclick button them
		if (o.equals(btnThem)) {
			if (btnThem.getText().equalsIgnoreCase("Thêm")) {
				moKhoaTextfields(true);
				moKhoaGioiTinh(true);
				moKhoaControls(false);
				btnLuu.setEnabled(true);
				btnThem.setEnabled(true);
				btnThem.setText("Hủy");
				xoaRongTextfields();
				//
			} else if (btnThem.getText().equalsIgnoreCase("Hủy")) {
				moKhoaTextfields(false);
				moKhoaControls(true);
				moKhoaGioiTinh(false);
				btnLuu.setEnabled(false);
				btnThem.setText("Thêm");
				txtMess.setText("");
				napLopHocVaoTextfields();
			}
		}
		// on click button luu and when dont see button "them"
		if (o.equals(btnLuu) && !btnThem.getText().equalsIgnoreCase("Thêm")) {
			try {
				String taiKhoan = txtTenTaiKhoan.getText();
				int caLam = Integer.parseInt(cbCaLam.getSelectedItem().toString());
				String ten = txtTen.getText();
				String cmnd = txtCMND.getText();
				String sodt = txtSDT.getText();
				String diaChi = txtDiaChi.getText();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = sf.parse(txtNgaySinh.getText());
				Date sqlDate = new Date(date.getTime());
				boolean phai = radNam.isSelected();
				BigDecimal gia = new BigDecimal(txtTienLuong.getText());
				NhanVien nv = new NhanVien(new TaiKhoan(taiKhoan), new CaLam(caLam), ten, cmnd, sodt, diaChi, sqlDate, phai, gia);
				if (nv_dao.craete(nv)) {
					ArrayList<NhanVien> listNV =  
					nv_dao.getAllNhanVien();
					nv = listNV.get(listNV.size()-1);
					dataModel.addRow(new Object[]{nv.getMaNhanVien(), nv.getTaiKhoan().getTenTaiKhoan(),nv.getCaLam().getMaCaLam(), nv.getTenNhanVien(),nv.getCMND(),
							nv.getSoDienThoai(),nv.getDiaChi(), nv.getNgaySinh(), nv.isGioiTinh(), nv.getLuong()});  // add colom calam
				}else JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại");

			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		//Delete row from database and table
		if (o.equals(btnXoa)) {

			String maNhanVien = txtMaNV.getText();
			int deleteRow = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nhân viên này không?");
			if(deleteRow == JOptionPane.YES_OPTION) {
				if (nv_dao.deleteNhanVienByID(maNhanVien)) {
					int getSelectedRowForDeletion = table.getSelectedRow();
					if(getSelectedRowForDeletion == -1) {
						getSelectedRowForDeletion = 0; //Khi chua click mặc định xóa row 0
					}
					dataModel.removeRow(getSelectedRowForDeletion);
					JOptionPane.showMessageDialog(null, "Hàng đã bị xóa");
				} else {
					JOptionPane.showMessageDialog(null, "Không thể xóa");
				}
			}
		}
		//onclick sua
		if (o.equals(btnSua)) {
			if (btnSua.getText().equalsIgnoreCase("Sửa")) {
				moKhoaTextfields(true);
				moKhoaControls(false);
				moKhoaGioiTinh(true);
				btnLuu.setEnabled(true);
				btnSua.setEnabled(true);
				btnSua.setText("Hủy");
				txtMess.setText("");

			} else if (btnSua.getText().equalsIgnoreCase("Hủy")) {
				moKhoaTextfields(false);
				moKhoaControls(true);
				btnLuu.setEnabled(false);
				btnSua.setText("Sửa");
				napLopHocVaoTextfields();
			}

		}
		//update row
		if (o.equals(btnLuu) && btnSua.isEnabled()){
			try {
				int maNV = Integer.parseInt(txtMaNV.getText());
				String taiKhoan = txtTenTaiKhoan.getText();
				int caLam = Integer.parseInt(cbCaLam.getSelectedItem().toString());
				String ten = txtTen.getText();
				String cmnd = txtCMND.getText();
				String sodt = txtSDT.getText();
				String diaChi = txtDiaChi.getText();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = sf.parse(txtNgaySinh.getText());
				Date sqlDate = new Date(date.getTime());
				boolean phai = radNam.isSelected();
				BigDecimal gia = new BigDecimal(txtTienLuong.getText());
				NhanVien nv = new NhanVien( maNV,new TaiKhoan(taiKhoan), new CaLam(caLam), ten, cmnd, sodt, diaChi, sqlDate, phai, gia);

				// removed try-catch
				if (nv_dao.update(nv)){

					txtTen.requestFocus();
					int i = table.getSelectedRow();
					dataModel.setValueAt(taiKhoan,i,1);
					dataModel.setValueAt(caLam,i,2);
					dataModel.setValueAt(ten,i,3);
					dataModel.setValueAt(cmnd,i,4);
					dataModel.setValueAt(sodt,i,5);
					dataModel.setValueAt(diaChi,i,6);
					dataModel.setValueAt(sqlDate,i,7);
					dataModel.setValueAt(phai,i,8);
					dataModel.setValueAt(gia,i,9);
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}

		}

		if (tongSoMauTin > 0) { // Cho các nút duyệt
			if (o.equals(btnDau))
				mauTinHienHanh = 0;
			else if (o.equals(btnCuoi))
				mauTinHienHanh = tongSoMauTin - 1;
			else if (o.equals(btnSau) && mauTinHienHanh < tongSoMauTin - 1)
				mauTinHienHanh++;
			else if (o.equals(btnTruoc) && mauTinHienHanh > 0)
				mauTinHienHanh--;
			capNhatThongTinMauTin(mauTinHienHanh);
		}
		if(o.equals(btnXemCTCL)) {
			int maCaLam = Integer.parseInt(cbCaLam.getSelectedItem().toString());
			CaLam caLam = cl_dao.getCaLamById(maCaLam);
			JOptionPane.showMessageDialog(this, caLam);
			
		}
	}
	public void serchEmployee(){
		TableRowSorter<TableModel> rowSorter
		= new TableRowSorter<>(table.getModel()) ;
		table.setRowSorter(rowSorter);
		txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = txtTimKiem.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = txtTimKiem.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Chưa được hỗ trợ."); 
			}
		});
	}

}