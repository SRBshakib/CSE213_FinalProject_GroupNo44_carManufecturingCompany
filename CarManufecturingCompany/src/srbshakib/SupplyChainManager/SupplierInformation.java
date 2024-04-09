/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package srbshakib.SupplyChainManager;

import java.io.Serializable;

/**
 *
 * @author SRB Shakib
 */
public class SupplierInformation implements Serializable{
    public String supplierName, country, deliveryType,email,addCountry;
    public int mobileNo;

    public SupplierInformation() {
    }

    public SupplierInformation(String supplierName, String country, String deliveryType, String email, int mobileNo) {
        this.supplierName = supplierName;
        this.country = country;
        this.deliveryType = deliveryType;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "SupplierInformation{" + "supplierName=" + supplierName + ", country=" + country + ", deliveryType=" + deliveryType + ", email=" + email + ", mobileNo=" + mobileNo + '}';
    }
    
    
    
    
}
