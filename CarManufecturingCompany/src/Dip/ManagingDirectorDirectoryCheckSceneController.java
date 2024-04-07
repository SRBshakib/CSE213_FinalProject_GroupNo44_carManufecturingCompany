/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class ManagingDirectorDirectoryCheckSceneController implements Initializable {

    @FXML
    private TableView<EmployeeList> empTV;
    @FXML
    private TableColumn<EmployeeList, String> nameTC;
    @FXML
    private TableColumn<EmployeeList, Integer> idTC;
    @FXML
    private TableColumn<EmployeeList, String> genderTC;
    @FXML
    private TableColumn<EmployeeList, String> designationTC;
    @FXML
    private TableColumn<EmployeeList, Integer> phoneTC;
    @FXML
    private TableView<WorkerList> wrkTV;
    @FXML
    private TableColumn<WorkerList, String> nameWrkTC;
    @FXML
    private TableColumn<WorkerList, Integer> idWrkTC;
    @FXML
    private TableColumn<WorkerList, String> genderWrkTC;
    @FXML
    private TableColumn<WorkerList, String> designationWrkTC;
    @FXML
    private TableColumn<WorkerList, Integer> phoneWrkTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagingDirectorDashboardScene.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();

            
    }

    @FXML
    private void viewDetailsOnClick(ActionEvent event) {
    }

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        ObservableList<EmployeeList> empList = FXCollections.observableArrayList();

            nameTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("name"));
            idTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, Integer>("id"));
            genderTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("gender"));
            designationTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("designation"));
            phoneTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, Integer>("phone"));

            File f = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;

            try {
                f = new File("EmployeeDirectory.bin");
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                EmployeeList p;
                try {
                    while (true) {
                        p = (EmployeeList) ois.readObject();
                        empList.add(p);
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
            empTV.setItems(empList);
            System.out.println(empList.toString());
    }

    @FXML
    private void viewDetailsOnClickWorker(ActionEvent event) {
    }

    @FXML
    private void loadButtonOnClickWorker(ActionEvent event) {
        ObservableList<WorkerList> workerArr = FXCollections.observableArrayList();

            nameWrkTC.setCellValueFactory(new PropertyValueFactory<WorkerList, String>("name"));
            idWrkTC.setCellValueFactory(new PropertyValueFactory<WorkerList, Integer>("id"));
            genderWrkTC.setCellValueFactory(new PropertyValueFactory<WorkerList, String>("gender"));
            designationWrkTC.setCellValueFactory(new PropertyValueFactory<WorkerList, String>("designation"));
            phoneWrkTC.setCellValueFactory(new PropertyValueFactory<WorkerList, Integer>("phone"));

            File f = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;

            try {
                f = new File("WorkerDirectory.bin");
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                WorkerList p;
                try {
                    while (true) {
                        p = (WorkerList) ois.readObject();
                        workerArr.add(p);
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
            wrkTV.setItems(workerArr);
            System.out.println(workerArr.toString());
    }
    
}
