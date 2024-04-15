
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import Dip.EmployeeList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import srbshakib.User;

/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class SignUpSceneController implements Initializable {

    @FXML
    private TextField userIdTextfield;
    @FXML
    private PasswordField userPasswordPwfield;
    @FXML
    private ComboBox<String> userTypeComboBox;
    
    

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        userTypeComboBox.getItems().addAll("Assembly Line Worker","Finance Manager","Managing Director","Suppler","Supply Chain Manager","Customer","Production Manager");
    }    

    @FXML
    private void forgotPasswordOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void signInOnMouseClicked(ActionEvent event) {
        if(userTypeComboBox.getValue().equals("Assembly Line Worker")){
            File f = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;

        try {
            f = new File("AssemblyLineWorkerData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User p;
            try {
                while (true) {
                    p = (User) ois.readObject();
                    if (String.valueOf(p.getUserId()).equals(userIdTextfield.getText()) && p.getPassword().equals(userPasswordPwfield.getText())) {
                        Parent A = FXMLLoader.load(getClass().getResource("/srbshakib/AssemblyLineWorkerDashboardScene.fxml"));
                        Scene sceneA = new Scene(A);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(sceneA);                      
                        stage.show();
                    }else {
                        Alert();
                        }
                    
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
    }
        if(userTypeComboBox.getValue().equals("Finance Manager")){
            File f = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;

        try {
            f = new File("FinanceManagerData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User p;
            try {
                while (true) {
                    p = (User) ois.readObject();
                    if (String.valueOf(p.getUserId()).equals(userIdTextfield.getText()) && p.getPassword().equals(userPasswordPwfield.getText())) {
                        Parent A = FXMLLoader.load(getClass().getResource("/Rifat/ProducerDashboard.fxml"));
                        Scene sceneA = new Scene(A);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(sceneA);                      
                        stage.show();
                    }else {
                        Alert();
                        }
                    
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
    }
        if(userTypeComboBox.getValue().equals("Managing Director")){
            File f = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;

        try {
            f = new File("ManagingDirectorData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User p;
            try {
                while (true) {
                    p = (User) ois.readObject();
                    if (String.valueOf(p.getPhone()).equals(userIdTextfield.getText()) && p.getPassword().equals(userPasswordPwfield.getText())) {
                        Parent A = FXMLLoader.load(getClass().getResource("/Dip/ManagingDirectorDashboardScene.fxml"));
                        Scene sceneA = new Scene(A);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(sceneA);                      
                        stage.show();
                    }else {
                        Alert();
                        }
                    
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
    }
        if(userTypeComboBox.getValue().equals("Production Manager")){
            File f = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;

        try {
            f = new File("ProductionManagerData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User p;
            try {
                while (true) {
                    p = (User) ois.readObject();
                    if (String.valueOf(p.getUserId()).equals(userIdTextfield.getText()) && p.getPassword().equals(userPasswordPwfield.getText())) {
                        Parent A = FXMLLoader.load(getClass().getResource("/Rifat/ProductionManagerdashboardScene.fxml"));
                        Scene sceneA = new Scene(A);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(sceneA);                      
                        stage.show();
                    }else {
                        Alert();
                        }
                    
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
    }
        if(userTypeComboBox.getValue().equals("Suppler")){
            File f = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;

        try {
            f = new File("SuppilerData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User p;
            try {
                while (true) {
                    p = (User) ois.readObject();
                    if (String.valueOf(p.getUserId()).equals(userIdTextfield.getText()) && p.getPassword().equals(userPasswordPwfield.getText())) {
                        Parent A = FXMLLoader.load(getClass().getResource("/Aunti/supplier/SupplierDashboardScene.fxml"));
                        Scene sceneA = new Scene(A);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(sceneA);                      
                        stage.show();
                    }else {
                        Alert();
                        }
                    
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
    }
        if(userTypeComboBox.getValue().equals("Supply Chain Manager")){
            File f = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;

        try {
            f = new File("SupplyChainManagerData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User p;
            try {
                while (true) {
                    p = (User) ois.readObject();
                    if (String.valueOf(p.getUserId()).equals(userIdTextfield.getText()) && p.getPassword().equals(userPasswordPwfield.getText())) {
                        Parent A = FXMLLoader.load(getClass().getResource("/srbshakib/SupplyChainManager/SupplyChainManagerDashboardScene.fxml"));
                        Scene sceneA = new Scene(A);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(sceneA);                      
                        stage.show();
                    }else {
                        Alert();
                        }
                    
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
    }

        
    }
        
        
        
    

    @FXML
    private void registerAsCustomerOnMouseClicked(ActionEvent event) {
    }
    
    private void Alert(){
        Alert a2 = new Alert(Alert.AlertType.ERROR);
        a2.setTitle("Warning ");
        a2.setHeaderText("LogIn Failed");
        a2.setContentText("Wrong ID/Password. Please Try Again");
        a2.showAndWait();
        }
}