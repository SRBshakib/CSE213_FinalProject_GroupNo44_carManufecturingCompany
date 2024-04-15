/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti.Supplier;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ReviewSceneController implements Initializable {

    @FXML
    private TableView<Review> reviewTypeTableView;
    @FXML
    private TableColumn<Review, String> productTypeTableColumn;
    @FXML
    private TableColumn<Review, String> commentsTableColumn;
    @FXML
    private TableColumn<Review, Integer> orderCodeTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homeButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("SupplierDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("SupplierDashboard");
        window.show();
    }

    @FXML
    private void orderListButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("OrderListScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("OrderListScene");
        window.show();
    }

    @FXML
    private void ordersButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("OrdersScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("OrdersScene");
        window.show();
    }

    


    @FXML
    private void dueBillsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("DueBillsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("DueBillsScene");
        window.show();
    }


    @FXML
    private void paymentsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("PaymentsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("PaymentsScene");
        window.show();
    }

    @FXML
    private void reviewButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ReviewScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("ReviewScene");
        window.show();
    }

    @FXML

    private void upcomingEventsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("UpcomingEventsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("UpcomingEventsScene");

        window.show();
    }

    @FXML
    private void makeDeliveryButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("MakeDeliveryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("MakeDeliveryScene");
        window.show();
        
        

    }


    

    @FXML

    private void loadReviewsButtonOnMouseClicked(ActionEvent event) {
//        ObservableList<MakeDelivery>MakeDeliveryInfo = FXCollections.observableArrayList();
//
//        //orderCodeTableColumn.setCellValueFactory(new PropertyValueFactory<MakeDelivery,Integer>("orderCode"));
//        
//        File f = null; 
//        FileInputStream fis = null; 
//        ObjectInputStream ois = null;
//
//        try {
//            f = new File("MakeDelivery.bin");
//            fis = new FileInputStream(f);
//            ois = new ObjectInputStream(fis);
//            MakeDelivery p;
//            try {
//                while (true) {
//                    p = (MakeDelivery) ois.readObject();
//                    MakeDeliveryInfo.add(p);
//                    System.out.println(p.toString());
//                }
//            } catch (Exception e) {
//            }
//        } catch (IOException ex) {
//        } finally {
//            try {
//                if (ois != null) {
//                    ois.close();
//                }
//            } catch (IOException ex) {
//            }
//
//        }
//        makeDeliveryTableView.setItems(MakeDeliveryInfo);
//        System.out.println(MakeDeliveryInfo.toString());
//    

    }
        
}
    
