package mainpkg;

import java.time.LocalDate;

public class EmployeeList {

    public String name;
    public String gender;
    public String designation;
    public LocalDate dob;
    public String email;
    public int phone;
    public String address;
    public String education;
    public int id;

    public EmployeeList(String name, String gender, String designation, LocalDate dob, String email, int phone, String address, String education, int id) {
        this.name = name;
        this.gender = gender;
        this.designation = designation;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.education = education;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDesignation() {
        return designation;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEducation() {
        return education;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EmployeeList{" + "name=" + name + ", gender=" + gender + ", designation=" + designation + ", dob=" + dob + ", email=" + email + ", phone=" + phone + ", address=" + address + ", education=" + education + ", id=" + id + '}';
    }
    
    
}

