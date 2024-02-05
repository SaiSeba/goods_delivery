package model;

public class ScheduleList {
	int scheduleid;
	String deliverydate;
	String warehouse="Warehouse Name";
	String warehouseaddress="Warehouse address1\nWarehouse address line2\nWarehouse address line3";
	int schdriverid;
	int schrouteid;
	int prouductid;
	int quantity;
	int orderid;
	int status;

	public ScheduleList(String deliverydate, String warehouse, String warehouseaddress, int schdriverid, int schrouteid,
			int prouductid, int quantity,int orderid,int status) {
		this.deliverydate = deliverydate;
		this.warehouse = warehouse;
		this.warehouseaddress = warehouseaddress;
		this.schdriverid = schdriverid;
		this.schrouteid = schrouteid;
		this.prouductid = prouductid;
		this.quantity = quantity;
		this.orderid=orderid;
		this.status=status;
	}

	public int getScheduleid() {
		return this.scheduleid;
	}

	public String getDeliverydate() {
		return this.deliverydate;
	}

	public String getWarehouse() {
		return this.warehouse;
	}

	public String getWarehouseaddress() {
		return this.warehouseaddress;
	}

	public int getschdriverid() {
		return this.schdriverid;
	}

	public int getschrouteid() {
		return this.schrouteid;
	}

	public int getprouductid() {
		return this.prouductid;
	}

	public int getquantity() {
		return this.quantity;
	}
    
	public int getorderid() {
		return this.orderid;
	}
	
	public int getstatus() {
		return this.status;
	}
	public void setscheduleid(int scheduleid) {
		this.scheduleid = scheduleid;
	}

	public void setdeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}

	public void setwarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public void setwarehouseaddress(String warehouseaddress) {
		this.warehouseaddress = warehouseaddress;
	}

	public void setschdriverid(int schdriverid) {
		this.schdriverid = schdriverid;
	}

	public void setschrouteid(int schrouteid) {
		this.schrouteid = schrouteid;
	}

	public void setprouductid(int prouductid) {
		this.prouductid = prouductid;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setorderid(int orderid) {
		this.orderid=orderid;
	}
	public void setstatus(int status) {
		this.status=status;
	}
}
