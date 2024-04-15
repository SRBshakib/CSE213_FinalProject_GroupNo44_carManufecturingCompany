package Dip;

import java.io.DataOutputStream;
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
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HumanResourceManagerSalaryManagmentSceneController implements Initializable {

    @FXML
    private TableView<EmployeeList> salaryTV;
    @FXML
    private TableColumn<EmployeeList, String> nameTC;
    @FXML
    private TableColumn<EmployeeList, Integer> idTC;
    @FXML
    private TableColumn<EmployeeList, LocalDate> dOJTC;

    private ArrayList<EmployeeList> empArr;
    private ArrayList<Salary> salaryArr;

    @FXML
    private TextField nameTF;
    @FXML
    private TextField idTF;
    @FXML
    private TextField dOJTF;
    @FXML
    private TableColumn<EmployeeList, String> genderTC;
    @FXML
    private TextField amountTF;
    @FXML
    private TableView<Salary> salaryShowTV;
    @FXML
    private TableColumn<Salary, String> nameShowTC;
    @FXML
    private TableColumn<Salary, Integer> idShowTC;
    @FXML
    private TableColumn<Salary, String> dOJShowTC;
    @FXML
    private TableColumn<Salary, Float> salaryAmountShowTC;
    Integer index;
    ObservableList<EmployeeList> empList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        empArr = new ArrayList<EmployeeList>();
        salaryArr = new ArrayList<Salary>();

        salaryTV.setEditable(true);
        salaryTV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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
        if (nameTF.getText().isEmpty() 
                || idTF.getText().isEmpty()
                ||dOJTF.getText().isEmpty()
                ||amountTF.getText().isEmpty() ) {
        salaryArr.add(
                new Salary(
                        nameTF.getText(),
                        Integer.parseInt(idTF.getText()),
                        dOJTF.getText(),
                        Float.parseFloat(amountTF.getText())));
        System.out.println(salaryArr.toString());
    }}

    @FXML
    private void showButtonOnMouseClick(ActionEvent event) {
        ObservableList<Salary> salaryArr = FXCollections.observableArrayList();

        nameShowTC.setCellValueFactory(new PropertyValueFactory<Salary, String>("empName"));
        idShowTC.setCellValueFactory(new PropertyValueFactory<Salary, Integer>("empId"));
        dOJShowTC.setCellValueFactory(new PropertyValueFactory<Salary, String>("empDoj"));
        salaryAmountShowTC.setCellValueFactory(new PropertyValueFactory<Salary, Float>("empSalary"));

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("SalaryInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Salary p;
            try {
                while (true) {
                    p = (Salary) ois.readObject();
                    salaryArr.add(p);
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
        salaryShowTV.setItems(salaryArr);
        System.out.println(salaryArr.toString());
    }

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        ObservableList<EmployeeList> empList = FXCollections.observableArrayList();

        nameTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("name"));
        idTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, Integer>("uniqueid"));
        dOJTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, LocalDate>("doj"));
        genderTC.setCellValueFactory(new PropertyValueFactory<EmployeeList, String>("gender"));

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
        salaryTV.setItems(empList);
//        System.out.println(empArr.toString());
    }

    @FXML
    private void getItem(MouseEvent event) {
        index = salaryTV.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        nameTF.setText(nameTC.getCellData(index).toString());
        idTF.setText(idTC.getCellData(index).toString());
        dOJTF.setText(dOJTC.getCellData(index).toString());

    }

    @FXML
    private void saveToBinOnClick(ActionEvent event) {
        Salary i = new Salary(
                nameTF.getText(),
                Integer.parseInt(idTF.getText()),
                dOJTF.getText(),
                Float.parseFloat(amountTF.getText())
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("SalaryInfo.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(HumanResourceManagerSalaryManagmentSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(HumanResourceManagerSalaryManagmentSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        nameTF.clear();
        amountTF.clear();
        idTF.clear();
        dOJTF.clear();
    }
}
