/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

import Rifat.Audit;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class ManagingDirectorAuditCheckSceneController implements Initializable {

    @FXML
    private TableView<Audit> auditTableView;
    @FXML
    private TableColumn<Audit, String> dateColumnTable;
    @FXML
    private TableColumn<Audit, String> detailsColumnTable;
    @FXML
    private TextArea detailsShowTA;
    @FXML
    private Label dateShowLabel;
Integer index;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateColumnTable.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailsColumnTable.setCellValueFactory(new PropertyValueFactory<>("details"));
    
        // TODO
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

    @FXML
    private void getItems(MouseEvent event) {
        index = auditTableView.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        dateShowLabel.setText(dateColumnTable.getCellData(index).toString());
        detailsShowTA.setText(detailsColumnTable.getCellData(index).toString());
    }
    
}
