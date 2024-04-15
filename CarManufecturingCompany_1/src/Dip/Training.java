package Dip;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author DIPAYON
 */
public class Training implements Serializable {
    private int trainingId;
    private String name;
    private int empId;
    private String doj;
    private LocalDate dateFrom, dateTo;
    private String trainingType, trainingName;
    private String payment;
    private String status;

    public Training(int trainingId, String name, int empId, String doj, LocalDate dateFrom, LocalDate dateTo, String trainingType, String trainingName, String payment) {
        this.trainingId = trainingId;
        this.name = name;
        this.empId = empId;
        this.doj = doj;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.trainingType = trainingType;
        this.trainingName = trainingName;
        this.payment = payment;
        this.status= "Not Completed";
    }

    public double getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Training{");
        sb.append("trainingId=").append(trainingId);
        sb.append(", name=").append(name);
        sb.append(", empId=").append(empId);
        sb.append(", doj=").append(doj);
        sb.append(", dateFrom=").append(dateFrom);
        sb.append(", dateTo=").append(dateTo);
        sb.append(", trainingType=").append(trainingType);
        sb.append(", trainingName=").append(trainingName);
        sb.append(", payment=").append(payment);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

}
