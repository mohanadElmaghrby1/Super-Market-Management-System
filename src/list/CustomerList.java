package list;

import customer.Customer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * create a customer List to add customer to table view
 * @author mohanad-elmaghrby
 *
 */
public class CustomerList {

	private SimpleIntegerProperty id;
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty phone;
	private SimpleIntegerProperty payments ;
	
	
	public CustomerList() {
		// TODO Auto-generated constructor stub
	}
	/**
	 *  initialize customer fields
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param payments
	 */
	public CustomerList(Customer customer) {
		super();
		this.id = new SimpleIntegerProperty(customer.getId());
		this.firstName = new SimpleStringProperty(customer.getFirstName());
		this.lastName = new SimpleStringProperty(customer.getLastName());
		this.phone = new SimpleStringProperty(customer.getPhone());
		this.payments = new SimpleIntegerProperty(customer.getPayments());
	}


	public int getId() {
		return id.get();
	}


	public void setId(SimpleIntegerProperty id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName.get();
	}


	public void setFirstName(SimpleStringProperty firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName.get();
	}


	public void setLastName(SimpleStringProperty lastName) {
		this.lastName = lastName;
	}


	public String getPhone() {
		return phone.get();
	}


	public void setPhone(SimpleStringProperty phone) {
		this.phone = phone;
	}


	public int getPayments() {
		return payments.get();
	}


	public void setPayments(SimpleIntegerProperty payments) {
		this.payments = payments;
	}
	
	
	
	
	
}
