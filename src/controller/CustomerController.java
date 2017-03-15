package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import customer.Customer;
import customer.CustomerDataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import list.CustomerList;
import list.ProductList;
import product.Product;

public class CustomerController implements Initializable {

	
	@FXML
	private TableView<CustomerList> customertTable;
	
	@FXML
	private TableColumn<CustomerList, Integer> id;
	
	@FXML
	private TableColumn<CustomerList, String> firstName;

	@FXML
	private TableColumn<CustomerList, String> lastName;
	
	@FXML
	private TableColumn<CustomerList, String> phone;
	
	@FXML
	private TableColumn<CustomerList, Integer> payments;
	
	@FXML
	public ObservableList<CustomerList> list;
	
	@FXML
	private TextField customerdSearchText;
	
	@FXML
	private TextField customerDeleteText;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//initialize table columns
		id.setCellValueFactory(new PropertyValueFactory<CustomerList , Integer>("id"));
		firstName.setCellValueFactory(new PropertyValueFactory<CustomerList , String>("firstName"));
		lastName.setCellValueFactory(new PropertyValueFactory<CustomerList , String>("lastName"));
		phone.setCellValueFactory(new PropertyValueFactory<CustomerList , String >("phone"));
		payments.setCellValueFactory(new PropertyValueFactory<CustomerList , Integer>("payments"));
		
		//refresh (add all customer to table)
		refresh(null);
	}
	
	
	/**
	 * 
	 * @param event
	 */
	@FXML
	public void refresh(ActionEvent event){
		
		System.out.println("sssssssssssssssss <<< Refresh  >>>sssssssssss");
        try {
        	//get all cutomers from data base 
        	List <Customer> allList = new CustomerDataBase().getAllCustomers();
        	
			list = FXCollections.observableArrayList( new CustomerList(allList.get(0)));
					
			int i=1;
			while (i < allList.size()){
				CustomerList inlist = new CustomerList(allList.get(i));
				list.add(inlist);
				++i;
			
			}
			System.out.println(list.get(0).getFirstName());
			customertTable.setItems(list);
		
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void addNewCustomer(ActionEvent event) throws IOException{
		
		//create new stage for adding new course 
		Stage stage = new Stage();
		
		//load fxml file 
		Parent root=FXMLLoader.load(getClass().getResource("/view/AddCustomer.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Add New Customer");
		stage.setScene(scene);
		stage.show();
		
		
		
		System.out.println("create new ");
	}

	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void updateCustomer(ActionEvent event) throws IOException{
		
		//create new stage for adding new course 
		Stage stage = new Stage();
		
		//load fxml file 
		Parent root=FXMLLoader.load(getClass().getResource("/view/UpdateCustomer.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Update Customer");
		stage.setScene(scene);
		stage.show();
		
		
		
		System.out.println("create new ");
	}
	
	
	/**
	 * search for a customer and display data to table
	 * @param event
	 */
	@FXML
	public void search (ActionEvent event){
		
		try {
			Integer.parseInt(customerdSearchText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Id");
			customerdSearchText.setText("");
			return;
		}
		
		try {
			Customer customer = new CustomerDataBase().getCustomer(Integer.parseInt(customerdSearchText.getText()));
			list = FXCollections.observableArrayList(new CustomerList(customer));

			
			customertTable.setItems(list);
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Customer Not Found");
			
			
		}
	}
	
	
	@FXML
	public void deleteCustomer(ActionEvent event){
		
		try {
			
			Integer.parseInt(customerDeleteText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insert Correct ID ");
			customerDeleteText.setText("");
			return;
		}
		
		try {
			int yes=JOptionPane.showConfirmDialog(null, "Are You sure to Delete Customer "+customerDeleteText.getText());
			if (yes>0)
				return;
			//if not found in data base
			if (!new CustomerDataBase().delete(Integer.parseInt(customerDeleteText.getText())))
				throw new Exception();
			
			JOptionPane.showMessageDialog(null, "Customer Deleted Successfuly");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Customer Not Found To Delete ( already deleted ) ");
		}
		
		//refresh table 
		refresh(null);
		customerDeleteText.setText("");
		
	}
	



}
