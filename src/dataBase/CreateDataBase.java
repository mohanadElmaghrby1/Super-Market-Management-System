/**
 * create data base and tables  if not exist  
 */
package dataBase;

import java.sql.*;

/**
 * create data bases for courses center
 * 
 * @author
 *
 */
public class CreateDataBase {

	private PreparedStatement pst;
	private Connection con;
	
	
	
	public void createDataBase (){
	
		// 
		//connect to data base
		DBConnection dbcon=new DBConnection();
		
		
		
		try {
			con=dbcon.mkConnection();
			//create connection and prepareStatment CREATE DATABASE IF NOT EXISTS courses_center
			pst =con.prepareStatement("CREATE DATABASE IF NOT EXISTS MarketManagementSystem");
			pst.executeUpdate();
			
			//use data base
			pst= con.prepareStatement("USE MarketManagementSystem");
			pst.executeUpdate();
			
			
			//CREAT TABLE admin
			pst=con.prepareStatement("CREATE TABLE if not exists admin ("

					+" userName varchar(20) unique ,"
    				+" password varchar(20)  not null "
					+")");
			pst.executeUpdate();
			
			//create table cashier
			pst =con.prepareStatement(" CREATE TABLE if not exists cashier ("

					
					+" id INT  PRIMARY KEY ,"
					+" identityNumber char(14) unique ,"
					+" firstName varchar(50) NOT NULL ,"
					+" lastName varchar(50) NOT NULL ,"
					+" phone char(11) unique ,"
					+" mail varchar(20) unique ,"
					+" address varchar(100) not null ,"
					+" userName varchar(20) unique ,"
    				+" password varchar(20)  not null "
					+" )");
			pst.executeUpdate();

			//create table customer
			pst =con.prepareStatement(" CREATE TABLE if not exists customer ("

					
					+" id INT  PRIMARY KEY ,"
					+" firstName varchar(50) NOT NULL ,"
					+" lastName varchar(50) NOT NULL ,"
					+" phone char(11) unique ,"
					+" payments int not null "
					+" )");
			pst.executeUpdate();
			
			//CREAT TABLE supplier
			pst=con.prepareStatement("CREATE TABLE if not exists supplier ("

    				+" id int PRIMARY KEY ,"
    				+" name varchar(50)  not null ,"
    				+" mail varchar(50)  not null ,"
    				+" phone varchar(11)  not null ,"
    				+" sallary int  not null ,"
    				+" joinDate date  not null ,"
    				+" productId int  not null ,"
    				+" address varchar(100)  not null "
    				
    				
					+")");
			pst.executeUpdate();
			
			//CREAT TABLE product
			pst=con.prepareStatement("CREATE TABLE if not exists product ("

    				+" id int PRIMARY KEY ,"
    				+" name varchar(50)  not null ,"
    				+" expireDate varchar(12)  not null ,"
    				+" quantity int  not null ,"
    				+" payPrice int  not null ,"
    				+" sellPrice int  not null "
    				
    				
					+")");
			pst.executeUpdate();
			
			
			//create table orderDetails
			pst = con.prepareStatement("CREATE TABLE  if not exists orderDetails ("
/**
 * 1 > 1 > عسل
 * 1 > 2 > ملح
 * 1 > 3
 */
   				+" id int primary key AUTO_INCREMENT ,"
   				+" productId int not null ,"
   				+" itemPrice int not null ,"
   				+" quantity int not null ,"
   				+" totalPrice int not null ,"
   				+" date varchar(10) not null , "
   				+" time varchar(10) not null "
					+")");
			pst.executeUpdate();
			
			//create table bill
			pst = con.prepareStatement("CREATE TABLE  if not exists bill ("

   				+" id int  primary key ,"
   				+" orderId int not null ,"
   				+" totalPrice int not null ,"
   				+" creatorId int  not null ,"
   				+" customerId int  not null "
					+")");
			pst.executeUpdate();
			
			System.out.println("data base created :::");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
