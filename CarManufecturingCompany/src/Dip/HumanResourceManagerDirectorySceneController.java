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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class HumanResourceManagerDirectorySceneController implements Initializable {
   
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy, String> nameTC;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy, Integer> idTC;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy, String> genderTC;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy, String> designationTC;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy, Integer> phoneTC;
    @FXML
    private RadioButton maleRBtn;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private RadioButton femaleRBtn;
    @FXML
    private RadioButton otherRBtn;
    @FXML
    private TextArea addressTA;
    @FXML
    private DatePicker dOBLocalDate;
    @FXML
    private DatePicker dOJLocalDate;
    @FXML
    private ComboBox<String> designationCB;
    @FXML
    private TextField idTF;
    private ArrayList<EmployeeList> empArr;
    private ArrayList<WorkerList> workerArr;

    
    @FXML
    private ComboBox<String> selectWhatToUpdateCB;
    ToggleGroup tg;
    @FXML
    private TextArea educationTA;
    @FXML
    private TableView<EmployeeList> empTV;
    @FXML
    private TableView<WorkerList> wrkTV;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy2, String> nameWrkTC;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy2, Integer> idWrkTC;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy2, String> genderWrkTC;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy2, String> designationWrkTC;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy2, Integer> phoneWrkTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        empArr = new ArrayList<EmployeeList>();
        workerArr =new ArrayList<WorkerList>();
        selectWhatToUpdateCB.getItems().addAll("Assambly Line Worker", "Employee");
        designationCB.getItems().addAll("Assambly Line Worker", "Managing Director", "Human Resource Manager", "Finance Manager", "Supply Chain Manager");
        tg = new ToggleGroup();
        maleRBtn.setToggleGroup(tg);
        femaleRBtn.setToggleGroup(tg);
        otherRBtn.setToggleGroup(tg);
        
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }


    @FXML
    private void loadButtonOnClick(ActionEvent event) {

            ObservableList<EmployeeList> empList = FXCollections.observableArrayList();

            nameTC.setCellValueFactory(new PropertyValueFactory<HumanResourceManagerDirectorySceneDummy, String>("name"));
            idTC.setCellValueFactory(new PropertyValueFactory<HumanResourceManagerDirectorySceneDummy, Integer>("id"));
            genderTC.setCellValueFactory(new PropertyValueFactory<HumanResourceManagerDirectorySceneDummy, String>("gender"));
            designationTC.setCellValueFactory(new PropertyValueFactory<HumanResourceManagerDirectorySceneDummy, String>("designation"));
            phoneTC.setCellValueFactory(new PropertyValueFactory<HumanResourceManagerDirectorySceneDummy, Integer>("phone"));

            File f = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;

            try {
                f = new File("EmployeeDirectory.bin");
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                EmployeeList p;
                try {
                    while (true) {
                        p = (EmployeeList) ois.readObject();
                        empList.add(p);
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
            empTV.setItems(empList);
            System.out.println(empList.toString());
        }
       
    

    @FXML
    private void viewDetailsOnClick(ActionEvent event) {
    }

    @FXML
    private void addButtonOnMouseClick(ActionEvent event) {
        String gender = "";
        if (maleRBtn.isSelected()) {
            gender = "Male";
        } else if (femaleRBtn.isSelected()) {
            gender = "Female";
        } else if (otherRBtn.isSelected()) {
            gender = "Other";
        }
//        if (selectWhatToUpdateCB.getValue().equals("Assambly Line Worker")){
//            designationCB.setValue("Assambly Line Worker");
//        }

        if (selectWhatToUpdateCB.getValue().equals("Employee")) {
            EmployeeList i = new EmployeeList(
                    nameTF.getText(),
                    gender,
                    designationCB.getValue(),
                    dOBLocalDate.getValue(),
                    dOJLocalDate.getValue(),
                    emailTF.getText(),
                    Integer.parseInt(phoneTF.getText()),
                    addressTA.getText(),
                    educationTA.getText(),
                    Integer.parseInt(idTF.getText())
            );
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            File f = null;
            try {
                f = new File("EmployeeDirectory.bin");
                if (f.exists()) {
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                }

                oos.writeObject(i);

            } catch (IOException ex) {
                Logger.getLogger(HumanResourceManagerDirectorySceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (oos != null) {
                        oos.close();

                    }
                } catch (IOException ex) {
                    Logger.getLogger(HumanResourceManagerDirectorySceneController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            nameTF.clear();
            designationCB.setValue(null);
            emailTF.clear();
            phoneTF.clear();
            addressTA.clear();
            educationTA.clear();
            idTF.clear();
            dOBLocalDate.setValue(null);
            dOJLocalDate.setValue(null);
        }
        else if (selectWhatToUpdateCB.getValue().equals("Assambly Line Worker")) {
           WorkerList j = new WorkerList(
                    nameTF.getText(),
                    gender,
                    designationCB.getValue(),
                    dOBLocalDate.getValue(),
                    dOJLocalDate.getValue(),
                    emailTF.getText(),
                    Integer.parseInt(phoneTF.getText()),
                    addressTA.getText(),
                    educationTA.getText(),
                    Integer.parseInt(idTF.getText())
            );
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            File f = null;
            try {
                f = new File("WorkerDirectory.bin");
                if (f.exists()) {
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                }

                oos.writeObject(j);

            } catch (IOException ex) {
                Logger.getLogger(HumanResourceManagerDirectorySceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (oos != null) {
                        oos.close();

                    }
                } catch (IOException ex) {
                    Logger.getLogger(HumanResourceManagerDirectorySceneController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            nameTF.clear();
            designationCB.setValue(null);
            emailTF.clear();
            phoneTF.clear();
            addressTA.clear();
            educationTA.clear();
            idTF.clear();
            dOBLocalDate.setValue(null);
            dOJLocalDate.setValue(null); 
        }

    }

    @FXML
    private void selectWhatToUpdateCBOnMouseClick(ActionEvent event) {
    }

    @FXML
    private void viewDetailsOnClickWorker(ActionEvent event) {
    }

    @FXML
    private void loadButtonOnClickWorker(ActionEvent event) {
            ObservableList<WorkerList> workerArr = FXCollections.observableArrayList();

            nameWrkTC.setCellValueFactory(new PropertyValueFactory<HumanResourceManagerDirectorySceneDummy2, String>("name"));
            idWrkTC.setCellValueFactory(new PropertyValueFactory<HumanResourceManagerDirectorySceneDummy2, Integer>("id"));
            genderWrkTC.setCellValueFactory(new PropertyValueFactory<HumanResourceManagerDirectorySceneDummy2, String>("gender"));
            designationWrkTC.setCellValueFactory(new PropertyValueFactory<HumanResourceManagerDirectorySceneDummy2, String>("designation"));
            phoneWrkTC.setCellValueFactory(new PropertyValueFactory<HumanResourceManagerDirectorySceneDummy2, Integer>("phone"));

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
            wrkTV.setItems(workerArr);
            System.out.println(workerArr.toString());
        }
    

}
