package goods;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;

public class CustomerHomePage extends JPanel implements ActionListener {
	JLabel productLabel, deliveryDateLebel, weightLabel;
	String[] choices = { "Customer", "Schedular", "Driver" };
	JComboBox<String> productBox;

	public CustomerHomePage() {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = 1;
		TitledBorder titledBorder = BorderFactory.createTitledBorder("Product 1");
		JPanel productPanel = new JPanel(new GridBagLayout());
		productLabel = new JLabel("Product\s\s\s\s\s\s\s\s:\s\s\s\s");
		weightLabel = new JLabel("Weight\s(KG)\s:\s\s\s");
		// Set the titled border to the JPanel
		productPanel.setBorder(titledBorder);

		productBox = new JComboBox<String>(choices);
		productBox.setBackground(Color.white);
		Dimension textFieldSize = new Dimension(250, 30); // Set the desired size
		productBox.setMaximumSize(textFieldSize);
		productBox.setPreferredSize(textFieldSize);
		productBox.setMinimumSize(textFieldSize);
		productBox.setVisible(true);

		JPanel productNamePanel = new JPanel(new GridBagLayout());
		GridBagConstraints roleGbc = new GridBagConstraints();
		roleGbc.gridx = 0;
		roleGbc.gridy = 0;
		roleGbc.anchor = GridBagConstraints.WEST;
		productNamePanel.add(productLabel, roleGbc);
		roleGbc.gridx = 1;
		productNamePanel.add(productBox, roleGbc);
		GridBagConstraints gbc01 = new GridBagConstraints();
		gbc01.gridx = 0;
		gbc01.gridy = 0;
		gbc01.weightx = 1.0;
		gbc01.weighty = 1.0;
		gbc01.anchor = GridBagConstraints.WEST;
		gbc01.gridwidth = 1;
		gbc01.insets = new Insets(10, 10, 0, 10);
		productPanel.add(productNamePanel, gbc01);

		JPanel weightPanel = new JPanel(new GridBagLayout());
		GridBagConstraints weightGbc = new GridBagConstraints();
		weightGbc.gridx = 0;
		weightGbc.gridy = 0;
		weightGbc.anchor = GridBagConstraints.WEST;
		weightPanel.add(weightLabel, weightGbc);
		weightGbc.gridx = 1;
		SpinnerNumberModel sm = new SpinnerNumberModel(0, 0, 9, 1);
		textFieldSize = new Dimension(80, 30); // Set the desired size
		JSpinner spinner = new JSpinner(sm);
		((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
		spinner.setMaximumSize(textFieldSize);
		spinner.setPreferredSize(textFieldSize);
		spinner.setMinimumSize(textFieldSize);
		weightPanel.add(spinner, weightGbc);
		gbc01 = new GridBagConstraints();
		gbc01.gridx = 0;
		gbc01.gridy = 1;
		gbc01.weightx = 1.0;
		gbc01.weighty = 1.0;
		gbc01.anchor = GridBagConstraints.WEST;
		gbc01.gridwidth = 1;
		gbc01.insets = new Insets(10, 10, 10, 10);
		productPanel.add(weightPanel, gbc01);

		panel.add(productPanel, gbc);

		JButton addBtn = new JButton("+");
		addBtn.setBounds(0, 0, 30, 25);
		addBtn.setBorder(new RoundedBorder(100)); // 10 is the radius
		addBtn.setForeground(Color.BLUE);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(addBtn, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		titledBorder = BorderFactory.createTitledBorder("Delivery");
		JPanel deliveryPanel = new JPanel(new GridBagLayout());
		deliveryDateLebel = new JLabel("Delivery Date");
		// Set the titled border to the JPanel
		deliveryPanel.setBorder(titledBorder);
		deliveryPanel.add(deliveryDateLebel);
		panel.add(deliveryPanel, gbc);
		this.add(panel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}