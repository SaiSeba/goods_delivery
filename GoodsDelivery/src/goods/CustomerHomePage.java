package goods;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import controller.DBManagement;
import model.NewOrder;
import model.OrderProduct;
import model.ProductList;

public class CustomerHomePage extends JPanel implements ActionListener {
	JLabel productLabel, deliveryDateLebel, weightLabel, addressLabel;
	private DefaultListModel productListModel;
	private JList<CustomPanel> productList;
	JTextArea addressTextField;
	// TitledBorder titledBorder;
	RoundedButton addBtn;
	RoundedButton removeBtn;
	JScrollPane scrollPane;
	JPanel productPanel01;
	JPanel buttonPanel;
	ArrayList<JPanel> listPanel;
	JDateChooser deliveryDateTextField;
	JButton confirmButton;
	JComboBox<String> productBox;
	List<ProductList> list;
	JSpinner spinner;

	public CustomerHomePage() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.setOpaque(true);
		panel.setBackground(Color.WHITE);
		// getContentPane().setBackground(Color.WHITE);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		// gbc.weightx = 1.0;
		// gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		// gbc.gridwidth = 1;

		listPanel = new ArrayList<JPanel>();
		productListModel = new DefaultListModel<>();
		productList = new JList<>(productListModel);
		NoSelectionModel noSelectionModel = new NoSelectionModel();
		productList.setSelectionModel(noSelectionModel);
		productList.setEnabled(false);
		productList.clearSelection();

		// productList.setCellRenderer(new JPanelCellRenderer());
		productList.setCellRenderer(new CustomPanelCellRenderer());
		// productList.setCellEditor(new CustomPanelEditor(new JTextField())); // Use
		// your desired editor

		this.setBackground(Color.WHITE);
		scrollPane = new JScrollPane(productList);
		productPanel01 = new JPanel(new GridBagLayout());
		// scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(380, 300));
		scrollPane.setMinimumSize(new Dimension(340, 100));
		scrollPane.setMaximumSize(new Dimension(340, 300));
		// panel.add(scrollPane, gbc);
		GridBagConstraints gbc02 = new GridBagConstraints();
		gbc02.gridx = 0;
		gbc02.gridy = 0;
		// gbc02.weightx = 1.0;
		// gbc02.weighty = 1.0;
		// gbc02.gridwidth = 1;
		JPanel panels = createPanel();
		scrollPane = new JScrollPane(panels);
		productPanel01.add(panels, gbc02);
		// productPanel01.add(scrollPane, gbc02);

		addBtn = new RoundedButton("+");
		addBtn.setSize(10, 10);
		// addBtn.setBounds(0, 0, 30, 25);
		// addBtn.setBorder(new RoundedBorder(10)); // 10 is the radius
		addBtn.setForeground(Color.BLUE);
		addBtn.addActionListener(this);
		gbc02 = new GridBagConstraints();
		gbc02.gridx = 0;
		gbc02.gridy = 2;
		gbc02.anchor = GridBagConstraints.EAST;
		gbc02.fill = GridBagConstraints.VERTICAL;
		buttonPanel = new JPanel(new GridBagLayout());

