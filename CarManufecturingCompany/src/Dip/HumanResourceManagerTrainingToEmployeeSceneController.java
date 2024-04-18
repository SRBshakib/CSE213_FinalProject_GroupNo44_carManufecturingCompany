/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class HumanResourceManagerTrainingToEmployeeSceneController implements Initializable {

    @FXML
    private TextField callnameTF;
    @FXML
    private TextField callIdTF;
    @FXML
    private DatePicker trainingFromDP;
    @FXML
    private DatePicker trainingToDP;
    @FXML
    private ComboBox<String> trainingTypeCB;
    @FXML
    private ComboBox<String> trainingNameCB;
    private ComboBox<String> trainingCourseNameCB;
    @FXML
    private ComboBox<String> trainingFeesCB;
    @FXML
    private TableColumn<Training, String> nameShowTC;
    @FXML
    private TableColumn<Training, Integer> idShowTC;
    @FXML
    private TableColumn<Training, LocalDate> trainingFromTC;
    @FXML
    private TableColumn<Training, LocalDate> trainingToTC;
    @FXML
    private TableColumn<Training, String> typeTC;
    @FXML
    private TableColumn<Training, String> trainingNameTC;
    @FXML
    private TableColumn<Training, String> feesTC;
    @FXML
    private TableColumn<WorkerList, String> callNameTC;
    @FXML
    private TableColumn<WorkerList, Integer> callIdTC;
    @FXML
    private TableColumn<WorkerList, String> callgenderTC;
    @FXML
    private TableView<WorkerList> workerListTV;
    @FXML
    private TableView<Training> trainingShowTV;
    @FXML
    private TableColumn<WorkerList, LocalDate> callDOJTC;
    Integer index;
    ObservableList<WorkerList> workerList = FXCollections.observableArrayList();
    private ArrayList<WorkerList> workerArr;
    private ArrayList<Training> trainingArr;
    @FXML
    private TextField callDOJTF;
    
    private ObservableList<String> onTheJob = FXCollections.observableArrayList("Training on Industry Culture",
                                                                                "Training on Industrial Safety",
                                                                                "Training on Industry Best Practices",
                                                                                "Training by experienced Trainers",
                                                                                "Training on Machineries",
                                                                                "Training on Advanced Technologies");
    private ObservableList<String> offTheJob = FXCollections.observableArrayList("WELDING", 
                                                                                "PAINTING", 
                                                                                "ASSEMBLY", 
                                                                                "MECHATRONICS", "PROGRAMMING","TECHNICAL");
    private ObservableList<String> fitnessTrain = FXCollections.observableArrayList("Body and Mind Training");
    private ObservableList<String> attitudeTrain = FXCollections.observableArrayList("Leadership Abilities Training", 
                                                                                    "Constructive Mindset Development Training");
    @FXML
    private TableColumn<Training, Integer> trainIdTC;
    @FXML
    private TableColumn<Training, String> statusTC;
    
   private static int idCounter = 000;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        workerArr = new ArrayList<WorkerList>();
        trainingArr = new ArrayList<Training>();
        trainingTypeCB.getItems().addAll("On The Job Training(FACTORY)","Off Job Training","Fitness Training","Attitude Training");
        trainingFeesCB.getItems().addAll("Paid by Company",
                "Pertially Paid by Comapny", "Paid By Own");
        
        
        nameShowTC.setCellValueFactory(new PropertyValueFactory<Training, String>("name"));
        idShowTC.setCellValueFactory(new PropertyValueFactory<Training, Integer>("empId"));
        trainingFromTC.setCellValueFactory(new PropertyValueFactory<Training, LocalDate>("dateFrom"));
        trainingToTC.setCellValueFactory(new PropertyValueFactory<Training, LocalDate>("dateTo"));
        typeTC.setCellValueFactory(new PropertyValueFactory<Training, String>("trainingType"));
        trainingNameTC.setCellValueFactory(new PropertyValueFactory<Training, String>("trainingName"));
        feesTC.setCellValueFactory(new PropertyValueFactory<Training, String>("payment"));
        trainIdTC.setCellValueFactory(new PropertyValueFactory<Training, Integer>("trainingId"));
        statusTC.setCellValueFactory(new PropertyValueFactory<Training, String>("status"));

    }    

    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void saveButtonOnMouseClick(ActionEvent event) {
        trainingArr.add(
                new Training(
                generateUniqueId(),
                callnameTF.getText(),
                Integer.parseInt(callIdTF.getText()),
                callDOJTF.getText(),
                trainingFromDP.getValue(),
                trainingToDP.getValue(),
                trainingTypeCB.getValue(),
                trainingNameCB.getValue(),
                trainingFeesCB.getValue()
                ));
        System.out.println(trainingArr.toString());
    }
