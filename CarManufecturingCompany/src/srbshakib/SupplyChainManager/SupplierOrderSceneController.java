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
import srbshakib.SupplyChainManager.SupplierInformation;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
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
import javafx.scene.control.DatePicker;
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
public class SupplierOrderSceneController implements Initializable {

    @FXML
    private ComboBox<String> suppilerComboBox;
    @FXML
    private ComboBox<String> productComboBox;
    @FXML
    private TextField quantityTextField;
    @FXML
    private ComboBox<String> paymentComboBox;
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
    private TableColumn<OrderForSuppiler, String> paymentTableColumn;

   private static int idCounter = 1110000;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productComboBox.getItems().addAll("Engine Block", "Cylinder Head", "Pistons", "Crankshaft", "Camshaft", "Connecting Rods",
    "Flywheel", "Driveshaft", "Differential", "Engine Control Unit (ECU)", "Transmission Control Unit (TCU)","Electric Motor", "Battery Pack", "Inverter", "Transmission","Steel Sheets (Body Panels)", "Aluminum Castings (Engine Hood, Trunk Lid)", "Composite Materials (Bumpers, Fenders)",
    "Windshield", "Side Windows", "Rear Window (Safety Glass)", "Sunroof (Optional)", "Doors", "Hood", "Trunk Lid",
    "Hinges", "Latches", "Locks", "Frame Rails", "Subframe Components (Steel)",    "Steering Wheel", "Steering Column", "Rack and Pinion Steering Gear", "Tie Rods", "Drag Link",
    "MacPherson Struts", "Coil Springs", "Shock Absorbers", "Control Arms", "Bushings", "Ball Joints","Disc Brakes (Front, Rear) or Drum Brakes (Rear, Less Common in Modern Cars)", "Brake Pads", "Rotors (Disc Brakes)", "Drums (Drum Brakes)",
    "Calipers", "Master Cylinder", "Brake Lines", "Brake Fluid","Steel Wheels or Aluminum Alloy Wheels", "Tires (Specified Size and Type - Summer, All-Season, Winter)",
    "Hubs", "Lug Nuts", "Seats (Frames, Upholstery)", "Instrument Panel, Dashboard", "Steering Wheel Cover, Gear Shift Knob (Interior Trim)",
    "Door Panels", "Carpeting", "Headliner","Battery", "Alternator", "Starter Motor", "Wiring Harness", "Fuses", "Relays", "Light Switches", "Window Switches",
    "Headlights", "Taillights", "Brake Lights", "Turn Signals (Exterior Lighting)", "Instrument Cluster Gauges", "Infotainment System (Interior Electronics)", "Compressor", "Condenser", "Evaporator (AC System)", "Heater Core", "Blower Motor","Airbags (Driver, Passenger, Side-Impact)", "Seatbelts (Pre-Tensioners, Force Limiters)", "Anti-Lock Braking System (ABS)",
    "Electronic Stability Control (ESC)", "Traction Control System (TCS)", "Tire Pressure Monitoring System (TPMS)","Fasteners (Bolts, Nuts, Screws, Washers)", "Gaskets & Seals (Engine Gaskets, Transmission Gaskets, Door Seals)",
    "Filters (Air Filter, Oil Filter, Fuel Filter)", "Fluids (Engine Oil, Transmission Fluid, Coolant, Brake Fluid)",
    "Exhaust System (Catalytic Converter, Muffler, Tailpipe)");
        
        paymentComboBox.getItems().addAll("Done", "Due");
       
    }    

    @FXML
    private void homeButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("SupplyChainManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Supply Chain Manager");
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
    private void distribruteButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("DistributeOrderScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Distribute");
        window.show();
    }
    @FXML
    private void orderButtonOnMouseClicked(ActionEvent event) {
        OrderForSuppiler i = new OrderForSuppiler(
                
                generateUniqueId(),
                suppilerComboBox.getValue(),
                productComboBox.getValue(),
                paymentComboBox.getValue(),
                Integer.parseInt(quantityTextField.getText())
                
                
                
        );
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("OrderForSuppiler.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(SupplierOrderSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(SupplierOrderSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
                suppilerComboBox.setValue(null);
                productComboBox.setValue(null);
                paymentComboBox.setValue(null);
                quantityTextField.clear();
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
    private void loadSupplierButtonOnMouseClicked(ActionEvent event) {
       String filePath = "SupplierList.bin";

    // Initialize an observable list to store supplier names
    ObservableList<String> supplierNames = FXCollections.observableArrayList();

    try (FileInputStream fis = new FileInputStream(filePath);
         ObjectInputStream ois = new ObjectInputStream(fis)) {
        // Read SupplierInformation objects from the binary file until EOF
        while (true) {
            SupplierInformation supplier = (SupplierInformation) ois.readObject();
            // Add the supplier name to the observable list
            supplierNames.add(supplier.getSupplierName());
        }
    } catch (EOFException e) {
        // Reached end of file
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    // Now you can use 'supplierNames' to set the items of your ComboBox
    suppilerComboBox.setItems(supplierNames);
    }

    @FXML
    private void loadOrderInfoButtonOnMouseClicked(ActionEvent event) {
        ObservableList<OrderForSuppiler> supplierOrderListInfo = FXCollections.observableArrayList();
        
        orderCodeTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderCode"));
        supplierNameTableColumn.setCellValueFactory(new PropertyValueFactory<OrderForSuppiler,String>("supplierName"));
        productTableColumn.setCellValueFactory(new PropertyValueFactory<OrderForSuppiler,String>("productName"));
        quantityTableColumn.setCellValueFactory(new PropertyValueFactory<OrderForSuppiler, Integer>("quantity"));
        paymentTableColumn.setCellValueFactory(new PropertyValueFactory<OrderForSuppiler, String>("payment"));
        
        
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
    
    }
    
    
   

