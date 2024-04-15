
package Rifat;

import Dip.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ProductionManagerAssignTasksSceneController implements Initializable {

   
    @FXML
    private TableView<AssignTasks> assignTasksTableView;
    @FXML
    private TableColumn<AssignTasks, String> destinationTableColumn;
    @FXML
    private TableColumn<AssignTasks, LocalDate> startingDateTableColumn;
    @FXML
    private TableColumn<AssignTasks, LocalDate> endingDateTableColumn;
    @FXML
    private TableColumn<AssignTasks, String> carTypeTableColumn;
  
    
    
    @FXML
    private ComboBox<String> selectCarTypeComboBox;
    @FXML
    private TableColumn<AssignTasks, String> assemblingCarModelTableColumn;
    @FXML
    private ComboBox<String> selectCarModelComboBox;
    
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
    private DatePicker startingDatePicker;
    @FXML
    private DatePicker endingDatePicker;
    @FXML
    private ComboBox<String> destinationComboBox;
    
    @FXML
    private TextField workerNameTextField;
    @FXML
    private TableColumn<AssignTasks, String> carTypeTableColumn1;
    
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize car type ComboBox
        selectCarTypeComboBox.getItems().addAll("Sedan", "Hatchback", "SUV", "Crossover", "Coupe", "Convertible", "Minivan", "Truck", "Electric Vehicle (EV)");
        destinationComboBox.getItems().addAll("Painting","Stamping","Welding","AssemblyInspection");
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
        AssignTasks i= new AssignTasks(
              
                destinationComboBox.getValue(),
                startingDatePicker.getValue(),
                endingDatePicker.getValue(),
                selectCarModelComboBox.getValue(),
                selectCarTypeComboBox.getValue(),
                workerNameTextField.getText()
                
        );
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("AssignTasksInfo.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(ProductionManagerAssignTasksSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(ProductionManagerAssignTasksSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        destinationComboBox.setValue(null);
        startingDatePicker.setValue(null);
        endingDatePicker.setValue(null);
        selectCarModelComboBox.setValue(null);        
        selectCarTypeComboBox.setValue(null);
        workerNameTextField.clear();
        
    }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        ObservableList<AssignTasks> AssignTasksInfo = FXCollections.observableArrayList();
    
    


        

        destinationTableColumn.setCellValueFactory(new PropertyValueFactory<AssignTasks,String>("destination"));

        startingDateTableColumn.setCellValueFactory(new PropertyValueFactory<AssignTasks, LocalDate>("startingDate"));
        
        
        endingDateTableColumn.setCellValueFactory(new PropertyValueFactory<AssignTasks, LocalDate>("endingDate"));
        assemblingCarModelTableColumn.setCellValueFactory(new PropertyValueFactory<AssignTasks, String>("assemblingCarModel"));
        carTypeTableColumn.setCellValueFactory(new PropertyValueFactory<AssignTasks, String>("carType"));
        carTypeTableColumn1.setCellValueFactory(new PropertyValueFactory<AssignTasks, String>("worker"));

        

        

        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("AssignTasksInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            AssignTasks p;
            try {
                while (true) {
                    p = (AssignTasks) ois.readObject();
                    AssignTasksInfo.add(p);
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
        assignTasksTableView.setItems(AssignTasksInfo);
        System.out.println(AssignTasksInfo.toString());
    }
    @FXML
    private void carTypeSelectOnAction(ActionEvent event) {
        String selectedCarType = selectCarTypeComboBox.getValue();
        if (selectedCarType != null) {
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
}
}    