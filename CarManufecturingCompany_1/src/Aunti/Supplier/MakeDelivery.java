/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aunti.Supplier;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class MakeDelivery implements Serializable {
    
    public int orderCode;
    public String productName;
    public int quantity;
    public int unitPrice;
    public String shipment;
    public LocalDate edd;

    public MakeDelivery() {
    }

    public MakeDelivery(int orderCode, String productName, int quantity, int unitPrice, String shipment, LocalDate edd) {
        this.orderCode = orderCode;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.shipment = shipment;
        this.edd = edd;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public LocalDate getEdd() {
        return edd;
    }

    public void setEdd(LocalDate edd) {
        this.edd = edd;
    }

    @Override
    public String toString() {
        return "MakeDelivery{" + "orderCode=" + orderCode + ", productName=" + productName + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", shipment=" + shipment + ", edd=" + edd + '}';
    }
    
}
