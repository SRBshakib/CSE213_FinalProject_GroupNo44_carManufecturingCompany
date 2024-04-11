/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti.Supplier;

import java.io.EOFException;
import srbshakib.SupplyChainManager.OrderForSuppiler;
     
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import srbshakib.SupplyChainManager.SupplierInformation;

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
    }

    @FXML
    private void deliveryButtonOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void loadOrderCodeAndProductButtonOnMouseClicked(ActionEvent event) {
        String filePath = "OrderForSupplier.bin";

    // Initialize an observable list to store supplier names
    ObservableList<Integer> orderCodes = FXCollections.observableArrayList();
    ObservableList<String> productNames = FXCollections.observableArrayList();
    ObservableList<Integer> quantitys = FXCollections.observableArrayList();

    try (FileInputStream fis = new FileInputStream(filePath);
         ObjectInputStream ois = new ObjectInputStream(fis)) {
        // Read SupplierInformation objects from the binary file until EOF
        while (true) {
            OrderForSuppiler supplierOrder = (OrderForSuppiler) ois.readObject();
            // Add the supplier name to the observable list
            orderCodes.add(supplierOrder.getOrderCode());
            productNames.add(supplierOrder.getProductName());
            quantitys.add(supplierOrder.getQuantity());
            
        }
    } catch (EOFException e) {
        // Reached end of file
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    // Now you can use 'supplierNames' to set the items of your ComboBox
    orderCodeComboBox.setItems(orderCodes);
    selectProductTypeComboBox.setItems(productNames);
    quantityComboBox.setItems(quantitys);
    }
    
    
}
