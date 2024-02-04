package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import goods.OfflineDB;
import model.NewOrder;
import model.OrderProduct;
import model.ProductList;
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
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			newId = rs.getInt(1);
		}
		System.out.println("1 row affected.");

		// 5. Close the connection
		conn.close();
		return newId;
	}

	public int orderProductIntoDB(OrderProduct orderProduct) throws SQLException {
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
			status = 1;
		} else {
			status = 0;
		}
		System.out.println("1 row affected.");

		// 5. Close the connection
		conn.close();
		return status;
	}

}
