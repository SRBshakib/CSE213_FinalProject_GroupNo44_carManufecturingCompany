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
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

    // Clear any existing items
    issueTableView.getItems().clear();
        
        
    }    

    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/ProductionManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void submitButtonOnMouseClicked(ActionEvent event) {
        Issue i= new Issue(
              
                
                titleTextField.getText(),
                descriptionTextArea.getText()
                
        );
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("IssueInfo.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(ProductionManagerIssueSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(ProductionManagerIssueSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        titleTextField.clear();
        descriptionTextArea.clear();
        
    }

    @FXML
    private void loadButtonOnMouseClicked(ActionEvent event) {
        ObservableList<Issue> IssueInfo = FXCollections.observableArrayList();
    
    


        

        titleTableColumn.setCellValueFactory(new PropertyValueFactory<Issue,String>("title"));

        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<Issue, String>("description"));
        
        
        

        

        

        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("IssueInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Issue p;
            try {
                while (true) {
                    p = (Issue) ois.readObject();
                    IssueInfo.add(p);
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
        issueTableView.setItems(IssueInfo);
        System.out.println(IssueInfo.toString());
    }  
  
}
  
