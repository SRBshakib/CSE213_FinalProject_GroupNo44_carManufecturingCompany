package Dip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
public class ManagingDirectorScheduleSceneController implements Initializable {

    @FXML
    private TextField time_Text_Field;
    @FXML
    private DatePicker date_Picker;
    @FXML
    private TableView<MeetingSchedule> tableView;
//    private TableColumn<MeetingSchedule, String> name_Table_Colm;
    @FXML
    private TableColumn<MeetingSchedule, String> time_Table_Colm;
    @FXML
    private TableColumn<MeetingSchedule, LocalDate> date_Table_Colm;
//    private ArrayList<MeetingSchedule> studArr;
    @FXML
    private ComboBox<String> dept_ComboBox;
    @FXML
    private TableColumn<MeetingSchedule, String> name_TableColm;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        studArr = new ArrayList<MeetingSchedule>();

        dept_ComboBox.getItems().addAll("All Employee", "HR",
                "Finance", "Supply Chain Manager",
                "Supply", "Assambly Line Worker");
    }

    @FXML
    private void back_Button_On_Click(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagingDirectorDashboardScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void showButtonOnClick(ActionEvent event) {

        ObservableList<MeetingSchedule> scheduleList = FXCollections.observableArrayList();

        name_TableColm.setCellValueFactory(new PropertyValueFactory<MeetingSchedule, String>("name"));
        time_Table_Colm.setCellValueFactory(new PropertyValueFactory<MeetingSchedule, String>("time"));
        date_Table_Colm.setCellValueFactory(new PropertyValueFactory<MeetingSchedule, LocalDate>("date"));

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Schedule.bin");
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
        tableView.setItems(scheduleList);
        System.out.println(scheduleList.toString());
    }

    @FXML
    private void cancelMeetingButtonOnClick(ActionEvent event) {
        ObservableList<MeetingSchedule> a, b;
        b = tableView.getItems();
        a = tableView.getSelectionModel().getSelectedItems();
        a.forEach(b::remove);
    }

    @FXML
    private void notifyButtonOnClick(ActionEvent event) {
        if (dept_ComboBox.getValue() == null
                || date_Picker.getValue() == null
                || time_Text_Field.getText().isEmpty()) {

            MeetingSchedule i = new MeetingSchedule(
                    dept_ComboBox.getValue(),
                    time_Text_Field.getText(),
                    date_Picker.getValue());
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            File f = null;
            try {
                f = new File("Schedule.bin");
                if (f.exists()) {
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                }

                oos.writeObject(i);

            } catch (IOException ex) {
                Logger.getLogger(ManagingDirectorScheduleSceneController.class
                        .getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (oos != null) {
                        oos.close();

                    }
                } catch (IOException ex) {
                    Logger.getLogger(ManagingDirectorScheduleSceneController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

            dept_ComboBox.setValue(null);
            time_Text_Field.clear();
            date_Picker.setValue(null);
            System.out.println(tableView);
        }
    }
}
