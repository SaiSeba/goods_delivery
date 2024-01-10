package goods;

import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame implements ActionListener {


	public HomePage() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setTitle("Goods Delivery Application");
		this.setSize(800, 460);		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

	}

}