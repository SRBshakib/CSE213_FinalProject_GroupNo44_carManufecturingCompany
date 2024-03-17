package mainpkg;

//import MD_Schedule_Scene_Model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DIPAYON
 */
public class MD_ScheduleSceneController implements Initializable {

    @FXML
    private ComboBox<String> select_Employee_ComboBox;
    @FXML
    private TextField time_Text_Field;
    @FXML
    private DatePicker date_Picker;
    @FXML
    private TableView<MeetingSchedule> TableView;
    @FXML
    private TableColumn<MeetingSchedule, String> name_Table_Colm;

    @FXML
    private TableColumn<MeetingSchedule, String> time_Table_Colm;
    @FXML
    private TableColumn<MeetingSchedule, LocalDate> date_Table_Colm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        select_Employee_ComboBox.getItems().addAll("All Employee", "HR",
                "Finance", "Supply Chain Manager",
                "Supply", "Assambly Line Worker");
        // TODO
    }

    @FXML
    private void notify_Button_On_Click(ActionEvent event) {
        MeetingSchedule i = new MeetingSchedule(
                time_Text_Field.getText(),
                select_Employee_ComboBox.getValue(),
                date_Picker.getValue());
        FileOutputStream fos = null;
        ObjectOutputStream oss = null;
        File f = null;
        try {
            f = new File("Set Schedule.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oss = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oss = new ObjectOutputStream(fos);
            }
            oss.writeObject(f);

        } catch (IOException ex) {
            Logger.getLogger(MeetingSchedule.class
                    .getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                if (oss != null) {
                    oss.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(MeetingSchedule.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

        select_Employee_ComboBox.setValue(null);
        time_Text_Field.clear();
        date_Picker.setValue(null);

    }

    @FXML
    private void show_Button_On_Click(ActionEvent event) {
        ObservableList<MeetingSchedule> scheduleList = FXCollections.observableArrayList();

        name_Table_Colm.setCellValueFactory(new PropertyValueFactory<MeetingSchedule, String>("Name"));
        time_Table_Colm.setCellValueFactory(new PropertyValueFactory<MeetingSchedule, String>("Time"));
        date_Table_Colm.setCellValueFactory(new PropertyValueFactory<MeetingSchedule, LocalDate>("Date"));

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Set Schedule.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            MeetingSchedule p;
            try {
                while (true) {
                    p = (MeetingSchedule) ois.readObject();
                    scheduleList.add(p);
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
        TableView.setItems(scheduleList);
    }

    @FXML
    private void CancelMeeting_Button_On_Click(ActionEvent event) {
        ObservableList<MeetingSchedule> a, b;
        b = TableView.getItems();
        a = TableView.getSelectionModel().getSelectedItems();
        a.forEach(b::remove);
    }

    @FXML
    private void back_Button_On_Click(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("MD_Dashboard_Scene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
}
