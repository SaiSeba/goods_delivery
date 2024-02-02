package model;

public class UsersList {
   int id;
   String email;
   String password;
   String firtname;
   String lastname;
   String phonenumber;
   String role;
   String regnumber;
   int capacity;
   public UsersList(String email,String password,String firstname,String lastname,String phonenumber,String role,String regnumber,int capacity) {
	   this.email=email;
	   this.password=password;
	   this.firtname=firstname;
	   this.lastname=lastname;
	   this.phonenumber=phonenumber;
	   this.role=role;
	   this.regnumber=regnumber;
	   this.capacity=capacity;
   }
   public int getID() {
	   return this.id;
   }
   public String getEmail() {
	   return this.email;
   }
   public String getPassword() {
	   return this.password;
   }
   public String getFirstName() {
	   return this.firtname;
   }
   public String getLastName() {
	   return this.lastname;
   }
   public String getPhoneNumber() {
	   return this.phonenumber;
   }
   public String getRole() {
	   return this.role;
   }
   public String getRegNumber() {
	   return this.regnumber;
   }
   public int getCapacity() {
	   return this.capacity;
   }
   public void setID(int id) {
	   this.id=id;
   }
   public void setEmail(String email) {
	   this.email=email;
   }
   public void setFirstName(String firstname) {
	   this.firtname=firstname;
   }
   public void setLastName(String lastname) {
	   this.lastname=lastname;
   }
   public void setPhoneNumber(String phonenumber) {
	   this.phonenumber=phonenumber;
   }
   public void setRole(String role) {
	   this.role=role;
   }
   public void setRegNumber(String regnumber) {
	   this.regnumber=regnumber;
   }
   public void setCapacity(int capacity) {
	   this.capacity=capacity;
   }
}
