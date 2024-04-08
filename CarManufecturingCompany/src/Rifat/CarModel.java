/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rifat;

/**
 *
 * @author Lenovo
 */
public class CarModel {
    private String carType;
    private String modelName;
    private String features;

    public CarModel(String carType, String modelName, String features) {
        this.carType = carType;
        this.modelName = modelName;
        this.features = features;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "CarModel{" + "carType=" + carType + ", modelName=" + modelName + ", features=" + features + '}';
    }
    
    
    
}
