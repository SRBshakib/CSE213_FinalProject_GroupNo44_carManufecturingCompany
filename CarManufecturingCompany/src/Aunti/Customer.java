/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aunti;

import java.io.Serializable;
import java.time.LocalDate;
import srbshakib.User;

/**
 *
 * @author Asus
 */
public class Customer extends User implements Serializable{
    String gender;
    int phone;
    String address;

    public Customer(String gender, int phone, String address, String name, int UserId, String password, LocalDate dob, String userType) {
        super(name, UserId, password, dob, userType);
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @Override
    public String toString() {
        return "Customer{" + "gender=" + gender + ", phone=" + phone + ", address=" + address + '}';
    }


    
}
