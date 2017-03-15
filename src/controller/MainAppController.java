package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MainAppController implements Initializable {
	
	//the pane which change after click any button from menu 
	@FXML
	private StackPane contentAnchorPane;
	
	@FXML
	private Button billBtn;

	@FXML
	private Button productBtn;
	
	@FXML
	private Button customerBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/**
	 * display Bill button content
	 * @param event
	 */
	@FXML
	public void billContent(ActionEvent event){
		
         try {
			
			//load courses FXML file to contentAnchorPane
			FXMLLoader fXMLLoader = new FXMLLoader();
			
	        fXMLLoader.load(getClass().getResource("/view/Billt.fxml").openStream());
	        AnchorPane homePane = fXMLLoader.getRoot();
	        
	        //clear the contentAnchorPane and set it to be courses.FXML Content 
	        contentAnchorPane.getChildren().clear();
	        contentAnchorPane.getChildren().add(homePane);
				
	        System.out.println("disply bill content");
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
			
		    }
	}
	
	
	/**
	 * display Bill button content
	 * @param event
	 */
	@FXML
	public void productContent(ActionEvent event){
		
         try {
			
			//load courses FXML file to contentAnchorPane
			FXMLLoader fXMLLoader = new FXMLLoader();
			
	        fXMLLoader.load(getClass().getResource("/view/Product.fxml").openStream());
	        AnchorPane homePane = fXMLLoader.getRoot();
	        
	        //clear the contentAnchorPane and set it to be courses.FXML Content 
	        contentAnchorPane.getChildren().clear();
	        contentAnchorPane.getChildren().add(homePane);
				
	        System.out.println("disply product content");
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
			
		    }
	}
	
	
	/**
	 * display the customer content when customer button pressed
	 * @param event
	 */
	@FXML
	private void customerContent(ActionEvent event){
		
		try{
		//load courses FXML file to contentAnchorPane
		FXMLLoader fXMLLoader = new FXMLLoader();
		
        fXMLLoader.load(getClass().getResource("/view/Customer.fxml").openStream());
        AnchorPane homePane = fXMLLoader.getRoot();
        
        //clear the contentAnchorPane and set it to be Customer.FXML Content 
        contentAnchorPane.getChildren().clear();
        contentAnchorPane.getChildren().add(homePane);
			
        System.out.println("disply customer content");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		
	    }
		
	}

}
