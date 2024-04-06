package Dip;

import java.time.LocalDate;

public class EmployeeList {

    public String name;
    public String gender;
    public String designation;
    public LocalDate dob;
    public LocalDate doj;
    public String email;
    public int phone;
    public String address;
    public String education;
    public int id;

    public EmployeeList(String name, String gender, String designation, LocalDate dob, LocalDate doj, String email, int phone, String address, String education, int id) {
        this.name = name;
        this.gender = gender;
        this.designation = designation;
        this.dob = dob;
        this.doj = doj;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.education = education;
        this.id = id;
    }

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
        return "EmployeeList{" + "name=" + name + ", gender=" + gender + ", designation=" + designation + ", dob=" + dob + ", doj=" + doj + ", email=" + email + ", phone=" + phone + ", address=" + address + ", education=" + education + ", id=" + id + '}';
    }
    
    

}
