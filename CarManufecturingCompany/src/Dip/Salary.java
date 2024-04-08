/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dip;

import java.io.Serializable;

/**
 *
 * @author DIPAYON
 */
public class Salary implements Serializable{

    private String empName;
    private int empId;
    private String empDoj;
    private Float empSalary;

    public Salary(String empName, int empId, String empDoj, Float empSalary) {
        this.empName = empName;
        this.empId = empId;
        this.empDoj = empDoj;
        this.empSalary = empSalary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpDoj() {
        return empDoj;
    }

    public void setEmpDoj(String empDoj) {
        this.empDoj = empDoj;
    }

    public Float getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Float empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Salary{" + "empName=" + empName + ", empId=" + empId + ", empDoj=" + empDoj + ", empSalary=" + empSalary + '}';
    }

    
}
