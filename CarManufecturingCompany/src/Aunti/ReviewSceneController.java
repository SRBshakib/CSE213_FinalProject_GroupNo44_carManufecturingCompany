/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ReviewSceneController implements Initializable {

    @FXML
    private TableView<?> reviewTypeTableView;
    @FXML
    private TableColumn<?, ?> deliveryCodeTableColumn;
    @FXML
    private TableColumn<?, ?> productTypeTableColumn;
    @FXML
    private TableColumn<?, ?> commentsTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homeButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void orderListButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void ordersButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void inventoryListButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void dueBillsButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void trackOrdersButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void paymentsButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void reviewButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void upcomingEventsButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void yesRadioButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void noRadioButtonOnMouseClicked(ActionEvent event) {
    }
    
}
