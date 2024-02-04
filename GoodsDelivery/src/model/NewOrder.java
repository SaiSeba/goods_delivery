package model;

import java.util.Date;

public class NewOrder {
	int orderid;
	Date deliverydate;
	String address;
	int status;
	int userid;

	public NewOrder( Date deliverydate, String address, int status, int userid) {
		this.deliverydate = deliverydate;
		this.address = address;
		this.status = status;
		this.userid = userid;
	}
	public int getOrderId() {
		return this.orderid;
	}
	public Date getDeliveryDate() {
		return this.deliverydate;
	}
	public String getAddress() {
		return this.address;
	}
	public int getStatus() {
		return this.status;
	}
	public int getUserID() {
		return this.userid;
	}
	public void setOrderID(int orderid) {
		this.orderid=orderid;
	}
	public void setDeliveryDate(Date deliverydate) {
		this.deliverydate=deliverydate;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public void setStatus(int status) {
		this.status=status;
	}
	public void setUserID(int userid) {
		this.userid=userid;
	}
	
}
