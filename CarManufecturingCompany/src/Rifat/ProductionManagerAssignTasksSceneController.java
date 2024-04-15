
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
    private TableColumn<AssignTasks, String> startingDateTableColumn;
    @FXML
    private TableColumn<AssignTasks, String> endingDateTableColumn;
    private TableColumn<AssignTasks, String> carModelTableColumn;
    @FXML
    private TableColumn<AssignTasks, String> carTypeTableColumn;
    @FXML
    private TextField destinationTextField;
    @FXML
    private TextField startingDateTextField;
    @FXML
    private TextField endingDateTextField;
    @FXML
    private TextField assemblingCarModelTextField;
    @FXML
    private ComboBox<String> selectCarTypeComboBox;
    @FXML
    private TableColumn<AssignTasks, String> assemblingCarModelTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize car type ComboBox
        selectCarTypeComboBox.getItems().addAll("Sedan", "Hatchback", "SUV", "Crossover", "Coupe", "Convertible", "Minivan", "Truck", "Electric Vehicle (EV)");
                            
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
              
                destinationTextField.getText(),
                startingDateTextField.getText(),
                endingDateTextField.getText(),
                assemblingCarModelTextField.getText(),
                selectCarTypeComboBox.getValue()
                
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
        
        
        destinationTextField.clear();
        startingDateTextField.clear();
        endingDateTextField.clear();
        assemblingCarModelTextField.clear();        
        selectCarTypeComboBox.setValue(null);
    }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        ObservableList<AssignTasks> AssignTasksInfo = FXCollections.observableArrayList();

        destinationTableColumn.setCellValueFactory(new PropertyValueFactory<AssignTasks,String>("destination"));
        startingDateTableColumn.setCellValueFactory(new PropertyValueFactory<AssignTasks, String>("startingDate"));
        endingDateTableColumn.setCellValueFactory(new PropertyValueFactory<AssignTasks, String>("endingDate"));
        assemblingCarModelTableColumn.setCellValueFactory(new PropertyValueFactory<AssignTasks, String>("assemblingCarModel"));
        carTypeTableColumn.setCellValueFactory(new PropertyValueFactory<AssignTasks, String>("carType"));

        
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
    private void carTypeSelectOnAction(ActionEvent event) {String selectedCarType = selectCarTypeComboBox.getValue();
        switch (selectedCarType) {
            case "Sedan":
                assemblingCarModelTextField.getText();
                break;
            case "Hatchback":
                assemblingCarModelTextField.getText();
                break;
             case "SUV":
                assemblingCarModelTextField.getText();
                break;
            case "Crossover":
                assemblingCarModelTextField.getText();
                break;
            case "Coupe":
                assemblingCarModelTextField.getText();
                break;
            case "Convertible":
                assemblingCarModelTextField.getText();
                break;
            case "Minivan":
                assemblingCarModelTextField.getText();
                break;
            case "Truck":
                assemblingCarModelTextField.getText();
                break;
            case "Electric Vehicle (EV)":
                assemblingCarModelTextField.getText();
            default:
                assemblingCarModelTextField.clear(); // Clear the ComboBox if no specific car type is selected
                break;
        }
        
    }
}
