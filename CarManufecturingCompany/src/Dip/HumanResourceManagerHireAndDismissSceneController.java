/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class HumanResourceManagerHireAndDismissSceneController implements Initializable {

<<<<<<< Updated upstream
=======
    private ComboBox<String> genderCB;
    @FXML
    private TextField nameTF;
    @FXML
    private ComboBox<String> designationCB;
    @FXML
    private DatePicker dateofbirthDP;
    @FXML
    private DatePicker dateOfJoinDP;
    @FXML
    private TableView<NewJoining> newJoiningTV;
    @FXML
    private TableColumn<NewJoining, Integer> idTC;
    @FXML
    private TableColumn<NewJoining, String> nameTC;
    @FXML
    private TableColumn<NewJoining, String> genderTC;
    @FXML
    private TableColumn<NewJoining, LocalDate> dateOfBirthTC;
    @FXML
    private TableColumn<NewJoining, LocalDate> dateOfJoinTC;
    private static int idCounter = 22200;
    @FXML
    private RadioButton maleRBtn;
    @FXML
    private RadioButton femaleRBtn;
    @FXML
    private RadioButton otherRBtn;
    private ArrayList<NewJoining> newjoiningArr;
    ToggleGroup tg;
    @FXML
    private TableColumn<NewJoining, String> designationTC;

>>>>>>> Stashed changes
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
    
}
