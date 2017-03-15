package controller;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import product.Product;

public class UpdateProductController {
	
	
	@FXML
	private TextField idText;
	
	@FXML
	private TextField nameText;
	
	@FXML
	private TextField quantityText;
	
	
	@FXML
	private TextField sellPriceText;
	
	@FXML
	private TextField payPriceText;
	
	@FXML
	private TextField expireDateText;
	
	@FXML
	private DatePicker expireDate;
	
	
	
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
		
		//get product from data base
		Product product = new Product().getProduct(Integer.parseInt(idText.getText()));
		
		//if id to update not found in data base
		if (product==null){
			JOptionPane.showMessageDialog(null, " ID not Found Please insert valid id ");
			idText.setText("");
			return;
		}
		//prevent user to change id 
		idText.setEditable(false);
		
		nameText.setText(product.getName());
		quantityText.setText(Integer.toString(product.getQuantity()));
		sellPriceText.setText(Integer.toString(product.getSellPrice()));
		payPriceText.setText(Integer.toString(product.getPayPrice()));
		expireDateText.setText(product.getExpireDate());
		
		
		//delete product from data base and then save
		product.delete(Integer.parseInt(idText.getText()));
		
	}
	
	
	@FXML
	public void save (ActionEvent event){
		
		 if (!checkValidation())
			 return;
		 int id=Integer.parseInt(idText.getText());
		 String name = nameText.getText();
		 
		 String newExpireDate;
		 
		 if (  !expireDate.getEditor().getText().equals("")){
			 newExpireDate=expireDate.getEditor().getText();
		 }
		 else{
			 newExpireDate= expireDateText.getText();
		 }
		 
		 
		 
		 int quantity = Integer.parseInt(quantityText.getText());
		 int payPrice= Integer.parseInt(payPriceText.getText());
		 int sellPrice = Integer.parseInt(sellPriceText.getText());
		 
		 new Product().addProduct(new Product(id, name, quantity, newExpireDate, payPrice, sellPrice));
		 JOptionPane.showMessageDialog(null, " Product Updated ");
	}
	

	private boolean checkValidation(){
		
		//validate id
		try {
			Integer.parseInt(idText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Id");
		}
		
		//validate name
		try {
			
			//validate product name 
			// if product name contain any thing expect characters it will throw
			//StringIndexOutOfBoundsException
			if (!nameText.getText().matches("[a-zA-Z]+"))
				throw new StringIndexOutOfBoundsException();
			
		} catch (StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Insert a Valid  Product Name");
			return false;
		}
		
		//validate quantity
		try {
			Integer.parseInt(quantityText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Quantity Number");
			return false;
		}
		
		//validate pay price
		try {
			Integer.parseInt(payPriceText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Correct Pay Price");
			return false;
		}
		
		//validate sell price
		try {
			Integer.parseInt(sellPriceText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, " Correct Sell Price");
			return false;
		}
		
		
		//if all is well return true
		return true;
	}
	

}
