package com.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
			
			LocalDateTime dateTime = order.getOrderDate();
			java.sql.Date sqlDate = java.sql.Date.valueOf(dateTime.toLocalDate());
			System.out.println("sql date "+sqlDate);
			pst.setDate(2, sqlDate);
			
			
			pst.setInt(3,order.getTableNumber());
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
		
		Order foundOrder = null;
		
		/*for(Order theOrder : orderList) {
			if(theOrder.getOrderId() == orderId) {
				foundOrder = theOrder;
				break;
			}
		}*/
		return foundOrder;
	}

	@Override
	public List<Order> selectAllOrders() { //SELECT ALL
		System.out.println("Selecting all orders....");
		return orderList;
	}

	@Override
	public void updateOrder(Order order) { //UPDATE
		System.out.println("Updating the order...");
		
		/*for(int i=0;i<orderList.size();i++) {
			Order tempOrder = orderList.get(i);
			if(tempOrder.getOrderId() == order.getOrderId())
			{
				orderList.remove(i);
				orderList.add(order);
				break;
			}
		}*/

	}

	@Override
	public void deleteOrder(int orderId) { //DELETE
		System.out.println("Deleting order....");
	/*	for(int i=0;i<orderList.size();i++) {
			Order tempOrder = orderList.get(i);
			if(tempOrder.getOrderId() == orderId)
			{
				orderList.remove(i);
				break;
			}
		}*/

	}

}
