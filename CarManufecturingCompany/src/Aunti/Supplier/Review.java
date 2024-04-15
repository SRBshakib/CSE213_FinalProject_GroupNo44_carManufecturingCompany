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
public class Review implements Serializable {
    
    public String productType;
    public String comments;
    public int orderCode;

    public Review(String productType, String comments, int orderCode) {
        this.productType = productType;
        this.comments = comments;
        this.orderCode = orderCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public String toString() {
        return "Review{" + "productType=" + productType + ", comments=" + comments + ", orderCode=" + orderCode + '}';
    }

    
    
    
    
}
