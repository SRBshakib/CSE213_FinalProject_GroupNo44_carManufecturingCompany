package Dip;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanResourceManagerDirectorySceneDummy extends EmployeeList implements Serializable{

    public HumanResourceManagerDirectorySceneDummy(String name, String gender, String designation, LocalDate dob, LocalDate doj, String email, int phone, String address, String education, int id) {
        super(name, gender, designation, dob, doj, email, phone, address, education, id);
    }
//    private String name;
//    private int id;
//    private String gender;
//    private String designation;
//    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HumanResourceManagerDirectorySceneDummy{");
        sb.append('}');
        return sb.toString();
    }

  
    
    
    
    
}
