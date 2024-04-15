
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

import java.io.EOFException;
import java.util.Date;
import srbshakib.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Dip.EmployeeList;
import Dip.NewJoining;


/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class HumanResourceManagerCreateUserSceneController implements Initializable {

    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private DatePicker dobDatePicker;

    boolean addUserStatus;

    @FXML
    private ComboBox<Integer> selectIdComboBox;
    @FXML
    private ComboBox<String> selectNameComboBox;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField addressTextField;
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        userTypeComboBox.getItems().addAll("Assembly Line Worker","Finance Manager","Managing Director","Suppler","Supply Chain Manager","Customer","Production Manager");



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
    private void signUpOnMouseClick(ActionEvent event) throws IOException {
         if(userTypeComboBox.getValue().equals("Assembly Line Worker")){

            lineWorkerAndShow();
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Your account has been created successfully");
            a1.showAndWait();
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();                                         
        }   
        else if(userTypeComboBox.getValue().equals("Finance Manager")){
            FinanceManagerAndShow(); 
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Your account has been created successfully");
            a1.showAndWait();
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
        }
        else if(userTypeComboBox.getValue().equals("Managing Director")){
            ManagingDirectorAndShow();
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Your account has been created successfully");
            a1.showAndWait();
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
        }
        else if(userTypeComboBox.getValue().equals("Suppler")){
            SupplierAndShow();
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Your account has been created successfully");
            a1.showAndWait();
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
        }
        else if(userTypeComboBox.getValue().equals("Production Manager")){
            productionManagerAndShow();
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Your account has been created successfully");
            a1.showAndWait();
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
        }
        else if(userTypeComboBox.getValue().equals("Supply Chain Manager")){
           supplyChainManagerAndShow();
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Your account has been created successfully");
            a1.showAndWait();
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
        }
                     selectNameComboBox.setItems(null);
                     selectIdComboBox.setItems(null);
                     passwordTextField.clear();
                     userTypeComboBox.setItems(null);
                     emailTextField.clear();
                     phoneNumberTextField.clear();
                     addressTextField.clear();
                     dobDatePicker.setValue(null);
         }     
       
    

    
    
    
    private void backLoginSceneOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    
    
    
    
    
    
    
    private void lineWorkerAndShow() throws IOException {
         if (selectNameComboBox.getValue().isEmpty()
               ||  selectIdComboBox.getValue()== null
                || passwordTextField.getText().isEmpty() 
                || userTypeComboBox.getValue().isEmpty()
                || emailTextField.getText().isEmpty()
                 || phoneNumberTextField.getText().isEmpty()
                
                 || addressTextField.getText().isEmpty()
                || dobDatePicker.getValue()== null){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i;
             i = new User(
                     selectNameComboBox.getValue(),
                     selectIdComboBox.getValue(),
                     passwordTextField.getText(),
                     userTypeComboBox.getValue(),
                     emailTextField.getText(),
                     Integer.parseInt(phoneNumberTextField.getText()),
                     addressTextField.getText(),
                     dobDatePicker.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("AssemblyLineWorkerData.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(HumanResourceManagerCreateUserSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(HumanResourceManagerCreateUserSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    
    
    
    private void FinanceManagerAndShow() throws IOException {
         if (selectNameComboBox.getValue().isEmpty()
               ||  selectIdComboBox.getValue()== null
                || passwordTextField.getText().isEmpty() 
                || userTypeComboBox.getValue().isEmpty()
                || emailTextField.getText().isEmpty()
                 || phoneNumberTextField.getText().isEmpty()
                
                 || addressTextField.getText().isEmpty()
                || dobDatePicker.getValue()== null){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i = new User(
                selectNameComboBox.getValue(),
                     selectIdComboBox.getValue(),
                     passwordTextField.getText(),
                     userTypeComboBox.getValue(),
                     emailTextField.getText(),
                     Integer.parseInt(phoneNumberTextField.getText()),
                     addressTextField.getText(),
                     dobDatePicker.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("FinanceManagerData.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(HumanResourceManagerCreateUserSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(HumanResourceManagerCreateUserSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    
    
    
    private void ManagingDirectorAndShow() throws IOException {
         if (selectNameComboBox.getValue().isEmpty()
               ||  selectIdComboBox.getValue()== null
                || passwordTextField.getText().isEmpty() 
                || userTypeComboBox.getValue().isEmpty()
                || emailTextField.getText().isEmpty()
                 || phoneNumberTextField.getText().isEmpty()
                
                 || addressTextField.getText().isEmpty()
                || dobDatePicker.getValue()== null){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i = new User(
               selectNameComboBox.getValue(),
                     selectIdComboBox.getValue(),
                     passwordTextField.getText(),
                     userTypeComboBox.getValue(),
                     emailTextField.getText(),
                     Integer.parseInt(phoneNumberTextField.getText()),
                     addressTextField.getText(),
                     dobDatePicker.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("ManagingDirectorData.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(HumanResourceManagerCreateUserSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(HumanResourceManagerCreateUserSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    
    
    
    
    private void SupplierAndShow() throws IOException {
         if (selectNameComboBox.getValue().isEmpty()
               ||  selectIdComboBox.getValue()== null
                || passwordTextField.getText().isEmpty() 
                || userTypeComboBox.getValue().isEmpty()
                || emailTextField.getText().isEmpty()
                 || phoneNumberTextField.getText().isEmpty()
                
                 || addressTextField.getText().isEmpty()
                || dobDatePicker.getValue()== null){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i = new User(
                selectNameComboBox.getValue(),
                     selectIdComboBox.getValue(),
                     passwordTextField.getText(),
                     userTypeComboBox.getValue(),
                     emailTextField.getText(),
                     Integer.parseInt(phoneNumberTextField.getText()),
                     addressTextField.getText(),
                     dobDatePicker.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("SuppilerData.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(HumanResourceManagerCreateUserSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(HumanResourceManagerCreateUserSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    
    
    
    private void productionManagerAndShow() throws IOException {
         if (selectNameComboBox.getValue().isEmpty()
               ||  selectIdComboBox.getValue()== null
                || passwordTextField.getText().isEmpty() 
                || userTypeComboBox.getValue().isEmpty()
                || emailTextField.getText().isEmpty()
                 || phoneNumberTextField.getText().isEmpty()
                
                 || addressTextField.getText().isEmpty()
                || dobDatePicker.getValue()== null){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i = new User(
                selectNameComboBox.getValue(),
                     selectIdComboBox.getValue(),
                     passwordTextField.getText(),
                     userTypeComboBox.getValue(),
                     emailTextField.getText(),
                     Integer.parseInt(phoneNumberTextField.getText()),
                     addressTextField.getText(),
                     dobDatePicker.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("ProductionManagerData.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(HumanResourceManagerCreateUserSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(HumanResourceManagerCreateUserSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    
    
    
    
    private void supplyChainManagerAndShow() throws IOException {
         if (selectNameComboBox.getValue().isEmpty()
               ||  selectIdComboBox.getValue()== null
                || passwordTextField.getText().isEmpty() 
                || userTypeComboBox.getValue().isEmpty()
                || emailTextField.getText().isEmpty()
                 || phoneNumberTextField.getText().isEmpty()
                
                 || addressTextField.getText().isEmpty()
                || dobDatePicker.getValue()== null){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i = new User( selectNameComboBox.getValue(),
                     selectIdComboBox.getValue(),
                     passwordTextField.getText(),
                     userTypeComboBox.getValue(),
                     emailTextField.getText(),
                     Integer.parseInt(phoneNumberTextField.getText()),
                     addressTextField.getText(),
                     dobDatePicker.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("SupplyChainManagerData.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(HumanResourceManagerCreateUserSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(HumanResourceManagerCreateUserSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    
    
    
    

    

    @FXML
    private void loadNameAndIdButtonONMouseClicked(ActionEvent event) {
        String filePath = "NewJoining.bin";

    // Initialize an observable list to store supplier names
    ObservableList<String> userNames = FXCollections.observableArrayList();
    ObservableList<Integer> userID = FXCollections.observableArrayList();

    try (FileInputStream fis = new FileInputStream(filePath);
         ObjectInputStream ois = new ObjectInputStream(fis)) {
        // Read SupplierInformation objects from the binary file until EOF
        while (true) {
            NewJoining newJoiningList = (NewJoining) ois.readObject();
            // Add the supplier name to the observable list
            userNames.add(newJoiningList.getName());
            userID.add(newJoiningList.getUniqueid());
        }
    } catch (EOFException e) {
        // Reached end of file
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    
    selectNameComboBox.setItems(userNames);
    selectIdComboBox.setItems(userID);
    }

        
    }


