/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import srbshakib.AskForLeave;

/**
 *
 * @author DIPAYON
 */
class DataReadWrite {

    public static <T> Boolean writeObjectToFile(String fileName, T instance) {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        File f = null;
        try {
            f = new File(fileName);
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            try {
                oos.writeObject(instance);
                oos.close();
                return true;
            } catch (IOException ex) {
                GenerateAlerts.unsuccessfulAlert("Error while writing the File." + "\n"
                        + "Please Check your Storage Efficiency, File type and name.");
            }
        } catch (Exception e) {
            GenerateAlerts.unsuccessfulAlert("Data is Vulnerable." + "\n" + "Please try again rechecking your data"
                    + "If you can't solve the issue. Contact Software maintainer.");
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                GenerateAlerts.unsuccessfulAlert("Error while closing the Binary File.");
                return false;
            }
        }
        return false;

    }

    public static <T> ObservableList<?> readObjectToFile(String fileName, T instance) {
        System.out.println("Hasib11");
        File f = null;
        FileInputStream fw = null;
        ObjectInputStream ois = null;
        ObservableList<AskForLeave> askingLeaveReq = FXCollections.observableArrayList();
        try {
            if (instance instanceof AskForLeave) {
                f = new File(fileName);
                fw = new FileInputStream(f);
                ois = new ObjectInputStream(fw);
                try {
                    while (true) {
                        askingLeaveReq.add((AskForLeave) ois.readObject());
                    }
                } catch (Exception e) {
                    System.out.println("crucialTaskPermissionRequest read exe Signup Data");
                }
                //  System.out.println("Hasib");               
            }
        } catch (Exception e) {
            System.out.println("Hasib False");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {

            }
        }
        return null;
        
    }
//    if ( instance instanceof Resident ) return people;
//        
//        
//        
//        return loginData;
public static <T> Boolean overWriteObjectToFile(String fileName, T instance){
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        File f = null;
        try{
            f = new File(fileName);
            if (f.exists() ){
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            try {
                oos.writeObject(instance);
                oos.close();
                return true;
            }
            catch(IOException ex){
                GenerateAlerts.unsuccessfulAlert("Error while writing the File." + "\n" +
                                                "Please Check your Storage Efficiency, File type and name.");
            }
        }
        catch (Exception e){
            GenerateAlerts.unsuccessfulAlert("Data is Vulnerable." + "\n" + "Please try again rechecking your data" + 
                                                "If you can't solve the issue. Contact Software maintainer.");
        }
        finally {
            try{
                if ( oos != null){
                    oos.close();
                }
            }
            catch (IOException ex){
                GenerateAlerts.unsuccessfulAlert("Error while closing the Binary File.");
                return false;
            }
        } 
        return false;
        
    }
}
