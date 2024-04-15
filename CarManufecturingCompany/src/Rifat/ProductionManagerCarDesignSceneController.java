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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
 * @author Lenovo
 */

public class ProductionManagerCarDesignSceneController implements Initializable {

    @FXML
    private ComboBox<String> selectCarTypeComboBox;
    @FXML
    private TextArea designTextArea;
    @FXML
    private TableView<CarDesign> carDesignTableView;
    @FXML
    private TableColumn<CarDesign, String> carTypeTableColumn;
    @FXML
    private TableColumn<CarDesign, String> carModelTableColumn;
    @FXML
    private TableColumn<CarDesign, String> designTableColumn;
    
    @FXML
    private TextField carModelTextField;



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
        UpcomingCarModels i= new UpcomingCarModels(
              
                
                selectCarTypeComboBox.getValue(),
                carModelTextField.getText(),
                designTextArea.getText()
                
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("CarDesignInfo.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(ProductionManagerCarDesignSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(ProductionManagerCarDesignSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        selectCarTypeComboBox.setValue(null);
        carModelTextField.clear();
        designTextArea.clear();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize car type ComboBox
        selectCarTypeComboBox.getItems().addAll("Sedan", "Hatchback", "SUV", "Crossover", "Coupe", "Convertible", "Minivan", "Truck", "Electric Vehicle (EV)");
        
        
        
        
    } 


    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        ObservableList<CarDesign> CarDesignInfo = FXCollections.observableArrayList();
    
    


        carTypeTableColumn.setCellValueFactory(new PropertyValueFactory<CarDesign, String>("carType"));

        carModelTableColumn.setCellValueFactory(new PropertyValueFactory<CarDesign,String>("modelName"));

        
        
        
        designTableColumn.setCellValueFactory(new PropertyValueFactory<CarDesign, String>("design"));

        

        

        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("CarDesignInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            CarDesign p;
            try {
                while (true) {
                    p = (CarDesign) ois.readObject();
                    CarDesignInfo.add(p);
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
        carDesignTableView.setItems(CarDesignInfo);
        System.out.println(CarDesignInfo.toString());
    }        
}
