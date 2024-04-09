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
public class Inventory implements Serializable{
    public String carType;
    public String carModel;
    public String nameOfParts;
    public int numbersOfParts;

    public Inventory() {
    }

    public Inventory(String carType, String carModel, String nameOfParts, int numbersOfParts) {
        this.carType = carType;
        this.carModel = carModel;
        this.nameOfParts = nameOfParts;
        this.numbersOfParts = numbersOfParts;
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

    public String getNameOfParts() {
        return nameOfParts;
    }

    public void setNameOfParts(String nameOfParts) {
        this.nameOfParts = nameOfParts;
    }

    public int getNumbersOfParts() {
        return numbersOfParts;
    }

    public void setNumbersOfParts(int numbersOfParts) {
        this.numbersOfParts = numbersOfParts;
    }

    @Override
    public String toString() {
        return "Inventory{" + "carType=" + carType + ", carModel=" + carModel + ", nameOfParts=" + nameOfParts + ", numbersOfParts=" + numbersOfParts + '}';
    }
    
    
    
}
