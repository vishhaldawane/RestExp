import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.java.order.level2.Order;
import com.java.order.level3.OrderRepository;
import com.java.order.level3.OrderRepositoryImpl;
/*
 * 			ClassName				OrderTest
 * 			fieldName				foodItem
 * 			methodName				setFoodItem
 * 			packagename				com.java.order
 * 			CONSTANT				MIN_ORDER/ MAX_ORDER
 */
public class OrderTest {
	public static void main(String[] args) {
		
		System.out.println("Begin main");
		
		OrderRepository orderRepo = new OrderRepositoryImpl();
		
		/*List<Order> orderList = orderRepo.selectAllOrders();
		
		
		// http://ip:port/order/getOrders
		for(Order theOrder : orderList) {
		
			System.out.println("Order Id      : "+theOrder.getOrderId());
			System.out.println("Table Number  : "+theOrder.getTableNumber());
			System.out.println("Order Date    : "+theOrder.getOrderDate());
			System.out.println("Food Item     : "+theOrder.getFoodItem());
			System.out.println("Food Price    : "+theOrder.getPrice());
			System.out.println("Food Quantity : "+theOrder.getQuantity());
			System.out.println("Total Bill    : "+theOrder.getTotal());
			System.out.println("------------------");
			
		}*/
		
		
		/*
		  Order theOrder = orderRepo.selectOrder(104); // http://ip:port/order/getOrder/103
		 
		System.out.println("Order Id      : "+theOrder.getOrderId());
		System.out.println("Table Number  : "+theOrder.getTableNumber());
		System.out.println("Order Date    : "+theOrder.getOrderDate());
		System.out.println("Food Item     : "+theOrder.getFoodItem());
		System.out.println("Food Price    : "+theOrder.getPrice());
		System.out.println("Food Quantity : "+theOrder.getQuantity());
		System.out.println("Total Bill    : "+theOrder.getTotal());
		System.out.println("------------------");
		*/
		/*
		Order newOrder = new Order(106,LocalDateTime.now(),6,"Paneer Chilly",230,2); //POJO 

		orderRepo.createOrder(newOrder);
		
		List<Order> orderList = orderRepo.selectAllOrders();
		
		
		// http://ip:port/order/getOrders
		for(Order theOrder : orderList) {
		
			System.out.println("Order Id      : "+theOrder.getOrderId());
			System.out.println("Table Number  : "+theOrder.getTableNumber());
			System.out.println("Order Date    : "+theOrder.getOrderDate());
			System.out.println("Food Item     : "+theOrder.getFoodItem());
			System.out.println("Food Price    : "+theOrder.getPrice());
			System.out.println("Food Quantity : "+theOrder.getQuantity());
			System.out.println("Total Bill    : "+theOrder.getTotal());
			System.out.println("------------------");
			
		}
		*/

		//103->Daal Rice",150,1
		/*
		 Order updatedOrder = new Order(103,LocalDateTime.now(),6,"Paneer Crispy",250,2); //POJO 
	

		orderRepo.updateOrder(updatedOrder);
		
		List<Order> orderList = orderRepo.selectAllOrders();
		
		
		// http://ip:port/order/getOrders
		for(Order theOrder : orderList) {
		
			System.out.println("Order Id      : "+theOrder.getOrderId());
			System.out.println("Table Number  : "+theOrder.getTableNumber());
			System.out.println("Order Date    : "+theOrder.getOrderDate());
			System.out.println("Food Item     : "+theOrder.getFoodItem());
			System.out.println("Food Price    : "+theOrder.getPrice());
			System.out.println("Food Quantity : "+theOrder.getQuantity());
			System.out.println("Total Bill    : "+theOrder.getTotal());
			System.out.println("------------------");
			
		}
		*/
		
		
		orderRepo.deleteOrder(102);
		
		List<Order> orderList = orderRepo.selectAllOrders();
		
		
		// http://ip:port/order/getOrders
		for(Order theOrder : orderList) {
		
			System.out.println("Order Id      : "+theOrder.getOrderId());
			System.out.println("Table Number  : "+theOrder.getTableNumber());
			System.out.println("Order Date    : "+theOrder.getOrderDate());
			System.out.println("Food Item     : "+theOrder.getFoodItem());
			System.out.println("Food Price    : "+theOrder.getPrice());
			System.out.println("Food Quantity : "+theOrder.getQuantity());
			System.out.println("Total Bill    : "+theOrder.getTotal());
			System.out.println("------------------");
			
		}
		
	}
}
