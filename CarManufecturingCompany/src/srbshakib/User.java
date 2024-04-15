package srbshakib;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SRB Shakib
 */
public class User implements Serializable{
   
    String name;
     int UserId;
     String password;
     LocalDate dob;
     String userType;

    public User() {
    }

    public User(String name, int UserId, String password, String userType, String email, int phone, String address, LocalDate DoB) {
        this.name = name;
        this.UserId = UserId;
        this.password = password;
        this.dob = dob;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", UserId=" + UserId + ", password=" + password + ", dob=" + dob + ", userType=" + userType + '}';
    }

    

