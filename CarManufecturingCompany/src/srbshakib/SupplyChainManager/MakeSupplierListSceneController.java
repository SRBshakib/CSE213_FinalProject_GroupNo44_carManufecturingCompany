/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package srbshakib.SupplyChainManager;


import java.util.concurrent.atomic.AtomicInteger;

import Dip.AppendableObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import srbshakib.SupplyChainManager.SupplierInformation;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class MakeSupplierListSceneController implements Initializable {

    @FXML
    private TextField suppilerNameTextField;
    @FXML
    private TableView<SupplierInformation> supplierInformationTableView;
    @FXML
    private TableColumn<SupplierInformation, String> supplierNameTableColumn;
    @FXML
    private TableColumn<SupplierInformation, String> deliveryTypeTableColumn;
    @FXML
    private TableColumn<SupplierInformation, Integer> mobileNoTableColumn;
    @FXML
    private TableColumn<SupplierInformation, String> emailTableColumn;
    @FXML
    private TextField mobileNoTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField searchTextField;
    @FXML
    private TextField addCountryTextField;



    @FXML
    private ComboBox<String> selectCountryComboBox;
    @FXML
    private ComboBox<String> deliveryTypeComboBox;
    @FXML
    private TableColumn<SupplierInformation, Integer> idTableColumn;
    @FXML
    private TableColumn<SupplierInformation, String> countryTableColumn;

    
    
    private static int idCounter = 9000;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deliveryTypeComboBox.getItems().addAll("Standard", "Express");
        selectCountryComboBox.getItems().addAll("China","Bangladesh","India","Malaysia");
       
        
    }    
     
    @FXML
    private void homeButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("SupplyChainManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Assigned Task");
        window.show();
    }


    private void inventoryButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ShowInventoryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Update Inventory");
        window.show();
    }
   

    @FXML
    private void trackLogisticsButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("TrackLogisticsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Track Logistics");
        window.show();
    }

    @FXML
    private void orderButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("SupplierOrderScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Order");
        window.show();
    }


    @FXML
    private void distribruteButtonOnMuseClicked(ActionEvent event) throws IOException {

        Parent mainParent = FXMLLoader.load(getClass().getResource("DistributeOrderScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Distribute");
        window.show();
    }

    @FXML
    private void orderHistoryButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("OrderHistoryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Order History");
        window.show();
    }

    @FXML
    private void updateInventoryButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("MakeInventoryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Update Inventroy");
        window.show();
    }

    @FXML
    private void customerOrderButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("CustomerOrderSecne.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Customer Order");
        window.show();
    }

    @FXML
    private void supplierListButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("MakeSupplierListScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Supplier List");
        window.show();
    }

    @FXML
    private void supplyHistoryButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("SupplyHistoryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Supply History");
        window.show();
    }

    @FXML
    private void submitButtonOnMouseClicked(ActionEvent event) {

        SupplierInformation i = new SupplierInformation(
                
                generateUniqueId(),
                suppilerNameTextField.getText(),
                selectCountryComboBox.getValue(),
                deliveryTypeComboBox.getValue(),
                emailTextField.getText(),
                Integer.parseInt(mobileNoTextField.getText())
                
                
        );
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("SupplierList.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(MakeSupplierListSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(MakeSupplierListSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
                suppilerNameTextField.clear();
                selectCountryComboBox.setValue(null);
                deliveryTypeComboBox.setValue(null);
                emailTextField.clear();
                mobileNoTextField.clear();
    }
     private int generateUniqueId() {
        return ++idCounter; // Increment the ID counter and return
    }

    private void saveSupplierInformation(SupplierInformation supplier) {
        try (FileOutputStream fos = new FileOutputStream("SupplierList.bin", true);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(supplier);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void loadInformationButtonOnMouseClicked(ActionEvent event) {
        ObservableList<SupplierInformation> supplierListInfo = FXCollections.observableArrayList();
        
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        supplierNameTableColumn.setCellValueFactory(new PropertyValueFactory<SupplierInformation,String>("supplierName"));
        countryTableColumn.setCellValueFactory(new PropertyValueFactory<SupplierInformation,String>("country"));
        deliveryTypeTableColumn.setCellValueFactory(new PropertyValueFactory<SupplierInformation, String>("deliveryType"));
        mobileNoTableColumn.setCellValueFactory(new PropertyValueFactory<SupplierInformation, Integer>("mobileNo"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<SupplierInformation, String>("email"));

        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("SupplierList.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            SupplierInformation p;
            try {
                while (true) {
                    p = (SupplierInformation) ois.readObject();
                    supplierListInfo.add(p);
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
        supplierInformationTableView.setItems(supplierListInfo);
        System.out.println(supplierListInfo.toString());
    }
    

    @FXML
    private void searchButtonOnMouseClicked(ActionEvent event) {
//        String supplierList = searchTextField.getText();
//        ObservableList<SupplierInformation> matchingName = searchSupplierListByName(supplierList);
//        // Clear existing items in the table
//        supplierInformationTableView.getItems().clear();
//        if (!matchingName.isEmpty()) {
//            supplierInformationTableView.setItems(mmatchingName);
//        } else {
//            // If no matching inventory found, display a message
//            System.out.println("No inventory found for car model: " + supplierList);
//        }
//    }
//
//    // Method to search for inventory items by car model
//    private ObservableList<Inventory> searchSupplierListByName(String carModel) {
//        ObservableList<Inventory> matchingInventory = FXCollections.observableArrayList();
//        try (FileInputStream fis = new FileInputStream("Inventory.bin");
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            while (true) {
//                Inventory inventory = (Inventory) ois.readObject();
//                if (inventory.getCarModel().equals(carModel)) {
//                    matchingInventory.add(inventory);
//                }
//            }
//        } catch (EOFException e) {
//            // Reached end of file
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return matchingInventory;
    }
    
    @FXML
    private void addCountryButtonOnMouseClicked(ActionEvent event) {
        String newCountry = addCountryTextField.getText(); // Get text from TextField
        if (!selectCountryComboBox.getItems().contains(newCountry)) {
        selectCountryComboBox.getItems().add(newCountry); // Add text to ComboBox if it's not already there
    }
        addCountryTextField.clear();

     }


    
}
