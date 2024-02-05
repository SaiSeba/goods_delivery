package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DefaultRouteOverviewListModel extends AbstractTableModel {

	private List<RouteOverviewListModel> items;

	public DefaultRouteOverviewListModel() {
		items = new ArrayList<>(25);
	}

	public DefaultRouteOverviewListModel(List<RouteOverviewListModel> items) {
		this.items = items;
	}

	@Override
	public int getRowCount() {
		return items.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
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
		case 6:
		}
		return Object.class;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "No";
		case 1:
			return "Reg No";
		case 2:
			return "Date";
		case 3:
			return "Route";
		case 4:
			return "Goods(KG)";
		case 5:
			return "Total weight";
		case 6:
			return "Status";
		}
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		RouteOverviewListModel item = items.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return String.valueOf(rowIndex + 1);
		case 1:
			return item.getregno();
			
		case 2:
			return item.getdate();
		case 3:
			return item.getroute();
		case 4:
			return item.getgoods();
		case 5:
			return item.gettotalWeight();
		case 6:
			return item.getstatus() == 2?"Completed" :(item.getstatus() == 1? "Scheduled" : "Not Scheduled");
		}
		return null;
	}

	public void add(RouteOverviewListModel item) {
		items.add(item);
		int row = items.indexOf(item);
		fireTableRowsInserted(row, row);
	}

	public void remove(RouteOverviewListModel item) {
		if (items.contains(item)) {
			int row = items.indexOf(item);
			items.remove(row);
			fireTableRowsDeleted(row, row);
		}
	}

}
