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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class HR_DashboardSceneController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void noticeMgtButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void directoryMgtButtonOnClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("HR_DirectoryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }


    @FXML
    private void leaveRequestButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void hireAndDismissButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void trainEmployeeButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void createUserButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void jobApplicationButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void salaryMgtButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void termsAndConditionsReadOnClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("HR_TermsAndConditionsReadScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage newWindow  = new Stage();
        newWindow.setTitle("Terms And Conditions");
        newWindow.setScene(scene1);
        newWindow.show();
    } 
}
