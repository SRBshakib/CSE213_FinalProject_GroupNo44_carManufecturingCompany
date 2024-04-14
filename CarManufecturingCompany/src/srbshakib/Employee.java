/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package srbshakib;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author SRB Shakib
 */
public class Employee extends User implements Serializable{
    private LocalDate dateOfJoin;
    private float salary;
    private String designation;

    public Employee(String name, String UserId, String password, UserType userType, String email, int phone, String address, LocalDate DoB) {
        super(name, UserId, password, userType, email, phone, address, DoB);
    }

    public Employee(LocalDate dateOfJoin, float salary, String designation, String name, String UserId, String password, UserType userType, String email, int phone, String address, LocalDate DoB) {
        super(name, UserId, password, userType, email, phone, address, DoB);
        this.dateOfJoin = dateOfJoin;
        this.salary = salary;
        this.designation = designation;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" + "dateOfJoin=" + dateOfJoin + ", salary=" + salary + ", designation=" + designation + '}';
    }
    
}
