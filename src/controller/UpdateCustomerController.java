package controller;

import javax.swing.JOptionPane;

import customer.Customer;
import customer.CustomerDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import product.Product;

public class UpdateCustomerController {

	
	@FXML
	private TextField idText;
	
	@FXML
	private TextField firstNameText;
	
	@FXML
	private TextField lastNameText;
	
	
	@FXML
	private TextField phoneText;
	
	@FXML
	private TextField paymentsText;
	
	
	@FXML
	public void search (ActionEvent event){
		
		//validation to id text field
		try {
			Integer.parseInt(idText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct ID ");
			idText.setText("");
			return;
		}
		
		System.out.println("id = "+idText.getText());
		//get customer from data base
		Customer customer = new CustomerDataBase().getCustomer(Integer.parseInt(idText.getText()));
		
		//if id to update not found in data base
		if (customer==null){
			JOptionPane.showMessageDialog(null, " ID not Found Please insert valid id ");
			idText.setText("");
			return;
		}
		//prevent user to change id 
		idText.setEditable(false);
		
		firstNameText.setText(customer.getFirstName());
		lastNameText.setText(customer.getLastName());
		phoneText.setText(customer.getPhone());
		paymentsText.setText(Integer.toString(customer.getPayments()));
		
		
		//delete customer from data base and then save
		new CustomerDataBase().delete(Integer.parseInt(idText.getText()));
		
	}
	
	
	@FXML
	public void save (ActionEvent event){
		
		 if (!checkValidation())
			 return;
		 int id=Integer.parseInt(idText.getText());
		 String firstName = firstNameText.getText();
		 String lastName =lastNameText.getText();
		 String phone =phoneText.getText();
		 int payments=Integer.parseInt(paymentsText.getText());

		 //save customer to date base
		 new CustomerDataBase().addCustomer(new Customer(id, firstName, lastName, phone, payments));
		 
		 //blank data 
		 idText.setText("");
		 firstNameText.setText("");
		 lastNameText.setText("");
		 phoneText.setText("");
		 paymentsText.setText("");
		 
		 
	}
	
	
	

	public boolean checkValidation(){
		
		//validate id
		try {
			Integer.parseInt(idText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Id");
		}
		
		//validate name
		try {
			
			//validate  name 
			// if  name contain any thing expect characters it will throw
			//StringIndexOutOfBoundsException
			if (!firstNameText.getText().matches("[a-zA-Z]+") || ! lastNameText.getText().matches("[a-zA-Z]+"))
				throw new StringIndexOutOfBoundsException();
			
		} catch (StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Insert a Valid Name");
			return false;
		}
		
		//validate phone
		try {
			if (!phoneText.getText().matches("01[0-2][0-9]{8}+"))
				throw new Exception();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct phone Number");
			return false;
		}
		
		//validate payments
		try {
			Integer.parseInt(paymentsText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Correct Payments number");
			return false;
		}
		
		
		//if all is well return true
		return true;
	}
}

