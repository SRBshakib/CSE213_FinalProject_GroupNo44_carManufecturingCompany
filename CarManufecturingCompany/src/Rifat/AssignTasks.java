/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rifat;

import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author Lenovo
 */

public class AssignTasks implements Serializable {
    private String destination;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private String assemblingCarModel;
    private String carType;

    public AssignTasks(String destination, LocalDate startingDate, LocalDate endingDate, String assemblingCarModel, String carType) {
        this.destination = destination;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.assemblingCarModel = assemblingCarModel;
        this.carType = carType;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public String getAssemblingCarModel() {
        return assemblingCarModel;
    }

    public void setAssemblingCarModel(String assemblingCarModel) {
        this.assemblingCarModel = assemblingCarModel;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "AssignTasks{" + "destination=" + destination + ", startingDate=" + startingDate + ", endingDate=" + endingDate + ", assemblingCarModel=" + assemblingCarModel + ", carType=" + carType + '}';
    }
    

}    