		removeBtn = new RoundedButton("-");
		removeBtn.setSize(10, 10);
		// addBtn.setBounds(0, 0, 30, 25);
		// addBtn.setBorder(new RoundedBorder(10)); // 10 is the radius
		removeBtn.setForeground(Color.BLUE);
		removeBtn.addActionListener(this);
		gbc02 = new GridBagConstraints();
		gbc02.gridx = 0;
		gbc02.gridy = 2;
		gbc02.anchor = GridBagConstraints.EAST;
		gbc02.fill = GridBagConstraints.VERTICAL;
		buttonPanel.add(removeBtn);
		buttonPanel.add(addBtn);
		productPanel01.add(buttonPanel, gbc02);
		productPanel01.setBackground(Color.WHITE);
		panel.add(productPanel01, gbc);
		// panel.add(productPanel01, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		TitledBorder titledBorder = BorderFactory.createTitledBorder("Delivery");
		JPanel deliveryPanel = new JPanel(new GridBagLayout());
		deliveryPanel.setBorder(titledBorder);
		JPanel deliveryDatePanel = new JPanel(new GridBagLayout());
		GridBagConstraints delivaryDateGbc = new GridBagConstraints();
		delivaryDateGbc.gridx = 0;
		delivaryDateGbc.gridy = 0;
		delivaryDateGbc.anchor = GridBagConstraints.WEST;
		deliveryDateLebel = new JLabel("Delivery Date\s:\s\s\s"); // Set the titled border to the JPanel
		addressLabel = new JLabel("Address\s:\s\s\s\s\s\s\s\s\s\s");
		deliveryDatePanel.setBackground(Color.white);
		deliveryDatePanel.add(deliveryDateLebel, delivaryDateGbc);
		delivaryDateGbc.gridx = 1;
		// productList.setEnabled(getFocusTraversalKeysEnabled());
//		SpinnerNumberModel sm = new SpinnerNumberModel(0, 0, 9, 1);
//		textFieldSize = new Dimension(80, 30); // Set the desired size
//		JSpinner spinner = new JSpinner(sm);
//		((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
//		spinner.setMaximumSize(textFieldSize);
//		spinner.setPreferredSize(textFieldSize);
//		spinner.setMinimumSize(textFieldSize);
//		spinner.getEditor().getComponent(0).setBackground(Color.white);
//		weightPanel.add(spinner, weightGbc);
//		
//		deliveryPanel.add(deliveryDateLebel);
		Dimension textFieldSize = new Dimension(200, 30); // Set the desired size
		deliveryDateTextField = new JDateChooser();
		deliveryDateTextField.setMaximumSize(textFieldSize);
		deliveryDateTextField.setPreferredSize(textFieldSize);
		deliveryDateTextField.setMinimumSize(textFieldSize);
		delivaryDateGbc.insets = new Insets(10, 10, 0, 10);
		deliveryDatePanel.add(deliveryDateTextField, delivaryDateGbc);

		JPanel addressPanel = new JPanel(new GridBagLayout());
		addressPanel.setBackground(Color.WHITE);
		GridBagConstraints addressGbc = new GridBagConstraints();
		addressGbc.gridx = 0;
		addressGbc.gridy = 0;
		addressGbc.anchor = GridBagConstraints.WEST;
		addressGbc.insets = new Insets(0, 10, 10, 10);
		addressPanel.add(addressLabel, addressGbc);
		addressGbc.gridx = 1;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 10, 10, 10);
//	    textFieldSize = new Dimension(200, 30); // Set the desired size
//	    deliveryDateTextField = new JTextField(20);
//	    deliveryDateTextField.setMaximumSize(textFieldSize);
//	    deliveryDateTextField.setPreferredSize(textFieldSize);
//	    deliveryDateTextField.setMinimumSize(textFieldSize);
//	    delivaryDateGbc.insets = new Insets(10, 10, 0, 10);
//	    deliveryDatePanel.add(deliveryDateTextField, delivaryDateGbc);

		deliveryPanel.add(deliveryDatePanel, gbc);
		addressTextField = new JTextArea();
		addressTextField.setRows(8);
		addressTextField.setColumns(20);
		textFieldSize = new Dimension(200, 30); // Set the desired size
