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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class DeliveryHistorySceneController implements Initializable {

    @FXML
    private AnchorPane pastOrdersTabPane;
    @FXML
    private TableView<?> pastOrderSummaryTableView;
    @FXML
    private TableColumn<?, ?> deliveryCodeTableColumn;
    @FXML
    private TableColumn<?, ?> deliveryDateTableColumn;
    @FXML
    private TableColumn<?, ?> orderAmountTableColumn;
    @FXML
    private TableColumn<?, ?> orderQuantityTableColumn;
    @FXML
    private AnchorPane newOrdersTabPane;
    @FXML
    private TableView<?> allNewOrdersTableView;
    @FXML
    private TableColumn<?, ?> orderIdTableColumn;
    @FXML
    private TableColumn<?, ?> perOrderQuantityTableColumn;
    @FXML
    private TableColumn<?, ?> totalAmountTableColumn;
    @FXML
    private TableColumn<?, ?> estimatedDeliveryTimeTableColumn;

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
    private void deliveryHistoryButtonOnMouseClicked(ActionEvent event) {
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
