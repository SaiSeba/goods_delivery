package goods;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import controller.DBManagement;
import model.DeafultScheduleListModel;
import model.DefaultMissionListModel;
import model.ScheduleList;
import model.UsersList;

public class MissionHistoryPage extends JPanel implements ActionListener {
	// headers for the table
	String[] columns = new String[] { "No", "Date", "Warehouse Address", "Goods", "Weight", "Schedule" };
	JLabel productLabel;
	JDateChooser deliveryDateTextField;
	List<ScheduleList> list01 = new ArrayList<>();
	List<ScheduleList> list = new ArrayList<>();
	DefaultMissionListModel model = new DefaultMissionListModel();
	HomePage frame;
	JPanel panel = new JPanel(new FlowLayout());
	public MissionHistoryPage(HomePage frame) {
		this.frame=frame;
		this.setLayout(new FlowLayout());
		// this.setLayout(new GridBagLayout());
		
//		productLabel=new JLabel("Check");
		Dimension textFieldSize = new Dimension(200, 30); // Set the desired size
		deliveryDateTextField = new JDateChooser();
		deliveryDateTextField.setMaximumSize(textFieldSize);
		deliveryDateTextField.setPreferredSize(textFieldSize);
		deliveryDateTextField.setMinimumSize(textFieldSize);
		GridBagConstraints delivaryDateGbc = new GridBagConstraints();
		delivaryDateGbc.gridx = 0;
		delivaryDateGbc.gridy = 0;
		delivaryDateGbc.anchor = GridBagConstraints.WEST;
		delivaryDateGbc.insets = new Insets(10, 10, 0, 10);
		panel.add(deliveryDateTextField, delivaryDateGbc);
		panel.setOpaque(true);
		panel.setBackground(Color.white);
		JTextFieldDateEditor editor = (JTextFieldDateEditor) deliveryDateTextField.getDateEditor();
		editor.setEditable(false);

		try {
			DBManagement dbManagement = new DBManagement();
			list01 = dbManagement.getScheduleList();
		

			for (int i = 0; i < list01.size(); i++) {
				model.add(list01.get(i));
			}
			JTable table = new JTable(model);
			TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(model);
			table.setRowSorter(rowSorter);
			deliveryDateTextField.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent e) {
					if ("date".equals(e.getPropertyName())) {
						SimpleDateFormat format1 = new SimpleDateFormat("EEE MMM dd yyyy");
						SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");

						System.out.println("chehjgjhgdgk 01 " + e.getNewValue());

						rowSorter.setRowFilter(RowFilter.regexFilter(format1.format(e.getNewValue()) + "?", 1));

					}
				}
			});

			panel.setSize(800, 460);
			this.setSize(800, 460);
			table.setSize(800, 460);
			panel.setPreferredSize(new Dimension(800, 600));
			panel.revalidate();
			panel.repaint();
			table.revalidate();
			table.repaint();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

//			table.setPreferredSize(width, height);
//			table.setMaximumSize(width, height);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setPreferredSize(new Dimension(750, 600));

			panel.add(scrollPane);
			TableColumnModel columnModel = table.getColumnModel();

			columnModel.getColumn(0).setPreferredWidth(2);
			columnModel.getColumn(1).setPreferredWidth(50);
			columnModel.getColumn(2).setPreferredWidth(100);
			columnModel.getColumn(3).setPreferredWidth(30);
			columnModel.getColumn(4).setPreferredWidth(10);
			columnModel.getColumn(5).setMinWidth(50);
			table.revalidate();
			table.repaint();
			table.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					int row = table.rowAtPoint(evt.getPoint());

					int col = table.columnAtPoint(evt.getPoint());
					if (row >= 0 && col == 5) {

						System.out.print("hjgdjghj  " + table.getValueAt(row, 0) + "  "
								+ list01.get(Integer.parseInt(table.getValueAt(row, 0) + "") - 1).getScheduleid());
						DBManagement dbManagement = new DBManagement();
						try {
							List<UsersList> list02 = dbManagement.getUserDetailsByType("Driver");
							String[] users = new String[300];
							for (int i = 0; i < list02.size(); i++) {
								users[i] = (list02.get(i).getFirstName() + " " + list02.get(i).getLastName());
							}
							JComboBox comboBox = new JComboBox(users);
							// comboBox.setSelectedIndex(1);
							int ref = JOptionPane.showConfirmDialog(null, comboBox, "Schedule",
									JOptionPane.DEFAULT_OPTION);
							if (ref == JOptionPane.OK_OPTION) {
								dbManagement = new DBManagement();

								int check = dbManagement.updateScheduleIntoDB(
										list02.get(comboBox.getSelectedIndex()).getID(), 0,
										list01.get(Integer.parseInt(table.getValueAt(row, 0) + "") - 1)
												.getScheduleid());
								if (check == 1) {
//									JOptionPane.showConfirmDialog(null, "Update Schedule sucessful ", "Confirm Message",
//											JOptionPane.DEFAULT_OPTION);
//									table.remove(comboBox);
//								table.removeAll();
//									table.validate();
//									table.repaint();
//									table.revalidate();
//									model = new DeafultScheduleListModel();
//									list01 = dbManagement.getScheduleList();
//								
//									
//									for (int i = 0; i < list01.size(); i++) {
//										
//										table.setValueAt(list01.get(i), 0, 0);
//										 model.remove(list01.get(i));
//										model.add(list01.get(i));
//									}
//									
//									JTable table = new JTable(model);
//									table.validate();
//									table.repaint();
//									table.revalidate();
//									TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(model);
//									table.tableChanged(new TableModelEvent(model));
									//table.setVisible(true);
									
								} else {
									JOptionPane.showConfirmDialog(null, "Something went wrong", "Error!",
											JOptionPane.DEFAULT_OPTION);
								}
								
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						// list01.get(row).getorderid());
					}
				}
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		//headers for the table
//        String[] columns = new String[] {
//            "Id", "Name", "Hourly Rate", "Part Time"
//        };
//         
//        //actual data for the table in a 2d array
//        Object[][] data = new Object[][] {
//            {1, "John", 40.0, false },
//            {2, "Rambo", 70.0, false },
//            {3, "Zorro", 60.0, true },
//        };
//         
//        final Class[] columnClass = new Class[] {
//            Integer.class, String.class, Double.class, Boolean.class
//        };
//        //create table model with data
//        DefaultTableModel model = new DefaultTableModel(data, columns) {
//            @Override
//            public boolean isCellEditable(int row, int column)
//            {
//                return false;
//            }
//            @Override
//            public Class<?> getColumnClass(int columnIndex)
//            {
//                return columnClass[columnIndex];
//            }
//        };
//         
//        JTable table = new JTable(model);

		// add the table to the frame

		// panel.add(new JScrollPane(table),gbc);
		// add the table to the frame
		this.add(panel);
		// this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
}
