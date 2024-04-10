/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package srbshakib.SupplyChainManager;

import java.io.Serializable;

public class SupplierInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String supplierName;
    private String country;
    private String deliveryType;
    private String email;
    private int mobileNo;

    public SupplierInformation() {
    }

    public SupplierInformation(int id, String supplierName, String country, String deliveryType, String email, int mobileNo) {
        this.id = id;
        this.supplierName = supplierName;
        this.country = country;
        this.deliveryType = deliveryType;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "SupplierInformation{" +
                "id=" + id +
                ", supplierName='" + supplierName + '\'' +
                ", country='" + country + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }
}
