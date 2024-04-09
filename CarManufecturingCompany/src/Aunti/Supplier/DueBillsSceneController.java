/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti.Supplier;

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
public class DueBillsSceneController implements Initializable {

    @FXML
    private TableView<?> dueListTableView;
    @FXML
    private TableColumn<?, ?> lastDuesTableColumn;
    @FXML
    private TableColumn<?, ?> totalPaymentTableColumn;
    @FXML
    private TableColumn<?, ?> dueDateTableColumn;
    @FXML
    private TableColumn<?, ?> orderIdTableColumn;

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
    
}
