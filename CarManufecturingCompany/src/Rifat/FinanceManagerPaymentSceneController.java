/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;


import Dip.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Lenovo
 */

public class FinanceManagerPaymentSceneController implements Initializable {

    @FXML
    private TableColumn<Payment, String> totalPaymentTableColumn;
    @FXML
    private TableView<Payment> paymentTableView;
    @FXML
    private TableColumn<Payment, String> idTableColumn;
    @FXML
    private TableColumn<Payment, String> nameTableColumn;
    @FXML
    private TableColumn<Payment, String> designationTableColumn;
    @FXML
    private TableColumn<Payment, String> duePaymentTableColumn;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField totalPaymentTextField;
    @FXML
    private TextField duePaymentTextField;
    @FXML
    private TextField designationTextField;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/FinanceManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void submitButtonOnMouseClicked(ActionEvent event) {
        Payment i= new Payment(
              
                
                
                idTextField.getText(),
                nameTextField.getText(),
                designationTextField.getText(),
                totalPaymentTextField.getText(),
                duePaymentTextField.getText()
                
                
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("PaymentInfo.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(FinanceManagerPaymentSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(FinanceManagerPaymentSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        idTextField.clear();
        nameTextField.clear();
        designationTextField.clear();
        totalPaymentTextField.clear();
        duePaymentTextField.clear();
       
    }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        ObservableList<Payment> PaymentInfo = FXCollections.observableArrayList();
    
    


        

        idTableColumn.setCellValueFactory(new PropertyValueFactory<Payment,String>("id"));

        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Payment, String>("name"));
        
        
        designationTableColumn.setCellValueFactory(new PropertyValueFactory<Payment, String>("designation"));
        totalPaymentTableColumn.setCellValueFactory(new PropertyValueFactory<Payment, String>("totalPayment"));
        duePaymentTableColumn.setCellValueFactory(new PropertyValueFactory<Payment, String>("duePayment"));

        

        

        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("PaymentInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Payment p;
            try {
                while (true) {
                    p = (Payment) ois.readObject();
                    PaymentInfo.add(p);
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
        paymentTableView.setItems(PaymentInfo);
        System.out.println(PaymentInfo.toString());
    }


    
}
