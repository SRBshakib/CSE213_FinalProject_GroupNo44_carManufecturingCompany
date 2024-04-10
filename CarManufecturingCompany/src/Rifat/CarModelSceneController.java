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
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import srbshakib.FlagAReport;
import srbshakib.FlagAReportSecneController;

public class CarModelSceneController implements Initializable {


    
    private ComboBox<String> carModelComboBox;
    
    @FXML
    private ImageView carModelImageview;
    
    @FXML
    private ComboBox<String> selectCarTypeComboBox;
    @FXML
    private TextArea featuresTextArea;
    @FXML
    private TableView<CarModel> carModelTableView;
    @FXML
    private TableColumn<CarModel, String> carTypeTableColumn;
    @FXML
    private TableColumn<CarModel, String> carModelTableColumn;
    private TableColumn<CarModel, String> featuresTableColumn;
    @FXML
    private TableColumn<?, ?> carModelTableColumn1;
    @FXML
    private TextField carModelTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize car type ComboBox
        selectCarTypeComboBox.getItems().addAll("Sedan", "Hatchback", "SUV", "Crossover", "Coupe", "Convertible", "Minivan", "Truck", "Electric Vehicle (EV)");
        
        
        
        
    }    

    @FXML
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
    private void submitButtonOnMouseClicked(ActionEvent event) {
        CarModel i= new CarModel(
              
                
                selectCarTypeComboBox.getValue(),
                carModelTextField.getText(),
                featuresTextArea.getText()
                
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("CarModelInfo.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(CarModelSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(CarModelSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        selectCarTypeComboBox.setValue(null);
        carModelTextField.clear();
        featuresTextArea.clear();
    }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        ObservableList<CarModel> CarModelInfo = FXCollections.observableArrayList();

        
        carModelTableColumn.setCellValueFactory(new PropertyValueFactory<CarModel,String>("carModel"));
        carTypeTableColumn.setCellValueFactory(new PropertyValueFactory<CarModel, String>("carType"));
        
        
        featuresTableColumn.setCellValueFactory(new PropertyValueFactory<CarModel, String>("Features"));
        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("CarModelInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            CarModel p;
            try {
                while (true) {
                    p = (CarModel) ois.readObject();
                    CarModelInfo.add(p);
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
        carModelTableView.setItems(CarModelInfo);
        System.out.println(CarModelInfo.toString());
    }
    
}
