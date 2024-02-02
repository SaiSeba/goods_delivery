package goods;

import java.awt.Color;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controller.DBManagement;
import controller.Toast;
import model.UsersList;

public class CustomerProfilePage extends JPanel implements ActionListener {
	JLabel  emailLabel, passwordLabel, firstNameLabel, lastNameLabel, phoneNumberLabel, roleLabel,
			registrationNoLabel, capacityLabel,   errorEmailLabel, errorPasswordLabel,
			errorFirstNameLabel, errorLastNameLabel, errorPhoneNumberLabel, errorRegNoLabel, errorCapacityLabel;
	JTextField emailTextField, passwordTextField, firstNameTextField, lastNameTextField, phoneNumberTextField,
			registerationNoTextField, capacityTextField;
	JButton submitButton;
	String[] choices = { "Customer", "Schedular", "Driver" };
	JComboBox<String> roleComboBox;
	JPanel registrationNumberPanel;
	JPanel capacityPanel;

	public CustomerProfilePage() {
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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

		errorEmailLabel = new JLabel("");
		errorEmailLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorEmailLabel.setForeground(Color.red);
		errorPasswordLabel = new JLabel("");
		errorPasswordLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorPasswordLabel.setForeground(Color.red);
		errorFirstNameLabel = new JLabel("");
		errorFirstNameLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorFirstNameLabel.setForeground(Color.red);
		errorLastNameLabel = new JLabel("");
		errorLastNameLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorLastNameLabel.setForeground(Color.red);
		errorPhoneNumberLabel = new JLabel("");
		errorPhoneNumberLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorPhoneNumberLabel.setForeground(Color.red);
		errorRegNoLabel = new JLabel("");
		errorRegNoLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorRegNoLabel.setForeground(Color.red);
		errorCapacityLabel = new JLabel("");
		errorCapacityLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorCapacityLabel.setForeground(Color.red);

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
		emailGbc.gridy = 2;
		errorEmailLabel.setVisible(false);
		emailPanel.add(errorEmailLabel, emailGbc);
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
		passwordGbc.gridy = 2;
		errorPasswordLabel.setVisible(false);
		passwordPanel.add(errorPasswordLabel, passwordGbc);
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
		firstNameGbc.gridy = 2;
		errorFirstNameLabel.setVisible(false);
		firstNamePanel.add(errorFirstNameLabel, firstNameGbc);
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
		lastNameGbc.gridy = 2;
		errorLastNameLabel.setVisible(false);
		lastNamePanel.add(errorLastNameLabel, lastNameGbc);

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
		phoneNumberGbc.gridy = 2;
		errorPhoneNumberLabel.setVisible(false);
		phoneNumberPanel.add(errorPhoneNumberLabel, phoneNumberGbc);
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
		roleComboBox.addActionListener(this);
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

		registrationNumberPanel = new JPanel(new GridBagLayout());
		GridBagConstraints registrationNumberGbc = new GridBagConstraints();
		registrationNumberGbc.gridx = 0;
		registrationNumberGbc.gridy = 0;
		registrationNumberGbc.anchor = GridBagConstraints.WEST;
		registrationNumberPanel.add(registrationNoLabel, registrationNumberGbc);
		registrationNumberGbc.gridy = 1;
		registrationNumberPanel.add(registerationNoTextField, registrationNumberGbc);
		registrationNumberGbc.gridy = 2;
		errorRegNoLabel.setVisible(false);
		registrationNumberPanel.add(errorRegNoLabel, registrationNumberGbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(10, 0, 0, 0); // Set insets to zero
		panel.add(registrationNumberPanel, gbc);

		capacityPanel = new JPanel(new GridBagLayout());
		GridBagConstraints capacityGbc = new GridBagConstraints();
		capacityGbc.gridx = 0;
		capacityGbc.gridy = 0;
		capacityGbc.anchor = GridBagConstraints.WEST;
		capacityPanel.add(capacityLabel, capacityGbc);
		capacityGbc.gridy = 1;
		capacityPanel.add(capacityTextField, capacityGbc);
		capacityGbc.gridy = 2;
		errorCapacityLabel.setVisible(false);
		capacityPanel.add(errorCapacityLabel, capacityGbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.insets = new Insets(10, 20, 0, 0); // Set insets to zero
		panel.add(capacityPanel, gbc);

		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		submitButton.setMargin(new Insets(5, 50, 5, 50));
		submitButton.setFocusPainted(false);
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
		buttonPanel.add(submitButton, buttonGbc);
		panel.add(buttonPanel, gbc);
		this.add(panel);
		
		DBManagement dbManagement = new DBManagement();
		OfflineDB offlineDB = new OfflineDB();
		UsersList usersList = null;
		try {
			usersList=dbManagement.getUserDetails(offlineDB.loadLoginId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(usersList!=null) {
		emailTextField.setText(usersList.getEmail());
		passwordTextField.setText(usersList.getPassword());
		firstNameTextField.setText(usersList.getFirstName());
		lastNameTextField.setText(usersList.getLastName());
		phoneNumberTextField.setText(usersList.getPhoneNumber());
		registerationNoTextField.setText(usersList.getRegNumber());
		capacityTextField.setText(String.valueOf(usersList.getCapacity()));
		if(usersList.getRole()=="Customer") {			
			roleComboBox.setSelectedIndex(0);
			registrationNumberPanel.setVisible(false);
			capacityPanel.setVisible(false);
		}else if(usersList.getRole()=="Schedular") {
			roleComboBox.setSelectedIndex(1);
			registrationNumberPanel.setVisible(false);
			capacityPanel.setVisible(false);
		}else if(usersList.getRole()=="Driver") {
			roleComboBox.setSelectedIndex(2);
			registrationNumberPanel.setVisible(true);
			capacityPanel.setVisible(true);
		}else {
			registrationNumberPanel.setVisible(false);
			capacityPanel.setVisible(false);
		}
		
		passwordTextField.setEditable(false);
		passwordTextField.setEnabled(false);
		roleComboBox.setEnabled(false);
		roleComboBox.setEditable(false);
		emailTextField.setEnabled(false);
		emailTextField.setEditable(false);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String role = choices[roleComboBox.getSelectedIndex()];
		if (e.getSource() == roleComboBox) {
			if (role == "Driver") {
				registrationNumberPanel.setVisible(true);
				capacityPanel.setVisible(true);
			} else {
				registrationNumberPanel.setVisible(false);
				capacityPanel.setVisible(false);
			}
		}
		if (e.getSource() == submitButton ) {
			if (emailTextField.getText().trim().equals("")) {
				errorEmailLabel.setText("Email is required");
				errorEmailLabel.setVisible(true);
			} else {
				errorEmailLabel.setVisible(false);
			}
			if (passwordTextField.getText().trim().equals("")) {
				errorPasswordLabel.setText("Password is required");
				errorPasswordLabel.setVisible(true);
			} else {
				errorPasswordLabel.setVisible(false);
			}
			if (firstNameTextField.getText().trim().equals("")) {
				errorFirstNameLabel.setText("First Name is required");
				errorFirstNameLabel.setVisible(true);
			} else {
				errorFirstNameLabel.setVisible(false);
			}
			if (lastNameTextField.getText().trim().equals("")) {
				errorLastNameLabel.setText("Last Name is required");
				errorLastNameLabel.setVisible(true);
			} else {
				errorLastNameLabel.setVisible(false);
			}
			if (phoneNumberTextField.getText().trim().equals("")) {
				errorPhoneNumberLabel.setText("Phone Number is required");
				errorPhoneNumberLabel.setVisible(true);
			} else {
				errorPhoneNumberLabel.setVisible(false);
			}
			if (role == "Driver") {
				if (registerationNoTextField.getText().trim().equals("")) {
					errorRegNoLabel.setText("Registration Number is required");
					errorRegNoLabel.setVisible(true);
				} else {
					errorRegNoLabel.setVisible(false);
				}
				if (capacityTextField.getText().trim().equals("")) {
					errorCapacityLabel.setText("Capacity is required");
					errorCapacityLabel.setVisible(true);
				} else {
					errorCapacityLabel.setVisible(false);
				}
			}
			if (!emailTextField.getText().trim().equals("") && !passwordTextField.getText().trim().equals("")
					&& !firstNameTextField.getText().trim().equals("") && !lastNameTextField.getText().trim().equals("")
					&& !phoneNumberTextField.getText().trim().equals("")
					&& (role == "Customer" || role == "Schedular"
							|| !registerationNoTextField.getText().trim().equals(""))
					&& (role == "Customer" || role == "Schedular" || !capacityTextField.getText().trim().equals(""))) {
				errorEmailLabel.setVisible(false);
				errorPasswordLabel.setVisible(false);
				errorFirstNameLabel.setVisible(false);
				errorLastNameLabel.setVisible(false);
				errorPhoneNumberLabel.setVisible(false);
				errorRegNoLabel.setVisible(false);
				errorCapacityLabel.setVisible(false);
				DBManagement dbManagement = new DBManagement();
				String email = emailTextField.getText();
				String password = passwordTextField.getText();
				String firstname = firstNameTextField.getText();
				String lastname = lastNameTextField.getText();
				String phonenumber = phoneNumberTextField.getText();
				String regnumber = "";
				int capacity = 0;
				if (role == "Driver") {
					regnumber = registerationNoTextField.getText();
					capacity = Integer.parseInt(capacityTextField.getText());
				}
				UsersList usersList = new UsersList(email, password, firstname, lastname, phonenumber, role, regnumber,
						capacity);
				try {
					boolean check=dbManagement.updateProfile(usersList);
					if(check) {
						Toast t = new Toast("Update is sucessful", 150, 400);
						t.showtoast();
					}else {
						Toast t = new Toast("Something went wrong", 150, 400);
						t.showtoast();
					}
					//new LoginPage();
					//closeWindow();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	}
	}
	
}