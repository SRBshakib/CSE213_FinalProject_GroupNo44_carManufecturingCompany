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
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class HumanResourceManagerDirectorySceneController implements Initializable {

    @FXML
    private TableColumn<EmployeeList, String> nameTC;
    @FXML
    private TableColumn<EmployeeList, Integer> idTC;
    @FXML
    private TableColumn<EmployeeList, String> genderTC;
    @FXML
    private TableColumn<EmployeeList, String> designationTC;
    @FXML
    private TableColumn<EmployeeList, Integer> phoneTC;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private TextArea addressTA;
    private ComboBox<String> designationCB;
    @FXML
    private TextField idTF;
    private ArrayList<EmployeeList> empArr;
    private ArrayList<WorkerList> workerArr;
    private ArrayList<NewJoining> newJoiningArr;

    private ComboBox<String> selectWhatToUpdateCB;
    @FXML
    private TextArea educationTA;
    @FXML
    private TableView<EmployeeList> empTV;
    @FXML
    private TableView<WorkerList> wrkTV;
    @FXML
    private TableColumn<WorkerList, String> nameWrkTC;
    @FXML
    private TableColumn<WorkerList, Integer> idWrkTC;
    @FXML
    private TableColumn<WorkerList, String> genderWrkTC;
    @FXML
    private TableColumn<WorkerList, String> designationWrkTC;
    @FXML
    private TableColumn<WorkerList, Integer> phoneWrkTC;
    @FXML
    private TableColumn<NewJoining, Integer> callIdTC;
    @FXML
    private TableColumn<NewJoining, String> callNameTC;
    @FXML
    private TableColumn<NewJoining, String> callGenderTC;
    @FXML
    private TableColumn<NewJoining, LocalDate> callDateOfBirthTC;
    @FXML
    private TableColumn<NewJoining, LocalDate> callDateOfJoinTC;
    @FXML
    private TableColumn<NewJoining, String> callDesignationTC;
    @FXML
    private TableView<NewJoining> callNewJoiningTV;
    Integer index;
    @FXML
    private TextField genderTF;
    @FXML
    private TextField designationTF;
    @FXML
    private DatePicker dOBDP;
    @FXML
    private DatePicker dOJDP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        empArr = new ArrayList<EmployeeList>();
        workerArr = new ArrayList<WorkerList>();
        newJoiningArr = new ArrayList<NewJoining>();
        callNewJoiningTV.setEditable(true);
        callNewJoiningTV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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

        nameTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("name"));
        idTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, Integer>("uniqueid"));
        genderTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("gender"));
        designationTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("designation"));
        phoneTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, Integer>("phone"));

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
    private void viewDetailsOnClickWorker(ActionEvent event) {
    }

    @FXML
    private void loadButtonOnClickWorker(ActionEvent event) {
        ObservableList<WorkerList> workerArr = FXCollections.observableArrayList();

        nameWrkTC.setCellValueFactory(new PropertyValueFactory<WorkerList, String>("name"));
        idWrkTC.setCellValueFactory(new PropertyValueFactory<WorkerList, Integer>("uniqueid"));
        genderWrkTC.setCellValueFactory(new PropertyValueFactory<WorkerList, String>("gender"));
        designationWrkTC.setCellValueFactory(new PropertyValueFactory<WorkerList, String>("designation"));
        phoneWrkTC.setCellValueFactory(new PropertyValueFactory<WorkerList, Integer>("phone"));

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

    @FXML
    private void getItems(MouseEvent event) {
        index = callNewJoiningTV.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        idTF.setText(callIdTC.getCellData(index).toString());
        nameTF.setText(callNameTC.getCellData(index).toString());
        genderTF.setText(callGenderTC.getCellData(index).toString());
        LocalDate dateOfJoin = (LocalDate) callDateOfJoinTC.getCellData(index);
        if (dateOfJoin != null) {
            dOJDP.setValue(dateOfJoin);
        }
        LocalDate dateOfBirth = (LocalDate) callDateOfBirthTC.getCellData(index);
        if (dateOfBirth != null) {
            dOBDP.setValue(dateOfBirth);
        }

        designationTF.setText(callDesignationTC.getCellData(index).toString());
    }

    @FXML
    private void updateLoadbuttonOnClick(ActionEvent event) {
        ObservableList<NewJoining> newjoiningArr = FXCollections.observableArrayList();
        callIdTC.setCellValueFactory(new PropertyValueFactory<NewJoining, Integer>("uniqueid"));
        callNameTC.setCellValueFactory(new PropertyValueFactory<NewJoining, String>("name"));
        callGenderTC.setCellValueFactory(new PropertyValueFactory<NewJoining, String>("gender"));
        callDateOfJoinTC.setCellValueFactory(new PropertyValueFactory<NewJoining, LocalDate>("dob"));
        callDateOfBirthTC.setCellValueFactory(new PropertyValueFactory<NewJoining, LocalDate>("doj"));
        callDesignationTC.setCellValueFactory(new PropertyValueFactory<NewJoining, String>("designation"));

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("NewJoining.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            NewJoining p;
            try {
                while (true) {
                    p = (NewJoining) ois.readObject();
                    newjoiningArr.add(p);
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
        callNewJoiningTV.setItems(newjoiningArr);
        System.out.println(newjoiningArr.toString());
    }

    @FXML
    private void addToBinButtonOnMouseClick(ActionEvent event) {

        if (designationTF.getText().equals("Assambly Line Worker")) {
//        String selectdesignation = designationTF.getText();
//        switch (selectdesignation) {
//            case "Assambly Line Worker":

            WorkerList j = new WorkerList(
                    emailTF.getText(),
                    Integer.parseInt(phoneTF.getText()),
                    addressTA.getText(),
                    educationTA.getText(),
                    Integer.parseInt(idTF.getText()),
                    nameTF.getText(),
                    genderTF.getText(),
                    designationTF.getText(),
                    dOBDP.getValue(),
                    dOJDP.getValue());

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
            designationTF.clear();
            emailTF.clear();
            phoneTF.clear();
            addressTA.clear();
            educationTA.clear();
            idTF.clear();
            dOBDP.setValue(null);
            dOJDP.setValue(null);
//                break;
        } else {
            EmployeeList i = new EmployeeList(
                    emailTF.getText(),
                    Integer.parseInt(phoneTF.getText()),
                    addressTA.getText(),
                    educationTA.getText(),
                    Integer.parseInt(idTF.getText()),
                    nameTF.getText(),
                    genderTF.getText(),
                    designationTF.getText(),
                    dOBDP.getValue(),
                    dOJDP.getValue());
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
            designationTF.clear();
            emailTF.clear();
            phoneTF.clear();
            addressTA.clear();
            educationTA.clear();
            idTF.clear();
            dOBDP.setValue(null);
            dOJDP.setValue(null);
        }
    }

    @FXML
    private void addArrayButtonOnMouseClick(ActionEvent event) {
        
            if (emailTF.getText().isEmpty()
                    || phoneTF.getText().isEmpty()
                    || addressTA.getText().isEmpty()
                    || educationTA.getText().isEmpty()
                    || idTF.getText().isEmpty()
                    || nameTF.getText().isEmpty()
                    || genderTF.getText().isEmpty()
                    || designationTF.getText().isEmpty()
                    || nameTF.getText().isEmpty()
                    || dOBDP.getValue() == null
                    || dOJDP.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the information");
                alert.showAndWait();
            } else {

                if (callDesignationTC.cellValueFactoryProperty().equals("Assambly Line Worker")) {

                    workerArr.add(
                            new WorkerList(
                                    emailTF.getText(),
                                    Integer.parseInt(phoneTF.getText()),
                                    addressTA.getText(),
                                    educationTA.getText(),
                                    Integer.parseInt(idTF.getText()),
                                    nameTF.getText(),
                                    genderTF.getText(),
                                    designationTF.getText(),
                                    dOBDP.getValue(),
                                    dOJDP.getValue()));
                    System.out.println(workerArr.toString());

                } else {

                    empArr.add(
                            new EmployeeList(
                                    emailTF.getText(),
                                    Integer.parseInt(phoneTF.getText()),
                                    addressTA.getText(),
                                    educationTA.getText(),
                                    Integer.parseInt(idTF.getText()),
                                    nameTF.getText(),
                                    genderTF.getText(),
                                    designationTF.getText(),
                                    dOBDP.getValue(),
                                    dOJDP.getValue()));
                    System.out.println(empArr.toString());

                }
            }
        }
    }

