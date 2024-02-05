package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

import controller.DBManagement;

public class DeafultScheduleListModel extends AbstractTableModel {

	private List<ScheduleList> items;

	public DeafultScheduleListModel() {
		items = new ArrayList<>(25);
	}

	public DeafultScheduleListModel(List<ScheduleList> items) {
		this.items = items;
	}

	@Override
	public int getRowCount() {
		return items.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		}
		return Object.class;
	}
   
  
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "No";
		case 1:
			return "Date";
		case 2:
			return "Warehouse Address";
		case 3:
			return "Goods";
		case 4:
			return "Weight";
		case 5:
			return "Schedule";
		}
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ScheduleList item = items.get(rowIndex);
		DBManagement db = new DBManagement();
		List<ProductList> list = new ArrayList<ProductList>();

		String productName = "";
		try {
			list = db.getProductList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			// choices[i]=list.get(i).getProductName();
			if (list.get(i).getId() == item.getprouductid()) {
				productName = list.get(i).getProductName();
				break;
			}
		}

//    	this.deliverydate = deliverydate;
//		this.warehouse = warehouse;
//		this.warehouseaddress = warehouseaddress;
//		this.schdriverid = schdriverid;
//		this.schrouteid = schrouteid;
//		this.prouductid = prouductid;
//		this.quantity = quantity;
//		this.orderid=orderid;
//		this.status=status;
		switch (columnIndex) {
		case 0:
			return String.valueOf(rowIndex + 1);
		case 1:
			SimpleDateFormat format1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
			SimpleDateFormat format2 = new SimpleDateFormat("EEE MMM dd yyyy");
			 try {
				Date date = format1.parse(item.getDeliverydate());
				return format2.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		case 2:
			return item.getWarehouseaddress();
		case 3:
			return productName;
		case 4:
			return String.valueOf(item.getquantity());
		case 5:
			return item.getstatus() == 1 ? "Scheduled" : "Not Scheduled";
		}
		return null;
	}

	public void add(ScheduleList item) {
		items.add(item);
		int row = items.indexOf(item);
		fireTableRowsInserted(row, row);
	}

	public void remove(ScheduleList item) {
		if (items.contains(item)) {
			int row = items.indexOf(item);
			items.remove(row);
			fireTableRowsDeleted(row, row);
		}
	}

}
