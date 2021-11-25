package com.java.order.level3;

import java.util.List;

import com.java.order.level2.Order;

public interface OrderRepository {
	//here we will have 5 methods for REST
	
	void createOrder(Order order); //declaration
	Order selectOrder(int orderid);
	List<Order> selectAllOrders();
	void updateOrder(Order order);
	void deleteOrder(int orderId);
	
}
