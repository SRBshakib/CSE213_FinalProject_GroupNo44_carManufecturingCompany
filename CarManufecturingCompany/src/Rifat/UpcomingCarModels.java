/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rifat;

import java.io.Serializable;

public class UpcomingCarModels implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String carType;
    private String carModel;
    private String features;

    public UpcomingCarModels(String carType, String carModel, String features) {
        this.carType = carType;
        this.carModel = carModel;
        this.features = features;
    }

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

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "UpcomingCarModels{" + "carType=" + carType + ", carModel=" + carModel + ", features=" + features + '}';
    }
}

