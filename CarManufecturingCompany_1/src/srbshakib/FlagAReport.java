/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package srbshakib;

import java.io.Serializable;

/**
 *
 * @author SRB Shakib
 */
public class FlagAReport implements Serializable{
    public int workerId;
    public String carModelNo;
    public String carType;
    public String problemType;
    public String comments;
    public String Status;

    public FlagAReport() {
    }

    public FlagAReport(int workerId, String carModelNo, String carType, String problemType, String comments) {
        this.workerId = workerId;
        this.carModelNo = carModelNo;
        this.carType = carType;
        this.problemType = problemType;
        this.comments = comments;
        this.Status = Status;
    }

  

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    


    

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getCarModelNo() {
        return carModelNo;
    }

    public void setCarModelNo(String carModelNo) {
        this.carModelNo = carModelNo;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    @Override
    public String toString() {
        return "FlagAReport{" + "workerId=" + workerId + ", carModelNo=" + carModelNo + ", carType=" + carType + ", problemType=" + problemType + '}';
    }
    
    
    
}
