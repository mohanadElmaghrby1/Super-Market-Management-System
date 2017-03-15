package customer;

public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private int payments ;
	
	
	public Customer() {
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
	public Customer(int id, String firstName, String lastName, String phone, int payments) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.payments = payments;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getPayments() {
		return payments;
	}


	public void setPayments(int payments) {
		this.payments = payments;
	}
	
	
	
	
	
}