//		addressTextField.setMaximumSize(textFieldSize);
//		addressTextField.setPreferredSize(textFieldSize);
//		addressTextField.setMinimumSize(textFieldSize);

		addressGbc = new GridBagConstraints();
		addressGbc.gridx = 1;
		addressGbc.gridy = 0;
		addressGbc.anchor = GridBagConstraints.WEST;
		addressGbc.insets = new Insets(0, 10, 10, 10);
		addressPanel.add(new JScrollPane(addressTextField), addressGbc);

		GridBagConstraints gbc01 = new GridBagConstraints();
		gbc01.gridx = 0;
		gbc01.gridy = 1;
		gbc01.weightx = 1.0;
		gbc01.weighty = 1.0;
		gbc01.anchor = GridBagConstraints.WEST;
		gbc01.gridwidth = 1;
		deliveryPanel.setBackground(Color.WHITE);
		deliveryPanel.add(addressPanel, gbc01);

		panel.add(deliveryPanel, gbc);
		addPanel();

		confirmButton = new JButton("Confim Order");
		confirmButton.addActionListener(this);
		confirmButton.setMargin(new Insets(5, 50, 5, 50));
		confirmButton.setFocusPainted(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 0;
		// gbc.weightx = 1.0;
		// gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.SOUTH;
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.white);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(panel);
		buttonPanel.add(confirmButton);
		this.add(buttonPanel, gbc);
	}

	private void addPanel() {
//		JPanel panel = createPanel();
		// productListModel.addElement(new CustomPanel(panel));
		if (productListModel.getSize() > 1) {
			buttonPanel.add(removeBtn, 0);
		} else {
			buttonPanel.remove(0);
		}
		buttonPanel.revalidate();
		buttonPanel.repaint();
		// panel.revalidate();
		// panel.repaint();
		// productPanel01.revalidate();
		// productPanel01.repaint();
		scrollPane.revalidate();
		scrollPane.repaint();
	}

	private void removePanel() {

		productListModel.remove(productListModel.getSize() - 1);
		if (productListModel.getSize() > 1) {
			buttonPanel.add(removeBtn, 0);
		} else {
			buttonPanel.remove(0);
		}
		buttonPanel.revalidate();
		buttonPanel.repaint();
	}

	private JPanel createPanel() {
		TitledBorder titledBorder = BorderFactory.createTitledBorder("Product " + (productListModel.getSize() + 1));

		JPanel productPanel = new JPanel(new GridBagLayout());
		productLabel = new JLabel("Product\s\s\s\s\s\s\s\s:\s\s\s\s");
		weightLabel = new JLabel("Weight\s(KG)\s:\s\s\s");
		// productListModel.en
		// Set the titled border to the JPanel
		productPanel.setBorder(titledBorder);

		DBManagement db = new DBManagement();
		list = new ArrayList<ProductList>();
		;

		productBox = new JComboBox<String>();
		try {
			list = db.getProductList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			// choices[i]=list.get(i).getProductName();
			productBox.addItem(list.get(i).getProductName());
		}

		productBox.setBackground(Color.white);
		Dimension textFieldSize = new Dimension(250, 30); // Set the desired size
		productBox.setMaximumSize(textFieldSize);
		productBox.setPreferredSize(textFieldSize);
		productBox.setMinimumSize(textFieldSize);
		// productBox.setRequestFocusEnabled(true);
		productBox.setEditable(true);

//		 productBox.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
//		        @Override
//		        public void focusLost(FocusEvent e) {
//		            updateJList();
//		        }
//		    });
//		 productBox.addActionListener(e -> updateJList());
		JPanel productNamePanel = new JPanel(new GridBagLayout());
		GridBagConstraints roleGbc = new GridBagConstraints();
		roleGbc.gridx = 0;
		roleGbc.gridy = 0;
		roleGbc.anchor = GridBagConstraints.WEST;
		productNamePanel.setBackground(Color.WHITE);
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
		 spinner = new JSpinner(sm);
		((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setEditable(true);
		spinner.setMaximumSize(textFieldSize);
		spinner.setPreferredSize(textFieldSize);
		spinner.setMinimumSize(textFieldSize);
		spinner.getEditor().getComponent(0).setBackground(Color.white);
		weightPanel.add(spinner, weightGbc);
		weightPanel.setBackground(Color.WHITE);

		gbc01 = new GridBagConstraints();
		gbc01.gridx = 0;
		gbc01.gridy = 1;
		gbc01.weightx = 1.0;
		gbc01.weighty = 1.0;
		gbc01.anchor = GridBagConstraints.WEST;
		gbc01.gridwidth = 1;
		gbc01.insets = new Insets(10, 10, 10, 10);
		productPanel.add(weightPanel, gbc01);
		listPanel.add(0, productPanel);

//		productList.add(productBox,productListModel.getSize());
//		productList.add(spinner,productListModel.getSize());
//		productList.add(productPanel,productListModel.getSize());
		// productListModel.add(productListModel.getSize(),new
		// CustomPanel(productBox,spinner,productPanel));
		return productPanel;
	}

	private static class CustomPanelCellRenderer extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			if (value instanceof CustomPanel) {
				CustomPanel customPanel = (CustomPanel) value;
				return customPanel.getPanel();
			}
			return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		}
	}
