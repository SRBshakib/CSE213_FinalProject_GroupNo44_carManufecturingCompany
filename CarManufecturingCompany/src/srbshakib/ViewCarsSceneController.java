/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package srbshakib;

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
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Rifat.CarModel;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import Rifat.CarModel;

/**
 * FXML Controller class
 *
 * @author SRB Shakib
 */
public class ViewCarsSceneController implements Initializable {

    @FXML
    private TableView<?> assemblingCarsTableView;
    @FXML
    private TableColumn<?, ?> viewCarsModelNoTableColumn;
    @FXML
    private TableColumn<?, ?> viewCarssectionTableColumn;
    @FXML
    private PieChart viewCarsAssemblingPieChart;
    @FXML
    private ImageView carViewCarImageview;
    @FXML
    private TextArea carViewcarFeaturesLabel;

    private ObservableList<String> sedanCarModels = FXCollections.observableArrayList("Camry", "Corolla", "Avalon");
    private ObservableList<String> hatchbackCarModels = FXCollections.observableArrayList("Yaris Hatchback", "Corolla Hatchback", "Matrix", "Prius c");
    private ObservableList<String> suvCarModels = FXCollections.observableArrayList("RAV4", "Highlander", "4Runner");
    private ObservableList<String> crossoverCarModels = FXCollections.observableArrayList("Corolla Cross", "Corolla Cross Hybrid", "RAV4 Hybrid", "Venza");
    private ObservableList<String> coupeCarModels = FXCollections.observableArrayList("GT86", "Supra");
    private ObservableList<String> convertibleCarModels = FXCollections.observableArrayList("Solara");
    private ObservableList<String> minivanCarModels = FXCollections.observableArrayList("Sienna");
    private ObservableList<String> truckCarModels = FXCollections.observableArrayList("Tundra", "Tacoma");
    private ObservableList<String> evCarModels = FXCollections.observableArrayList("Toyota Prius Prime");
    @FXML
    private ComboBox<String> CarTypeComboBox;
    @FXML
    private ComboBox<String> selectCarModelComboBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CarTypeComboBox.getItems().addAll("Sedan", "Hatchback", "SUV", "Crossover", "Coupe", "Convertible", "Minivan", "Truck", "Electric Vehicle (EV)");
        
    }    

    @FXML
    private void homeButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AssemblyLineWorkerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Assembly Line Worker Dashboard");
        window.show();
        
    }

    @FXML
    private void assignedTaskButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AssignedTaskSecne.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Assigned Task");
        window.show();
    }

    @FXML
    private void inventoryButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ShowInventoryScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Inventory");
        window.show();
    }

    @FXML
    private void instructionsButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AssemblingInsturctionScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Instructions");
        window.show();
    }

    @FXML
    private void leaveApplicationButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("AskLeaveScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Ask Leave");
        window.show();
    }

    @FXML
    private void traingButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("CheckTrainingScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Training");
        window.show();
    }

    @FXML
    private void flagReportButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("FlagAReportSecne.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Flag Report");
        window.show();
    }

    @FXML
    private void checkScheduleButtonOnMuseClicked(ActionEvent event) throws IOException {
       Parent mainParent = FXMLLoader.load(getClass().getResource("CheckScheduleScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Schedule");
        window.show();
    }
     @FXML
    private void viewCarsButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ViewCarsScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.setTitle("Cars");
        window.show();
    }

    @FXML
    private void viewcarsCarTypeSelectcarTypeOnMouseClicked(ActionEvent event) {
        String selectedCarType = CarTypeComboBox.getValue();
        switch (selectedCarType) {
            case "Sedan":
                selectCarModelComboBox.setItems(sedanCarModels);
                break;
            case "Hatchback":
                selectCarModelComboBox.setItems(hatchbackCarModels);
                break;
             case "SUV":
                selectCarModelComboBox.setItems(suvCarModels);
                break;
            case "Crossover":
                selectCarModelComboBox.setItems(crossoverCarModels);
                break;
            case "Coupe":
                selectCarModelComboBox.setItems(coupeCarModels);
                break;
            case "Convertible":
                selectCarModelComboBox.setItems(convertibleCarModels);
                break;
            case "Minivan":
                selectCarModelComboBox.setItems(minivanCarModels);
                break;
            case "Truck":
                selectCarModelComboBox.setItems(truckCarModels);
                break;
            case "Electric Vehicle (EV)":
                selectCarModelComboBox.setItems(evCarModels);
            default:
                selectCarModelComboBox.getItems().clear(); // Clear the ComboBox if no specific car type is selected
                break;
        }
    
    }

    @FXML
    private void selectCarModelComboBoxOnAction(ActionEvent event) {
          String carModelName = selectCarModelComboBox.getValue();
        
        // Call the method to search for car features by model name
        ObservableList<String> features = searchInventoryByCarModel(carModelName);
        
        // Clear existing text in the label
        carViewcarFeaturesLabel.setText("");
        
        // Check if features were found for the selected model
        if (!features.isEmpty()) {
            // Concatenate the features into a single string
            StringBuilder featuresText = new StringBuilder();
            for (String feature : features) {
                featuresText.append(feature).append("\n");
            }
            // Set the concatenated features text in the label
            carViewcarFeaturesLabel.setText(featuresText.toString());
        } else {
            // If no features were found, display a message
            carViewcarFeaturesLabel.setText("No features found for car model: " + carModelName);
        }
    }

    private ObservableList<String> searchInventoryByCarModel(String carModelName) {
        ObservableList<String> carFeatures = FXCollections.observableArrayList();
        try (FileInputStream fis = new FileInputStream("UpcomingCarModelsInfo.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                CarModel carModel = (CarModel) ois.readObject();
                if (carModel.getModelName().equals(carModelName)) {
                    carFeatures.addAll(carModel.getFeatures());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            // Handle exceptions
            e.printStackTrace();
        }
        return carFeatures;
    }
}


