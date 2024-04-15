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

public class WorkingSchedule implements Serializable {
    private String workerId;
    private String workerName;
    private String shiftDate;
    private String shiftTime;

    public WorkingSchedule(String workerId, String workerName, String shiftDate, String shiftTime) {
        this.workerId = workerId;
        this.workerName = workerName;
        this.shiftDate = shiftDate;
        this.shiftTime = shiftTime;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(String shiftDate) {
        this.shiftDate = shiftDate;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    @Override
    public String toString() {
        return "WorkingSchedule{" + "workerId=" + workerId + ", workerName=" + workerName + ", shiftDate=" + shiftDate + ", shiftTime=" + shiftTime + '}';
    }
    
    
}