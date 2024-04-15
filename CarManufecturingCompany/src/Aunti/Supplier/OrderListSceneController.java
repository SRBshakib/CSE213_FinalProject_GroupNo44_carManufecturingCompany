/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti.Supplier;
import java.io.File;
import java.io.FileInputStream;
import srbshakib.SupplyChainManager.OrderForSuppiler;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Collections;
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
public class OrderListSceneController implements Initializable {

    @FXML
    private TableView<OrderForSuppiler> orderInfoTableView;
    @FXML
    private TableColumn<OrderForSuppiler, Integer> orderCodeTableColumn;
    @FXML
    private TableColumn<OrderForSuppiler, String> supplierNameTableColumn;
    @FXML
    private TableColumn<OrderForSuppiler, String> productTableColumn;
    @FXML
    private TableColumn<OrderForSuppiler, Integer> quantityTableColumn;
    @FXML
    private TableColumn<OrderForSuppiler, Integer> paymentTableColumn;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void homeButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("SupplierDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("SupplierDashboard");
        window.show();
    }

    private void orderListButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("OrderListScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("OrderListScene");
        window.show();
    }

    private void ordersButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("OrdersScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("OrdersScene");
        window.show();
    }

    

    private void dueBillsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("DueBillsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("DueBillsScene");
        window.show();
    }


    private void paymentsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("PaymentsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("PaymentsScene");
        window.show();
    }

    private void reviewButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ReviewScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("ReviewScene");
        window.show();
    }

    private void upcomingEventsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("UpcomingEventsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("UpcomingEventsScene");
        window.show();
    }

    private void makeDeliveryButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("MakeDeliveryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("MakeDeliveryScene");
        window.show();
    }

    private void orderHistoryButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("OrderHistoryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("OrderHistoryScene");
        window.show();
    }

    


    @FXML
    private void loadOrderInfoButtonOnMouseClicked(ActionEvent event) {
        ObservableList<OrderForSuppiler> supplierOrderListInfo = FXCollections.observableArrayList();
        
        orderCodeTableColumn.setCellValueFactory(new PropertyValueFactory<OrderForSuppiler,Integer>("orderCode"));
        supplierNameTableColumn.setCellValueFactory(new PropertyValueFactory<OrderForSuppiler,String>("supplierName"));
        productTableColumn.setCellValueFactory(new PropertyValueFactory<OrderForSuppiler,String>("productName"));
        quantityTableColumn.setCellValueFactory(new PropertyValueFactory<OrderForSuppiler, Integer>("quantity"));
        paymentTableColumn.setCellValueFactory(new PropertyValueFactory<OrderForSuppiler, Integer>("payment"));
        
        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("OrderForSuppiler.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            OrderForSuppiler p;
            try {
                while (true) {
                    p = (OrderForSuppiler) ois.readObject();
                    supplierOrderListInfo.add(p);
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
        Collections.reverse(supplierOrderListInfo);
        orderInfoTableView.setItems(supplierOrderListInfo);
        System.out.println(supplierOrderListInfo.toString());
    }

    @FXML
    private void homeButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void trackLogisticsButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void orderButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void distribruteButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void orderHistoryButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void updateInventoryButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void customerOrderButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void supplierListButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void supplyHistoryButtonOnMuseClicked(ActionEvent event) {
    }
        
    }

    

