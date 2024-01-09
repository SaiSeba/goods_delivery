package goods;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginPage extends JFrame implements ActionListener {
    JLabel titleLabel,subTitleLabel,emailLabel,passwordLabel,donthaveLabel,registerLabel;
    JTextField emailTextField,passwordTextField;
    JButton loginButton;
    public LoginPage() {
    	 JFrame frame = new JFrame("Button Resize Example");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         titleLabel = new JLabel("Welcome Back!");
         titleLabel.setFont(new Font("Serif", Font.PLAIN, 20));
         titleLabel.setBorder(new EmptyBorder(24, 0, 0, 0)); // top,left,bottom,right
         subTitleLabel = new JLabel("Login to continue");
         subTitleLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         subTitleLabel.setBorder(new EmptyBorder(16, 0, 16, 0)); // top,left,bottom,right
         emailLabel = new JLabel("Email :");
         emailLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         passwordLabel = new JLabel("Password :");
         passwordLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         passwordLabel.setBorder(new EmptyBorder(10, 0, 0, 0)); 
         emailTextField = new JTextField(20);
         donthaveLabel = new JLabel("Dont't have an account?.");
         donthaveLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         donthaveLabel.setBorder(new EmptyBorder(10, 0, 0, 0)); // top,left,bottom,right
         registerLabel = new JLabel("Register");
         registerLabel.setFont(new Font("Serif", Font.PLAIN, 13));
         Font font = registerLabel.getFont();
         Map attributes = font.getAttributes();
         attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
         registerLabel.setFont(font.deriveFont(attributes));
         registerLabel.setForeground(Color.blue);
         registerLabel.setBorder(new EmptyBorder(10, 10, 0, 0)); // top,left,bottom,right
         registerLabel.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
            	 new RegisterPage();
              }
          });
         Dimension textFieldSize = new Dimension(200, 30); // Set the desired size
         emailTextField.setMaximumSize(textFieldSize);
         emailTextField.setPreferredSize(textFieldSize);
         emailTextField.setMinimumSize(textFieldSize);
         
         passwordTextField = new JTextField(20);
         textFieldSize = new Dimension(200, 30); // Set the desired size
         passwordTextField.setMaximumSize(textFieldSize);
         passwordTextField.setPreferredSize(textFieldSize);
         passwordTextField.setMinimumSize(textFieldSize);
         JLabel emptyLabel = new JLabel("1");
         emptyLabel.setBorder(new EmptyBorder(10, 0, 0, 0));
         loginButton = new JButton("Login");
         loginButton.addActionListener(e -> {
             // Your action listener code here
         });
         loginButton.setMargin(new Insets(5, 50, 5, 50));
         loginButton.setFocusPainted(false);
         
        
         JPanel panel = new JPanel(new GridBagLayout());
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.gridx = 0;
         gbc.gridy = 0;
         gbc.anchor = GridBagConstraints.CENTER;
         panel.add(titleLabel, gbc);

         gbc.gridy = 1;
         panel.add(subTitleLabel, gbc);

         // Create a new panel for email components with GridBagLayout
         JPanel emailPanel = new JPanel(new GridBagLayout());
         GridBagConstraints emailGbc = new GridBagConstraints();
         emailGbc.gridx = 0;
         emailGbc.gridy = 0;
         emailGbc.anchor = GridBagConstraints.WEST;
         emailPanel.add(emailLabel, emailGbc);

         emailGbc.gridy = 1;
         emailPanel.add(emailTextField, emailGbc);

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
         gbc.gridy = 3;
         gbc.insets = new Insets(0, 0, 10, 0); // Set insets t
         panel.add(passwordPanel, gbc);         
         gbc.gridy = 4;
         panel.add(loginButton, gbc);
         gbc = new GridBagConstraints();
         gbc.gridy = 5;
         gbc.anchor = GridBagConstraints.CENTER;
         panel.add(donthaveLabel,gbc);
         GridBagConstraints registerGbc = new GridBagConstraints();
         registerGbc.gridx = 0;
         registerGbc.gridy = 5;
         registerGbc.anchor = GridBagConstraints.CENTER;
         JPanel labelPanel = new JPanel();
         labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
         labelPanel.add(donthaveLabel);
         labelPanel.add(Box.createGlue()); //creates space between the JLabels
         labelPanel.add(registerLabel);

         panel.add(labelPanel,registerGbc);
         frame.add(panel);
         frame.setTitle("Goods Delivery Application");
         frame.setSize(800, 460);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);

    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if(e.getSource()==loginButton) {
					
				}
				
	}

}
