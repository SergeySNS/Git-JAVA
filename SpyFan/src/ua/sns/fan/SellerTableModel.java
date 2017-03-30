package ua.sns.fan;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class SellerTableModel implements TableModel {
	private ArrayList<TableModelListener> listener;
	
	public SellerTableModel(){
		listener = new ArrayList<TableModelListener>();
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		listener.add(l);

	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public String getColumnName(int index) {
		String rs = "";
		switch (index) {
			case 0:
				rs = "Server";
				break;
			case 1:
				rs = "Side";
				break;
			case 2:
				rs = "Name";
				break;
			case 3:
				rs = "Sum";
				break;
			case 4:
				rs = "Price";
				break;
			case 5:
				rs = "Sell";
				break;
		}
		return rs;
	}

	@Override
	public int getRowCount() {
		return spyfan.sellers.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Object ro = null;
		switch (col) {
			case 0:
				ro = spyfan.sellers.get(row).getServer();
				break;
			case 1:
				ro = spyfan.sellers.get(row).getSide();
				break;
			case 2:
				ro = spyfan.sellers.get(row).getName();
				break;
			case 3:
				ro = spyfan.sellers.get(row).getSum();
				break;
			case 4:
				ro = spyfan.sellers.get(row).getPrice();
				break;
			case 5:
				ro = spyfan.sellers.get(row).getSell();
				break;
		}
		return ro;
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listener.remove(l);
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		switch (col) {
		case 0:
			spyfan.sellers.get(row).setServer((String) value);
			break;
		case 1:
			spyfan.sellers.get(row).setSide((String) value);
			break;
		case 2:
			spyfan.sellers.get(row).setName((String) value);
			break;
		case 3:
			spyfan.sellers.get(row).setSum((String) value);
			break;
		case 4:
			spyfan.sellers.get(row).setPrice((String) value);
			break;
		case 5:
			spyfan.sellers.get(row).setSell((String) value);
			break;
		}

	}

}
