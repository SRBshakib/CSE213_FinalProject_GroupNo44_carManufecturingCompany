/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dip;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
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
                "Production Manager");
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
//        try{
//                FileOutputStream fos = new FileOutputStream("Notice.bin", true);
//                DataOutputStream dos = new DataOutputStream(fos);
//                for(Notice s: noticeArr){
//                    dos.write(getNoticeDate());
//                    dos.writeUTF(s.getDept());
//                    dos.writeUTF(s.getMsg());
//                }
//                dos.close();
//            }
//            catch(Exception e){
//                //SHOW e.toString() IN AN ALERT
//            }           
//
//
//            //2: write the Student instance using object stream
//            try{
//                FileOutputStream fos = new FileOutputStream("Notice.bin",true);
//                ObjectOutputStream oos = new ObjectOutputStream(fos);
//                for(Notice s: noticeArr)
//                    oos.writeObject(s);
//                oos.close();
//            }
//            catch(Exception e){
//                //SHOW e.toString() IN AN ALERT
//            
//        }
    }

    @FXML
    private void showButtonOnClick(ActionEvent event) {
//        ObjectInputStream ois=null;
//         try {
//             Notice s;
//             //FileInputStream fis = new FileInputStream("studObjects.bin");
//             //ois = new ObjectInputStream(fis);
//             ois = new ObjectInputStream(new FileInputStream("Notice.bin"));
//             
//            noticeShowTA.setText(null);
//            
//            //int[] arr={1,2,3};
//            //System.out.println(arr[3]);
//            while(true){
//                s = (Notice) ois.readObject();
//                //studArr.add((Student) ois.readObject());
//                noticeShowTA.appendText(s.toString()+"\n");
//    }
//            }
//        catch(RuntimeException e){
//            e.printStackTrace();
//             //
//        }
//        catch (Exception ex) {
//            try {
//                if(ois!=null)
//                    ois.close();
//            } catch (IOException ex1) {  }           
//        }
//         ObjectInputStream ois=null;
//         try {
//             Notice s;
//             //FileInputStream fis = new FileInputStream("studObjects.bin");
//             //ois = new ObjectInputStream(fis);
//             ois = new ObjectInputStream(new FileInputStream("Notice.bin"));
//             
//            noticeShowTA.setText(null);
//            
//            //int[] arr={1,2,3};
//            //System.out.println(arr[3]);
//            while(true){
//                s = (Notice) ois.readObject();
//                //studArr.add((Student) ois.readObject());
//                noticeShowTA.appendText(s.toString()+"\n");
//                //outputTxtArea.appendText(s+"\n");
//            }
//            //ois.close();
//                       
//        }
//        catch(RuntimeException e){
//            e.printStackTrace();
//             //
//        }
//        catch (Exception ex) {
//            try {
//                if(ois!=null)
//                    ois.close();
//            } catch (IOException ex1) {  }           
//        }
         
    }

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
        noticeArr.add(
            new Notice(  
                    noticeDP.getValue(),
                    deptCB.getValue(),
                    noticeTA.getText()));
    }
    
}
    