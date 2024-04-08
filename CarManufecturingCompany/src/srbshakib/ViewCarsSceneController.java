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
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class ViewCarsSceneController implements Initializable {

    @FXML
    private TableView<?> assemblingCarsTableView;
    @FXML
    private TableColumn<?, ?> viewCarsModelNoTableColumn;
    @FXML
    private TableColumn<?, ?> viewCarssectionTableColumn;
    @FXML
    private PieChart viewCarsAssemblingPieChart;
    @FXML
    private ComboBox<?> viewcarsCarModelSelectCarTypeComboBox;
    @FXML
    private ComboBox<?> viewcarsCarModelSelectCarModelComboBox;
    @FXML
    private ImageView carViewCarImageview;
    @FXML
    private Label carViewcarFeaturesLabel;

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

    @FXML
    private void viewcarsCarTypeSelectcarTypeOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void viewcarsCarModelSelectcarTypeOnMouseClicked(ActionEvent event) {
    }
    
}
