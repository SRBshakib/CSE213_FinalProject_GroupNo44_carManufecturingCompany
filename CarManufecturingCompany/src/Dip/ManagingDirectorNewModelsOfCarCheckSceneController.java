/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

import Rifat.CarModel;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class ManagingDirectorNewModelsOfCarCheckSceneController implements Initializable {

    @FXML
    private TableView<CarModel> carModelTableView;
    @FXML
    private TableColumn<CarModel, String> carTypeTableColumn;
    @FXML
    private TableColumn<CarModel, String> carModelTableColumn;
    @FXML
    private TableColumn<CarModel, String> carModelFeaturesTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
    Parent mainParent = FXMLLoader.load(getClass().getResource("ManagingDirectorDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
        }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        ObservableList<CarModel> CarModelInfo = FXCollections.observableArrayList();
        carModelTableColumn.setCellValueFactory(new PropertyValueFactory<CarModel,String>("modelName"));
        carTypeTableColumn.setCellValueFactory(new PropertyValueFactory<CarModel, String>("carType")); 
        carModelFeaturesTableColumn.setCellValueFactory(new PropertyValueFactory<CarModel, String>("features"));

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
