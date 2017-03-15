package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
import list.ProductList;
import product.Product;

public class ProductController implements Initializable{

	
	@FXML
	private TableView<ProductList> productTable;
	
	@FXML
	private TableColumn<ProductList, Integer> id;
	
	@FXML
	private TableColumn<ProductList, String> name;

	@FXML
	private TableColumn<ProductList, Integer> quantity;
	
	@FXML
	private TableColumn<ProductList, String> expireDate;
	
	@FXML
	private TableColumn<ProductList, Integer> payPrice;
	
	@FXML
	private TableColumn<ProductList, Integer> sellPrice;
	
	@FXML
	private TextField productIdSearchText;
	
	@FXML
	private TextField productDeleteText;
	
	public ObservableList<ProductList> list;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		id.setCellValueFactory(new PropertyValueFactory<ProductList , Integer>("id"));
		name.setCellValueFactory(new PropertyValueFactory<ProductList , String>("name"));
		quantity.setCellValueFactory(new PropertyValueFactory<ProductList , Integer>("quantity"));
		expireDate.setCellValueFactory(new PropertyValueFactory<ProductList , String >("expireDate"));
		payPrice.setCellValueFactory(new PropertyValueFactory<ProductList , Integer>("payPrice"));
		sellPrice.setCellValueFactory(new PropertyValueFactory< ProductList , Integer>("sellPrice"));

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
        	List <Product> allList = new Product().getAllProducts();
        	
			list = FXCollections.observableArrayList( new ProductList(allList.get(0)));
					
			int i=1;
			while (i < allList.size()){
				ProductList inlist = new ProductList(allList.get(i));
				list.add(inlist);
				++i;
			
			}
			System.out.println(list.get(0).getName());
			productTable.setItems(list);
		
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		
		
	}
	
	/**
	 * search for a product and display data to table
	 * @param event
	 */
	@FXML
	public void search (ActionEvent event){
		
		try {
			Integer.parseInt(productIdSearchText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Id");
			productIdSearchText.setText("");
			return;
		}
		
		try {
			Product product = new Product().getProduct(Integer.parseInt(productIdSearchText.getText()));
			ProductList p =new ProductList(product);
			System.out.println("seel = " + p.getSellPrice());

			list = FXCollections.observableArrayList(new ProductList(product));

			
			productTable.setItems(list);
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "product Not Found");
			
			
		}
	}


	@FXML
	public void addNewProduct(ActionEvent event) throws IOException{
		
		//create new stage for adding new course 
		Stage stage = new Stage();
		
		//load fxml file 
		Parent root=FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Add New Product");
		stage.setScene(scene);
		stage.show();
		
		
		
		System.out.println("create new ");
	}

	
	
	@FXML
	public void deleteProduct(ActionEvent event){
		
		try {
			
			Integer.parseInt(productDeleteText.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insert Correct ID ");
			productDeleteText.setText("");
			return;
		}
		
		try {
			int yes=JOptionPane.showConfirmDialog(null, "Are You sure to Delete Product "+productDeleteText.getText());
			if (yes>0)
				return;
			//if not found in data base
			if (!new Product().delete(Integer.parseInt(productDeleteText.getText())))
				throw new Exception();
			
			JOptionPane.showMessageDialog(null, "product Deleted Successfuly");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "product Not Found To Delete ( already deleted ) ");
		}
		
		//refresh table 
		refresh(null);
		productDeleteText.setText("");
		
	}
	

	
	@FXML
	public void updateProduct(ActionEvent event) throws IOException{
		
		//create new stage for adding new course 
		Stage stage = new Stage();
		
		//load fxml file 
		Parent root=FXMLLoader.load(getClass().getResource("/view/UpdateProduct.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Update Product");
		stage.setScene(scene);
		stage.show();
		
		
		
		System.out.println("Update  ");
	}
	
}
