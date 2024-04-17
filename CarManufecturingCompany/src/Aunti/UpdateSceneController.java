/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti;

import srbshakib.SupplyChainManager.MakeInventorySceneController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class UpdateSceneController implements Initializable {

    @FXML
    private TableColumn<?, String> carTypeTableColumn;
    @FXML
    private ComboBox<?> carTypeComboBox;
    @FXML
    private TableColumn<?, ?> carModelsTableColumn;
    @FXML
    private ComboBox<?> carModelsComboBox;
    @FXML
    private TableView<?> updateTableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void loadInfoButtonOnMouseClicked(ActionEvent event) {
        
    }

    
}
