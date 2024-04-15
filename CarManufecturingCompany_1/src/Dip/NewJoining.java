/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dip;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author DIPAYON
 */
public class NewJoining implements Serializable{
    private int  uniqueid;
    public String name;
    public String gender;
    public String designation;
    public LocalDate dob;
    public LocalDate doj;

    public NewJoining(int uniqueid, String name, String gender, String designation, LocalDate dob, LocalDate doj) {
        this.uniqueid = uniqueid;
        this.name = name;
        this.gender = gender;
        this.designation = designation;
        this.dob = dob;
        this.doj = doj;
    }

    public int getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(int uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "NewJoining{" + "uniqueid=" 
                + uniqueid + ", name="
                + name + ", gender="
                + gender + ", designation="
                + designation + ", dob="
                + dob + ", doj="
                + doj + '}';
    }
    
    
}