private int generateUniqueId() {
        return ++idCounter; // Increment the ID counter and return
    }





    @FXML
    private void saveToBinOnClick(ActionEvent event) {
        Training i = new Training(
                generateUniqueId(),
                callnameTF.getText(),
                Integer.parseInt(callIdTF.getText()),
                callDOJTF.getText(),
                trainingFromDP.getValue(),
                trainingToDP.getValue(),
                trainingTypeCB.getValue(),
                trainingNameCB.getValue(),
                trainingFeesCB.getValue()
        );

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Training.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(HumanResourceManagerTrainingToEmployeeSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(HumanResourceManagerTrainingToEmployeeSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        callnameTF.clear();
        callIdTF.clear();
        callDOJTF.clear();
        trainingFromDP.setValue(null);
        trainingToDP.setValue(null);
        trainingTypeCB.setValue(null);
        trainingNameCB.setValue(null);
        trainingFeesCB.setValue(null);

    }

    @FXML
    private void getRowItem(MouseEvent event) {
        index = workerListTV.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        callnameTF.setText(callNameTC.getCellData(index).toString());
        callIdTF.setText(callIdTC.getCellData(index).toString());
        callDOJTF.setText(callDOJTC.getCellData(index).toString());
    }

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        ObservableList<WorkerList> workerArr = FXCollections.observableArrayList();

        callNameTC.setCellValueFactory(new PropertyValueFactory<WorkerList, String>("name"));
        callIdTC.setCellValueFactory(new PropertyValueFactory<WorkerList, Integer>("uniqueid"));
        callDOJTC.setCellValueFactory(new PropertyValueFactory<WorkerList, LocalDate>("doj"));
        callgenderTC.setCellValueFactory(new PropertyValueFactory<WorkerList, String>("gender"));

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("WorkerDirectory.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            WorkerList p;
            try {
                while (true) {
                    p = (WorkerList) ois.readObject();
                    workerArr.add(p);
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
        workerListTV.setItems(workerArr);
    }

    @FXML
    private void showButtonOnMouseClick(ActionEvent event) {
        ObservableList<Training> trainingArr = FXCollections.observableArrayList();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Training.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Training p;
            try {
                while (true) {
                    p = (Training) ois.readObject();
                    trainingArr.add(p);
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
        trainingShowTV.setItems(trainingArr);
        System.out.println(trainingArr.toString());
    }

    @FXML
    private void selectTrainingTypeOnClick(ActionEvent event) {
        String selectedTrainingType = trainingTypeCB.getValue();
        switch (selectedTrainingType) {
            case "On The Job Training(FACTORY)":
                trainingNameCB.setItems(onTheJob);
                break;
            case "Off Job Training":
                trainingNameCB.setItems(offTheJob);
                break;
             case "Fitness Training":
                trainingNameCB.setItems(fitnessTrain);
                break;
            case "Attitude Training":
                trainingNameCB.setItems(attitudeTrain);
                break;
            
            default:
                trainingNameCB.getItems().clear(); // Clear the ComboBox if no specific car type is selected
                break;
    }
    }
        
    @FXML
    private void selectTrainingNameOnClick(ActionEvent event) {
        
   }

    
}
