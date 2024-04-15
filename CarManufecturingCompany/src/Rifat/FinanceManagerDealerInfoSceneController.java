/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;

import Dip.AppendableObjectOutputStream;
import java.io.*;
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

public class FinanceManagerDealerInfoSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextField regionTextField;
    @FXML
    private TextField mobileNumberTextField;
    @FXML
    private TableColumn<Dealer, String> nameTableColumn;
    @FXML
    private TableColumn<Dealer, String> locationTableColumn;
    @FXML
    private TableColumn<Dealer, String> regionTableColumn;
    @FXML
    private TableColumn<Dealer, String> mobileNumberTableColumn;
    @FXML
    private TableColumn<Dealer, String> countryNameTableColumn;
    @FXML
    private TextField emailTextField;
    @FXML
    private ComboBox<String> countryNameComboBox;
    @FXML
    private TableColumn<Dealer, String> emailTableColumn;
    @FXML
    private TableView<Dealer> dealerTableView;

    private  ObservableList<Dealer> dealerList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        countryNameComboBox.getItems().addAll("Bangladesh", "China", "Greece", "India", "Malaysia");
        
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
        Dealer i= new Dealer(
              
                
                
                
                
                countryNameComboBox.getValue(),
                nameTextField.getText(),
                locationTextField.getText(),
                mobileNumberTextField.getText(),
                regionTextField.getText(),
                emailTextField.getText()
                
                            
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("DealerInfo.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(FinanceManagerDealerInfoSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(FinanceManagerDealerInfoSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        countryNameComboBox.setValue(null);
        nameTextField.clear();
        locationTextField.clear();
        regionTextField.clear();
        mobileNumberTextField.clear();
        emailTextField.clear();
        
    } 


    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        ObservableList<Dealer> DealerInfo = FXCollections.observableArrayList();
    
    


        

        countryNameTableColumn.setCellValueFactory(new PropertyValueFactory<Dealer,String>("CountryName"));

        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Dealer, String>("Name"));
        
        
        locationTableColumn.setCellValueFactory(new PropertyValueFactory<Dealer, String>("Location"));
        regionTableColumn.setCellValueFactory(new PropertyValueFactory<Dealer, String>("Region"));
        mobileNumberTableColumn.setCellValueFactory(new PropertyValueFactory<Dealer, String>("MobileNumber"));

        
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<Dealer, String>("Email"));

        

        

        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("DealerInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Dealer p;
            try {
                while (true) {
                    p = (Dealer) ois.readObject();
                    DealerInfo.add(p);
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
        dealerTableView.setItems(DealerInfo);
        System.out.println(DealerInfo.toString());
    }


   

    
}
        


    
