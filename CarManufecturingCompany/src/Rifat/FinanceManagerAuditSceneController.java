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
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class FinanceManagerAuditSceneController implements Initializable {

    @FXML
    private DatePicker auditDatePicker;
    @FXML
    private TextArea auditDetailsTextArea;
    @FXML
    private TableView<Audit> auditTableView;
    
    @FXML
    private TableColumn<Audit, String> dateColumnTable;
    @FXML
    private TableColumn<Audit, String> detailsColumnTable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateColumnTable.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailsColumnTable.setCellValueFactory(new PropertyValueFactory<>("details"));
    }



    @FXML
    private void submitAuditButtonOnMouseClicked(ActionEvent event) {
        // Get the selected date and details
        LocalDate selectedDate = auditDatePicker.getValue();
        String details = auditDetailsTextArea.getText();

        // Create a new Audit object
        Audit audit = new Audit(selectedDate.toString(), details);

        // Serialize and save the Audit object to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("AuditInfo.bin", true))) {
            oos.writeObject(audit);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Clear input fields
        auditDatePicker.setValue(null);
        auditDetailsTextArea.clear();
    }
    

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        // Clear existing items from the table
        auditTableView.getItems().clear();

        // Deserialize and load Audit objects from file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("AuditInfo.bin"))) {
            Object obj;
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof Audit) {
                    Audit audit = (Audit) obj;
                    auditTableView.getItems().add(audit);
                }
            }
        } catch (EOFException ex) {
            // Reached end of file, no more objects to read
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
    


