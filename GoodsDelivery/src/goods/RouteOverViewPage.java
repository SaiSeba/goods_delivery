package goods;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
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
import model.DefaultDriverListModel;
import model.DefaultRouteOverviewListModel;
import model.NewOrder;
import model.OrderProduct;
import model.ProductList;
import model.RouteOverviewListModel;
import model.ScheduleList;
import model.UsersList;

public class RouteOverViewPage extends JPanel implements ActionListener {
	// headers for the table
	String[] columns = new String[] { "No", "Reg No", "Date", "Route", "Goods(KG)", "Total weight","Status" };
	List<RouteOverviewListModel> list01=new ArrayList<>();
	List<RouteOverviewListModel> list=new ArrayList<>();
	JDateChooser deliveryDateTextField;
	JButton exportButton;

	public RouteOverViewPage() {
		this.setLayout(new FlowLayout());
		JPanel panel = new JPanel(new FlowLayout());	
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
		exportButton = new JButton("Export");
		exportButton.addActionListener(this);
		exportButton.setMargin(new Insets(5, 50, 5, 50));
		exportButton.setFocusPainted(false);
		GridBagConstraints gbc01= new GridBagConstraints();
		gbc01.gridx = 0;
		gbc01.gridy = 6;
		gbc01.anchor = GridBagConstraints.CENTER;
		JPanel buttonPanel = new JPanel(new GridBagLayout());
		GridBagConstraints buttonGbc = new GridBagConstraints();
		buttonGbc.gridx = 1;
		buttonGbc.gridy = 0;
		gbc01.gridwidth = 2;
		gbc01.insets = new Insets(20, 0, 0, 0); // Set insets to zero
		buttonGbc.anchor = GridBagConstraints.EAST;
		buttonPanel.add(exportButton, buttonGbc);
		panel.add(buttonPanel, gbc01);
		panel.setOpaque(true);
		panel.setBackground(Color.white);
		JTextFieldDateEditor editor = (JTextFieldDateEditor) deliveryDateTextField.getDateEditor();
		editor.setEditable(false);
		panel.setOpaque(true);
		panel.setBackground(Color.white);		
		try {
			DBManagement dbManagement = new DBManagement();
			List<ScheduleList> scheduleList = dbManagement.getScheduleList();
			DefaultRouteOverviewListModel model =new DefaultRouteOverviewListModel();
			
			for (int i = 0; i < scheduleList.size(); i++) {
				ScheduleList s=scheduleList.get(i);
				System.out.println("bjdgjdgj "+s.getschdriverid());
				UsersList user=dbManagement.getUserDetails(s.getschdriverid());
				
				NewOrder neworder=dbManagement.getOrderIntoDB(s.getorderid());
				OrderProduct order=dbManagement.getProductOrderIntoDB(neworder.getOrderId());
				List<ProductList> listProduct=dbManagement.getProductList();
				String goods="";
				for(int j=0;j<listProduct.size();j++) {
					if(listProduct.get(j).getId()==order.getProductId()) {
						goods=listProduct.get(j).getProductName();
					}
				}
				if(user!=null) {
				RouteOverviewListModel route=new RouteOverviewListModel(user.getRegNumber(),s.getDeliverydate(),s.getWarehouseaddress()+" "+neworder.getAddress(),goods,order.getQuantity(),s.getstatus(),s.getScheduleid());
				
				list01.add(route);}
						
			}
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

						rowSorter.setRowFilter(RowFilter.regexFilter(format1.format(e.getNewValue()) + "?", 2));

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
