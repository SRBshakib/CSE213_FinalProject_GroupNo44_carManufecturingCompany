/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class CarModelSceneController implements Initializable {

    @FXML
    private ComboBox<String> carModelSelectCarTypeComboBox;
    
    @FXML
    private ComboBox<String> carModelComboBox;
    
    @FXML
    private ImageView carModelImageview;
    
    @FXML
    private Label carModelFeaturesLabe;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize car type ComboBox
        carModelSelectCarTypeComboBox.getItems().addAll("Toyota Camry", "Toyota SUV");
        carModelSelectCarTypeComboBox.setPromptText("Car Type");
        
        // Set prompt text for car model ComboBox
        carModelComboBox.setPromptText("Car Model");
    }    

    @FXML
    private void carTypeSelectOnAction(ActionEvent event) {
        String selectedCarType = carModelSelectCarTypeComboBox.getValue();
        if (selectedCarType != null) {
            // Implement logic based on the selected car type
            System.out.println("Selected car type: " + selectedCarType);
            
            // Clear existing items in car model ComboBox
            carModelComboBox.getItems().clear();
            
            // Populate car model ComboBox based on the selected car type
            if (selectedCarType.equals("Toyota Camry")) {
                carModelComboBox.getItems().addAll("Camry XLE", "Camry SE", "Camry LE", "Camry XSE");
            } else if (selectedCarType.equals("Toyota SUV")) {
                carModelComboBox.getItems().addAll("RAV4", "4Runner", "Sequoia", "Highlander");
            }
        }
    }

    @FXML
    private void carModelSelectOnAction(ActionEvent event) {
        String selectedModel = carModelComboBox.getValue();
        if (selectedModel != null) {
            // Implement logic based on the selected car model
            System.out.println("Selected car model: " + selectedModel);
        }
    }
}

