/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package srbshakib;

import Dip.AppendableObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import srbshakib.SupplyChainManager.Inventory;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class ShowInventorySceneController implements Initializable {

    @FXML
    private TableView<Inventory> partsTableView;
    @FXML
    private TableColumn<Inventory, String> carTypeTableColumn;
    @FXML
    private TableColumn<Inventory, String> carModelTableColumn;
    @FXML
    private TableColumn<Inventory, String> nameOfPartsTableColumn;
    @FXML
    private TableColumn<Inventory, Integer> availabilityTableColumn;
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
    private void homeButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AssemblyLineWorkerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Assembly Line Worker Dashboard");
        window.show();
        
    }

    @FXML
    private void assignedTaskButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AssignedTaskSecne.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Assigned Task");
        window.show();
    }

    @FXML
    private void inventoryButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ShowInventoryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Inventory");
        window.show();
    }

    @FXML
    private void instructionsButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AssemblingInsturctionScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Instructions");
        window.show();
    }

    @FXML
    private void leaveApplicationButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AskLeaveScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Ask Leave");
        window.show();
    }

    @FXML
    private void traingButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("CheckTrainingScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Training");
        window.show();
    }

    @FXML
    private void flagReportButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("FlagAReportSecne.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Flag Report");
        window.show();
    }

    @FXML
    private void checkScheduleButtonOnMuseClicked(ActionEvent event) throws IOException {
       Parent mainParent = FXMLLoader.load(getClass().getResource("CheckScheduleScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Schedule");
        window.show();
    }


    @FXML
    private void viewCarsButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ViewCarsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Cars");
        window.show();
    }

    @FXML
    private void loadPartsButtonOnMouseClicked(ActionEvent event) {
        ObservableList<Inventory> inventoryInfo = FXCollections.observableArrayList();

        carTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Inventory,String>("carType"));
        carModelTableColumn.setCellValueFactory(new PropertyValueFactory<Inventory,String>("carModel"));
        nameOfPartsTableColumn.setCellValueFactory(new PropertyValueFactory<Inventory, String>("nameOfParts"));
        availabilityTableColumn.setCellValueFactory(new PropertyValueFactory<Inventory, Integer>("numbersOfParts"));
        
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
        partsTableView.setItems(inventoryInfo);
        System.out.println(inventoryInfo.toString());
    }

    @FXML
    private void searchPartsOnMouseClicked(ActionEvent event) {
        String carModel = searchCarModelTextField.getText();
        ObservableList<Inventory> matchingInventory = searchInventoryByCarModel(carModel);
        // Clear existing items in the table
        partsTableView.getItems().clear();
        if (!matchingInventory.isEmpty()) {
            partsTableView.setItems(matchingInventory);
        } else {
            // If no matching inventory found, display a message
            System.out.println("No inventory found for car model: " + carModel);
        }
    }

    // Method to search for inventory items by car model
    private ObservableList<Inventory> searchInventoryByCarModel(String carModel) {
        ObservableList<Inventory> matchingInventory = FXCollections.observableArrayList();
        try (FileInputStream fis = new FileInputStream("Inventory.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                Inventory inventory = (Inventory) ois.readObject();
                if (inventory.getCarModel().equals(carModel)) {
                    matchingInventory.add(inventory);
                }
            }
        } catch (EOFException e) {
            // Reached end of file
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return matchingInventory;
    }
    }
    

