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

import javax.swing.JLabel;
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
import model.DefaultDriverListModel;
import model.ScheduleList;
import model.UsersList;

public class DriverOverviewPage extends JPanel implements ActionListener {
	// headers for the table
	String[] columns = new String[] { "No", "First name", "Last name", "Registration number", "Capacity", "Phone number" };
	List<UsersList> list01=new ArrayList<>();
	List<UsersList> list=new ArrayList<>();

	public DriverOverviewPage() {
		this.setLayout(new FlowLayout());
		JPanel panel = new JPanel(new FlowLayout());		
		panel.setOpaque(true);
		panel.setBackground(Color.white);		
		try {
			DBManagement dbManagement = new DBManagement();
			list01 = dbManagement.getUserDetailsByType("Driver");
			DefaultDriverListModel model =new DefaultDriverListModel();
			
			for (int i = 0; i < list01.size(); i++) {
				model.add(list01.get(i));
			}
			JTable table = new JTable(model);
			TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(model);
			table.setRowSorter(rowSorter);
						 
			panel.setSize(800, 460);
			this.setSize(800, 460);
			table.setSize(800, 460);
			panel.setPreferredSize(new Dimension(800, 600));
			panel.revalidate();
			panel.repaint();
			table.revalidate();
			table.repaint();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			JScrollPane scrollPane = new JScrollPane(table, 
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
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
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

