/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package srbshakib;

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
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class AssemblyLineWorkerDashboardSceneController implements Initializable {


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

    @FXML
    private void assignedTaskButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void inventoryButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ShowInventoryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void instructionsButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void leaveApplicationButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void traingButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void flagReportButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void checkScheduleButtonOnMuseClicked(ActionEvent event) {
    }


    
}
