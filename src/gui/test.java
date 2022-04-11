package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class test extends JFrame {	
	JMenuItem mnit = new JMenuItem();

	public test() {
		JMenuItem mntmThot = new JMenuItem("Tho\u00E1t");
		mnit.add(mntmThot);
		
		JMenu mniuKhin = new JMenu("\u0110i\u1EC1u khi\u1EC3n");
		
		add (new JButton("Tho\u00E1t"));
		add (new JLabel("\u0110i\u1EC1u khi\u1EC3n"));
		
	}
	public static void main(String[] args) {
		new test().setVisible(true);
	}
}