//	private static class CustomPanelEditor  extends DefaultCellEditor  {
//		public CustomPanelEditor (JTextField textField) {
//            super(textField);
//            setClickCountToStart(1);
//        }
//		@Override
//		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//			Component renderer = super.getTableCellEditorComponent(table, value, isSelected, row, column);
//        
//
//			if (value instanceof CustomPanel) {
//                CustomPanel customPanel = (CustomPanel) value;
//                return customPanel.getPanel();
//            }
//			return renderer;
//		}
//	}
	// Add a method to update the JList when the JComboBox values are changed
//	private void updateJList() {
//	    int selectedIndex = productList.getSelectedIndex();
//	    if (selectedIndex != -1) {
//	        productListModel.set(selectedIndex, createPanel());
//	    }
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (addBtn == e.getSource()) {
			addPanel();
		}
		if (removeBtn == e.getSource()) {
			removePanel();
		}
        if(confirmButton==e.getSource()) {
        	DBManagement dbManagement = new DBManagement();
        	OfflineDB offlineDB = new OfflineDB();
        	Date deliverydate=deliveryDateTextField.getDate();
        	String address=addressTextField.getText();
        	int status=0;
        	int userid=offlineDB.loadLoginId();
        	NewOrder newOrder=new NewOrder(deliverydate,address,status,userid);
        	try {
			int orderID=	dbManagement.newOrderIntoDB(newOrder);
			int quantity=(int) spinner.getValue();
			  int productid=list.get( productBox.getSelectedIndex()).getId();
			OrderProduct orderProduct=new OrderProduct(quantity,orderID,productid);
			int check=dbManagement.orderProductIntoDB(orderProduct,deliverydate);
			if(check==1) {
				JOptionPane.showConfirmDialog(null, 
		                "Thank for your order", "Confirm Message", JOptionPane.DEFAULT_OPTION);
			}else {
				JOptionPane.showConfirmDialog(null, 
		                "Something went wrong", "Error!", JOptionPane.DEFAULT_OPTION);
			}
			System.out.println("order id "+orderID);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
	}

	private static class CustomPanel {
		private JComboBox<String> productBox;
		private JSpinner spinner;
		private JPanel panel;

		public CustomPanel(JComboBox<String> productBox, JSpinner spinner, JPanel panel) {
			this.productBox = productBox;
			this.spinner = spinner;
			this.panel = panel;
		}

		public JComboBox<String> getProductBox() {
			return productBox;
		}

		public JSpinner getSpinner() {
			return spinner;
		}

		public JPanel getPanel() {
			return panel;
		}

//	        public CustomPanel( JPanel panel) {
//	            // ... (your existing code)
//
//	             this.panel=panel;
//	        }
	}

	private static class NoSelectionModel extends DefaultListSelectionModel {
		@Override
		public void setSelectionInterval(int index0, int index1) {
			super.setSelectionInterval(-1, -1);
		}
	}
}