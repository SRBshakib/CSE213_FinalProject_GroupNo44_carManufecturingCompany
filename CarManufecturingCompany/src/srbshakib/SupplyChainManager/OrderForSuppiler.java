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
public class OrderForSuppiler implements Serializable{
    private static final long serialVersionUID = 1L;

    private int orderCode;
    public String supplierName, productName, payment;
    public int quantity;

    public OrderForSuppiler() {
    }

    public OrderForSuppiler(int orderCode, String supplierName, String productName, String payment, int quantity) {
        this.orderCode = orderCode;
        this.supplierName = supplierName;
        this.productName = productName;
        this.payment = payment;
        this.quantity = quantity;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderForSuppiler{" + "orderCode=" + orderCode + ", supplierName=" + supplierName + ", productName=" + productName + ", payment=" + payment + ", quantity=" + quantity + '}';
    }
    
    
    
    
}
