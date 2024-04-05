package Dip;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class HumanResourceManagerDirectorySceneController implements Initializable {

    @FXML
    private ComboBox<String> personCB;
    @FXML
    private TableView<EmployeeList> personTV;
    @FXML
    private TableColumn<EmployeeList, String> nameTC;
    @FXML
    private TableColumn<EmployeeList, Integer> idTC;
    @FXML
    private TableColumn<EmployeeList, String> genderTC;
    @FXML
    private TableColumn<EmployeeList, String> designationTC;
    @FXML
    private RadioButton maleRBtn;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private RadioButton femaleRBtn;
    @FXML
    private RadioButton otherRBtn;
    @FXML
    private TextArea addressTA;
    @FXML
    private DatePicker dOBLocalDate;
    @FXML
    private DatePicker dOJLocalDate;
    @FXML
    private ComboBox<String> designationCB;
    @FXML
    private TextField idTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void selectPersonOnClick(ActionEvent event) {
    }

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewDetailsOnClick(ActionEvent event) {
    }

    @FXML
    private void addButtonOnMouseClick(ActionEvent event) {
    }
    
}
