/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rifat;

import java.time.LocalDate;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
import javafx.collections.ObservableList;
import java.time.LocalDate;

public class AssignTasks {
    private ObservableList<String> destinations;
    private ObservableList<String> carModels;
    private ObservableList<String> carTypes;

    public AssignTasks(String destinations, LocalDate carModels, LocalDate carTypes, String carModel, String carType) {
        
    }

    public ObservableList<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(ObservableList<String> destinations) {
        this.destinations = destinations;
    }

    public ObservableList<String> getCarModels() {
        return carModels;
    }

    public void setCarModels(ObservableList<String> carModels) {
        this.carModels = carModels;
    }

    public ObservableList<String> getCarTypes() {
        return carTypes;
    }

    public void setCarTypes(ObservableList<String> carTypes) {
        this.carTypes = carTypes;
    }

    @Override
    public String toString() {
        return "AssignTasks{" +
                "destinations=" + destinations +
                ", carModels=" + carModels +
                ", carTypes=" + carTypes +
                '}';
    }
}

