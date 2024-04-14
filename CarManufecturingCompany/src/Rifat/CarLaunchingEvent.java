/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rifat;

import java.io.Serializable;

public class CarLaunchingEvent implements Serializable {
    private String carType;
    private String carModel;
    private String date;
    private String time;
    private String location;
    private String manufacturer;
    private String features;

    // Constructors
    public CarLaunchingEvent() {
    }

    public CarLaunchingEvent(String carType, String carModel, String date, String time, String location, String manufacturer, String features) {
        this.carType = carType;
        this.carModel = carModel;
        this.date = date;
        this.time = time;
        this.location = location;
        this.manufacturer = manufacturer;
        this.features = features;
    }

    // Getters and setters
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    // toString method
    @Override
    public String toString() {
        return "CarLaunchingEvent{" +
                "carType='" + carType + '\'' +
                ", carModel='" + carModel + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", features='" + features + '\'' +
                '}';
    }
}

