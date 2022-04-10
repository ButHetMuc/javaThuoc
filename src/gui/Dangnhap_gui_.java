package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class Dangnhap_gui_ extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenTk;
	private JTextField textMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dangnhap_gui_ frame = new Dangnhap_gui_();
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
	public Dangnhap_gui_() {
		setBackground(new Color(102, 204, 255));
		setTitle("đăng nhập\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 515);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("text"));
		panel.setBounds(200, 109, 361, 286);
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtTenTk = new JTextField();
		txtTenTk.setBounds(50, 80, 289, 31);
		panel.add(txtTenTk);
		txtTenTk.setFont(new Font("Tahoma", Font.PLAIN, 29));
		txtTenTk.setColumns(10);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setIcon(new ImageIcon("data\\images\\log_in.png"));
		btnDangNhap.setBackground(Color.LIGHT_GRAY);
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDangNhap.setForeground(Color.BLACK);
		btnDangNhap.setBounds(50, 197, 149, 41);
		panel.add(btnDangNhap);
		
		JLabel lblNhapMK = new JLabel("Nhập mật khẩu");
		lblNhapMK.setBounds(50, 110, 171, 31);
		panel.add(lblNhapMK);
		lblNhapMK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textMatKhau = new JPasswordField();
		textMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 31));
		textMatKhau.setBounds(50, 142, 289, 31);
		panel.add(textMatKhau);
		textMatKhau.setColumns(10);
		
		JLabel lblTenDangNhap = new JLabel("Nhập tên tài khoản");
		lblTenDangNhap.setBounds(50, 45, 161, 31);
		panel.add(lblTenDangNhap);
		lblTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setForeground(SystemColor.infoText);
		lblDangNhap.setBounds(95, 0, 179, 41);
		panel.add(lblDangNhap);
		lblDangNhap.setFont(new Font("Tahoma", Font.BOLD, 29));
		
		JButton btnExit = new JButton("Thoát");
		
		btnExit.setBounds(211, 197, 117, 41);
		panel.add(btnExit);
		btnExit.setIcon(new ImageIcon("E:\\HUY\\NAM2\\hk2\\LT_JAVA\\clone\\javaThuoc\\data\\images\\shut-down.png"));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBackground(new Color(255, 255, 204));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setLabelFor(panel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("data\\images\\bg2.jpg"));
		lblNewLabel.setBounds(0, 0, 718, 476);
		contentPane.add(lblNewLabel);
		this.setVisible(true);
		
	}
}
