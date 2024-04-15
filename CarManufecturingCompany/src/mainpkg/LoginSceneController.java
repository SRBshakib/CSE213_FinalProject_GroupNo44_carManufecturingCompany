/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
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
 * @author DIPAYON
 */
public class LoginSceneController implements Initializable {

    @FXML
    private TextField userIdTextfield;
    @FXML
    private PasswordField userPasswordPwfield;
    @FXML
    private ComboBox<String> userTypeComboBox;

    /**
     * Initializes the controller class.
     */
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
        // TODO
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
            f = new File("Assembly Line Worker.bin");
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
            f = new File("Finance Manager.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User p;
            try {
                while (true) {
                    p = (User) ois.readObject();
                    if (String.valueOf(p.getUserId()).equals(userIdTextfield.getText()) && p.getPassword().equals(userPasswordPwfield.getText())) {
                        Parent A = FXMLLoader.load(getClass().getResource("/Rifat/FinanceManagerDashboardScene.fxml"));
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
            f = new File("Managing Director.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User p;
            try {
                while (true) {
                    p = (User) ois.readObject();
                    if (String.valueOf(p.getUserId()).equals(userIdTextfield.getText()) && p.getPassword().equals(userPasswordPwfield.getText())) {
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
            f = new File("Production Manager.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User p;
            try {
                while (true) {
                    p = (User) ois.readObject();
                    if (String.valueOf(p.getUserId()).equals(userIdTextfield.getText()) && p.getPassword().equals(userPasswordPwfield.getText())) {
                        Parent A = FXMLLoader.load(getClass().getResource("/Rifat/ProductionManagerDashboardScene.fxml"));
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
        if(userTypeComboBox.getValue().equals("Supplier")){
            File f = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;

        try {
            f = new File("Supplier.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User p;
            try {
                while (true) {
                    p = (User) ois.readObject();
                    if (String.valueOf(p.getUserId()).equals
        (userIdTextfield.getText()) && p.getPassword().equals(userPasswordPwfield.getText())) {
                        Parent A = FXMLLoader.load(getClass().getResource("/Aunti.Supplier/SupplierDashboardScene.fxml"));
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
        if(userTypeComboBox.getValue().equals("Human Resource Manager")){
            File f = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;

        try {
            f = new File("Human Resource Manager.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User p;
            try {
                while (true) {
                    p = (User) ois.readObject();
                    if (String.valueOf(p.getUserId()).equals(userIdTextfield.getText()) && p.getPassword().equals(userPasswordPwfield.getText())) {
                        Parent A = FXMLLoader.load(getClass().getResource("/Dip/HumanResourceManagerCreateUserScene.fxml"));
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
            f = new File("Supply Chain Manager.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User p;
            try {
                while (true) {
                    p = (User) ois.readObject();
                    if (String.valueOf(p.getUserId()).equals(userIdTextfield.getText()) && p.getPassword().equals(userPasswordPwfield.getText())) {
                        Parent A = FXMLLoader.load(getClass().getResource("/srbshakib.SupplyChainManager/SupplyChainManagerDashboardScene.fxml"));
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
    }}}

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
