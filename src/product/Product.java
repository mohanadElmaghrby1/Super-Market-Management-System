package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dataBase.CreateDataBase;
import dataBase.DBConnection;

public class Product {

	private int id;
	private String name;
	private int quantity;
	private String expireDate;
	private int payPrice;
	private int sellPrice;
	
	
	public Product(int id, String name, int quantity, String expireDate, int payPrice, int sellPrice) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.expireDate = expireDate;
		this.payPrice = payPrice;
		this.sellPrice = sellPrice;
	}
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public int getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}
	public int getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	/**
	 * search for product in data base
	 * @param id : product id 
	 * @return product if found and null if not
	 */
	public Product getProduct(int id){
		
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
			pst=con.prepareStatement("SELECT * FROM product WHERE id=?");
			pst.setInt(1, id);
			
			//assign to result set
			rsltSet=pst.executeQuery();
			
			
			while (rsltSet.next()){
				Product product = new Product();
				
				System.out.println(rsltSet.getInt("id"));
				product.setId(rsltSet.getInt("id"));
				
				System.out.println(rsltSet.getString("name"));
				product.setName(rsltSet.getString("name"));
				
				System.out.println(rsltSet.getString("expireDate"));
				product.setExpireDate(rsltSet.getString("expireDate"));
				
				System.out.println(rsltSet.getInt("payPrice"));
				product.setPayPrice(rsltSet.getInt("payPrice"));
				

				System.out.println(rsltSet.getInt("sellPrice"));
				product.setSellPrice(rsltSet.getInt("sellPrice"));
				
				System.out.println(rsltSet.getInt("quantity"));
				product.setQuantity(rsltSet.getInt("quantity"));
				
				

				return product;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @return all products 
	 */
	public List<Product> getAllProducts(){
		
        List<Product> list = new ArrayList<>();
		
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
			pst=con.prepareStatement("SELECT * FROM product");
			
			//assign to result set
			rsltSet=pst.executeQuery();
			
			while (rsltSet.next()){
				//create new product to initialize returned date from rsltSet
				Product product = new Product();
				
				System.out.println(rsltSet.getInt("id"));
				product.setId(rsltSet.getInt("id"));
				
				System.out.println(rsltSet.getString("name"));
				product.setName(rsltSet.getString("name"));
				
				System.out.println(rsltSet.getString("expireDate"));
				product.setExpireDate(rsltSet.getString("expireDate"));
				
				System.out.println(rsltSet.getInt("payPrice"));
				product.setPayPrice(rsltSet.getInt("payPrice"));
				

				System.out.println("sell Price:: "+rsltSet.getInt("sellPrice"));
				product.setSellPrice(rsltSet.getInt("sellPrice"));
				
				System.out.println(rsltSet.getInt("quantity"));
				product.setQuantity(rsltSet.getInt("quantity"));
				
				
				list.add(product);
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
	 * @param id : product id
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
			
			//first we search for the product in data base if null we return false (not found)
			if (getProduct(id)==null)
				return false;
			pst=con.prepareStatement("delete from product where id =?");
			pst.setInt(1, id);
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	public boolean addProduct (Product product){
		DBConnection dbcon = new DBConnection();
		Connection con ;
		PreparedStatement pst;
			
		try {
			//create connection
			con=dbcon.mkConnection();
			pst =con.prepareStatement("use MarketManagementSystem");
			pst.executeUpdate();
				
			pst = con.prepareStatement("INSERT INTO product VALUES (?,?,?,?,?,?)");
			pst.setInt(1, product.getId());
			pst.setString(2, product.getName());
			pst.setString(3, product.getExpireDate());
			pst.setInt(4, product.getQuantity());
			pst.setInt(6 ,product.getPayPrice() );
			pst.setInt(5, product.getSellPrice());
			
			pst.executeUpdate();
			System.out.println("new product added to data base");
			con.close();
			JOptionPane.showMessageDialog(null, "product Successfuly saved ");
		} catch (Exception e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "product id already exsist");
			return false;
			
			}
		return true;
	}

}
