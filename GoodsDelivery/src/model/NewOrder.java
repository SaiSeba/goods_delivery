package model;

public class NewOrder {
	int orderid;
	String deliverydate;
	String address;
	String status;
	int userid;

	public NewOrder(int orderid, String deliverydate, String address, String status, int userid) {
		this.orderid = orderid;
		this.deliverydate = deliverydate;
		this.address = address;
		this.status = status;
		this.userid = userid;
	}
	int getOrderId() {
		return this.orderid;
	}
	String getDeliveryDate() {
		return this.deliverydate;
	}
	String getAddress() {
		return this.address;
	}
	String getStatus() {
		return this.status;
	}
	int getUserID() {
		return this.userid;
	}
	void setOrderID(int orderid) {
		this.orderid=orderid;
	}
	void setDeliveryDate(String deliverydate) {
		this.deliverydate=deliverydate;
	}
	void setAddress(String address) {
		this.address=address;
	}
	void setStatus(String status) {
		this.status=status;
	}
	void setUserID(int userid) {
		this.userid=userid;
	}
	
}
