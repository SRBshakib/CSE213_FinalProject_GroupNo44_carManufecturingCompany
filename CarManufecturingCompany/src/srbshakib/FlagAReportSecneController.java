/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package srbshakib;

import Dip.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class FlagAReportSecneController implements Initializable {

    @FXML
    private ComboBox<String> flagReportProblemTypeComboBox;
    @FXML
    private TextArea flagReportTextArea;
    @FXML
    private TextField flagReportWorkarIdTextField;
    @FXML
    private TextField flagReportAssigendCarModelNoTextField;
    @FXML
    private ComboBox<String> flagReportCarTypeComboBox;
    @FXML
    private TableView<FlagAReport> flagReportTableView;
    @FXML
    private TableColumn<FlagAReport, Integer> idTableColumn;
    @FXML
    private TableColumn<FlagAReport, String> carModelNoTableColumn;
    @FXML
    private TableColumn<FlagAReport, String> carTypeTableColumn;
    @FXML
    private TableColumn<FlagAReport, String> problemTypeTableColumn;
    @FXML
    private TableColumn<FlagAReport, String> commentsTableColumn;
    @FXML
    private TableColumn<FlagAReport, String> statusTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flagReportProblemTypeComboBox.getItems().addAll("Equipment Malfunction","Supply Shortages","Safety Concerns","Communication Issues","Quality Control Problems","Engine Assembly",
"Transmission Assembly",
"Chassis Assembly",
"Body Assembly",
"Interior Assembly",
"Electrical System Assembly",
"Exterior Trim Assembly",
"Final Assembly");
        
        flagReportCarTypeComboBox.getItems().addAll("Sedan",
"Hatchback",
"SUV",
"Crossover",
"Coupe",
"Convertible",
"Minivan",
"Truck" );
        
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
    private void flagReportSubmitButtonOnMouseClicked(ActionEvent event) {
        FlagAReport i= new FlagAReport(
                Integer.parseInt(flagReportWorkarIdTextField.getText()),
                flagReportAssigendCarModelNoTextField.getText(),
                flagReportCarTypeComboBox.getValue(),
                flagReportProblemTypeComboBox.getValue(),
                flagReportTextArea.getText()
                
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("FlagReportInfo.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(FlagAReportSecneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(FlagAReportSecneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        flagReportWorkarIdTextField.clear();
        flagReportAssigendCarModelNoTextField.clear();
        flagReportCarTypeComboBox.setValue(null);
        flagReportProblemTypeComboBox.setValue(null);
        flagReportTextArea.clear();
        
        
    }

    @FXML
    private void loadReportsOnMouseClicked(ActionEvent event) {
        ObservableList<FlagAReport> flagReportInfo = FXCollections.observableArrayList();

        idTableColumn.setCellValueFactory(new PropertyValueFactory<FlagAReport,Integer>("workerId"));
        carModelNoTableColumn.setCellValueFactory(new PropertyValueFactory<FlagAReport,String>("carModelNo"));
        carTypeTableColumn.setCellValueFactory(new PropertyValueFactory<FlagAReport, String>("carType"));
        problemTypeTableColumn.setCellValueFactory(new PropertyValueFactory<FlagAReport, String>("problemType"));
        commentsTableColumn.setCellValueFactory(new PropertyValueFactory<FlagAReport, String>("comments"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<FlagAReport, String>("Status"));
        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("FlagReportInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            FlagAReport p;
            try {
                while (true) {
                    p = (FlagAReport) ois.readObject();
                    flagReportInfo.add(p);
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
        flagReportTableView.setItems(flagReportInfo);
        System.out.println(flagReportInfo.toString());
    }

    
    
}
