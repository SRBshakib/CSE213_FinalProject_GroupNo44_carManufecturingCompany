/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti.Supplier;

import Rifat.CarLaunchingEvent;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class UpcomingEventsSceneController implements Initializable {

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
    private TableView<CarLaunchingEvent> carLaunchingEventTableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void homeButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("SupplierDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("SupplierDashboard");
        window.show();
    }

    private void orderListButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("OrderListScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("OrderListScene");
        window.show();
    }

    private void ordersButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("OrdersScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("OrdersScene");
        window.show();
    }

    

    private void dueBillsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("DueBillsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("DueBillsScene");
        window.show();
    }


    private void paymentsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("PaymentsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("PaymentsScene");
        window.show();
    }

    private void reviewButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ReviewScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("ReviewScene");
        window.show();
    }

    private void upcomingEventsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("UpcomingEventsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("UpcomingEventsScene");
        window.show();
    }

    private void makeDeliveryButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("MakeDeliveryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("MakeDeliveryScene");
        window.show();
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
    
