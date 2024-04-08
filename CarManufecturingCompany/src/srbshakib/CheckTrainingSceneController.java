/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package srbshakib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class CheckTrainingSceneController implements Initializable {

    @FXML
    private TableColumn<?, ?> pastTrainigInformationStartingDateTableColumn;
    @FXML
    private TableColumn<?, ?> pastTrainigInformationEndingDateTableColumn;
    @FXML
    private TableColumn<?, ?> pastTrainigInformationPlaceTableColumn;
    @FXML
    private TableColumn<?, ?> pastTrainigInformationTopicTableColumn;
    @FXML
    private TableColumn<?, ?> pastTrainigInformationInstructorTableColumn;
    @FXML
    private Label noTrainingForYoulLabel;
    @FXML
    private TableColumn<?, ?> trainigStartingDateTableColumn;
    @FXML
    private TableColumn<?, ?> trainigEndingDateTableColumn;
    @FXML
    private TableColumn<?, ?> trainigPlaceTableColumn;
    @FXML
    private TableColumn<?, ?> trainigTopicTableColumn;
    @FXML
    private TableColumn<?, ?> trainigInstructorTableColumn;

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
    private void inventoryButtonOnMuseClicked(ActionEvent event) {
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
