package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import dataBase.CreateDataBase;
import dataBase.DBConnection;
import product.Product;


public class CustomerDataBase {

	

	/**
	 * add customer to data base
	 * @param customer : customer object to add to data base
	 * @return : true if inserted , false if not
	 */
	public boolean addCustomer (Customer customer){
		DBConnection dbcon = new DBConnection();
		Connection con ;
		PreparedStatement pst;
			
		try {
			//create connection
			con=dbcon.mkConnection();
			pst =con.prepareStatement("use MarketManagementSystem");
			pst.executeUpdate();
				
			pst = con.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?)");
			pst.setInt(1, customer.getId());
			pst.setString(2, customer.getFirstName());
			pst.setString(3, customer.getLastName());
			pst.setString(4, customer.getPhone());
			pst.setInt(5, customer.getPayments());
			
			pst.executeUpdate();
			System.out.println("new customer added to data base");
			con.close();
			JOptionPane.showMessageDialog(null, "customer Successfuly saved ");
		} catch (Exception e) {
			if (e.getMessage().contains("PRIMARY"))
				JOptionPane.showMessageDialog(null, "customer id already exsist  ");
			else
			JOptionPane.showMessageDialog(null, " insert correct phone (phone id already exsist in another customer)");
			return false;
			
			}

		return true;
	}
	
	/**
	 * search for customer in data base
	 * 
	 * @param id ; customer id for search
	 * @return customer if found and null if not 
	 */
	public Customer getCustomer(int id){
		
		DBConnection dbcon = new DBConnection();
		ResultSet rsltSet ;
		Connection con ;
		PreparedStatement pst;
			
		try {
			//create connection
			con=dbcon.mkConnection();
			pst =con.prepareStatement("use MarketManagementSystem");
			pst.executeUpdate();
			
			//select product from data base
			pst=con.prepareStatement("SELECT * FROM customer WHERE id=?");
			pst.setInt(1, id);
			
			//assign to result set
			rsltSet=pst.executeQuery();
			
			
			while (rsltSet.next()){
				Customer customer = new Customer();
				
				System.out.println("********************Customer Data*******************");
				System.out.println("id= "+rsltSet.getInt("id"));
				customer.setId(rsltSet.getInt("id"));
				
				System.out.println("firstName= "+rsltSet.getString("firstName"));
				customer.setFirstName((rsltSet.getString("firstName")));
				
				System.out.println("lastNAme ="+rsltSet.getString("lastName"));
				customer.setLastName(rsltSet.getString("lastName"));
				
				System.out.println("phone ="+rsltSet.getString("phone"));
				customer.setPhone(rsltSet.getString("phone"));
				

				System.out.println("payments ="+rsltSet.getInt("payments"));
				customer.setPayments(rsltSet.getInt("payments"));

				return customer;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * select all customers from data base 
	 * @return all customers 
	 */
	public List<Customer> getAllCustomers(){
		
        List<Customer> list = new ArrayList<>();
		
		DBConnection dbcon = new DBConnection();
		ResultSet rsltSet ;
		Connection con ;
		PreparedStatement pst;
			
		try {
			
			//create connection
			con=dbcon.mkConnection();
			pst =con.prepareStatement("use MarketManagementSystem");
			pst.executeUpdate();
			
			//select product from data base
			pst=con.prepareStatement("SELECT * FROM customer");
			
			//assign to result set
			rsltSet=pst.executeQuery();
			
			while (rsltSet.next()){
				
				
				//create new customer to initialize returned date from rsltSet
				Customer customer = new Customer();

				System.out.println("********************Customer Data*******************");
				System.out.println("id= "+rsltSet.getInt("id"));
				customer.setId(rsltSet.getInt("id"));
				
				System.out.println("firstName= "+rsltSet.getString("firstName"));
				customer.setFirstName((rsltSet.getString("firstName")));
				
				System.out.println("lastNAme ="+rsltSet.getString("lastName"));
				customer.setLastName(rsltSet.getString("lastName"));
				
				System.out.println("phone ="+rsltSet.getString("phone"));
				customer.setPhone(rsltSet.getString("phone"));
				

				System.out.println("payments ="+rsltSet.getInt("payments"));
				customer.setPayments(rsltSet.getInt("payments"));
				list.add(customer);
				System.out.println("list size = " + list.size());
				System.out.println("**********************************************************");
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
				
	}
	
	
	/**
	 * delete product from data base
	 * @param id : customer id
	 * @return true if deleted , and false if not
	 */
	public boolean delete (int id){
		
		DBConnection dbcon = new DBConnection();
		CreateDataBase cdb=new CreateDataBase();
		cdb.createDataBase();
		Connection con ;
		PreparedStatement pst;
		
		try {
			con=dbcon.mkConnection();
			pst =con.prepareStatement("use MarketManagementSystem");
			pst.executeUpdate();
			
			//first we search for the customer in data base if null we return false (not found)
			if (getCustomer(id)==null)
				return false;
			pst=con.prepareStatement("delete from customer where id =?");
			pst.setInt(1, id);
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
