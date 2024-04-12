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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ProductionManagerUpcomingCarModelsSceneController implements Initializable {

    @FXML
    private ComboBox<?> selectCarTypeComboBox;
    @FXML
    private ImageView carModelImageView;
    @FXML
    private TextArea featuresTextArea;
    @FXML
    private TableView<?> carModelTableView;
    @FXML
    private TableColumn<?, ?> carTypeTableColumn;
    @FXML
    private TableColumn<?, ?> carModelTableColumn;
    @FXML
    private TableColumn<?, ?> carModelTableColumn1;
    @FXML
    private TextField upcomingCarModelTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/ProductionManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void carTypeSelectOnAction(ActionEvent event) {
    }

    @FXML
    private void submitButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
    }
    
}
