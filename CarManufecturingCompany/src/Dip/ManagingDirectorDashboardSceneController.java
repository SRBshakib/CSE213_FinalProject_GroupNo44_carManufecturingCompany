/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

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
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class ManagingDirectorDashboardSceneController implements Initializable {

    private TextArea noticeBoardTA;
    @FXML
    private TextArea noticeOutputTA;
    @FXML
    private ComboBox<String> NoticeUserSelectCB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NoticeUserSelectCB.getItems().addAll("Managing Director",
                "Human Resource Manager");
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
        Stage newWindow = new Stage();
        newWindow.setTitle("Terms And Conditions");
        newWindow.setScene(scene1);
        newWindow.show();

    }

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

    @FXML
    private void signOutOnClick(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirm");
        a.setContentText("Are you sure to SIgnOut?");

        Optional<ButtonType> result = a.showAndWait();
        if (result.get() == ButtonType.OK) {
            Parent mainSceneParent = FXMLLoader.load(getClass().getResource("/mainpkg/LoginScene.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
            showCustomInformationAlert("Have a Good Day.");
        } else {
            //show appropriate cancellation message
            showCustomInformationAlert("You choose to stay in Dashboard!");
        }

    }

    private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();
    }

    @FXML
    private void refreshNoticeButtonOnClick(ActionEvent event) {
        if (NoticeUserSelectCB.getValue().equals("Managing Director")) {
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
        } else {
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
