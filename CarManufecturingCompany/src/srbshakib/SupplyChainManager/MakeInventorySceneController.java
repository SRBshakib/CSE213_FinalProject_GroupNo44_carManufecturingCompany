/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package srbshakib.SupplyChainManager;

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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class MakeInventorySceneController implements Initializable {

    @FXML
    private ComboBox<?> selectPartsForInventoryComboBox;
    @FXML
    private ImageView inventoryPartImageView;
    @FXML
    private ComboBox<?> numberOfPartsAvailableComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homeButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AssemblyLineWorkerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }


    private void inventoryButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ShowInventoryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    @FXML
    private void selectPartOfInventoryOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void trackLogisticsButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void orderButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void distributeButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void orderHistoryButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void updateInventoryButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void customerOrderButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void supplierListButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void supplyHistoryButtonOnMuseClicked(ActionEvent event) {
    }
    
}
