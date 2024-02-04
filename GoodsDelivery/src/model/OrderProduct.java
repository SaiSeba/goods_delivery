package model;

public class OrderProduct {
  int quantity;
  int orderid;
  int productid;
  public OrderProduct(int quantity,int orderid,int productid) {
	  this.quantity=quantity;
	  this.orderid=orderid;
	  this.productid=productid;
  }
  public int getQuantity() {
	  return this.quantity;
  }
  public int getOrderId() {
	  return this.orderid;
  }
  public int getProductId() {
	  return this.productid;
  }
  public void setQuantity(int quantity) {
	  this.quantity=quantity;
  }
  public void setOrderid(int orderid) {
	  this.orderid=orderid;
  }
  public void setProductid(int productid) {
	  this.productid=productid;
  }
}
