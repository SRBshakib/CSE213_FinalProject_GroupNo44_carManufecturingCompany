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
public class AskForLeave implements Serializable {
    public int howManyWorkingDays;
    public LocalDate forWhichDay;
    public LocalDate fromWhichDay;
    public LocalDate toWhichDay;
    public String reasonForLeave;
    public String commentForLeave;
    public String status;

    public AskForLeave() {
    }
    

    public AskForLeave(Integer howManyWorkingDays, LocalDate forWhichDay, LocalDate fromWhichDay, LocalDate toWhichDay, String reasonForLeave, String commentForLeave) {
        this.howManyWorkingDays = howManyWorkingDays;
        this.forWhichDay = forWhichDay;
        this.fromWhichDay = fromWhichDay;
        this.toWhichDay = toWhichDay;
        this.reasonForLeave = reasonForLeave;
        this.commentForLeave = commentForLeave;
        this.status = "Pending";
    }

    

    public int getHowManyWorkingDays() {
        return howManyWorkingDays;
    }

    public void setHowManyWorkingDays(int howManyWorkingDays) {
        this.howManyWorkingDays = howManyWorkingDays;
    }

    public LocalDate getForWhichDay() {
        return forWhichDay;
    }

    public void setForWhichDay(LocalDate forWhichDay) {
        this.forWhichDay = forWhichDay;
    }

    public LocalDate getFromWhichDay() {
        return fromWhichDay;
    }

    public void setFromWhichDay(LocalDate fromWhichDay) {
        this.fromWhichDay = fromWhichDay;
    }

    public LocalDate getToWhichDay() {
        return toWhichDay;
    }

    public void setToWhichDay(LocalDate toWhichDay) {
        this.toWhichDay = toWhichDay;
    }

    public String getReasonForLeave() {
        return reasonForLeave;
    }

    public void setReasonForLeave(String reasonForLeave) {
        this.reasonForLeave = reasonForLeave;
    }

    public String getCommentForLeave() {
        return commentForLeave;
    }

    public void setCommentForLeave(String commentForLeave) {
        this.commentForLeave = commentForLeave;
    }

 

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AskForLeave{" + "howManyWorkingDays=" + howManyWorkingDays + ", forWhichDay=" + forWhichDay + ", fromWhichDay=" + fromWhichDay + ", toWhichDay=" + toWhichDay + ", reasonForLeave=" + reasonForLeave + ", commentForLeave=" + commentForLeave + ", status=" + status + '}';
    }
    
    
    
    
    
}
