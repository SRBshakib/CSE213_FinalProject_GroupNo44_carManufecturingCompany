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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ProductionManagerCarDesignSceneController implements Initializable {

    @FXML
    private TextField carTypeTextField;
    @FXML
    private TextField carModelTextField;
    @FXML
    private TextArea featuresTextArea;
    @FXML
    private Button submitButton;
    @FXML
    private Button loadButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitCarDesign(ActionEvent event) {
    }

    @FXML
    private void loadCarDesign(ActionEvent event) {
    }
    
}
