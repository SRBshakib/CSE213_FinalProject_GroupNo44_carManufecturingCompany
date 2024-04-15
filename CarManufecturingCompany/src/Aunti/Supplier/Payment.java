/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aunti.Supplier;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class Payment implements Serializable {
    public int orderCode;
    public String paymentType;

    public Payment() {
    }

    public Payment(int orderCode, String paymentType) {
        this.orderCode = orderCode;
        this.paymentType = paymentType;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Payment{" + "orderCode=" + orderCode + ", paymentType=" + paymentType + '}';
    }

    
    
    

    
    
    
    
}
