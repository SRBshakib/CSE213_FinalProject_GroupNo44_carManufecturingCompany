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
    private TableView<?> salaryTV;
    @FXML
    private TableColumn<?, ?> nameTC;
    @FXML
    private TableColumn<?, ?> idTC;
    @FXML
    private TableColumn<?, ?> dOJTC;
    @FXML
    private TableColumn<?, ?> amountTC;
    @FXML
    private TextField amountTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}
