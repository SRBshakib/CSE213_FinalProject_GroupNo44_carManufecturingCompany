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
public class Payment implements Serializable{
    private String id;
    private String name;
    private String designation;
    private String totalPayment;
    private String duePayment;

    public Payment(String id, String name, String designation, String totalPayment, String duePayment) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.totalPayment = totalPayment;
        this.duePayment = duePayment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(String totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getDuePayment() {
        return duePayment;
    }

    public void setDuePayment(String duePayment) {
        this.duePayment = duePayment;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", name=" + name + ", designation=" + designation + ", totalPayment=" + totalPayment + ", duePayment=" + duePayment + '}';
    }
    
    
    
}
