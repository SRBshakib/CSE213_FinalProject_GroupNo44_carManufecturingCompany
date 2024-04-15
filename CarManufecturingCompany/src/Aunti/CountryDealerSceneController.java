/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti;

import Rifat.Dealer;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CountryDealerSceneController implements Initializable {

    @FXML
    private TableColumn<Dealer,String> nameTableColumn;
    @FXML
    private TableColumn<Dealer, String> locationTableColumn;
    @FXML
    private TableColumn<Dealer, String> regionTableColumn;
    @FXML
    private TableColumn<Dealer, Integer> mobileNumberTableColumn;
    @FXML
    private TableColumn<Dealer, String> countryNameTableColumn;
    @FXML
    private ComboBox<String> countryNameComboBox;
    @FXML
    private TableView<Dealer> dealerTableView;
    @FXML
    private TableColumn<Dealer, String> emailTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        countryNameComboBox.getItems().addAll("Bangladesh", "China","Grece","India","Malaysia");
        // TODO
    }    

    private void homeButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource(".fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Assembly Line Worker Dashboard");
        window.show();
    }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        ObservableList<Dealer> DealerInfo = FXCollections.observableArrayList();
    
    


        

        countryNameTableColumn.setCellValueFactory(new PropertyValueFactory<Dealer,String>("CountryName"));

        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Dealer, String>("Name"));
        
        
        locationTableColumn.setCellValueFactory(new PropertyValueFactory<Dealer, String>("Location"));
        regionTableColumn.setCellValueFactory(new PropertyValueFactory<Dealer, String>("Region"));
        mobileNumberTableColumn.setCellValueFactory(new PropertyValueFactory<Dealer, Integer>("MobileNumber"));

        
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

    @FXML
    private void searchByCountryNameButtonOnMouseClicked(ActionEvent event) {
        String CountryDealer = countryNameComboBox.getValue();
        ObservableList<Dealer> matchingCountryDealer = searchDealer(CountryDealer);
        // Clear existing items in the table
        dealerTableView.getItems().clear();
        if (!matchingCountryDealer.isEmpty()) {
            dealerTableView.setItems(matchingCountryDealer);
        } else {
            // If no matching inventory found, display a message
            System.out.println("No similar found: " + CountryDealer);
        }
    }

    // Method to search for inventory items by car model
    private ObservableList<Dealer> searchDealer(String CountryDealer) {
        ObservableList<Dealer> matchingCountryDealer = FXCollections.observableArrayList();
        try (FileInputStream fis = new FileInputStream("DealerInfo.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                Dealer dealer = (Dealer) ois.readObject();
                if (dealer.getCountryName().equals(CountryDealer)) {
                    matchingCountryDealer.add(dealer);
                }
            }
        } catch (EOFException e) {
            // Reached end of file
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return matchingCountryDealer;
    }
    }
    

    


    

    

