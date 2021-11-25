import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
		
		Order theOrder1 = new Order(101,LocalDateTime.now(),1,"Fried Rice",220,2); //POJO 
		Order theOrder2 = new Order(102,LocalDateTime.now(),2,"Plain Rice",120,2); //POJO 
		Order theOrder3 = new Order(103,LocalDateTime.now(),3,"Daal Rice",150,1); //POJO 
		Order theOrder4 = new Order(104,LocalDateTime.now(),4,"Curd Rice",100,3); //POJO 
		Order theOrder5 = new Order(105,LocalDateTime.now(),5,"Jeera Rice",170,4); //POJO 

		
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		orderList.add(theOrder1);
		orderList.add(theOrder2);
		orderList.add(theOrder3);
		orderList.add(theOrder4);
		orderList.add(theOrder5);
		
		
		
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
