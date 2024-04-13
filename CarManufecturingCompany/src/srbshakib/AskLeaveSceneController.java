
package srbshakib;

import Dip.AppendableObjectOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.time.LocalDate;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class AskLeaveSceneController implements Initializable {

    @FXML
    private AnchorPane askLeaveFromDatePIcker;
    @FXML
    private ComboBox<Integer> askLeaveHowManyWorkingDaysComboBox;
    @FXML
    private DatePicker askLeaveForDatePIcker;
    @FXML
    private DatePicker askLeaveToDatePIcker;
    @FXML
    private TextArea askLeaveTextArea;
    @FXML
    private TableView<AskForLeave> pastLeaveInformationTableView;
    @FXML
    private TableColumn<AskForLeave, Integer> daysTableColumn;
    @FXML
    private TableColumn<AskForLeave, LocalDate> forTableColumn;
    @FXML
    private TableColumn<AskForLeave, LocalDate> fromTableColumn;
    @FXML
    private TableColumn<AskForLeave, LocalDate> toTableColumn;
    @FXML
    private TableColumn<AskForLeave, String> reasonTableColumn;
    @FXML
    private TableColumn<AskForLeave, String> commentTableColumn;
    @FXML
    private ComboBox<String> askLeaveReasonComboBox;
    @FXML
    private DatePicker askLeaveForSingleDatePIcker;
    @FXML
    private TableColumn<AskForLeave, String> pastLeaveInformationStatusTableColumn;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       askLeaveHowManyWorkingDaysComboBox.getItems().addAll(1,2,3,4,5);
       askLeaveReasonComboBox.getItems().addAll("Personal","Cold and Cough","Treatment","Travel");
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
//       Parent parent = FXMLLoader.load(getClass().getResource("ShowInventoryScene.fxml"));
//       Scene scene1 = new Scene(parent);
//       Stage newWindow  = new Stage();
//       newWindow.setTitle("Inventory");
//       newWindow.setScene(scene1);
//       newWindow.show();

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
    private void askLeaveSubmitButtonOnMouseClicked(ActionEvent event) {
        AskForLeave i = new AskForLeave(
                
                askLeaveHowManyWorkingDaysComboBox.getValue(),
                askLeaveForSingleDatePIcker.getValue(),
                askLeaveForDatePIcker.getValue(),
                askLeaveToDatePIcker.getValue(),
                askLeaveReasonComboBox.getValue(),
                askLeaveTextArea.getText()
                
                
        );
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("LeaveInfo.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(AskLeaveSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(AskLeaveSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

        askLeaveHowManyWorkingDaysComboBox.setValue(null);
        askLeaveTextArea.clear();
        askLeaveForSingleDatePIcker.setValue(null);
        askLeaveForDatePIcker.setValue(null);
        askLeaveToDatePIcker.setValue(null);
        askLeaveReasonComboBox.setValue(null);
    }

        
    

    @FXML
    private void howManyWorkingDaysOnMouseClicked(ActionEvent event) {
        switch (askLeaveHowManyWorkingDaysComboBox.getValue()) {
            case 1:
                askLeaveForSingleDatePIcker.setDisable(false);
                askLeaveForDatePIcker.setDisable(true);
                askLeaveToDatePIcker.setDisable(true);
                break;
            case 2:
                askLeaveForSingleDatePIcker.setDisable(true);
                askLeaveForDatePIcker.setDisable(false);
                askLeaveToDatePIcker.setDisable(false);
                break;
            case 3:
                askLeaveForSingleDatePIcker.setDisable(true);
                askLeaveForDatePIcker.setDisable(false);
                askLeaveToDatePIcker.setDisable(false);
                break;
            case 4:
                askLeaveForSingleDatePIcker.setDisable(true);
                askLeaveForDatePIcker.setDisable(false);
                askLeaveToDatePIcker.setDisable(false);
                break;
            case 5:
                askLeaveForSingleDatePIcker.setDisable(true);
                askLeaveForDatePIcker.setDisable(false);
                askLeaveToDatePIcker.setDisable(false);
                break;
            default:
                break;
        }
        
    }

    @FXML
    private void showPastLeaveInformationOnMouseClicked(ActionEvent event) {
        ObservableList<AskForLeave> leaveInfo = FXCollections.observableArrayList();

        daysTableColumn.setCellValueFactory(new PropertyValueFactory<AskForLeave, Integer>("howManyWorkingDays"));
        forTableColumn.setCellValueFactory(new PropertyValueFactory<AskForLeave,LocalDate>("forWhichDay"));
        fromTableColumn.setCellValueFactory(new PropertyValueFactory<AskForLeave, LocalDate>("fromWhichDay"));
        toTableColumn.setCellValueFactory(new PropertyValueFactory<AskForLeave, LocalDate>("toWhichDay"));
        reasonTableColumn.setCellValueFactory(new PropertyValueFactory<AskForLeave, String>("reasonForLeave"));
        commentTableColumn.setCellValueFactory(new PropertyValueFactory<AskForLeave, String>("commentForLeave"));
        pastLeaveInformationStatusTableColumn.setCellValueFactory(new PropertyValueFactory<AskForLeave, String>("status"));
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("LeaveInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            AskForLeave p;
            try {
                while (true) {
                    p = (AskForLeave) ois.readObject();
                    leaveInfo.add(p);
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
        pastLeaveInformationTableView.setItems(leaveInfo);
        System.out.println(leaveInfo.toString());
    }

    
    
}
