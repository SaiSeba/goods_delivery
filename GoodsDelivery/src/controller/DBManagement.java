package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import goods.OfflineDB;
import model.NewOrder;
import model.OrderProduct;
import model.ProductList;
import model.ScheduleList;
import model.UsersList;

public class DBManagement {
	public void registerIntoDB(UsersList usersList) throws SQLException {
		System.out.println("Inserting DATA");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "insert registration (email,password,firstname,lastname,phonenumber,role,regnumber,capacity) VALUES ( "
				+ "'" + usersList.getEmail() + "', '" + usersList.getPassword() + "', '" + usersList.getFirstName()
				+ "', '" + usersList.getLastName() + "', '" + usersList.getPhoneNumber() + "', '" + usersList.getRole()
				+ "', '" + usersList.getRegNumber() + "', " + usersList.getCapacity() + "" + ")";
		// 4. Execute The Query
		stmt.executeUpdate(sql);
		System.out.println("1 row affected.");

		// 5. Close the connection
		conn.close();
	}

	public boolean checkLogin(String email, String password01) throws SQLException {
		boolean check = false;
		System.out.println("Getting data from a DB");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "select * from registration where email='" + email + "' and password='" + password01 + "'";
		// 4. Execute The Query
		ResultSet rs = stmt.executeQuery(sql);
		// 5. Displaying the Result
		while (rs.next()) {
			check = true;
			OfflineDB offlineDB = new OfflineDB();
			offlineDB.saveLoginStatus(true);
			offlineDB.saveLoginID(rs.getInt("id"));
		}

		// 4. Close connection
		conn.close();
		return check;
	}

	public List<ProductList> getProductList() throws SQLException {
		System.out.println("Getting data from a DB");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "select * from productlist ";
		// 4. Execute The Query
		ResultSet rs = stmt.executeQuery(sql);
		List<ProductList> productList = new ArrayList<ProductList>();
		// 5. Displaying the Result
		while (rs.next()) {
			int productid = rs.getInt("productid");
			String productname = rs.getString("productname");
			int weight = rs.getInt("weight");
			productList.add(new ProductList(productid, productname, weight));

		}

		// 4. Close connection
		conn.close();
		return productList;
	}

	public UsersList getUserDetails(int userID) throws SQLException {
		System.out.println("Getting data from a DB");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "select * from registration where id=" + userID + "";
		// 4. Execute The Query
		ResultSet rs = stmt.executeQuery(sql);
		UsersList usersList = null;
		// 5. Displaying the Result
		while (rs.next()) {
			String email = rs.getString("email");
			String password01 = rs.getString("password");
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			String phonenumber = rs.getString("phonenumber");
			String role = rs.getString("role");
			String regnumber = rs.getString("regnumber");
			int capacity = rs.getInt("capacity");
			usersList = new UsersList(email, password01, firstname, lastname, phonenumber, role, regnumber, capacity);

		}

		// 4. Close connection
		conn.close();
		return usersList;
	}
	
	public List<UsersList> getUserDetailsByType(String role01) throws SQLException {
		System.out.println("Getting data from a DB");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "select * from registration where role='" + role01 + "'";
		// 4. Execute The Query
		ResultSet rs = stmt.executeQuery(sql);
		List<UsersList> usersList = new ArrayList<>();
		// 5. Displaying the Result
		while (rs.next()) {
			int id=rs.getInt("id");
			String email = rs.getString("email");
			String password01 = rs.getString("password");
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			String phonenumber = rs.getString("phonenumber");
			String role = rs.getString("role");
			String regnumber = rs.getString("regnumber");
			int capacity = rs.getInt("capacity");
			UsersList usersList01= new UsersList(email, password01, firstname, lastname, phonenumber, role, regnumber, capacity);
			usersList01.setID(id);
			usersList.add(usersList01);

		}

		// 4. Close connection
		conn.close();
		return usersList;
	}

	public boolean updateProfile(UsersList usersList) throws SQLException {
		boolean check = false;
		System.out.println("Inserting DATA");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		OfflineDB offlineDB = new OfflineDB();
		// 3. Prepare The Query
		String sql = "update registration SET " + "email='" + usersList.getEmail() + "',password= '"
				+ usersList.getPassword() + "',firstname= '" + usersList.getFirstName() + "',lastname= '"
				+ usersList.getLastName() + "',phonenumber= '" + usersList.getPhoneNumber() + "',role= '"
				+ usersList.getRole() + "',regnumber= '" + usersList.getRegNumber() + "',capacity= "
				+ usersList.getCapacity() + "" + " where id=" + offlineDB.loadLoginId() + "";
		System.out.println(sql);
		// 4. Execute The Query
		stmt.executeUpdate(sql);
		// ResultSet rs = stmt.executeQuery(sql);
		System.out.println("1 row affected.");
		// while (rs.next()) {
		check = true;

		// }
		// 5. Close the connection
		conn.close();
		return check;
	}

