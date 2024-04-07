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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class CheckScheduleSceneController implements Initializable {

    @FXML
    private TableView<?> currentWorkibgScheduleTableView;
    @FXML
    private TableColumn<?, ?> checkScheduleCurrentWorkerNameTbaleColumn;
    @FXML
    private TableColumn<?, ?> checkScheduleCurrentWorkerDesingnationTbaleColumn;
    @FXML
    private TableColumn<?, ?> checkScheduleCurrentStartingDateTbaleColumn;
    @FXML
    private TableColumn<?, ?> checkScheduleCurrentEndingDateTbaleColumn;
    @FXML
    private TableColumn<?, ?> checkScheduleCurrentShiftTbaleColumn;
    @FXML
    private TableView<?> pastWorkibgScheduleTableView;
    @FXML
    private TableColumn<?, ?> checkSchedulePastWorkerNameTbaleColumn;
    @FXML
    private TableColumn<?, ?> checkSchedulePastWorkerDesingnationTbaleColumn;
    @FXML
    private TableColumn<?, ?> checkSchedulePastStartingDateTbaleColumn;
    @FXML
    private TableColumn<?, ?> checkSchedulePastEndingDateTbaleColumn;
    @FXML
    private TableColumn<?, ?> checkSchedulePastShiftTbaleColumn;

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
