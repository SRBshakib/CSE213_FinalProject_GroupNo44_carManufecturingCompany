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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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
   private void homeButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AssemblyLineWorkerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Assembly Line Worker Dashboard");
        window.show();
        
    }

    @FXML
    private void assignedTaskButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AssignedTaskSecne.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Assigned Task");
        window.show();
    }

    @FXML
    private void inventoryButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ShowInventoryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Inventory");
        window.show();
    }

    @FXML
    private void instructionsButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AssemblingInsturctionScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Instructions");
        window.show();
    }

    @FXML
    private void leaveApplicationButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AskLeaveScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Ask Leave");
        window.show();
    }

    @FXML
    private void traingButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("CheckTrainingScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Training");
        window.show();
    }

    @FXML
    private void flagReportButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("FlagAReportSecne.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Flag Report");
        window.show();
    }

    @FXML
    private void checkScheduleButtonOnMuseClicked(ActionEvent event) throws IOException {
       Parent mainParent = FXMLLoader.load(getClass().getResource("CheckScheduleScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Schedule");
        window.show();
    }

    @FXML
    private void viewCarsButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ViewCarsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Cars");
        window.show();
    }
    
}
