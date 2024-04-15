/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rifat;
import java.io.Serializable;
/**
 *
 * @author Lenovo
 */
public class Audit implements Serializable{
    private String date;
    private String details;

    public Audit(String date, String details) {
        this.date = date;
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Audit{" + "date=" + date + ", details=" + details + '}';
    }
    
    
}
