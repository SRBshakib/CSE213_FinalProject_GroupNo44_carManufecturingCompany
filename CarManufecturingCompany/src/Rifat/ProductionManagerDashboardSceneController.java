/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;

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
 * @author Lenovo
 */
public class ProductionManagerDashboardSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void carModelButtonOnClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("CarModelScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    

    @FXML
    private void upcomingCarModelsButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void carLunchingEventButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void issueButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void assemblyManuelButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void assignTasksButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void workingScheduleButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void carDesignButtonOnClicked(ActionEvent event) {
    }
    
}
