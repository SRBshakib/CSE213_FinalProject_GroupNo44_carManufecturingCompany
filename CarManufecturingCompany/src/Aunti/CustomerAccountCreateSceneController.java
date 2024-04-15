/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti;

import Dip.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class CustomerAccountCreateSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField IDTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextArea addressTA;
    private RadioButton maleRB;
    private RadioButton femaleRB;
    private RadioButton otherRB;
    @FXML
    private CheckBox checkBoxPolicy;

    @FXML
    private ComboBox<String> genderCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll("Customer");

        userTypeComboBox.setValue("Customer");
        genderCB.getItems().addAll("Male", "Female", "Others");

    }

    @FXML
    private void signUpOnMouseClick(ActionEvent event) throws IOException {
        if (!checkBoxPolicy.isSelected()) {
            if (userTypeComboBox.getValue().equals("Customer")) {
                customerAndShow();
                Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                a1.setTitle("LogIn Status");
                a1.setContentText("Click Ok to Continue");
                a1.setHeaderText("Your account has been created successfully");
                a1.showAndWait();
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/mainpkg/LoginScene.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
            }

        }

    }


private void customerAndShow() throws IOException {

        if (genderCB.getValue() == null
                ||phoneTextField.getText().isEmpty()
                ||addressTA.getText().isEmpty()
                ||nameTextField.getText().isEmpty()
                || IDTextField.getText().isEmpty()
                || passwordTextField.getText().isEmpty()
                || dobDatePicker.getValue() == null) {
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else { 

                Customer i = new Customer(genderCB.getValue(),
                        Integer.parseInt(phoneTextField.getText()),
                        addressTA.getText(),
                        nameTextField.getText(),
                        Integer.parseInt(IDTextField.getText()),
                        passwordTextField.getText(),
                        dobDatePicker.getValue(),
                        userTypeComboBox.getValue());
                FileOutputStream fos = null;
                ObjectOutputStream oos = null;
                File f = null;
                try {
                    f = new File("Customer.bin");
                    if (f.exists()) {
                        fos = new FileOutputStream(f, true);
                        oos = new AppendableObjectOutputStream(fos);
                    } else {
                        fos = new FileOutputStream(f);
                        oos = new ObjectOutputStream(fos);
                    }

                    oos.writeObject(i);

} catch (IOException ex) {
                    Logger.getLogger(CustomerAccountCreateSceneController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        if (oos != null) {
                            oos.close();

}
                    } catch (IOException ex) {
                        Logger.getLogger(CustomerAccountCreateSceneController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
