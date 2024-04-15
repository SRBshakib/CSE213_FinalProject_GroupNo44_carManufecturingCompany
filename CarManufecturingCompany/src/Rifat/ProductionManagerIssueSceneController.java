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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import srbshakib.FlagAReport;

public class ProductionManagerIssueSceneController implements Initializable {

    
    
    @FXML
    private TableColumn<FlagAReport, Integer> idTableColumn;
    @FXML
    private TableColumn<FlagAReport, String> carModelNoTableColumn;
    @FXML
    private TableColumn<FlagAReport, String> carTypeTableColumn;
    @FXML
    private TableColumn<FlagAReport, String> problemTypeTableColumn;
    @FXML
    private TableColumn<FlagAReport, String> commentsTableColumn;
    @FXML
    private TableColumn<FlagAReport, String> statusTableColumn;
    @FXML
    private TableView<FlagAReport> issueTableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    

    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/ProductionManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

      

    @FXML
    private void loadReportsOnMouseClicked(ActionEvent event) {
        ObservableList<FlagAReport> flagReportInfo = FXCollections.observableArrayList();

        idTableColumn.setCellValueFactory(new PropertyValueFactory<FlagAReport,Integer>("workerId"));
        carModelNoTableColumn.setCellValueFactory(new PropertyValueFactory<FlagAReport,String>("carModelNo"));
        carTypeTableColumn.setCellValueFactory(new PropertyValueFactory<FlagAReport, String>("carType"));
        problemTypeTableColumn.setCellValueFactory(new PropertyValueFactory<FlagAReport, String>("problemType"));
        commentsTableColumn.setCellValueFactory(new PropertyValueFactory<FlagAReport, String>("comments"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<FlagAReport, String>("Status"));
        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("FlagReportInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            FlagAReport p;
            try {
                while (true) {
                    p = (FlagAReport) ois.readObject();
                    flagReportInfo.add(p);
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
        issueTableView.setItems(flagReportInfo);
        System.out.println(flagReportInfo.toString());
    }

    
    
}
    
  

  
