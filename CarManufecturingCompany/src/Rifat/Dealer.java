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
public class Dealer implements Serializable{
    public String CountryName;
    public String Name;
    public String Location;
    public String Region;
    public String MobileNumber;
    public String Email;

    public Dealer(String CountryName, String Name, String Location, String MobileNumber, String Region, String Email) {
        this.CountryName = CountryName;
        this.Name = Name;
        this.Location = Location;
        this.Region = Region;
        this.MobileNumber = MobileNumber;
        this.Email = Email;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Dealer{" + "CountryName=" + CountryName + ", Name=" + Name + ", Location=" + Location + ", Region=" + Region + ", MobileNumber=" + MobileNumber + ", Email=" + Email + '}';
    }
    
    
    
}
