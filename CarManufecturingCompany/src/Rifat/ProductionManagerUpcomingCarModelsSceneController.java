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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;


import srbshakib.FlagAReport;
import srbshakib.FlagAReportSecneController;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ProductionManagerUpcomingCarModelsSceneController implements Initializable {

    @FXML
    private ComboBox<String> selectCarTypeComboBox;
    @FXML
    private TextArea featuresTextArea;
    @FXML
    private TableColumn<UpcomingCarModels, String> carTypeTableColumn;
    @FXML
    private TableColumn<UpcomingCarModels, String> carModelTableColumn;
    @FXML
    private TableView<UpcomingCarModels> upcomingCarModelTableView;
    @FXML
    
    
    private TextField upcomingCarModelsTextField;
    @FXML
    private TableColumn<UpcomingCarModels, String> upcomingCarModelFeaturesTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {// Initialize car type ComboBox
        selectCarTypeComboBox.getItems().addAll("Sedan", "Hatchback", "SUV", "Crossover", "Coupe", "Convertible", "Minivan", "Truck", "Electric Vehicle (EV)");
        
        
        
        
    }

    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/ProductionManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }


    @FXML
    private void submitButtonOnMouseClicked(ActionEvent event) {
        UpcomingCarModels i= new UpcomingCarModels(
              
                
                selectCarTypeComboBox.getValue(),
                upcomingCarModelsTextField.getText(),
                featuresTextArea.getText()
                
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("UpcomingCarModelsInfo.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(ProductionManagerUpcomingCarModelsSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(ProductionManagerUpcomingCarModelsSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        selectCarTypeComboBox.setValue(null);
        upcomingCarModelsTextField.clear();
        featuresTextArea.clear();
    }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        ObservableList<UpcomingCarModels> UpcomingCarModelsInfo = FXCollections.observableArrayList();
    
    


        

        carModelTableColumn.setCellValueFactory(new PropertyValueFactory<UpcomingCarModels,String>("carModel"));

        carTypeTableColumn.setCellValueFactory(new PropertyValueFactory<UpcomingCarModels, String>("carType"));
        
        
        upcomingCarModelFeaturesTableColumn.setCellValueFactory(new PropertyValueFactory<UpcomingCarModels, String>("Features"));

        

        

        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("UpcomingCarModelsInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            UpcomingCarModels p;
            try {
                while (true) {
                    p = (UpcomingCarModels) ois.readObject();
                    UpcomingCarModelsInfo.add(p);
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
        upcomingCarModelTableView.setItems(UpcomingCarModelsInfo);
        System.out.println(UpcomingCarModelsInfo.toString());
    }

    @FXML
    private void carTypeSelectOnAction(ActionEvent event) {String selectedCarType = selectCarTypeComboBox.getValue();
        switch (selectedCarType) {
            case "Sedan":
                upcomingCarModelsTextField.getText();
                break;
            case "Hatchback":
                upcomingCarModelsTextField.getText();
                break;
             case "SUV":
                upcomingCarModelsTextField.getText();
                break;
            case "Crossover":
                upcomingCarModelsTextField.getText();
                break;
            case "Coupe":
                upcomingCarModelsTextField.getText();
                break;
            case "Convertible":
                upcomingCarModelsTextField.getText();
                break;
            case "Minivan":
                upcomingCarModelsTextField.getText();
                break;
            case "Truck":
                upcomingCarModelsTextField.getText();
                break;
            case "Electric Vehicle (EV)":
                upcomingCarModelsTextField.getText();
            default:
                upcomingCarModelsTextField.clear(); // Clear the ComboBox if no specific car type is selected
                break;
        }
        
    }
}