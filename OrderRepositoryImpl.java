package com.java.order.level3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.java.order.level2.Order;

public class OrderRepositoryImpl implements OrderRepository {

	List<Order> orderList = new ArrayList<Order>(); // DATA
	
	public OrderRepositoryImpl() { //INITIALIZER 
		Order theOrder1 = new Order(101,LocalDateTime.now(),1,"Fried Rice",220,2); //POJO 
		Order theOrder2 = new Order(102,LocalDateTime.now(),2,"Plain Rice",120,2); //POJO 
		Order theOrder3 = new Order(103,LocalDateTime.now(),3,"Daal Rice",150,1); //POJO 
		Order theOrder4 = new Order(104,LocalDateTime.now(),4,"Curd Rice",100,3); //POJO 
		Order theOrder5 = new Order(105,LocalDateTime.now(),5,"Jeera Rice",170,4); //POJO 

		orderList.add(theOrder1);
		orderList.add(theOrder2);
		orderList.add(theOrder3);
		orderList.add(theOrder4);
		orderList.add(theOrder5);
	}
	
	
	@Override
	public void createOrder(Order order) {  // CREATE REPO
		System.out.println("Adding the order....");
		orderList.add(order);
	}

	@Override
	public Order selectOrder(int orderId) { // SELECT SINGLE REPO
		System.out.println("Searching the order...."+orderId);
		
		Order foundOrder = null;
		
		for(Order theOrder : orderList) {
			if(theOrder.getOrderId() == orderId) {
				foundOrder = theOrder;
				break;
			}
		}
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
		
		for(int i=0;i<orderList.size();i++) {
			Order tempOrder = orderList.get(i);
			if(tempOrder.getOrderId() == order.getOrderId())
			{
				orderList.remove(i);
				orderList.add(order);
				break;
			}
		}

	}

	@Override
	public void deleteOrder(int orderId) { //DELETE
		System.out.println("Deleting order....");
		for(int i=0;i<orderList.size();i++) {
			Order tempOrder = orderList.get(i);
			if(tempOrder.getOrderId() == orderId)
			{
				orderList.remove(i);
				break;
			}
		}

	}

}
