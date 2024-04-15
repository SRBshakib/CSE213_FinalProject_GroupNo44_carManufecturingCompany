/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import srbshakib.SupplyChainManager.Inventory;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class ManagingDirectorInventoryCheckSceneController implements Initializable {

    @FXML
    private TableView<Inventory> partsCheckTableView;
    @FXML
    private TableColumn<Inventory, String> carTypeTC;
    @FXML
    private TableColumn<Inventory, String> carModelTC;
    @FXML
    private TableColumn<Inventory, String> nameOfPartsTC;
    @FXML
    private TableColumn<Inventory, Integer> availabilityTC;
    @FXML
    private TextField searchCarModelTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ManagingDirectorDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void loadPartsButtonOnClicked(ActionEvent event) {
        ObservableList<Inventory> inventoryInfo = FXCollections.observableArrayList();

        carTypeTC.setCellValueFactory(new PropertyValueFactory<Inventory, String>("carType"));
        carModelTC.setCellValueFactory(new PropertyValueFactory<Inventory, String>("carModel"));
        nameOfPartsTC.setCellValueFactory(new PropertyValueFactory<Inventory, String>("nameOfParts"));
        availabilityTC.setCellValueFactory(new PropertyValueFactory<Inventory, Integer>("numbersOfParts"));

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Inventory.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Inventory p;
            try {
                while (true) {
                    p = (Inventory) ois.readObject();
                    inventoryInfo.add(p);
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
        partsCheckTableView.setItems(inventoryInfo);
        System.out.println("Inventory List Loaded Succesfully");
    }

    @FXML
    private void searchPartsOnClicked(ActionEvent event) {
        
            String carModel = searchCarModelTextField.getText();
            ObservableList<Inventory> matchingInventoryData = searchInventoryByCarModel(carModel);
            // Clear existing items in the table
            partsCheckTableView.getItems().clear();
            if (!matchingInventoryData.isEmpty()) {
                partsCheckTableView.setItems(matchingInventoryData);
            } else {
                // If no matching inventory found, display a message
                System.out.println("No inventory found for car model: " + carModel);
            }
        }
    

    // Method to search for inventory items by car model
    private ObservableList<Inventory> searchInventoryByCarModel(String carModel) {
        ObservableList<Inventory> matchingInventoryData = FXCollections.observableArrayList();
        try (FileInputStream fis = new FileInputStream("Inventory.bin"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                Inventory inventory = (Inventory) ois.readObject();
                if (inventory.getCarModel().equals(carModel)) {
                    matchingInventoryData.add(inventory);
                }
            }
        } catch (EOFException e) {
            // Reached end of file
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return matchingInventoryData;

    }

}