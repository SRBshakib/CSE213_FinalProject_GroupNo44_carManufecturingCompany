/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rifat;

import java.io.Serializable;

public class Budget implements Serializable {
    private String year;
    private double partsBudget;
    private double lunchBudget;
    private double salaryBudget;
    private double marketingBudget;

    public Budget(String year, double partsBudget, double lunchBudget, double salaryBudget, double marketingBudget) {
        this.year = year;
        this.partsBudget = partsBudget;
        this.lunchBudget = lunchBudget;
        this.salaryBudget = salaryBudget;
        this.marketingBudget = marketingBudget;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getPartsBudget() {
        return partsBudget;
    }

    public void setPartsBudget(double partsBudget) {
        this.partsBudget = partsBudget;
    }

    public double getLunchBudget() {
        return lunchBudget;
    }

    public void setLunchBudget(double lunchBudget) {
        this.lunchBudget = lunchBudget;
    }

    public double getSalaryBudget() {
        return salaryBudget;
    }

    public void setSalaryBudget(double salaryBudget) {
        this.salaryBudget = salaryBudget;
    }

    public double getMarketingBudget() {
        return marketingBudget;
    }

    public void setMarketingBudget(double marketingBudget) {
        this.marketingBudget = marketingBudget;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "year='" + year + '\'' +
                ", partsBudget=" + partsBudget +
                ", lunchBudget=" + lunchBudget +
                ", salaryBudget=" + salaryBudget +
                ", marketingBudget=" + marketingBudget +
                '}';
    }
}


