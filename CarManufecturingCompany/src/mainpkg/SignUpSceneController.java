/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class SignUpSceneController implements Initializable {

    @FXML
    private TextField userIdTextfield;
    @FXML
    private PasswordField userPasswordPwfield;
    @FXML

    private ComboBox<String> userTypeComboBox;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll("Assembly Line Worker","Finance Manager","Managing Director","Suppler","Supply Chain Manager","Customer","Production Manager");
    }    

    @FXML
    private void forgotPasswordOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void signInOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void registerAsCustomerOnMouseClicked(ActionEvent event) {
    }
    
}
