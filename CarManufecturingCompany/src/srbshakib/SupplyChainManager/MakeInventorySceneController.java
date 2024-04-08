/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package srbshakib.SupplyChainManager;

import Dip.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectCarTypeComboBox.getItems().addAll("Sedan","Hatchback","SUV","Crossover","Coupe","Convertible","Minivan","Truck","Electric Vehicle (EV)");
               
        numberOfPartsAvailableComboBox.getItems().addAll(10,15,20,50,70,10,150);
        
        
             
         
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
        if (selectCarTypeComboBox.getValue().equals("Sedan")){
            selectCarModelComboBox.getItems().addAll("Camry", "Corolla", "Avalon"); 
            selectPartsForInventoryComboBox.getItems().addAll("Engine"
,"Transmission","Body parts (doors, fenders, hood, trunk)","Suspension system","Braking system"
,"Steering system"
,"Interior components (seats, dashboard, carpeting)"
,"Lights");
        }
        else if(selectCarTypeComboBox.getValue().equals("Hatchback")){
                 selectCarModelComboBox.getItems().addAll("Yaris Hatchback", "Corolla Hatchback", "Matrix", "Prius c");
                 selectPartsForInventoryComboBox.getItems().addAll("Engine", "Transmission", "Body parts (doors, hatch)", "Suspension system", "Braking system", "Steering system", "Interior components (seats, cargo space)", "Rear wiper and defroster");
        }
        else if(selectCarTypeComboBox.getValue().equals("SUV")){
                 selectCarModelComboBox.getItems().addAll("RAV4", "Highlander", "4Runner");
        selectPartsForInventoryComboBox.getItems().addAll("Engine"
,"Transmission"
,"Body parts (doors, fenders, hood, tailgate)"
,"Suspension system (often designed for off-road capabilities)"
,"Braking system (may have specialized components for towing)"
,"Steering system"
,"Interior components (seats, cargo space, dashboard)"
,"Roof racks or rails"
,"All-wheel drive or four-wheel drive components");         
        }
        else if(selectCarTypeComboBox.getValue().equals("Crossover")){
                 selectCarModelComboBox.getItems().addAll("Corolla Cross", "Corolla Cross Hybrid", "RAV4 Hybrid","Venza");
                 selectPartsForInventoryComboBox.getItems().addAll( "Engine", "Transmission", "Body parts (doors, convertible top mechanism)", "Suspension system", "Braking system", "Steering system", "Interior components (often weather-resistant materials)", "Convertible top components (fabric, motors)");

        }
        else if(selectCarTypeComboBox.getValue().equals("Coupe")){
                 selectCarModelComboBox.getItems().addAll("GT86", "Supra");
                 selectPartsForInventoryComboBox.getItems().addAll( "Engine", "Transmission", "Body parts (doors, hood, trunk, sometimes a hatchback)", "Suspension system (often tuned for sporty handling)", "Braking system", "Steering system", "Interior components (sport seats, compact dashboard)", "Performance upgrades (sport exhaust, performance brakes)");
         
        }
        else if(selectCarTypeComboBox.getValue().equals("Convertible")){
                 selectCarModelComboBox.getItems().addAll("Solara");
                 selectPartsForInventoryComboBox.getItems().addAll( "Engine", "Transmission", "Body parts (doors, convertible top mechanism)", "Suspension system", "Braking system", "Steering system", "Interior components (often weather-resistant materials)", "Convertible top components (fabric, motors)");
         
        }
        else if(selectCarTypeComboBox.getValue().equals("Minivan")){
                 selectCarModelComboBox.getItems().addAll("Sienna");
                 selectPartsForInventoryComboBox.getItems().addAll("Engine", "Transmission", "Body parts (doors, fenders, hood, tailgate)", "Suspension system", "Braking system", "Steering system", "Interior components (seats, cargo space, dashboard)", "Sliding doors", "Rear entertainment system");
             
        }
        else if(selectCarTypeComboBox.getValue().equals("Truck")){
                 selectCarModelComboBox.getItems().addAll("Tundra", "Tacoma");
                 selectPartsForInventoryComboBox.getItems().addAll("Engine (often larger and more powerful for towing and hauling)", "Transmission (may include heavy-duty options)", "Body parts (doors, fenders, bed)", "Suspension system (designed for heavy loads)", "Braking system (may include trailer brake controllers)", "Steering system", "Towing equipment (hitch, trailer wiring)", "Cargo management systems (bed liners, tie-downs)");
              
        }
        else if(selectCarTypeComboBox.getValue().equals("Electric Vehicle (EV)")){
                 selectCarModelComboBox.getItems().addAll("Toyota Prius Prime");
                 selectPartsForInventoryComboBox.getItems().addAll("Electric motor", "Battery pack", "Charging system (charger, charging port)", "Regenerative braking system", "Body parts (doors, fenders, hood, trunk)", "Suspension system", "Braking system (may have different characteristics due to regenerative braking)", "Steering system", "Interior components (similar to conventional cars but may include energy monitoring displays)");
              
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
        Inventory i= new Inventory(
                selectCarTypeComboBox.getValue(),
                selectCarModelComboBox.getValue(),
                selectPartsForInventoryComboBox.getValue(),
                numberOfPartsAvailableComboBox.getValue()
    
                
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Inventory.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(MakeInventorySceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(MakeInventorySceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        selectCarModelComboBox.setValue(null);
        selectCarTypeComboBox.setValue(null);
        selectPartsForInventoryComboBox.setValue(null);
        numberOfPartsAvailableComboBox.setValue(null);
        
        
    }
    
}
