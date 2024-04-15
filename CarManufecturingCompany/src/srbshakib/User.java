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

    private String name;
    private int UserId;
    private String password;
    private String userType;
    private String email;
    private int phone;
    private String address;
    private LocalDate DoB;


    public User() {
    }

    public User(String name, int UserId, String password, LocalDate DoB, String userType) {

        this.name = name;
        this.UserId = UserId;
        this.password = password;
        this.DoB = DoB;
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



    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate DoB) {
        this.DoB = DoB;
    }


    @Override
    public String toString() {
        return "User{" + "name=" + name + ", UserId=" + UserId + ", password=" + password + ", dob=" + DoB + ", userType=" + userType + '}';
    }


    
    
    
    }



    

    

