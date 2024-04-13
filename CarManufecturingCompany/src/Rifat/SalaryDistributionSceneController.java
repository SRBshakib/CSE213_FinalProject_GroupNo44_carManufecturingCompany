/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;

import Dip.EmployeeList;
import Dip.Salary;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SalaryDistributionSceneController implements Initializable {

    @FXML
    private TextField amountTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField idTF;
    @FXML
    private TextField dOJTF;
    @FXML
    private TableView<Salary> salaryTV;
    @FXML
    private TableColumn<Salary, String> nameTC;
    @FXML
    private TableColumn<Salary, Integer> idTC;
    @FXML
    private TableColumn<Salary, String> dOJTC;
    @FXML
    private TableColumn<Salary, Float> salaryAmountTC;
    
    private ArrayList<EmployeeList> empArr;
    private ArrayList<Salary> salaryArr;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        empArr = new ArrayList<EmployeeList>();
        salaryArr = new ArrayList<Salary>();

        salaryTV.setEditable(true);
        salaryTV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
        
   

    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        // Go back to the Finance Manager Dashboard scene
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/FinanceManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void distributeButtonOnMouseClick(ActionEvent event) {
        // Add salary to the TableView
        String empName = nameTF.getText();
        int empId = Integer.parseInt(idTF.getText());
        String empDOJ = dOJTF.getText();
        float empSalary = Float.parseFloat(amountTF.getText());
        Salary newSalary = new Salary(empName, empId, empDOJ, empSalary);
        salaryTV.getItems().add(newSalary);
    }

    @FXML
    private void saveToBinOnClick(ActionEvent event) {
        // Save salary data to a binary file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SalaryInfo.bin"))) {
            for (Salary salary : salaryTV.getItems()) {
                oos.writeObject(salary);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        // Load salary data from a binary file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SalaryInfo.bin"))) {
            Salary salary;
            while ((salary = (Salary) ois.readObject()) != null) {
                salaryTV.getItems().add(salary);
            }
        } catch (EOFException ex) {
            // Reached end of file
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void getItem(MouseEvent event) {
        // Handle mouse click event
        Salary selectedSalary = salaryTV.getSelectionModel().getSelectedItem();
        if (selectedSalary != null) {
           // nameTF.setText(selectedSalary.getName());
            //idTF.setText(String.valueOf(selectedSalary.getId()));
            //dOJTF.setText(selectedSalary.getDoj());
            //amountTF.setText(String.valueOf(selectedSalary.getSalary()));
        }
    }
}
