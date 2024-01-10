package goods;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class RegisterPage extends JFrame  implements ActionListener{
	JLabel titleLabel,emailLabel,passwordLabel,firstNameLabel,lastNameLabel,phoneNumberLabel,roleLabel,registrationNoLabel,capacityLabel,alreadyLabel,loginLabel;
    JTextField emailTextField,passwordTextField,firstNameTextField,lastNameTextField,phoneNumberTextField,registerationNoTextField,capacityTextField;
    JButton registerButton;
    String[] choices = { "Customer","Schedular", "Driver"};
    JComboBox<String> roleComboBox; 
	public RegisterPage() {
	 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 titleLabel = new JLabel("Get Started!");
         titleLabel.setFont(new Font("Serif", Font.PLAIN, 20));
         titleLabel.setBorder(new EmptyBorder(14, 0, 0, 0)); // top,left,bottom,right
        
         emailLabel = new JLabel("Email :");
         emailLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         passwordLabel = new JLabel("Password :");
         passwordLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         passwordLabel.setBorder(new EmptyBorder(10, 0, 0, 0)); 
       
         firstNameLabel = new JLabel("First Name :");
         firstNameLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         
         lastNameLabel = new JLabel("Last Name :");
         lastNameLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         
         phoneNumberLabel = new JLabel("Phone Number :");
         phoneNumberLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         
         roleLabel = new JLabel("Role :");
         roleLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         
         registrationNoLabel = new JLabel("Registration Number :");
         registrationNoLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         
         capacityLabel = new JLabel("Capacity (in KG) :");
         capacityLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         
         alreadyLabel = new JLabel("Already Registered?.");
         alreadyLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         alreadyLabel.setBorder(new EmptyBorder(10, 0, 0, 0)); // top,left,bottom,right
         loginLabel = new JLabel("Login");
         loginLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         Font font = loginLabel.getFont();
         Map attributes = font.getAttributes();
         attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
         loginLabel.setFont(font.deriveFont(attributes));
         loginLabel.setForeground(Color.blue);
         loginLabel.setBorder(new EmptyBorder(10, 10, 0, 0)); // top,left,bottom,right
         loginLabel.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
            	 SwingUtilities.invokeLater(() -> {
            			//WelcomePage wecomePage = new WelcomePage();
            			//new LoginPage();
            		 new LoginPage();
                	 closeWindow();
            			});
            	
              }
          });
         
         emailTextField = new JTextField(20); 
         Dimension textFieldSize = new Dimension(200, 30); // Set the desired size
         emailTextField.setMaximumSize(textFieldSize);
         emailTextField.setPreferredSize(textFieldSize);
         emailTextField.setMinimumSize(textFieldSize);
         
         firstNameTextField = new JTextField(20); 
         textFieldSize = new Dimension(200, 30); // Set the desired size
         firstNameTextField.setMaximumSize(textFieldSize);
         firstNameTextField.setPreferredSize(textFieldSize);
         firstNameTextField.setMinimumSize(textFieldSize);
         
         lastNameTextField = new JTextField(20); 
         textFieldSize = new Dimension(200, 30); // Set the desired size
         lastNameTextField.setMaximumSize(textFieldSize);
         lastNameTextField.setPreferredSize(textFieldSize);
         lastNameTextField.setMinimumSize(textFieldSize);
         
         passwordTextField = new JTextField(20);
         textFieldSize = new Dimension(200, 30); // Set the desired size
         passwordTextField.setMaximumSize(textFieldSize);
         passwordTextField.setPreferredSize(textFieldSize);
         passwordTextField.setMinimumSize(textFieldSize);
         
         phoneNumberTextField = new JTextField(20); 
         textFieldSize = new Dimension(200, 30); // Set the desired size
         phoneNumberTextField.setMaximumSize(textFieldSize);
         phoneNumberTextField.setPreferredSize(textFieldSize);
         phoneNumberTextField.setMinimumSize(textFieldSize);
         
         registerationNoTextField = new JTextField(20); 
         textFieldSize = new Dimension(200, 30); // Set the desired size
         registerationNoTextField.setMaximumSize(textFieldSize);
         registerationNoTextField.setPreferredSize(textFieldSize);
         registerationNoTextField.setMinimumSize(textFieldSize);
         
         capacityTextField = new JTextField(20); 
         textFieldSize = new Dimension(200, 30); // Set the desired size
         capacityTextField.setMaximumSize(textFieldSize);
         capacityTextField.setPreferredSize(textFieldSize);
         capacityTextField.setMinimumSize(textFieldSize);
             
         JPanel panel = new JPanel(new GridBagLayout());
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.gridx = 0;
         gbc.gridy = 0;
         gbc.anchor = GridBagConstraints.CENTER;
         gbc.gridwidth = 2;
        // gbc.insets = new Insets(0, 0, 0, 0); // Set insets to zero
         panel.add(titleLabel,gbc);
         gbc.gridwidth = 1;

         // Create a new panel for email components with GridBagLayout
         JPanel emailPanel = new JPanel(new GridBagLayout());
         GridBagConstraints emailGbc = new GridBagConstraints();
         emailGbc.gridx = 0;
         emailGbc.gridy = 0;
         emailGbc.anchor = GridBagConstraints.WEST;
         emailPanel.add(emailLabel, emailGbc);

         emailGbc.gridy = 1;
         emailPanel.add(emailTextField, emailGbc);
         gbc.gridx = 0;
         gbc.gridy = 2;
         gbc.insets = new Insets(0, 0, 0, 0); // Set insets to zero
         panel.add(emailPanel, gbc);

         JPanel passwordPanel = new JPanel(new GridBagLayout());
         GridBagConstraints passwordGbc = new GridBagConstraints();
         passwordGbc.gridx = 0;
         passwordGbc.gridy = 0;
         passwordGbc.anchor = GridBagConstraints.WEST;
         passwordPanel.add(passwordLabel, passwordGbc);
         passwordGbc.gridy = 1;
         passwordPanel.add(passwordTextField, passwordGbc);
         gbc.gridx = 1;
         gbc.gridy = 2;
         gbc.insets = new Insets(0, 20, 10, 0); // Set insets t
         panel.add(passwordPanel, gbc);         
        
         JPanel firstNamePanel = new JPanel(new GridBagLayout());
         GridBagConstraints firstNameGbc = new GridBagConstraints();
         firstNameGbc.gridx = 0;
         firstNameGbc.gridy = 0;
         firstNameGbc.anchor = GridBagConstraints.WEST;
         firstNamePanel.add(firstNameLabel, firstNameGbc);
         firstNameGbc.gridy = 1;
         firstNamePanel.add(firstNameTextField, firstNameGbc);
         gbc.gridx = 0;         
         gbc.gridy = 3;
         gbc.insets = new Insets(0, 0, 0, 0); // Set insets to zero
         panel.add(firstNamePanel, gbc);
         
        
         
         JPanel lastNamePanel = new JPanel(new GridBagLayout());
         GridBagConstraints lastNameGbc = new GridBagConstraints();
         lastNameGbc.gridx = 0;
         lastNameGbc.gridy = 0;
         lastNameGbc.anchor = GridBagConstraints.WEST;
         lastNamePanel.add(lastNameLabel, lastNameGbc);
         lastNameGbc.gridy = 1;
         lastNamePanel.add(lastNameTextField, lastNameGbc);
         
         
         gbc.gridx = 1;
         gbc.gridy = 3;
         gbc.insets = new Insets(0, 20, 0, 0); // Set insets to zero
         panel.add(lastNamePanel, gbc);        
         
         JPanel phoneNumberPanel = new JPanel(new GridBagLayout());
         GridBagConstraints phoneNumberGbc = new GridBagConstraints();
         phoneNumberGbc.gridx = 0;
         phoneNumberGbc.gridy = 0;
         phoneNumberGbc.anchor = GridBagConstraints.WEST;
         phoneNumberPanel.add(phoneNumberLabel, phoneNumberGbc);
         phoneNumberGbc.gridy = 1;
         phoneNumberPanel.add(phoneNumberTextField, phoneNumberGbc);
         gbc.gridx = 0;         
         gbc.gridy = 4;
         gbc.insets = new Insets(10, 0, 0, 0); // Set insets to zero
         panel.add(phoneNumberPanel, gbc);
         
         roleComboBox = new JComboBox<String>(choices);
         roleComboBox.setBackground(Color.white);
         textFieldSize = new Dimension(200, 30); // Set the desired size
         roleComboBox.setMaximumSize(textFieldSize);
         roleComboBox.setPreferredSize(textFieldSize);
         roleComboBox.setMinimumSize(textFieldSize);
         roleComboBox.setVisible(true);
         
         JPanel rolePanel = new JPanel(new GridBagLayout());
         GridBagConstraints roleGbc = new GridBagConstraints();
         roleGbc.gridx = 0;
         roleGbc.gridy = 0;
         roleGbc.anchor = GridBagConstraints.WEST;
         rolePanel.add(roleLabel, roleGbc);
         roleGbc.gridy = 1;
         rolePanel.add(roleComboBox, roleGbc);
         
         
         gbc.gridx = 1;
         gbc.gridy = 4;
         gbc.insets = new Insets(10, 20, 0, 0); // Set insets to zero
         panel.add(rolePanel, gbc);        
         
         JPanel registrationNumberPanel = new JPanel(new GridBagLayout());
         GridBagConstraints registrationNumberGbc = new GridBagConstraints();
         registrationNumberGbc.gridx = 0;
         registrationNumberGbc.gridy = 0;
         registrationNumberGbc.anchor = GridBagConstraints.WEST;
         registrationNumberPanel.add(registrationNoLabel, registrationNumberGbc);
         registrationNumberGbc.gridy = 1;
         registrationNumberPanel.add(registerationNoTextField, registrationNumberGbc);
         gbc.gridx = 0;         
         gbc.gridy = 5;
         gbc.insets = new Insets(10, 0, 0, 0); // Set insets to zero
         panel.add(registrationNumberPanel, gbc);
         
         JPanel capacityPanel = new JPanel(new GridBagLayout());
         GridBagConstraints capacityGbc = new GridBagConstraints();
         capacityGbc.gridx = 0;
         capacityGbc.gridy = 0;
         capacityGbc.anchor = GridBagConstraints.WEST;
         capacityPanel.add(capacityLabel, capacityGbc);
         capacityGbc.gridy = 1;
         capacityPanel.add(capacityTextField, capacityGbc);
         
         
         gbc.gridx = 1;
         gbc.gridy = 5;
         gbc.insets = new Insets(10, 20, 0, 0); // Set insets to zero
         panel.add(capacityPanel, gbc);        
         
         registerButton = new JButton("Register");
         registerButton.addActionListener(e -> {
             // Your action listener code here
         });
         registerButton.setMargin(new Insets(5, 50, 5, 50));
         registerButton.setFocusPainted(false);
         gbc.gridx = 0;
         gbc.gridy = 6;
         gbc.anchor = GridBagConstraints.CENTER;
         JPanel buttonPanel = new JPanel(new GridBagLayout());
         GridBagConstraints buttonGbc = new GridBagConstraints();
         buttonGbc.gridx = 1;
         buttonGbc.gridy = 0;
         gbc.gridwidth = 2;
         gbc.insets = new Insets(20, 0, 0, 0); // Set insets to zero
         buttonGbc.anchor = GridBagConstraints.CENTER;
         buttonPanel.add(registerButton, buttonGbc);
         panel.add(buttonPanel, gbc);   
         gbc.gridwidth = 4;
         
         gbc = new GridBagConstraints();
         gbc.gridx =0;
         gbc.gridy = 7;
         gbc.anchor = GridBagConstraints.CENTER;
         JPanel alreadyPanel = new JPanel(new GridBagLayout());
         GridBagConstraints alreadyGbc = new GridBagConstraints();
         alreadyGbc.gridx = 1;
         alreadyGbc.gridy = 0;
         gbc.gridwidth = 4;
         gbc.insets = new Insets(0, 0, 0, 0); // Set in
         buttonPanel.add(alreadyLabel, alreadyGbc);
         panel.add(alreadyPanel,gbc);
         GridBagConstraints registerGbc = new GridBagConstraints();
         gbc = new GridBagConstraints();
         registerGbc.gridx =0;
         registerGbc.gridy = 7;
         registerGbc.anchor = GridBagConstraints.CENTER;
         JPanel labelPanel = new JPanel();
         labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
         labelPanel.add(alreadyLabel);
         labelPanel.add(Box.createGlue()); //creates space between the JLabels
         labelPanel.add(loginLabel);
         gbc.gridx =1;
         gbc.gridy = 7;
         gbc.gridwidth = 2;
         panel.add(loginLabel,gbc);
         gbc.gridwidth = 1;
         this.add(panel);
         this.setTitle("Goods Delivery Application");
         this.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
         this.setSize(800, 460);		
         this.setLocationRelativeTo(null);
         this.setVisible(true);
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void closeWindow() {
		this.dispose();
	}

}
