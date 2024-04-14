
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;

import Dip.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ProductionManagerWorkingScheduleSceneController implements Initializable {

    @FXML
    private TextField workerIdTextField;
    @FXML
    private TextField workerNameTextField;
    @FXML
    private TextField shiftDateTextField;
    @FXML
    private TextField shiftTimeTextField;
    @FXML
    private TableView<WorkingSchedule> scheduleTableView;
    @FXML
    private TableColumn<WorkingSchedule, String> workerIdColumnTable;
    @FXML
    private TableColumn<WorkingSchedule, String> workerNameColumnTable;
    @FXML
    private TableColumn<WorkingSchedule, String> shiftDateColumnTable;
    @FXML
    private TableColumn<WorkingSchedule, String> shiftTimeColumnTable;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {workerIdColumnTable.setCellValueFactory(new PropertyValueFactory<>("workerId"));
    workerNameColumnTable.setCellValueFactory(new PropertyValueFactory<>("workerName"));
    shiftDateColumnTable.setCellValueFactory(new PropertyValueFactory<>("shiftDate"));
    shiftTimeColumnTable.setCellValueFactory(new PropertyValueFactory<>("shiftTime"));
}

    @FXML
    private void addButtonOnMouseClicked(ActionEvent event) {
        WorkingSchedule i= new WorkingSchedule(
              
                
                
                workerIdTextField.getText(),
                workerNameTextField.getText(),
                shiftDateTextField.getText(),
                shiftTimeTextField.getText()
                
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("WokringScheduleInfo.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(ProductionManagerWorkingScheduleSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(ProductionManagerWorkingScheduleSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        workerIdTextField.clear();
        workerNameTextField.clear();
        shiftDateTextField.clear();
        shiftTimeTextField.clear();
    }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        ObservableList<WorkingSchedule> WorkingScheduleInfo = FXCollections.observableArrayList();
    
    


        

        workerIdColumnTable.setCellValueFactory(new PropertyValueFactory<WorkingSchedule,String>("workerId"));

        workerNameColumnTable.setCellValueFactory(new PropertyValueFactory<WorkingSchedule, String>("workerName"));
        
        
        shiftDateColumnTable.setCellValueFactory(new PropertyValueFactory<WorkingSchedule, String>("shiftDate"));
        shiftTimeColumnTable.setCellValueFactory(new PropertyValueFactory<WorkingSchedule, String>("shiftTime"));

        

        

        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("WokringScheduleInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            WorkingSchedule p;
            try {
                while (true) {
                    p = (WorkingSchedule) ois.readObject();
                    WorkingScheduleInfo.add(p);
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
        scheduleTableView.setItems(WorkingScheduleInfo);
        System.out.println(WorkingScheduleInfo.toString());
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