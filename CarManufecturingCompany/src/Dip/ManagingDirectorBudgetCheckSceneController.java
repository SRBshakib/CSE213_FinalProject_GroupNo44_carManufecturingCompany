/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

import Rifat.Budget;
import Rifat.FinanceManagerBudgetSceneController;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
 * @author DIPAYON
 */
public class ManagingDirectorBudgetCheckSceneController implements Initializable {

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
    @FXML
    private TextField searchTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    yearTableColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
    partsBudgetTableColumn.setCellValueFactory(new PropertyValueFactory<>("partsBudget"));
    lunchBudgetTableColumn.setCellValueFactory(new PropertyValueFactory<>("lunchBudget"));
    salaryBudgetTableColumn.setCellValueFactory(new PropertyValueFactory<>("salaryBudget"));
    marketingBudgetTableColumn.setCellValueFactory(new PropertyValueFactory<>("marketingBudget"));

    }    

    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
    Parent mainParent = FXMLLoader.load(getClass().getResource("ManagingDirectorDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
        }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
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

    @FXML
    private void searchButtonOnClick(ActionEvent event) {
        String year = searchTF.getText();
            ObservableList<Budget> matchingInventoryData = searchInventoryByCarModel(year);
            // Clear existing items in the table
            budgetTableView.getItems().clear();
            if (!matchingInventoryData.isEmpty()) {
                budgetTableView.setItems(matchingInventoryData);
            } else {
                // If no matching inventory found, display a message
                System.out.println("No Year found for Budget: " + year);
            }
        }
    

    // Method to search for inventory items by car model
    private ObservableList<Budget> searchInventoryByCarModel(String year) {
        ObservableList<Budget> matchingInventoryData = FXCollections.observableArrayList();
        try (FileInputStream fis = new FileInputStream("BudgetInfo.bin"); 
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                Budget inventory = (Budget) ois.readObject();
                if (inventory.getYear().equals(year)) {
                    matchingInventoryData.add(inventory);
                }
            }
        } catch (EOFException e) {
            // Reached end of file
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return matchingInventoryData;
    }
    
}
