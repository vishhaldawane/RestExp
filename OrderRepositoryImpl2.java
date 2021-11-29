package com.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.sql.DATE;


public class OrderRepositoryImpl2 implements OrderRepository {
	
	 List<Order> orderList = new ArrayList<Order>(); // blank arraylist
	 Connection conn; //import from java.sql
	
	OrderRepositoryImpl2()  { //INITIALIZER run only once 
		
		//1. LOAD THE DATABASE DRIVER 
		try {
			//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver is loaded...");
		
			//2. now acquire the connection  - thin url
			//
	// conn = DriverManager.getConnection("jdbc:oracle:thin:@ipoforacleserver:1521:oracleInstance",
		//			"oracle user name",
			//		"password here");
	 
	 conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydb","SA","");
			System.out.println("Connected to the database ....");
			
			//3 make the statement of your choice , DQL, DML etc
	Statement st = conn.createStatement();
			System.out.println("Statement is created...");
			
			//4. execute the query and retrieve the result if any
	ResultSet rs	=	st.executeQuery("select * from order12");
	System.out.println("Query is fired...and got the result....");
	
			while(rs.next()) {
				
				Order orderObj = new Order(); //  blank order
					orderObj.setOrderId(rs.getInt(1));
					orderObj.setTableNumber(rs.getInt(2));
					
					
					java.sql.Date date = rs.getDate(3); //grab the data from 3rd field and assing it to java.sql.Date
					Timestamp timestamp = new Timestamp(date.getTime());//retrieve the date's milliseconds and convert to a timestamp
					LocalDateTime tempLocalDate = timestamp.toLocalDateTime();
					orderObj.setOrderDate(tempLocalDate);
					
					orderObj.setFoodItem(rs.getString(4));
					orderObj.setPrice(rs.getInt(5));
					orderObj.setQuantity(rs.getInt(6));
					orderObj.setTotal(rs.getInt(7));
				
				System.out.println("Adding the object to the list.....");
				orderList.add(orderObj); // fill up the object to the list
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public void createOrder(Order order) {  // CREATE REPO
		System.out.println("Adding the order....");
		//orderList.add(order);
	
		try {
			PreparedStatement pst =conn.prepareStatement("insert into order12 values(?,?,?,?,?,?,?)");
			pst.setInt(1, order.getOrderId());
			pst.setInt(2,order.getTableNumber());
			
			LocalDateTime dateTime = order.getOrderDate();
			System.out.println("=>dateTime : "+dateTime);
			
			Timestamp timestamp =  Timestamp.valueOf(dateTime);
			System.out.println("=>timestamp : "+timestamp);
			
			java.sql.Date sqlDate = new java.sql.Date(timestamp.getTime());
			System.out.println("=>sqlDate : "+sqlDate);
			pst.setDate(3, sqlDate);
		
			
			pst.setString(4,order.getFoodItem());
			pst.setFloat(5, order.getPrice());
			pst.setInt(6, order.getQuantity());
			pst.setFloat(7, order.getPrice() * order.getQuantity());
			pst.executeUpdate(); // will fire the insert query....
			System.out.println("Order created in the database.....");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Order selectOrder(int orderId) { // SELECT SINGLE REPO
		System.out.println("Searching the order...."+orderId);
		
		Order orderObj = new Order(); //  blank order
		
		try {
			
			Statement st = conn.createStatement();
			System.out.println("Statement is created...");
			
			//4. execute the query and retrieve the result if any
			ResultSet rs	=	st.executeQuery("select * from order12 where orderid="+orderId);
			System.out.println("Query is fired...and got the result....");
	
			
		
				if(rs.next()) {
			
				
					orderObj.setOrderId(rs.getInt(1));
					orderObj.setTableNumber(rs.getInt(2));
				
				
					java.sql.Date date = rs.getDate(3); //grab the data from 3rd field and assing it to java.sql.Date
					Timestamp timestamp = new Timestamp(date.getTime());//retrieve the date's milliseconds and convert to a timestamp
					LocalDateTime tempLocalDate = timestamp.toLocalDateTime();
					orderObj.setOrderDate(tempLocalDate);
					
					orderObj.setFoodItem(rs.getString(4));
					orderObj.setPrice(rs.getInt(5));
					orderObj.setQuantity(rs.getInt(6));
					orderObj.setTotal(rs.getInt(7));
			
					System.out.println("Found the object.");
					
				}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		return orderObj;
	}
	
	
	

	@Override
	public List<Order> selectAllOrders() { //SELECT ALL
		System.out.println("Selecting all orders....");
		return orderList;
	}

	@Override
	public void updateOrder(Order order) {  // CREATE REPO
		System.out.println("updating the order....");
		
		try {//tablenumber int,
			 
			PreparedStatement pst =conn.prepareStatement("update order12 set tablenumber=?, orderdate=?, fooditem=?, price=?, quantity=?, total=? where orderid=?");
			pst.setInt(7, order.getOrderId());
			pst.setInt(1,order.getTableNumber());
			
			LocalDateTime dateTime = order.getOrderDate();
			System.out.println("=>dateTime : "+dateTime);
			
			Timestamp timestamp =  Timestamp.valueOf(dateTime);
			System.out.println("=>timestamp : "+timestamp);
			
			java.sql.Date sqlDate = new java.sql.Date(timestamp.getTime());
			System.out.println("=>sqlDate : "+sqlDate);
			pst.setDate(2, sqlDate);
		
			
			pst.setString(3,order.getFoodItem());
			pst.setFloat(4, order.getPrice());
			pst.setInt(5, order.getQuantity());
			pst.setFloat(6, order.getPrice() * order.getQuantity());
			pst.executeUpdate(); // will fire the insert query....
			System.out.println("Order updated in the database.....");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrder(int orderId) { //DELETE
		System.out.println("Deleting order....");
		try {//tablenumber int,
			 
			PreparedStatement pst =conn.prepareStatement("delete from order12 where orderid=?");
			pst.setInt(1, orderId);
			
			pst.executeUpdate(); // will fire the insert query....
			System.out.println("Order deleted from the database.....");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
