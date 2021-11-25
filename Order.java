import java.time.LocalDateTime;

public class Order {
	
	private int 	orderId; //?
	LocalDateTime 	orderDate; //?
	private int 	tableNumber; // ?
	private String 	foodItem; //customer
	private float 	price;    //restaurant
	private int  	quantity;  //customer
	private float 	total;   //restaurant
	
	
	public Order(int orderId, LocalDateTime orderDate, int tableNumber, String foodItem, float price, int quantity) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.tableNumber = tableNumber;
		this.foodItem = foodItem;
		this.price = price;
		this.quantity = quantity;
		this.total = this.quantity * this.price; //autocalculate
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
	
}
