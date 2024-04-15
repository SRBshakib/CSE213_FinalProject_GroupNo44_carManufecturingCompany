
package Rifat;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AssignTasksSceneController implements Initializable {

    @FXML
    private ComboBox<String> destinationComboBox;
    @FXML
    private DatePicker startingDatePicker;
    @FXML
    private DatePicker endingDatePicker;
    @FXML
    private ComboBox<String> carModelComboBox;
    @FXML
    private ComboBox<String> carTypeComboBox;
    @FXML
    private TableView<AssignTasks> assignedTaskTableView;
    @FXML
    private TableColumn<AssignTasks, String> workerNameColumn;
    @FXML
    private TableColumn<AssignTasks, String> taskDetailsColumn;
    @FXML
    private Button assignTaskButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/ProductionManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
private void assignTaskButtonOnMouseClicked(ActionEvent event) {
    // Get selected values from UI components
    String destination = destinationComboBox.getValue();
    LocalDate startingDate = startingDatePicker.getValue();
    LocalDate endingDate = endingDatePicker.getValue();
    String carModel = carModelComboBox.getValue();
    String carType = carTypeComboBox.getValue();
    
    // Validate selected values
    if (destination == null || startingDate == null || endingDate == null || carModel == null || carType == null) {
        // Display an error message or handle invalid input
        System.out.println("Please fill in all fields!");
        return;
    }
    
    // Perform task assignment logic
    // Here you can create an AssignedTask object with the selected values
    AssignTasks assignTasks = new AssignTasks(destination, startingDate, endingDate, carModel, carType);
    
    // Add the assigned task to the table view
    assignedTaskTableView.getItems().add(assignTasks);
}


    @FXML
    private void destinationComboBoxAction(ActionEvent event) {
    }

    @FXML
    private void startingDatePickerAction(ActionEvent event) {
    }

    @FXML
    private void endingDatePickerAction(ActionEvent event) {
    }

    @FXML
    private void carModelComboBoxAction(ActionEvent event) {
    }

    @FXML
    private void carTypeComboBoxAction(ActionEvent event) {
    }
    
}
