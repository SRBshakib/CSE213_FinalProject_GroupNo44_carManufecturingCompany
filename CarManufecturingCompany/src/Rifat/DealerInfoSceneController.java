/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class DealerInfoSceneController implements Initializable {

    @FXML
    private TextField dealerNameTextField;
    @FXML
    private TextField contactNumberTextField;
    @FXML
    private TextField dealerLocationTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set prompt text for the text fields
    dealerNameTextField.setPromptText("Enter dealer name");
    contactNumberTextField.setPromptText("Enter contact number");
    dealerLocationTextField.setPromptText("Enter dealer location");
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/FinanceManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
private void saveButtonOnMouseClick(ActionEvent event) {
    // Retrieve data entered by the user in the text fields
    String dealerName = dealerNameTextField.getText();
    String contactNumber = contactNumberTextField.getText();
    String dealerLocation = dealerLocationTextField.getText();

    // Perform validation if necessary
    if (dealerName.isEmpty() || contactNumber.isEmpty() || dealerLocation.isEmpty()) {
        // Display an error message or handle validation failure
        System.out.println("Please fill in all fields.");
        return; // Exit method if validation fails
    }

    // Example: Save the dealer information to a database
    boolean savedSuccessfully = saveDealerInfoToDatabase(dealerName, contactNumber, dealerLocation);
    if (savedSuccessfully) {
        System.out.println("Dealer information saved successfully.");
    } else {
        System.out.println("Failed to save dealer information. Please try again.");
    }
}

// Example method to save dealer information to a database
private boolean saveDealerInfoToDatabase(String dealerName, String contactNumber, String dealerLocation) {
    // Perform database operation to save the dealer information
    // Return true if the operation is successful, false otherwise
    // Replace this example implementation with your actual database logic
    return true; // For demonstration purposes, always return true
   }
}
