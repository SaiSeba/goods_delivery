package model;

public class ProductList {
   int id;
   String productName;
   int weight;
   public ProductList(int id,String productName,int weight) {
	   this.id=id;
	   this.productName=productName;
	   this.weight=weight;
   }
   
public int getId() {
	   return this.id;
   }
   public String getProductName() {
	   return this.productName;
   }
   public int getWeight() {
	   return this.weight;
   }
   public void setId(int id) {
	   this.id=id;
   }
   public void setProductName(String productName) {
	   this.productName=productName;
   }
   public void setWeight(int weight) {
	   this.weight=weight;
   }
}
