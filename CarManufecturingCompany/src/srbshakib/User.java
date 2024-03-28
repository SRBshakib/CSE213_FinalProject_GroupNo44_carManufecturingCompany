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
    private String UserId;
    private String password;
    private UserType userType;
    private String email;
    private int phone;
    private String address;
    private LocalDate DoB;

    public User(String name, String UserId, String password, UserType userType, String email, int phone, String address, LocalDate DoB) {
        this.name = name;
        this.UserId = UserId;
        this.password = password;
        this.userType = userType;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.DoB = DoB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
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
    public void login(){
    }
    public void verifyLogin(){
    }
    public void forgotPassword(){
    }
    public void signUp(){
    }
    public void showNoticeBoard(){
    }
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", UserId=" + UserId + ", password=" + password + ", userType=" + userType + ", email=" + email + ", phone=" + phone + ", address=" + address + ", DoB=" + DoB + '}';
    }
    

   
    
}
