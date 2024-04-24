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

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author User
 */
public class ManagingDirectorTermsAndConditionsSceneController implements Initializable {


    @FXML
    private TextArea termsAndConditionsTextArea;
    @FXML
    private TextArea showInfoTextArea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void returnButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagingDirectorDashboardScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void showButtonOnClick(ActionEvent event) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("termsAndConditions.bin"))) {
            String loadedData = (String) ois.readObject();
            showInfoTextArea.setText(loadedData);

            System.out.println("Data loaded from binary file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateButtonOnClick(ActionEvent event) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("termsAndConditions.bin"))) {
             String termsAndConditions = termsAndConditionsTextArea.getText();
            oos.writeObject(termsAndConditions);
            System.out.println("Data saved/Update to binary file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
