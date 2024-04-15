/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package Rifat;


import Dip.MeetingSchedule;
import Dip.Notice;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FinanceManagerDashboardSceneController implements Initializable {

    @FXML
    private TextArea noticeOutputTA;
    @FXML
    private ComboBox<String> NoticeUserSelectCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NoticeUserSelectCB.getItems().addAll("Managing Director",
                "Human Resource Manager");
        // TODO
    }    

    @FXML
    private void homeButtonOnMuseClicked(ActionEvent event) {
    }

    @FXML
    private void paymentButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("FinanceManagerPaymentScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void transactionButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("FinanceManagerTransactionScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void budgetButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("FinanceManagerBudgetScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();

    }

    @FXML
    private void financialReportButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("FinanceManagerFinancialReportScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();


    }


    @FXML
    private void salaryDistrubutionButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("FinanceManagerSalaryDistributionScene.fxml"));

        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();

    }

        

    @FXML
    private void dealerInfoButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("FinanceManagerDealerInfoScene.fxml"));

        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }


    

    @FXML
    private void auditButtonOnMuseClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("FinanceManagerAuditScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void refreshNoticeButtonOnClick(ActionEvent event) {
        if (NoticeUserSelectCB.getValue().equals("Managing Director")){
        ObjectInputStream ois = null;
        try {
            MeetingSchedule s;
            FileInputStream fis = new FileInputStream("Schedule.bin");
            ois = new ObjectInputStream(fis);

            noticeOutputTA.setText(null);

            while (true) {
                s = (MeetingSchedule) ois.readObject();

                noticeOutputTA.appendText(s.toString() + "\n");
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
    }else{
        ObjectInputStream ois = null;
        try {
            Notice s;
            FileInputStream fis = new FileInputStream("Notice.bin");
            ois = new ObjectInputStream(fis);

            noticeOutputTA.setText(null);

            while (true) {
                s = (Notice) ois.readObject();

                noticeOutputTA.appendText(s.toString() + "\n");
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

       }
    

