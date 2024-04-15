/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package srbshakib;

import Dip.Training;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import Dip.Training;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class CheckTrainingSceneController implements Initializable {
    
    @FXML
    private TableView<Training> trainingShowTV;
    @FXML
    private TableColumn<Training, String> nameShowTC;
    @FXML
    private TableColumn<Training, Integer> idShowTC;
    @FXML
    private TableColumn<Training, LocalDate> trainingFromTC;
    @FXML
    private TableColumn<Training, LocalDate> trainingToTC;
    @FXML
    private TableColumn<Training, String> typeTC;
    @FXML
    private TableColumn<Training, String> trainingNameTC;
    @FXML
    private TableColumn<Training, String> feesTC;
     @FXML
    private TableColumn<Training, Integer> trainIdTC;
    @FXML
    private TableColumn<Training, String> statusTC;

   private ArrayList<Training> trainingArr;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameShowTC.setCellValueFactory(new PropertyValueFactory<Training, String>("name"));
        idShowTC.setCellValueFactory(new PropertyValueFactory<Training, Integer>("empId"));
        trainingFromTC.setCellValueFactory(new PropertyValueFactory<Training, LocalDate>("dateFrom"));
        trainingToTC.setCellValueFactory(new PropertyValueFactory<Training, LocalDate>("dateTo"));
        typeTC.setCellValueFactory(new PropertyValueFactory<Training, String>("trainingType"));
        trainingNameTC.setCellValueFactory(new PropertyValueFactory<Training, String>("trainingName"));
        feesTC.setCellValueFactory(new PropertyValueFactory<Training, String>("payment"));
        trainIdTC.setCellValueFactory(new PropertyValueFactory<Training, Integer>("trainingId"));
        statusTC.setCellValueFactory(new PropertyValueFactory<Training, String>("status"));
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

    @FXML
    private void showButtonOnMouseClick(ActionEvent event) {
        ObservableList<Training> trainingArr = FXCollections.observableArrayList();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("TrainingInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Training p;
            try {
                while (true) {
                    p = (Training) ois.readObject();
                    trainingArr.add(p);
                    System.out.println(p.toString());
                }
            } catch (Exception e) {
            }
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }

        }
        trainingShowTV.setItems(trainingArr);
        System.out.println(trainingArr.toString());
    }
    
}
