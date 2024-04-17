/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import srbshakib.SupplyChainManager.MakeSupplierListSceneController;
import srbshakib.SupplyChainManager.SupplierInformation;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class HumanResourceManagerHireAndDismissSceneController implements Initializable {

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

    private static int idCounter = 2221000;

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

  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newjoiningArr = new ArrayList<NewJoining>();
        designationCB.getItems().addAll(
                "Assambly Line Worker", 
                "Managing Director", 
                "Human Resource Manager", 
                "Finance Manager", 
                "Supply Chain Manager",
                "Production Manager");
        tg = new ToggleGroup();
        maleRBtn.setToggleGroup(tg);
        femaleRBtn.setToggleGroup(tg);
        otherRBtn.setToggleGroup(tg);

        idTC.setCellValueFactory(new PropertyValueFactory<NewJoining, Integer>("uniqueid"));
        nameTC.setCellValueFactory(new PropertyValueFactory<NewJoining, String>("name"));
        genderTC.setCellValueFactory(new PropertyValueFactory<NewJoining, String>("gender"));
        dateOfBirthTC.setCellValueFactory(new PropertyValueFactory<NewJoining, LocalDate>("dob"));
        dateOfJoinTC.setCellValueFactory(new PropertyValueFactory<NewJoining, LocalDate>("doj"));
        designationTC.setCellValueFactory(new PropertyValueFactory<NewJoining, String>("designation"));

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
    private void addbuttonOnClick(ActionEvent event) {
        String gender = "";
        if (maleRBtn.isSelected()) {
            gender = "Male";
        } else if (femaleRBtn.isSelected()) {
            gender = "Female";
        } else if (otherRBtn.isSelected()) {
            gender = "Other";
        }
        
        if (nameTF.getText().isEmpty() 
                || gender.isEmpty()
                || designationCB.getValue() == null 
        || designationCB.getValue() == null 
                || dateOfJoinDP.getValue() == null ) {
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {

        NewJoining i = new NewJoining(
                generateUniqueId(),
                nameTF.getText(),
                gender,
                designationCB.getValue(),
                dateofbirthDP.getValue(),
                dateOfJoinDP.getValue()
        );

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("NewJoining.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(HumanResourceManagerHireAndDismissSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(HumanResourceManagerHireAndDismissSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        nameTF.clear();
      
        designationCB.setValue(null);
        dateofbirthDP.setValue(null);
        dateOfJoinDP.setValue(null);
    }
    }
    private int generateUniqueId() {
        return ++idCounter; // Increment the ID counter and return
    }

    @FXML
    private void loadbuttonOnClick(ActionEvent event) {
        ObservableList<NewJoining> newjoiningArr = FXCollections.observableArrayList();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("NewJoining.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            NewJoining p;
            try {
                while (true) {
                    p = (NewJoining) ois.readObject();
                    newjoiningArr.add(p);
                    System.out.println(p.toString());
                }
            } catch (Exception e) {
            }
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }

        }
        newJoiningTV.setItems(newjoiningArr);
        System.out.println(newjoiningArr.toString());
    }
}


