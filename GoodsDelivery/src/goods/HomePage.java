package goods;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DBManagement;
import model.UsersList;

public class HomePage extends JFrame implements ActionListener {
	JPanel homeCustomerPanel,homeSchedularPanel,profileCustomerPanel;

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
		
		
		// Initialize the panels
		homeCustomerPanel = new JPanel();
		homeCustomerPanel.add(new CustomerHomePage());
		profileCustomerPanel=new JPanel();
		profileCustomerPanel.add(new CustomerProfilePage());
		homeSchedularPanel=new JPanel();
		homeCustomerPanel.add(new SchedulerHomePage());
		DBManagement dbManagement = new DBManagement();
		OfflineDB offlineDB = new OfflineDB();
		UsersList usersList = null;
		try {
			usersList=dbManagement.getUserDetails(offlineDB.loadLoginId());
			if(usersList.getRole().contains("Customer")) {	
			    
				// Set the default content to Page 1
				setContentPane(homeCustomerPanel);
				System.out.print("dkjdkjdkjddjdj");
			}else if(usersList.getRole().contains("Schedular")) {
				// Set the default content to Page 1
				setContentPane(homeSchedularPanel);
			}else if(usersList.getRole().contains("Driver")) {
				// Set the default content to Page 1
				setContentPane(homeCustomerPanel);
			}
			menuBar.add(new MenuBar(usersList.getRole(), this));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// gbc.insets = new Insets(0, 0, 0, 0); // Set insets to zero
		this.setJMenuBar(menuBar);
		this.add(panel);
		this.setTitle("Goods Delivery Application");
		this.setSize(800, 460);
		 getContentPane().setBackground(Color.WHITE);
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