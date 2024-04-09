/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package srbshakib.SupplyChainManager;

import Dip.AppendableObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class MakeInventorySceneController implements Initializable {

    @FXML
    private ComboBox<String> selectPartsForInventoryComboBox;
    @FXML
    private ComboBox<Integer> numberOfPartsAvailableComboBox;
    @FXML
    private TableView<Inventory> partsTableView;
    @FXML
    private TableColumn<Inventory, String> nameOfPartsTableColumn;
    @FXML
    private TableColumn<Inventory, Integer> availabilityTableColumn;
    @FXML
    private TableColumn<Inventory, String> carTypeTableColumn;
    @FXML
    private TableColumn<Inventory, String> carModelTableColumn;
    @FXML
    private ComboBox<String> selectCarTypeComboBox;
    @FXML
    private ComboBox<String> selectCarModelComboBox;

   private ObservableList<String> sedanCarModels = FXCollections.observableArrayList("Camry", "Corolla", "Avalon");
    private ObservableList<String> hatchbackCarModels = FXCollections.observableArrayList("Yaris Hatchback", "Corolla Hatchback", "Matrix", "Prius c");
    private ObservableList<String> suvCarModels = FXCollections.observableArrayList("RAV4", "Highlander", "4Runner");
    private ObservableList<String> crossoverCarModels = FXCollections.observableArrayList("Corolla Cross", "Corolla Cross Hybrid", "RAV4 Hybrid", "Venza");
    private ObservableList<String> coupeCarModels = FXCollections.observableArrayList("GT86", "Supra");
    private ObservableList<String> convertibleCarModels = FXCollections.observableArrayList("Solara");
    private ObservableList<String> minivanCarModels = FXCollections.observableArrayList("Sienna");
    private ObservableList<String> truckCarModels = FXCollections.observableArrayList("Tundra", "Tacoma");
    private ObservableList<String> evCarModels = FXCollections.observableArrayList("Toyota Prius Prime");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectCarTypeComboBox.getItems().addAll("Sedan", "Hatchback", "SUV", "Crossover", "Coupe", "Convertible", "Minivan", "Truck", "Electric Vehicle (EV)");
        selectPartsForInventoryComboBox.getItems().addAll("Engine", "Transmission", "Body parts", "Suspension system", "Braking system", "Steering system", "Interior components", "Lights", "Body parts", "Rear wiper and defroster", "Roof racks or rails", "All-wheel drive or four-wheel drive components", "Convertible top components", "Performance upgrades", "Sliding doors", "Rear entertainment system", "Towing equipment", "Cargo management systems", "Electric motor", "Battery pack", "Charging system", "Regenerative braking system", "Body parts", "Interior components");
        numberOfPartsAvailableComboBox.getItems().addAll(10, 15, 20, 50, 70, 10, 150);
         
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
    private void distributeButtonOnMuseClicked(ActionEvent event) throws IOException {
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
    private void selectCarTypeOnMouseClicked(ActionEvent event) {
         String selectedCarType = selectCarTypeComboBox.getValue();
        switch (selectedCarType) {
            case "Sedan":
                selectCarModelComboBox.setItems(sedanCarModels);
                break;
            case "Hatchback":
                selectCarModelComboBox.setItems(hatchbackCarModels);
                break;
             case "SUV":
                selectCarModelComboBox.setItems(suvCarModels);
                break;
            case "Crossover":
                selectCarModelComboBox.setItems(crossoverCarModels);
                break;
            case "Coupe":
                selectCarModelComboBox.setItems(coupeCarModels);
                break;
            case "Convertible":
                selectCarModelComboBox.setItems(convertibleCarModels);
                break;
            case "Minivan":
                selectCarModelComboBox.setItems(minivanCarModels);
                break;
            case "Truck":
                selectCarModelComboBox.setItems(truckCarModels);
                break;
            case "Electric Vehicle (EV)":
                selectCarModelComboBox.setItems(evCarModels);
            default:
                selectCarModelComboBox.getItems().clear(); // Clear the ComboBox if no specific car type is selected
                break;
        }
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
private void addPartsOnMouseClicked(ActionEvent event) {
    Inventory newInventory = new Inventory(
            selectCarTypeComboBox.getValue(),
            selectCarModelComboBox.getValue(),
            selectPartsForInventoryComboBox.getValue(),
            numberOfPartsAvailableComboBox.getValue()
    );

    File f = new File("Inventory.bin");
    List<Inventory> existingInventory = new ArrayList<>();

    // Read existing Inventory objects from the file
    if (f.exists()) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                Inventory inventory = (Inventory) ois.readObject();
                existingInventory.add(inventory);
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MakeInventorySceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Check if an entry with the same car type, car model, and name of parts exists
    boolean entryExists = false;
    for (Inventory inventory : existingInventory) {
        if (inventory.getCarType().equals(newInventory.getCarType()) &&
                inventory.getCarModel().equals(newInventory.getCarModel()) &&
                inventory.getNameOfParts().equals(newInventory.getNameOfParts())) {
            // Update the quantity
            inventory.setNumbersOfParts(inventory.getNumbersOfParts() + newInventory.getNumbersOfParts());
            entryExists = true;
            break;
        }
    }

    // If no entry exists, add the new Inventory object
    if (!entryExists) {
        existingInventory.add(newInventory);
    }

    // Write the updated or new Inventory objects back to the file
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
        for (Inventory inventory : existingInventory) {
            oos.writeObject(inventory);
        }
    } catch (IOException ex) {
        Logger.getLogger(MakeInventorySceneController.class.getName()).log(Level.SEVERE, null, ex);
    }

    // Clear the input fields
    selectCarModelComboBox.setValue(null);
    selectCarTypeComboBox.setValue(null);
    selectPartsForInventoryComboBox.setValue(null);
    numberOfPartsAvailableComboBox.setValue(null);
}

    
}
