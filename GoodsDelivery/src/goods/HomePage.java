package goods;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame implements ActionListener {
	JPanel homeCustomerPanel, profileCustomerPanel;

	public HomePage() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(new MenuBar("Customer", this));
		// Initialize the panels
		homeCustomerPanel = new JPanel();
		homeCustomerPanel.add(new CustomerHomePage());
		profileCustomerPanel = new JPanel();
		profileCustomerPanel.add(new CustomerProfilePage());
		// Set the default content to Page 1
		setContentPane(homeCustomerPanel);
		// gbc.insets = new Insets(0, 0, 0, 0); // Set insets to zero
		this.setJMenuBar(menuBar);
		this.add(panel);
		this.setTitle("Goods Delivery Application");
		this.setSize(800, 460);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void switchToPage(JPanel page) {
		setContentPane(page);

		// Repaint the frame to reflect the changes
		revalidate();
		repaint();
	}

}