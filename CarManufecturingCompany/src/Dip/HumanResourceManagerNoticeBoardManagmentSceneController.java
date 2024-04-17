/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class HumanResourceManagerNoticeBoardManagmentSceneController implements Initializable {

    @FXML
    private DatePicker noticeDP;
    @FXML
    private TextArea noticeTA;
    @FXML
    private ComboBox<String> deptCB;
    @FXML
    private TextArea noticeShowTA;
    private ArrayList<Notice> noticeArr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deptCB.getItems().addAll(
                "Assambly Line Worker",
                "Managing Director",
                "Human Resource Manager",
                "Finance Manager",
                "Supply Chain Manager",
                "Production Manager", "All Employee");
        noticeArr = new ArrayList<Notice>();

    }

    @FXML
    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("HumanResourceManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void sendButtonOnClick(ActionEvent event) {
        Notice j = new Notice(
                noticeDP.getValue(),
                deptCB.getValue(),
                noticeTA.getText());

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Notice.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(j);

        } catch (IOException ex) {
            Logger.getLogger(HumanResourceManagerNoticeBoardManagmentSceneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(HumanResourceManagerNoticeBoardManagmentSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void showButtonOnClick(ActionEvent event) {
        ObjectInputStream ois = null;
        try {
            Notice s;
            FileInputStream fis = new FileInputStream("Notice.bin");
            ois = new ObjectInputStream(fis);

            noticeShowTA.setText(null);

            while (true) {
                s = (Notice) ois.readObject();

                noticeShowTA.appendText(s.toString() + "\n");
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
    private void saveButtonOnClick(ActionEvent event) {
        if (noticeDP.getValue() == null
                || deptCB.getValue() == null
                || noticeTA.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the information");
            alert.showAndWait();
        } else {
            noticeArr.add(
                    new Notice(
                            noticeDP.getValue(),
                            deptCB.getValue(),
                            noticeTA.getText()));
        }

    }}
