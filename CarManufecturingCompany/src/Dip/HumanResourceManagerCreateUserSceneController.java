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
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private TableColumn<NewJoining, String> designationTC;
    private ArrayList<NewJoining> newjoiningArr;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField IDTextField;
//    private DatePicker dobDatePicker1;
    Integer index;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll(
                "Assembly Line Worker",
                "Finance Manager",
                "Managing Director",
                "Supplier",
                "Supply Chain Manager",
                "Human Resource Manager",
                "Production Manager");
        
        
    }
    @FXML
    private void getRowItrems(MouseEvent event) {
        index = newJoiningTV.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        nameTextField.setText(nameTC.getCellData(index).toString());
        IDTextField.setText(idTC.getCellData(index).toString());
        LocalDate dateOfBirth = (LocalDate) dateOfBirthTC.getCellData(index);
        if (dateOfBirth != null) {
            dobDatePicker.setValue(dateOfBirth);
    }
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
            assemblyLineWorkerAndShow();
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Your account has been created successfully");
            a1.showAndWait();
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerCreateUserScene.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();                                         
        }   
        else if(userTypeComboBox.getValue().equals("Finance Manager")){
            financeManagerAndShow(); 
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Your account has been created successfully");
            a1.showAndWait();
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerCreateUserScene.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
        }
        else if(userTypeComboBox.getValue().equals("Managing Director")){
            managingDirectorAndShow();
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Your account has been created successfully");
            a1.showAndWait();
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerCreateUserScene.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
        }
        else if(userTypeComboBox.getValue().equals("Supplier")){
            supplierAndShow();
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Your account has been created successfully");
            a1.showAndWait();
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerCreateUserScene.fxml"));
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
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerHireAndDismissSceneController.fxml"));
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
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerCreateUserScene.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
        }
        else if(userTypeComboBox.getValue().equals("Human Resource Manager")){
            humanResourceManagerAndShow();
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Your account has been created successfully");
            a1.showAndWait();
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerCreateUserScene.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
        
        }
        else {
            Alert a2 = new Alert(Alert.AlertType.WARNING);
            a2.setTitle("Warning ");
            a2.setHeaderText("LogIn Failed");
//            a2.setContentText("Wrong ID/Password");
            a2.setContentText("Wrong ID/Password. Please Try Again");
            a2.showAndWait();
        }}    
       
    

    
    
    
    private void backLoginSceneOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerCreateUserScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    
    
    
    
    
    
    
    private void assemblyLineWorkerAndShow() throws IOException {
         if (nameTextField.getText().isEmpty() 
                || IDTextField.getText().isEmpty() 
                || passwordTextField.getText().isEmpty() 
                || dobDatePicker.getValue() == null ){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i = new User(nameTextField.getText(),
                    Integer.parseInt(IDTextField.getText()),
                    passwordTextField.getText(),
               dobDatePicker.getValue(),
                    userTypeComboBox.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Assembly Line Worker.bin");
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
    
    
    
    private void financeManagerAndShow() throws IOException {
         if (nameTextField.getText().isEmpty() 
                || IDTextField.getText().isEmpty() 
                || passwordTextField.getText().isEmpty() 
                || dobDatePicker.getValue() == null ){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i = new User(nameTextField.getText(),
                    Integer.parseInt(IDTextField.getText()),
                    passwordTextField.getText(),
                    dobDatePicker.getValue(),
                    userTypeComboBox.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Finance Manager.bin");
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
    
    
    
    private void managingDirectorAndShow() throws IOException {
         if (nameTextField.getText().isEmpty() 
                || IDTextField.getText().isEmpty() 
                || passwordTextField.getText().isEmpty() 
                || dobDatePicker.getValue() == null ){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i = new User(nameTextField.getText(),
                    Integer.parseInt(IDTextField.getText()),
                    passwordTextField.getText(),
                    dobDatePicker.getValue(),
                    userTypeComboBox.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Managing Director.bin");
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
    
    
    
    
    private void supplierAndShow() throws IOException {
         if (nameTextField.getText().isEmpty() 
                || IDTextField.getText().isEmpty() 
                || passwordTextField.getText().isEmpty() 
                || dobDatePicker.getValue() == null ){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i = new User(nameTextField.getText(),
                    Integer.parseInt(IDTextField.getText()),
                    passwordTextField.getText(),
                    dobDatePicker.getValue(),
                    userTypeComboBox.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Supplier.bin");
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
         if (nameTextField.getText().isEmpty() 
                || IDTextField.getText().isEmpty() 
                || passwordTextField.getText().isEmpty() 
                || dobDatePicker.getValue() == null ){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i = new User(nameTextField.getText(),
                    Integer.parseInt(IDTextField.getText()),
                    passwordTextField.getText(),
                    dobDatePicker.getValue(),
                    userTypeComboBox.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Production Manager.bin");
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
         if (nameTextField.getText().isEmpty() 
                || IDTextField.getText().isEmpty() 
                || passwordTextField.getText().isEmpty() 
                || dobDatePicker.getValue() == null ){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i = new User(nameTextField.getText(),
                    Integer.parseInt(IDTextField.getText()),
                    passwordTextField.getText(),
                    dobDatePicker.getValue(),
                    userTypeComboBox.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Supply Chain Manager.bin");
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
    
    
    
    
    private void humanResourceManagerAndShow() throws IOException {
         if (nameTextField.getText().isEmpty() 
                || IDTextField.getText().isEmpty() 
                || passwordTextField.getText().isEmpty() 
                || dobDatePicker.getValue() == null ){
            // Show notification to user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {          
       User i = new User(nameTextField.getText(),
                    Integer.parseInt(IDTextField.getText()),
                    passwordTextField.getText(),
                    dobDatePicker.getValue(),
                    userTypeComboBox.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Human Resource Manager.bin");
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
    private void loadbuttonOnClick(ActionEvent event) {
        ObservableList<NewJoining> newjoiningArr = FXCollections.observableArrayList();
        idTC.setCellValueFactory(new PropertyValueFactory<NewJoining, Integer>("uniqueid"));
        nameTC.setCellValueFactory(new PropertyValueFactory<NewJoining, String>("name"));
        genderTC.setCellValueFactory(new PropertyValueFactory<NewJoining, String>("gender"));
        dateOfBirthTC.setCellValueFactory(new PropertyValueFactory<NewJoining, LocalDate>("dob"));
        dateOfJoinTC.setCellValueFactory(new PropertyValueFactory<NewJoining, LocalDate>("doj"));
        designationTC.setCellValueFactory(new PropertyValueFactory<NewJoining, String>("designation"));


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


