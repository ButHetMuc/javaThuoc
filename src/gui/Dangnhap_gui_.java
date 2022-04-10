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
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.PublicKey;
import java.util.jar.Attributes.Name;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;

import util.Placeholder;

import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.Color;

public class Dangnhap_gui_ extends JFrame {
	
//	public void addPlaceholderStyle(JTextField txtdfield) {
//		Font font=txtdfield.getFont();
//		font=font.deriveFont(Font.ITALIC);
//		txtdfield.setForeground(Color.gray);
//	}
//	
//	public void removePlaceholderStyle(JTextField txtdfield) {
//		Font font=txtdfield.getFont();
//		font=font.deriveFont(Font.PLAIN|Font.BOLD);
//		txtdfield.setForeground(Color.black);
//	}
	private JPanel contentPane;
	private JTextField txtTenTk;
	private JPasswordField textMatKhau;

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
//		addPlaceholderStyle(txtTenTk);
		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("text"));
		panel.setBounds(210, 110, 451, 300);
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		txtTenTk = new JTextField("Enter UserName");
		txtTenTk.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenTk.setBounds(131, 75, 289, 41);
		panel.add(txtTenTk);
		txtTenTk.setFont(new Font("Tahoma", Font.PLAIN, 28));
		txtTenTk.setColumns(10);
		txtTenTk.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTenTk.getText().equals("")) {
					txtTenTk.setText("Enter UserName");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtTenTk.getText().equals("Enter UserName")) {
					txtTenTk.setText("");
				}
			}
		});
		txtTenTk.setRequestFocusEnabled(true);
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setIcon(new ImageIcon("data\\images\\log_in.png"));
		btnDangNhap.setBackground(Color.LIGHT_GRAY);
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDangNhap.setForeground(Color.BLACK);
		btnDangNhap.setBounds(131, 233, 149, 41);
		panel.add(btnDangNhap);
		
		JLabel lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setForeground(SystemColor.infoText);
		lblDangNhap.setBounds(176, 11, 179, 41);
		panel.add(lblDangNhap);
		lblDangNhap.setFont(new Font("Tahoma", Font.BOLD, 29));
		
		JButton btnExit = new JButton("Thoát");
		
		btnExit.setBounds(290, 233, 117, 41);
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
		
		JCheckBox chk_login_nvien = new JCheckBox("Nhân viên");
		chk_login_nvien.setFont(new Font("Tahoma", Font.BOLD, 16));
		chk_login_nvien.setBounds(131, 191, 117, 23);
		panel.add(chk_login_nvien);
		chk_login_nvien.setOpaque(false);
		JCheckBox chk_showpass = new JCheckBox("Hiện mật khẩu");
		chk_showpass.setFont(new Font("Tahoma", Font.BOLD, 16));
		chk_showpass.setBounds(271, 191, 149, 23);
		panel.add(chk_showpass);
		chk_showpass.setOpaque(false);
		
		
		textMatKhau = new JPasswordField("Password");
		textMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		textMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textMatKhau.setToolTipText("");
		textMatKhau.setBounds(131, 143, 289, 41);
		
		
		textMatKhau.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(textMatKhau.getText().equals("")) {
					textMatKhau.setText("Password");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(textMatKhau.getText().equals("Password")) {
					textMatKhau.setText("");
				}
			}
		});
		//hide & show password
		chk_showpass.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		        JCheckBox cb = (JCheckBox) event.getSource();
		        if (cb.isSelected()) {
		            // do something if check box is selected
		        	textMatKhau.setEchoChar((char)0);
		        } else {
		            // check box is unselected, do something else
		        	textMatKhau.setEchoChar('*');
		        }
		    }
		});

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		panel.add(textMatKhau);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\HUY\\NAM2\\hk2\\LT_JAVA\\huy\\BTLON\\javaThuoc-master\\data\\images\\User.png"));
		lblNewLabel_1.setBounds(89, 75, 32, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\HUY\\NAM2\\hk2\\LT_JAVA\\huy\\BTLON\\javaThuoc-master\\data\\images\\Lock.png"));
		lblNewLabel_2.setBounds(89, 143, 32, 41);
		panel.add(lblNewLabel_2);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("data\\images\\bg2.jpg"));
		lblNewLabel.setBounds(0, 0, 718, 476);
		contentPane.add(lblNewLabel);
		this.setResizable(false);
		this.setVisible(true);
		//--------------------phím tắt-------------
				textMatKhau.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ENTER)
						{
							btnDangNhap.doClick();
						}
					}
				});
				textMatKhau.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ENTER)
						{
							btnDangNhap.doClick();
						}
					}
				});
				textMatKhau.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
						{
							btnExit.doClick();
						}
					}
				});
				txtTenTk.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
						{
							btnExit.doClick();
						}
					}
				});
				//-----------------------------------------
	}
}
