package Dip;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class HumanResourceManagerSalaryManagmentSceneController implements Initializable {

    @FXML
    private TableView<EmployeeList> salaryTV;
    @FXML
    private TableColumn<EmployeeList, String> nameTC;
    @FXML
    private TableColumn<EmployeeList, Integer> idTC;
    @FXML
    private TableColumn<EmployeeList, LocalDate> dOJTC;
    @FXML
    private TableColumn<Salary, Float> amountTC;
    @FXML
    private TextField amountTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    private void saveButtonOnMouseClick(ActionEvent event) {
    }

    @FXML
    private void saveToBinButtonOnMouseClick(ActionEvent event) {
    }

    @FXML
    private void showButtonOnMouseClick(ActionEvent event) {
    }

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
    }

}
