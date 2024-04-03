package mainpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HumanResourceManagerTermsAndConditionsReadSceneController implements Initializable {

    @FXML
    private Label termsAndConditionsSetTextLabel;
       

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("termsAndConditions.bin"))) {
            String loadedData = (String) ois.readObject();
            termsAndConditionsSetTextLabel.setText(loadedData);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    
}
