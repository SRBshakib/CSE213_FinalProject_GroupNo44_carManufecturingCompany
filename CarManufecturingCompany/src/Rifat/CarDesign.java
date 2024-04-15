/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rifat;
import java.io.Serializable;
/**
 *
 * @author Lenovo
 */
public class CarDesign implements Serializable{
    private String carType;
    private String modelName;
    private String design;

    public CarDesign(String carType, String modelName, String design) {
        this.carType = carType;
        this.modelName = modelName;
        this.design = design;
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

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    @Override
    public String toString() {
        return "CarDesign{" + "carType=" + carType + ", modelName=" + modelName + ", design=" + design + '}';
    }
    
    
    
}