	public int newOrderIntoDB(NewOrder newOrder) throws SQLException {
		int newId = 0;
		System.out.println("Inserting DATA");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "insert neworder (deliverydate,address,status,userid) VALUES ( " + "'" + newOrder.getDeliveryDate()
				+ "', '" + newOrder.getAddress() + "', '" + newOrder.getStatus() + "', " + newOrder.getUserID() + ")";
		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		// 4. Execute The Query
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			newId = rs.getInt(1);
		}
		System.out.println("1 row affected.");

		// 5. Close the connection
		conn.close();
		return newId;
	}
	
	public NewOrder getOrderIntoDB(int orderid) throws SQLException {
		NewOrder neworder = null;
		int newId = 0;
		System.out.println("Inserting DATA");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "select * from neworder where orderid="+orderid+"";
		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		// 4. Execute The Query
		//ps.executeUpdate();
		ResultSet rs = stmt.executeQuery(sql);
		neworder=new NewOrder();
		if (rs.next()) {
			
			neworder.setOrderID(rs.getInt("orderid")); 
			neworder.setAddress(rs.getString("address"));
			
		}
		System.out.println("1 row affected.");

		// 5. Close the connection
		conn.close();
		return neworder;
	}
	
	public OrderProduct getProductOrderIntoDB(int orderproductid) throws SQLException {
		OrderProduct neworder = null;
		int newId = 0;
		System.out.println("Inserting DATA");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "select * from orderproduct where orderproductid="+orderproductid+"";
		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		// 4. Execute The Query
	//	ps.executeUpdate();
		ResultSet rs = stmt.executeQuery(sql);
		neworder=new OrderProduct();
		if (rs.next()) {
			neworder.setOrderid(rs.getInt("orderid")); 
			neworder.setProductid(rs.getInt("productid"));
			neworder.setQuantity(rs.getInt("quantity"));
			
		}
		System.out.println("1 row affected.");

		// 5. Close the connection
		conn.close();
		return neworder;
	}

	public int orderProductIntoDB(OrderProduct orderProduct,Date orderDate) throws SQLException {
		int status = 0;
		System.out.println("Inserting DATA");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "insert orderproduct(quantity,orderid,productid) VALUES ( " + "" + orderProduct.getQuantity()
				+ ", " + orderProduct.getOrderId() + ", " + orderProduct.getProductId() + ")";
		// 4. Execute The Query
		int count = stmt.executeUpdate(sql);
		if (count > 0) {
			status = scheduleIntoDB(orderDate,orderProduct);
			
		} else {
			status = 0;
		}
		System.out.println("1 row affected.");

		// 5. Close the connection
		conn.close();
		return status;
	}
	public int scheduleIntoDB(Date orderDate,OrderProduct orderProduct) throws SQLException {
		int status = 0;
		System.out.println("Inserting DATA");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "insert schedule(deliverydate,productid,quantity,orderid,status) VALUES ( "+ "'" + orderDate + "', " + orderProduct.getProductId()
				+ ", " + orderProduct.getQuantity() + ", " + orderProduct.getOrderId()+", "+0 + ")";
		// 4. Execute The Query
		int count = stmt.executeUpdate(sql);
		if (count > 0) {
			status = 1;
		} else {
			status = 0;
		}
		System.out.println("1 row affected.");

		// 5. Close the connection
		conn.close();
		return status;
	}
	
	public int updateScheduleIntoDB(int schdriverid,int status01,int scheduleid) throws SQLException {
		int status = 0;
		System.out.println("Inserting DATA");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "UPDATE schedule SET status="+status01+", schdriverid="+schdriverid+" WHERE scheduleid="+scheduleid
				+ "";
		System.out.println("1 row affected. "+sql);
		// 4. Execute The Query
		int count = stmt.executeUpdate(sql);
		if (count > 0) {
			status = 1;
		} else {
			status = 0;
		}
		

		// 5. Close the connection
		conn.close();
		return status;
	}
	
	@SuppressWarnings("null")
	public List<ScheduleList> getScheduleList() throws SQLException {
		System.out.println("Getting data from a DB");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdelivery";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "select * from schedule";
		// 4. Execute The Query
		ResultSet rs = stmt.executeQuery(sql);
		List<ScheduleList> list = new ArrayList<>();
		
		// 5. Displaying the Result
		while (rs.next()) {
			int scheduleid=rs.getInt("scheduleid");
			String deliverydate= rs.getString("deliverydate");;
			String warehouse=rs.getString("warehouse");
			String warehouseaddress=rs.getString("warehouseaddress");
			int schdriverid=rs.getInt("schdriverid");
			int schrouteid=rs.getInt("schrouteid");
			int prouductid=rs.getInt("productid");
			int quantity=rs.getInt("quantity");
			int orderid=rs.getInt("orderid");
			int status=rs.getInt("status");
			ScheduleList  scheduleList = new ScheduleList(deliverydate, warehouse,  warehouseaddress,  schdriverid,  schrouteid,
					 prouductid,  quantity,orderid,status);
			scheduleList.setscheduleid(scheduleid);
			list.add(scheduleList);
		}

		// 4. Close connection
		conn.close();
		return list;
	}

}
