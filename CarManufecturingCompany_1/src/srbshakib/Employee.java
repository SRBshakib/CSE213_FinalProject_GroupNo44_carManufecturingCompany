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

    public Employee(String name, int UserId, String password, LocalDate dob, String userType) {
        super(name, UserId, password, dob, userType);
    }


    
    
}
