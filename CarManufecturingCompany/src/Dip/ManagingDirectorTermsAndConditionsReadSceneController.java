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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class ManagingDirectorTermsAndConditionsReadSceneController implements Initializable {

    @FXML
    private TextArea termsAndConditionsSetTextArea;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("termsAndConditions.bin"))) {
            String loadedData = (String) ois.readObject();
            termsAndConditionsSetTextArea.setText(loadedData);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
