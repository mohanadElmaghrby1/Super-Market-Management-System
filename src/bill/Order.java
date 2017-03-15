package bill;

/**
 * 
 * @author mohanad-elmaghrby
 *
 */
public class Order {

	
	private int id;
	
	private int productId;
	
	private int itemPrice;
	
	private int quantity;
	
	private int totalPrice;
	
	private String date;
	
	private String time;

	
	
	
	public Order(int id, int productId, int itemPrice, int quantity, int totalPrice, String date, String time) {
		super();
		this.id = id;
		this.productId = productId;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.date = date;
		this.time = time;
	}

	//setters and getters for Order fields
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
