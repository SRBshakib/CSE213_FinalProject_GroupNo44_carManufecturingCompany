/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author Lenovo
 */
public class CarModel {
    private String Model;
    private String manufacturer;
    private double price;

    public CarModel(String Model, String manufacturer, double price) {
        this.Model = Model;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarModel{" + "Model=" + Model + ", manufacturer=" + manufacturer + ", price=" + price + '}';
    }
    
    
}
