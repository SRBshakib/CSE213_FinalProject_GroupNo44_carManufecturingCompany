/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class ManagingDirectorTermsAndConditionsSceneController implements Initializable {

    private TextArea termsAndConditionsTextField;
    private TextArea showInfoLabel;
    @FXML
    private TextArea showInfoTextArea;
    @FXML
    private TextArea termsAndConditionsTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void returnButtonOnClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("ManagingDirectorDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void showButtonOnClick(ActionEvent event) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("termsAndConditions.bin"))) {
            String loadedData = (String) ois.readObject();
            showInfoTextArea.setText(loadedData);
            System.out.println("Data showed to binary file successfully.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateButtonOnClick(ActionEvent event) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("termsAndConditions.bin"))) {
             String termsAndConditions = termsAndConditionsTextArea.getText();
            oos.writeObject(termsAndConditions);
            System.out.println("Data saved to binary file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        termsAndConditionsTextArea.clear();

    }

    
}
