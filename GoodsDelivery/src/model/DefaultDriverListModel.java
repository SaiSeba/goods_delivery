package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import controller.DBManagement;

public class DefaultDriverListModel extends AbstractTableModel {

	private List<UsersList> items;

	public DefaultDriverListModel() {
		items = new ArrayList<>(25);
	}

	public DefaultDriverListModel(List<UsersList> items) {
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
			return "First Name";
		case 2:
			return "Last Name";
		case 3:
			return "Registration number";
		case 4:
			return "Capacity";
		case 5:
			return "Phone number";
		}
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		UsersList item = items.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return String.valueOf(rowIndex + 1);
		case 1:
			return item.getFirstName();
			
		case 2:
			return item.getLastName();
		case 3:
			return item.getRegNumber();
		case 4:
			return String.valueOf(item.getCapacity());
		case 5:
			return item.getPhoneNumber();
		}
		return null;
	}

	public void add(UsersList item) {
		items.add(item);
		int row = items.indexOf(item);
		fireTableRowsInserted(row, row);
	}

	public void remove(UsersList item) {
		if (items.contains(item)) {
			int row = items.indexOf(item);
			items.remove(row);
			fireTableRowsDeleted(row, row);
		}
	}

}
