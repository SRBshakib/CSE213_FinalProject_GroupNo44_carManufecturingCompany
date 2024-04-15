/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CountryDealerSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextField regionTextField;
    @FXML
    private TextField mobileNumberTextField;
    @FXML
    private TableView<CountryDealer> countryDealerTableView;
    @FXML
    private TableColumn<CountryDealer,String> nameTableColumn;
    @FXML
    private TableColumn<CountryDealer, String> locationTableColumn;
    @FXML
    private TableColumn<CountryDealer, String> regionTableColumn;
    @FXML
    private TableColumn<CountryDealer, Integer> mobileNumberTableColumn;
    @FXML
    private TableColumn<CountryDealer, String> countryNameTableColumn;
    @FXML
    private TextField emailTextField;
    @FXML
    private ComboBox<String> countryNameComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        countryNameComboBox.getItems().addAll("Bangladesh", "China","Grece","India","Malaysia");
        // TODO
    }    

    @FXML
    private void homeButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource(".fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Assembly Line Worker Dashboard");
        window.show();
    }

    @FXML
    private void myCarButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void countryDealerButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void updateButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void orderButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void orderHistoryButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void viewCarsButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void preOrderButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void upcomingEventsButtonOnMouseClicked(ActionEvent event) {
    }


    @FXML
    private void submitButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void showAllButtonOnMouseClicked(ActionEvent event) {
    }
    
}
