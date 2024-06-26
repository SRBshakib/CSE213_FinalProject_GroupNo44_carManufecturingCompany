/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ProductionManagerCarLunchingEventSceneController implements Initializable {

    @FXML
    private TableView<CarLaunchingEvent> carLaunchingEventTableView;
    @FXML
    private TableColumn<CarLaunchingEvent, String> carTypeTableColumn;
    @FXML
    private TableColumn<CarLaunchingEvent, String> carModelTableColumn;
    @FXML
    private TableColumn<CarLaunchingEvent, String> dateTableColumn;
    @FXML
    private TableColumn<CarLaunchingEvent, String> timeTableColumn;
    @FXML
    private TableColumn<CarLaunchingEvent, String> locationTableColumn;
    @FXML
    private TableColumn<CarLaunchingEvent, String> manufacturerTableColumn;
    @FXML
    private TableColumn<CarLaunchingEvent, String> featuresTableColumn;
    @FXML
    private ComboBox<String> selectCarTypeComboBox;
    @FXML
    private TextField carModelTextField;
    @FXML
    private TextField timeTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextField manufacturerTextField;
    @FXML
    private TextArea featuresTextArea;
    
    @FXML
    private TextField dateTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {// Initialize car type ComboBox
        selectCarTypeComboBox.getItems().addAll("Sedan", "Hatchback", "SUV", "Crossover", "Coupe", "Convertible", "Minivan", "Truck", "Electric Vehicle (EV)");
                           
    }
    
    private void carTypeSelectOnAction(ActionEvent event) {
        String selectedCarType = selectCarTypeComboBox.getValue();
        switch (selectedCarType) {
            case "Sedan":
                carModelTextField.getText();
                break;
            case "Hatchback":
                carModelTextField.getText();
                break;
             case "SUV":
                carModelTextField.getText();
                break;
            case "Crossover":
                carModelTextField.getText();
                break;
            case "Coupe":
                carModelTextField.getText();
                break;
            case "Convertible":
                carModelTextField.getText();
                break;
            case "Minivan":
                carModelTextField.getText();
                break;
            case "Truck":
                carModelTextField.getText();
                break;
            case "Electric Vehicle (EV)":
                carModelTextField.getText();
            default:
                carModelTextField.clear(); // Clear the ComboBox if no specific car type is selected
                break;
        }
        
    }
        
       
    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/ProductionManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void submitButtonOnMouseClicked(ActionEvent event) {
        CarLaunchingEvent i= new CarLaunchingEvent(
              
                
                selectCarTypeComboBox.getValue(),
                carModelTextField.getText(),
                dateTextField.getText(),
                timeTextField.getText(),
                locationTextField.getText(),
                manufacturerTextField.getText(),
                featuresTextArea.getText()
                
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("CarLaunchingEventInfo.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(ProductionManagerCarLunchingEventSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(ProductionManagerCarLunchingEventSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        selectCarTypeComboBox.setValue(null);
        carModelTextField.clear();
        dateTextField.clear();
        timeTextField.clear();
        locationTextField.clear();
        manufacturerTextField.clear();                        
        featuresTextArea.clear();
    }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        ObservableList<CarLaunchingEvent> CarLaunchingEventInfo = FXCollections.observableArrayList();
    
    


        

        

        carTypeTableColumn.setCellValueFactory(new PropertyValueFactory<CarLaunchingEvent, String>("carType"));
        carModelTableColumn.setCellValueFactory(new PropertyValueFactory<CarLaunchingEvent,String>("carModel"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<CarLaunchingEvent,String>("date"));
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<CarLaunchingEvent,String>("time"));
        locationTableColumn.setCellValueFactory(new PropertyValueFactory<CarLaunchingEvent,String>("location"));
        manufacturerTableColumn.setCellValueFactory(new PropertyValueFactory<CarLaunchingEvent,String>("manufacturer"));       
        featuresTableColumn.setCellValueFactory(new PropertyValueFactory<CarLaunchingEvent, String>("Features"));

        

        

        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("CarLaunchingEventInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            CarLaunchingEvent p;
            try {
                while (true) {
                    p = (CarLaunchingEvent) ois.readObject();
                    CarLaunchingEventInfo.add(p);
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
        carLaunchingEventTableView.setItems(CarLaunchingEventInfo);
        System.out.println(CarLaunchingEventInfo.toString());
    }
}
