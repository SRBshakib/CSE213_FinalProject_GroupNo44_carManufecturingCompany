/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProductionManagerIssueSceneController implements Initializable {

    @FXML
    private TextField titleTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TableView<Issue> issueTableView;
    @FXML
    private TableColumn<Issue, String> titleTableColumn;
    @FXML
    private TableColumn<Issue, String> descriptionTableColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize table columns
        titleTableColumn.setCellValueFactory(cellData -> {
            cellData.getValue().titleProperty();
            return null;
        });
        descriptionTableColumn.setCellValueFactory(cellData -> {
            cellData.getValue().descriptionProperty();
            return null;
        });
    }    

    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/ProductionManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void submitButtonOnMouseClicked(ActionEvent event) {
        // Get data from text fields
        String title = titleTextField.getText();
        String description = descriptionTextArea.getText();
        
        // Create an Issue object
        Issue issue = new Issue(title, description);
        
        // Store data to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Issue.bin"))) {
            oos.writeObject(issue);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        // Clear text fields after submission
        titleTextField.clear();
        descriptionTextArea.clear();
    }

    @FXML
    private void cancelButtonOnMouseClicked(ActionEvent event) {
        // Clear text fields on cancel
        titleTextField.clear();
        descriptionTextArea.clear();
    }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
    // Load data from file and populate the table view
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Issue.bin"))) {
        ObservableList<Issue> issueList = FXCollections.observableArrayList();
        while (true) {
            try {
                Issue issue = (Issue) ois.readObject();
                issueList.add(issue);
            } catch (EOFException e) {
                break; // Break the loop when end of file is reached
            }
        }
        issueTableView.setItems(issueList);
    } catch (IOException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }
}



}
