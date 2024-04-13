/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rifat;

/**
 *
 * @author Lenovo
 */


import java.io.Serializable;
import java.util.List;

public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;

    static List<Budget> getBudgetData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void serializeBudgetList(List<Budget> budgetList, String budgetInfobin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static List<Budget> deserializeBudgetList(String budgetInfobin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
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

    void yearProperty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object partsBudgetProperty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object lunchBudgetProperty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object salaryBudgetProperty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object marketingBudgetProperty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

