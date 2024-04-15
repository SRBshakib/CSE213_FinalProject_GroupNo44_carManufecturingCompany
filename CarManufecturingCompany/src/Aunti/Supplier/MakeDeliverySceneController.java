/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti.Supplier;


import Dip.AppendableObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import srbshakib.SupplyChainManager.OrderForSuppiler;
     
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MakeDeliverySceneController implements Initializable {

    @FXML
    private ComboBox<String> selectProductTypeComboBox;
    @FXML
    private TextField unitPriceTextField;
    @FXML
    private TextField shipmentTextField;
    @FXML
    private DatePicker estimatedDeliveryDateDatePicker;
    @FXML
    private TableView<MakeDelivery> makeDeliveryTableView;
    @FXML
    private TableColumn<MakeDelivery, Integer> orderCodeTableColumn;
    @FXML
    private TableColumn<MakeDelivery, String> productNameTableColumn;
    @FXML
    private TableColumn<MakeDelivery, Integer> unitPriceTableColumn;
    @FXML
    private TableColumn<MakeDelivery, String> shipmentTableColumn;
    @FXML
    private TableColumn<MakeDelivery, LocalDate> eddTableColumn;
    @FXML
    private TableColumn<MakeDelivery, Integer> totalPriceTableColumn;
    @FXML
    private TableColumn<MakeDelivery, Integer> quantityTableColumn;
    @FXML
    private ComboBox<Integer> orderCodeComboBox;
    @FXML
    private ComboBox<Integer> quantityComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
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
    private void loadInformationButtonOnMouseClicked(ActionEvent event) {
        ObservableList<MakeDelivery>MakeDeliveryInfo = FXCollections.observableArrayList();

        orderCodeTableColumn.setCellValueFactory(new PropertyValueFactory<MakeDelivery,Integer>("orderCode"));
        productNameTableColumn.setCellValueFactory(new PropertyValueFactory<MakeDelivery,String>("productName"));
        quantityTableColumn.setCellValueFactory(new PropertyValueFactory<MakeDelivery, Integer>("quantity"));
        unitPriceTableColumn.setCellValueFactory(new PropertyValueFactory<MakeDelivery, Integer>("unitPrice"));
        shipmentTableColumn.setCellValueFactory(new PropertyValueFactory<MakeDelivery, String>("shipment"));
        eddTableColumn.setCellValueFactory(new PropertyValueFactory<MakeDelivery, LocalDate>("edd"));
        //totalPriceTableColumn.setCellValueFactory(new PropertyValueFactory<MakeDelivery, Integer>("totalPrice"));
        File f = null; 
        FileInputStream fis = null; 
        ObjectInputStream ois = null;

        try {
            f = new File("MakeDelivery.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            MakeDelivery p;
            try {
                while (true) {
                    p = (MakeDelivery) ois.readObject();
                    MakeDeliveryInfo.add(p);
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
        makeDeliveryTableView.setItems(MakeDeliveryInfo);
        System.out.println(MakeDeliveryInfo.toString());
    

    }

    @FXML
    private void deliveryButtonOnMouseClicked(ActionEvent event) {

        MakeDelivery i= new MakeDelivery(
                orderCodeComboBox.getValue(),
                selectProductTypeComboBox.getValue(),
                quantityComboBox.getValue(),
                Integer.parseInt(unitPriceTextField.getText()),
                shipmentTextField.getText(),
                estimatedDeliveryDateDatePicker.getValue()
      
                
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("MakeDelivery.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(MakeDeliverySceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(MakeDeliverySceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        orderCodeComboBox.setValue(null);
        selectProductTypeComboBox.setValue(null);
        quantityComboBox.setValue(null);
        unitPriceTextField.clear();
        shipmentTextField.clear();
        estimatedDeliveryDateDatePicker.setValue(null);

    }

    @FXML
    private void loadOrderCodeAndProductButtonOnMouseClicked(ActionEvent event) {

        String filePath = "OrderForSuppiler.bin";



    // Initialize observable lists to store order details
    ObservableList<Integer> orderCodes = FXCollections.observableArrayList();
    ObservableList<String> productNames = FXCollections.observableArrayList();
    ObservableList<Integer> quantities = FXCollections.observableArrayList();

    ObservableList<String> payment = FXCollections.observableArrayList();


    try (FileInputStream fis = new FileInputStream(filePath);
         ObjectInputStream ois = new ObjectInputStream(fis)) {

        // Read SupplierInformation objects from the binary file until EOF
        while (true) {
            try {
                OrderForSuppiler supplierOrder = (OrderForSuppiler) ois.readObject();
                orderCodes.add(supplierOrder.getOrderCode());
                productNames.add(supplierOrder.getProductName());
                quantities.add(supplierOrder.getQuantity());
            } catch (EOFException e) {
                break; // Break the loop when end of file is reached
            }
        }
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    // Now you can use 'orderCodes', 'productNames', and 'quantities' to set the items of your ComboBoxes
    orderCodeComboBox.setItems(orderCodes);
    selectProductTypeComboBox.setItems(productNames);
    quantityComboBox.setItems(quantities);
    

    
}

}
