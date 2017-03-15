package controller;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import product.Product;

public class AddProductController {

	
	@FXML
	private TextField productIdText;
	
	@FXML
	private TextField productNameText;
	
	@FXML
	private TextField productQuantityText;
	
	@FXML
	private TextField productSellPriceText;
	
	@FXML
	private TextField productPayPriceText;
	
	@FXML
	private DatePicker productExpireDate;
	
	
	
	/**
	 * insert product to data base
	 * @param event
	 */
	public void insertProductToDataBase(ActionEvent event){
		
	
		 
		if (!checkValidation()){
			return;
		}
		    
			int productId = Integer.parseInt(productIdText.getText());
			
			String productName=productNameText.getText();
						
			int productQuantity = Integer.parseInt(productQuantityText.getText());
			
			int productSellPrice = Integer.parseInt(productSellPriceText.getText());
			
			int productPayPrice = Integer.parseInt(productPayPriceText.getText());
			
			//picking up date and convert to String
			String ExpireDate=productExpireDate.getEditor().getText();
			
			//create product object
			Product product = new Product(productId, productName, productQuantity,
					ExpireDate, productPayPrice, productSellPrice);
			
			product.addProduct(product);

		
	}
	
	
	public boolean checkValidation(){
		
		//validate id
		try {
			Integer.parseInt(productIdText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Id");
		}
		
		//validate name
		try {
			
			//validate product name 
			// if product name contain any thing expect characters it will throw
			//StringIndexOutOfBoundsException
			if (!productNameText.getText().matches("[a-zA-Z]+"))
				throw new StringIndexOutOfBoundsException();
			
		} catch (StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Insert a Valid  Product Name");
			return false;
		}
		
		//validate quantity
		try {
			Integer.parseInt(productQuantityText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Quantity Number");
			return false;
		}
		
		//validate pay price
		try {
			Integer.parseInt(productPayPriceText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Correct Pay Price");
			return false;
		}
		
		//validate sell price
		try {
			Integer.parseInt(productSellPriceText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, " Correct Sell Price");
			return false;
		}
		
		
		//if all is well return true
		return true;
	}
	
}
