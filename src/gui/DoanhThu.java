package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class DoanhThu extends JFrame {
	
	public DoanhThu() {
		// TODO Auto-generated constructor stub
		createGui();
		
	}
	
	private void createGui() {
		setTitle("Quản lí bán hàng");
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// variable common use
		Dimension dimensionLabel = new Dimension(50,22);
		Dimension dimensionTextField = new Dimension(200,22);
		
		//
	}
	
	public static void main(String[] args) {
		new DoanhThu().setVisible(true);
	}
}
