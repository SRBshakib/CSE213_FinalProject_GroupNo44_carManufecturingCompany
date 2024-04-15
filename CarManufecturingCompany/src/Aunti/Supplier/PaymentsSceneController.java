/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti.Supplier;


import Dip.AppendableObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.URL;
import java.time.LocalDate;
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

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import srbshakib.SupplyChainManager.OrderForSuppiler;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class PaymentsSceneController implements Initializable {

    @FXML
    private TableView<Payment> paymentListTableView;
    @FXML
    private TableColumn<Payment, String> paymentTypeTableColumn;
    @FXML
    private ComboBox<String> paymentTypeComboBox;
    @FXML
    private TableColumn<Payment, Integer> orderCodeTableColumn;
    @FXML
    private ComboBox<Integer> orderCodeComboBox;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       paymentTypeComboBox.getItems().addAll("Done","Half Done","Due");
    }    

    @FXML
    private void homeButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("SupplierDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("SupplierDashboard");
        window.show();
    }

    @FXML
    private void orderListButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("OrderListScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("OrderListScene");
        window.show();
    }

    @FXML
    private void ordersButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("OrdersScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("OrdersScene");
        window.show();
    }

    


    @FXML
    private void dueBillsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("DueBillsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("DueBillsScene");
        window.show();
    }



    @FXML

    private void paymentsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("PaymentsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("PaymentsScene");
        window.show();
    }


    @FXML

    private void reviewButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ReviewScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("ReviewScene");

        window.show();
    }

    @FXML

    private void upcomingEventsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("UpcomingEventsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("UpcomingEventsScene");

        window.show();
    }

    @FXML

    private void makeDeliveryButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("MakeDeliveryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("MakeDeliveryScene");

        window.show();
    }

    @FXML

    private void loadPaymentListButtonOnMouseClicked(ActionEvent event) {
        ObservableList<Payment>PaymentInfo = FXCollections.observableArrayList();

        orderCodeTableColumn.setCellValueFactory(new PropertyValueFactory<Payment,Integer>("orderCode"));
        paymentTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Payment,String>("paymentType"));
        File f = null; 
        FileInputStream fis = null; 
        ObjectInputStream ois = null;

        try {
            f = new File("Payment.bin");
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
        paymentListTableView.setItems(PaymentInfo);
        System.out.println(PaymentInfo.toString());
    
        
    
    
    
}

    @FXML
    private void loadOrderCodeButtonOnMouseClicked(ActionEvent event) {
        String filePath = "OrderForSuppiler.bin";

    // Initialize observable lists to store order details
    ObservableList<Integer> orderCodes = FXCollections.observableArrayList();
    

    try (FileInputStream fis = new FileInputStream(filePath);
         ObjectInputStream ois = new ObjectInputStream(fis)) {

        // Read SupplierInformation objects from the binary file until EOF
        while (true) {
            try {
                OrderForSuppiler supplierOrder = (OrderForSuppiler) ois.readObject();
                orderCodes.add(supplierOrder.getOrderCode());
                
            } catch (EOFException e) {
                break; // Break the loop when end of file is reached
            }
        }
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();

    }

    // Now you can use 'orderCodes', 'productNames', and 'quantities' to set the items of your ComboBoxes
    orderCodeComboBox.setItems(orderCodes);
    
    
    
}

    @FXML
    private void submitButtonOnMouseClicked(ActionEvent event) {
            Payment i= new Payment(
                orderCodeComboBox.getValue(),
                paymentTypeComboBox.getValue()
      
                
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Payment.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(PaymentsSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(PaymentsSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        orderCodeComboBox.setValue(null);
        paymentTypeComboBox.setValue(null);
        
    }
}

        
    
    

