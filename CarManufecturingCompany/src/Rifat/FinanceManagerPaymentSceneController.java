/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FinanceManagerPaymentSceneController implements Initializable {

    @FXML
    private TableView<?> paymentListTableView;
    @FXML
    private TableColumn<?, ?> userIdTableColumn;
    @FXML
    private TableColumn<?, ?> totalPaymentTableColumn;
    @FXML
    private TableColumn<?, ?> totalPaidTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
