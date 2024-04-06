
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

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
public class WorkingScheduleSceneController implements Initializable {

    @FXML
    private TextField time_Text_Field;
    @FXML
    private ComboBox<?> select_Employee_ComboBox;
    @FXML
    private DatePicker date_Picker;
    @FXML
    private TableView<?> TableView;
    @FXML
    private TableColumn<?, ?> name_Table_Colm;
    @FXML
    private TableColumn<?, ?> date_Table_Colm;
    @FXML
    private TableColumn<?, ?> time_Table_Colm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back_Button_On_Click(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/ProductionManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    
}