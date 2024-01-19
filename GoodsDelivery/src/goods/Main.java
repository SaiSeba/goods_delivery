package goods;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
		//WelcomePage wecomePage = new WelcomePage();
		//new LoginPage();
//			RegisterPage registerPage=new RegisterPage();
//		registerPage.setVisible(true);
			HomePage homePage=	new HomePage();
			homePage.setVisible(true);
		});
	}

}
