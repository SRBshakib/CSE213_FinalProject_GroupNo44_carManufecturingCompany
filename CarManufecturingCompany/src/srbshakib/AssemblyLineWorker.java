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
public class AssemblyLineWorker extends Employee implements Serializable {

    public AssemblyLineWorker() {
    }

    public AssemblyLineWorker(LocalDate dateOfJoin, float salary, String designation, String name, int UserId, String password, String userType, String email, int phone, String address, LocalDate DoB) {
        super(dateOfJoin, salary, designation, name, UserId, password, userType, email, phone, address, DoB);
    }

    
    
   

   
    }
    

