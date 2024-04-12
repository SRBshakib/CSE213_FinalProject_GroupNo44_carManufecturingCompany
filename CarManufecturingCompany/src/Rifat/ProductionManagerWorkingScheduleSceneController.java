
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ProductionManagerWorkingScheduleSceneController implements Initializable {

    @FXML
    private TableView<?> currentWorkingScheduleTableView;
    @FXML
    private TableColumn<?, ?> currentWorkerNameTableColumn;
    @FXML
    private TableColumn<?, ?> currentWorkerDesignationTableColumn;
    @FXML
    private TableColumn<?, ?> currentStartingDateTableColumn;
    @FXML
    private TableColumn<?, ?> currentEndingDateTableColumn;
    @FXML
    private TableColumn<?, ?> currentShiftTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void back_Button_On_Click(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/ProductionManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void submitButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
    }

    
}
