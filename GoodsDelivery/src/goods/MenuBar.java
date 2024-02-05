package goods;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuBar extends JMenuBar implements ActionListener {
	JMenu homeMenu, profileMenu, routeOverviewMenu, driverOverviewMenu, missionsHistoryMenu, missionsMenu, logoutMenu;
	JMenuItem viewProfile, editProfile, viewOrders, createOrders, viewDeliverables, completeDeliverable, generateReport,
			logout,createSchedule,viewDriverList,viewRouteOverView,viewMisson,viewMissionHistory;
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
		logout = new JMenuItem("Logout");
		createSchedule= new JMenuItem("Create Schedule");
		viewDriverList=new JMenuItem("View Driver List");
		viewRouteOverView=new JMenuItem("View Route Overiew");
		viewMisson=new JMenuItem("View Mission");
		viewMissionHistory=new JMenuItem("View Mission History");
		createOrders.addActionListener(this);
		editProfile.addActionListener(this);
		logout.addActionListener(this);
		createSchedule.addActionListener(this);
		viewDriverList.addActionListener(this);
		viewRouteOverView.addActionListener(this);
		viewMisson.addActionListener(this);
		viewMissionHistory.addActionListener(this);
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
		System.out.print("dkjdkjdkjddjdjs,jsjsj" + from + "dd");
		if (from.contains("Customer")) {
			homeMenu.add(createOrders);
		} else if (from.contains("Schedular")) {
			homeMenu.add(createSchedule);
			driverOverviewMenu.add(viewDriverList);
			routeOverviewMenu.add(viewRouteOverView);
			add(routeOverviewMenu);
			add(driverOverviewMenu);
			//add(viewRouteOverView);
		} else if (from.contains("Driver")) {
			homeMenu.add(viewMisson);
			//missionsMenu.add(viewMisson);
			missionsHistoryMenu.add(viewMissionHistory);
			add(missionsHistoryMenu);
			
		}

		add(logoutMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Handle menu item clicks
		if (e.getSource() == createOrders) {
			// Switch to Page 1
			frame.switchToPage(frame.homeCustomerPanel);
		} else if (e.getSource() == editProfile) {
			// Switch to Page 2
			frame.switchToPage(frame.profileCustomerPanel);
		}else if(e.getSource()==createSchedule) {
			System.out.println("hjgdjdjhd");
			frame.switchToPage(frame.homeSchedularPanel);
		}else if(e.getSource()==viewDriverList) {
			frame.switchToPage(frame.driverOverviewPanel);
		}else if(e.getSource()==viewRouteOverView) {
			frame.switchToPage(frame.routeOverviewPanel);
		}else if(e.getSource()==viewMisson) {
			frame.switchToPage(frame.homeDriverPanel);
		}
		else if(e.getSource()==viewMissionHistory) {
			frame.switchToPage(frame.viewMissionHistory);
		}
	    else if (e.getSource() == logout) {
			OfflineDB offlineDB = new OfflineDB();
			offlineDB.saveLoginStatus(false);
			offlineDB.saveLoginID(0);
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
