/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ManagingDirectorDashboardSceneController implements Initializable {

    @FXML
    private TextArea noticeBoardTA;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void set_Schedule_Button_On_Click(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagingDirectorScheduleScene.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
        
    }

    @FXML
    private void termsAndConditionsButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagingDirectorTermsAndConditionsScene.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
    }

    @FXML
    private void auditCheckButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagingDirectorAuditCheckScene.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
    }

    @FXML
    private void newModelsOfCarButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagingDirectorNewModelsOfCarCheckScene.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
    }

    @FXML
    private void addFundButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagingDirectorAddFundCheckFundScene.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
    }

    @FXML
    private void checkInventoryButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagingDirectorInventoryCheckScene.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
    }

    @FXML
    private void budgetButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagingDirectorBudgetCheckScene.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
    }

    @FXML
    private void directoryButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagingDirectorDirectoryCheckScene.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
    }

    @FXML
    private void termsAndConditonsReadHyperLinkOnClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ManagingDirectorTemsAndConditionsReadScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage newWindow  = new Stage();
        newWindow.setTitle("Terms And Conditions");
        newWindow.setScene(scene1);
        newWindow.show();
        
    }

    @FXML
    private void refreshNoticeBoardOnClick(ActionEvent event) {
        ObjectInputStream ois = null;
        try {
            MeetingSchedule s;
            FileInputStream fis = new FileInputStream("Schedule.bin");
            ois = new ObjectInputStream(fis);

            noticeBoardTA.setText(null);

            while (true) {
                s = (MeetingSchedule) ois.readObject();

                noticeBoardTA.appendText(s.toString() + "\n");
            }

        } catch (RuntimeException e) {
            e.printStackTrace();

        } catch (Exception ex) {

            try {
                System.out.println(ex.toString());
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
            }
        }
    }
    }
    

