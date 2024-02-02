package goods;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuBar extends JMenuBar implements ActionListener {
	JMenu homeMenu, profileMenu, routeOverviewMenu, driverOverviewMenu, missionsHistoryMenu, missionsMenu, logoutMenu;
	JMenuItem viewProfile, editProfile, viewOrders, createOrders, viewDeliverables, completeDeliverable, generateReport,logout;
	Box horizontalBox;
	
	HomePage frame;

	public MenuBar(String from, HomePage frame) {
		this.frame = frame;
		homeMenu = new JMenu("Home");
		profileMenu = new JMenu("Profile");
		routeOverviewMenu = new JMenu("Route Overview");
		driverOverviewMenu = new JMenu("Driver Overview");
		missionsHistoryMenu = new JMenu("Missions History");
		missionsMenu = new JMenu("Missions");
		createOrders = new JMenuItem("Create Orders");
		viewOrders = new JMenuItem("View Orders");
		viewDeliverables = new JMenuItem("View Deliverables");
		completeDeliverable = new JMenuItem("Completed Deliverables");
		viewProfile = new JMenuItem("View Profile");
		editProfile = new JMenuItem("Edit Profile");
		generateReport = new JMenuItem("Generate Report");
		logout=new JMenuItem("Logout");
		createOrders.addActionListener(this);
		editProfile.addActionListener(this);
		logout.addActionListener(this);
		homeMenu.add(createOrders);
        profileMenu.add(editProfile);
        
//        ordersMenu.add(createOrders);
//        ordersMenu.add(viewOrders);
//        missionOverviewMenu.add(generateReport);
//        driversMenu.add(viewDeliverables);
//        driversMenu.add(completeDeliverable);
		logoutMenu = new JMenu("Logout");
		logoutMenu.add(logout);
		add(homeMenu);
		add(profileMenu);
		if (from != "Customer") {
			add(routeOverviewMenu);
			add(driverOverviewMenu);
			add(missionsHistoryMenu);
		}
		add(logoutMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Handle menu item clicks
		if (e.getSource()==createOrders) {
			// Switch to Page 1
			frame.switchToPage(frame.homeCustomerPanel);
		} else if (e.getSource()==editProfile) {
			// Switch to Page 2
			frame.switchToPage(frame.profileCustomerPanel);
		} else if (e.getSource()==logout) {
			OfflineDB offlineDB = new OfflineDB();
			offlineDB.saveLoginStatus(false);
			new LoginPage();
			closeWindow();
		}
		// Repaint the frame to reflect the changes
		revalidate();
		repaint();
	}
	public void closeWindow() {
		frame.dispose();
	}
}
