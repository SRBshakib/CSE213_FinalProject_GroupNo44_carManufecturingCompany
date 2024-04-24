/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Aunti;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CustomerDashboardSceneController implements Initializable {

    @FXML
    private BorderPane showBorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homeButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("CustomerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("CustomerDashboardScene");
        window.show();
    }

    @FXML
    private void myCarButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("MyCarScene.fxml"));
        showBorderPane.setCenter(mainParent);
    }

    @FXML
    private void countryDealerButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("CountryDealerScene.fxml"));
                showBorderPane.setCenter(mainParent);

    }

    @FXML
    private void updateButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("UpdateScene.fxml"));
        showBorderPane.setCenter(mainParent);
    }

    @FXML
    private void carOrderButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("CarOrderScene.fxml"));
        showBorderPane.setCenter(mainParent);
    }

    @FXML
    private void orderHistoryButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("OrderHistoryScene.fxml"));
        showBorderPane.setCenter(mainParent);
    }

    @FXML
    private void viewCarsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ViewCarsScene.fxml"));
       showBorderPane.setCenter(mainParent);
    }

    @FXML
    private void preOrderButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("PreOrderScene.fxml"));
        showBorderPane.setCenter(mainParent);
    }

    @FXML
    private void upcomingEventsButtonOnMouseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("UpcomingEventScene.fxml"));
        showBorderPane.setCenter(mainParent);
    }
    
}
