package goods;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WelcomePage extends JFrame implements ActionListener {
	JLabel titlelabel, welcomelabel;
	JButton loginbutton, registerbutton;

	public WelcomePage() {
		JFrame frame = new JFrame("Button Resize Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		titlelabel = new JLabel("Hello!");
		titlelabel.setFont(new Font("Serif", Font.PLAIN, 40));
		titlelabel.setBorder(new EmptyBorder(60, 0, 0, 0));// top,left,bottom,right
		titlelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		 frame.setLocationRelativeTo(null);
		welcomelabel = new JLabel("Welcome to Goods Delivery Application");
		welcomelabel.setFont(new Font("Serif", Font.PLAIN, 24));
		welcomelabel.setBorder(new EmptyBorder(16, 0, 37, 0));// top,left,bottom,right
		welcomelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginbutton = new JButton("Login");
		loginbutton.addActionListener(this);
		loginbutton.setPreferredSize(new Dimension(195, 45));
		registerbutton = new JButton("Register");
		registerbutton.addActionListener(this);
		registerbutton.setPreferredSize(new Dimension(195, 45));
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));		
		this.add(panel);
		panel.add(titlelabel);
		panel.add(welcomelabel);
		panel.add(loginbutton);
		panel.add(registerbutton);
		this.setTitle("Goods Delivery Application");
		this.setSize(800, 460);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
