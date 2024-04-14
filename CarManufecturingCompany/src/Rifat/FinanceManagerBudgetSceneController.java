/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;

import Dip.AppendableObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
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
public class FinanceManagerBudgetSceneController implements Initializable {

    @FXML
    private TextField yearTF;
    @FXML
    private TextField partsBudgetTF;
    @FXML
    private TextField lunchBudgetTF;
    @FXML
    private TextField salaryBudgetTF;
    @FXML
    private TextField marketingBudgetTF;
    @FXML
    private TableView<Budget> budgetTableView;
    @FXML
    private TableColumn<Budget, String> yearTableColumn;
    @FXML
    private TableColumn<Budget, Double> partsBudgetTableColumn;
    @FXML
    private TableColumn<Budget, Double> lunchBudgetTableColumn;
    @FXML
    private TableColumn<Budget, Double> salaryBudgetTableColumn;
    @FXML
    private TableColumn<Budget, Double> marketingBudgetTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
public void initialize(URL url, ResourceBundle rb) {
    // Initialize TableView columns
    yearTableColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
    partsBudgetTableColumn.setCellValueFactory(new PropertyValueFactory<>("partsBudget"));
    lunchBudgetTableColumn.setCellValueFactory(new PropertyValueFactory<>("lunchBudget"));
    salaryBudgetTableColumn.setCellValueFactory(new PropertyValueFactory<>("salaryBudget"));
    marketingBudgetTableColumn.setCellValueFactory(new PropertyValueFactory<>("marketingBudget"));
}
    

    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/FinanceManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
private void submitButtonOnMouseClicked(ActionEvent event) {
    // Parse the text from text fields to double values
    double partsBudgetValue = Double.parseDouble(partsBudgetTF.getText());
    double lunchBudgetValue = Double.parseDouble(lunchBudgetTF.getText());
    double salaryBudgetValue = Double.parseDouble(salaryBudgetTF.getText());
    double marketingBudgetValue = Double.parseDouble(marketingBudgetTF.getText());
    
    // Create a new Budget object
    Budget budget = new Budget(
        yearTF.getText(),
        partsBudgetValue,
        lunchBudgetValue,
        salaryBudgetValue,
        marketingBudgetValue
    );

    // Define file output streams
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    File f = null;
    try {
        f = new File("BudgetInfo.bin");
        if (f.exists()) {
            fos = new FileOutputStream(f, true);
            oos = new AppendableObjectOutputStream(fos);
        } else {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
        }

        // Write the Budget object to the file
        oos.writeObject(budget);

    } catch (IOException ex) {
        Logger.getLogger(FinanceManagerBudgetSceneController.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (oos != null) {
                oos.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(FinanceManagerBudgetSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Clear text fields
    yearTF.clear();
    partsBudgetTF.clear();
    lunchBudgetTF.clear();
    salaryBudgetTF.clear();
    marketingBudgetTF.clear();
}


    @FXML
private void loadButtonOnMouseClicked(ActionEvent event) {
    // Create an observable list to store loaded Budget objects
    ObservableList<Budget> budgetList = FXCollections.observableArrayList();

    // Define file input streams
    FileInputStream fis = null;
    ObjectInputStream ois = null;

    try {
        // Open the file for reading
        File file = new File("BudgetInfo.bin");
        fis = new FileInputStream(file);
        ois = new ObjectInputStream(fis);

        // Read Budget objects from the file and add them to the observable list
        while (true) {
            Budget budget = (Budget) ois.readObject();
            budgetList.add(budget);
        }
    } catch (EOFException e) {
        // End of file reached, do nothing
    } catch (IOException | ClassNotFoundException ex) {
        Logger.getLogger(FinanceManagerBudgetSceneController.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Close input streams
        try {
            if (ois != null) {
                ois.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(FinanceManagerBudgetSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Set the loaded budget list to the table view
    budgetTableView.setItems(budgetList);
}
}
