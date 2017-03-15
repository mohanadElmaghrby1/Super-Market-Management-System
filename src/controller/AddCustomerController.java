package controller;

import javax.swing.JOptionPane;

import customer.Customer;
import customer.CustomerDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import product.Product;

public class AddCustomerController {

	@FXML
	private TextField customerIdText;
	
	@FXML
	private TextField CustomerFirstNameText;
	
	@FXML
	private TextField customerLastNameText;
	
	@FXML
	private TextField customerPhoneText;
	
	@FXML
	private TextField customerPaymentsText;
	
	
	
	
	
	/**
	 * insert product to data base
	 * @param event
	 */
	@FXML
	public void insertCustomerToDataBase(ActionEvent event){
		
	
		 
		if (!checkValidation()){
			return;
		}
		    
			int id = Integer.parseInt(customerIdText.getText());
			
			String firstName=CustomerFirstNameText.getText();
						
			String lastName = customerLastNameText.getText();
			
			String phone = (customerPhoneText.getText());
			
			int payments = Integer.parseInt(customerPaymentsText.getText());
			
			
			//create customer object
			Customer customer = new Customer(id, firstName, lastName, phone, payments);
			
			//save customer to data base
			//if saved success blank all text to insert new customer 
			 if (new CustomerDataBase().addCustomer(customer)){
				 customerIdText.setText("");
				 CustomerFirstNameText.setText("");
				 customerLastNameText.setText("");
				 customerPhoneText.setText("");
				 customerPaymentsText.setText("");
				 
			 }

		
	}
	
	
	public boolean checkValidation(){
		
		//validate id
		try {
			Integer.parseInt(customerIdText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Id");
		}
		
		//validate name
		try {
			
			//validate  name 
			// if  name contain any thing expect characters it will throw
			//StringIndexOutOfBoundsException
			if (!CustomerFirstNameText.getText().matches("[a-zA-Z]+") || ! customerLastNameText.getText().matches("[a-zA-Z]+"))
				throw new StringIndexOutOfBoundsException();
			
		} catch (StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Insert a Valid Name");
			return false;
		}
		
		//validate phone
		try {
			if (!customerPhoneText.getText().matches("01[0-2][0-9]{8}+"))
				throw new Exception();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct phone Number");
			return false;
		}
		
		//validate payments
		try {
			Integer.parseInt(customerPaymentsText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Correct Payments number");
			return false;
		}
		
		
		//if all is well return true
		return true;
	}
	
}

	

