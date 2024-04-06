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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpkg.AppendableObjectOutputStream;
import mainpkg.MeetingSchedule;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class HumanResourceManagerDirectorySceneController implements Initializable {

    @FXML
    private ComboBox<String> personCB;
    @FXML
    private TableView<EmployeeList> personTV;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy, String> nameTC;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy, Integer> idTC;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy, String> genderTC;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy, String> designationTC;
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
    @FXML
    private CheckBox empCheckBox;
    @FXML
    private CheckBox workerCheckBox;
    private ArrayList<EmployeeList> empArr;
    @FXML
    private TableColumn<HumanResourceManagerDirectorySceneDummy, Integer> phoneTC;
    @FXML
    private ComboBox<String> selectWhatToUpdateCB;
    ToggleGroup tg;
    @FXML
    private TextArea educationTA;
    @FXML
    private TextArea outputTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        empArr = new ArrayList<EmployeeList>();
        personCB.getItems().addAll("Assambly Line Worker", "Employee");
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
    private void selectPersonOnClick(ActionEvent event) {
        
    }

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
//        ObjectInputStream ois=null;
//         try {
//             EmployeeList s;
//             FileInputStream fis = new FileInputStream("EmployeeDirectory.bin");
//             ois = new ObjectInputStream(fis);
//             //ois = new ObjectInputStream(new FileInputStream("StudObjects.bin"));
//             
//            outputTextArea.setText(null);
//            
//            //int[] arr={1,2,3};
//            //System.out.println(arr[3]);
//            while(true){
//                s = (EmployeeList) ois.readObject();
//                //s.getId();               
//                //Object obj = ois.readObject();
//                //obj.toString();
//                //studArr.add((Student) ois.readObject());
//                outputTextArea.appendText(s.toString()+"\n");
//                //outputTxtArea.appendText(s+"\n");
//            }
//            //ois.close();
//                       
//        }
//        catch(RuntimeException e){
//            e.printStackTrace();
//             //
//        }
//        catch (Exception ex) {
//           
//            try {
//                System.out.println(ex.toString());
//                if(ois!=null)
//                    ois.close();
//            } catch (IOException ex1) {  }           
//        }  
//        
    
    
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
        personTV.setItems(empList);
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

        if (empCheckBox.isSelected()) {
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

    }

    @FXML
    private void selectWhatToUpdateCBOnMouseClick(ActionEvent event) {
    }

}
