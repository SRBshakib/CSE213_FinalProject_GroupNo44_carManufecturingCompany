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
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProductionManagerCarLunchingEventSceneController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void learnMoreButtonClicked(ActionEvent event) throws IOException {
        // Load the scene for learning more about the car launching event
        Parent learnMoreParent = FXMLLoader.load(getClass().getResource("CarLunchingEventScene.fxml"));
        Scene learnMoreScene = new Scene(learnMoreParent);
        
        // Get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        // Set the scene onto the stage and show
        window.setScene(learnMoreScene);
        window.show();
    }

    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/ProductionManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
}

