/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import srbshakib.AskForLeave;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class HumanResourceManagerLeaveRequestReadSceneController implements Initializable {

    @FXML
    private TableView<AskForLeave> leaveInformationTV;
    @FXML
    private TableColumn<AskForLeave, Integer> daysTC;
    @FXML
    private TableColumn<AskForLeave, LocalDate> forTC;
    @FXML
    private TableColumn<AskForLeave, LocalDate> fromTC;
    @FXML
    private TableColumn<AskForLeave, LocalDate> toTC;
    @FXML
    private TableColumn<AskForLeave, String> reasonTC;
    @FXML
    private TableColumn<AskForLeave, String> commentTC;
    @FXML
    private TableColumn<AskForLeave, String> statusTC;
    @FXML
    private Button approveButton;
    @FXML
    private Button denyButton;
    Integer index;
    private ObservableList<AskForLeave> askingLeaveReq;

    private ObservableList<AskForLeave> updatedLeaveReq;
    @FXML
    private Label reasonShowLabel;
    @FXML
    private Label commentShowLabel;
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
    private TableColumn<AskForLeave, String> pastLeaveInformationStatusTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updatedLeaveReq = FXCollections.observableArrayList();

        daysTC.setCellValueFactory(new PropertyValueFactory<AskForLeave, Integer>("howManyWorkingDays"));
        forTC.setCellValueFactory(new PropertyValueFactory<AskForLeave, LocalDate>("forWhichDay"));
        fromTC.setCellValueFactory(new PropertyValueFactory<AskForLeave, LocalDate>("fromWhichDay"));
        toTC.setCellValueFactory(new PropertyValueFactory<AskForLeave, LocalDate>("toWhichDay"));
        reasonTC.setCellValueFactory(new PropertyValueFactory<AskForLeave, String>("reasonForLeave"));
        commentTC.setCellValueFactory(new PropertyValueFactory<AskForLeave, String>("commentForLeave"));
        statusTC.setCellValueFactory(new PropertyValueFactory<AskForLeave, String>("status"));
      
    }

    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void approveButtonOnClick(ActionEvent event) {
    }
    @FXML
    private void denyButtonOnClick(ActionEvent event) {

    }

    @FXML
    private void refreshButtonOnClick(ActionEvent event) {
        ObservableList<AskForLeave> leaveInfo = FXCollections.observableArrayList();

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
        leaveInformationTV.setItems(leaveInfo);
        System.out.println(leaveInfo.toString());
    }

    @FXML
    private void getItemsOnClick(MouseEvent event
    ) {
        index = leaveInformationTV.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        reasonShowLabel.setText(reasonTC.getCellData(index).toString());
        commentShowLabel.setText(commentTC.getCellData(index).toString());
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
