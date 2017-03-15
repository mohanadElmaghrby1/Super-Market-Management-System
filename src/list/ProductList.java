package list;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import product.Product;

public class ProductList {

	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleIntegerProperty quantity;
	private SimpleStringProperty expireDate;
	private SimpleIntegerProperty payPrice;
	private SimpleIntegerProperty sellPrice;
	
	public ProductList( Product product) {
		super();
		this.id =new SimpleIntegerProperty(product.getId());
		this.name =new SimpleStringProperty(product.getName());
		this.quantity = new SimpleIntegerProperty(product.getQuantity());
		this.expireDate = new SimpleStringProperty(product.getExpireDate());
		this.payPrice = new SimpleIntegerProperty(product.getPayPrice());
		this.sellPrice = new SimpleIntegerProperty(product.getSellPrice());
	}
	
	
	public int getId() {
		return id.get();
	}
	public void setId(SimpleIntegerProperty id) {
		this.id = id;
	}
	public String getName() {
		return name.get();
	}
	public void setName(SimpleStringProperty name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity.get();
	}
	public void setQuantity(SimpleIntegerProperty quantity) {
		this.quantity = quantity;
	}
	
	public void setExpireDate(SimpleStringProperty expireDate) {
		this.expireDate = expireDate;
	}
	public String getExpireDate() {
		return expireDate.get();
	}
	
	public int getPayPrice() {
		return payPrice.get();
	}
	public void setPayPrice(SimpleIntegerProperty payPrice) {
		this.payPrice = payPrice;
	}
	public int getSellPrice() {
		return sellPrice.get();
	}
	public void setSellPrice(SimpleIntegerProperty sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	
	
}
