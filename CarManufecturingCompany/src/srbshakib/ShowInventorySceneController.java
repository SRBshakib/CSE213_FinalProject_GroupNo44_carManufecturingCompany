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
public class ShowInventorySceneController implements Initializable {

    @FXML
    private ComboBox<?> selectPartsForInventoryComboBox;
    @FXML
    private ImageView inventoryPartImageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homeButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void assignedTaskButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void inventoryButtonOnMuseClicked(ActionEvent event) throws IOException {
       Parent parent = FXMLLoader.load(getClass().getResource("ShowInventoryScene.fxml"));
       Scene scene1 = new Scene(parent);
       Stage newWindow  = new Stage();
       newWindow.setTitle("MD Dashboard");
       newWindow.setScene(scene1);
       newWindow.show();
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

    @FXML
    private void selectPartOfInventoryOnMouseClicked(ActionEvent event) {
    }
    
}
