package goods;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			OfflineDB offlineDB = new OfflineDB();
			if (!offlineDB.loadLoginStatus()) {
				new WelcomePage();
			} else {
				HomePage homePage = new HomePage();
				homePage.setVisible(true);
			}
			// new LoginPage();
//			RegisterPage registerPage=new RegisterPage();
//		registerPage.setVisible(true);
//			HomePage homePage=	new HomePage();
//			homePage.setVisible(true);
		});
	}

}
