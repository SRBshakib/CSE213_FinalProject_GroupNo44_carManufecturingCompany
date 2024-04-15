package Dip;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author DIPAYON
 */
public class MeetingSchedule implements Serializable{
    public String name;
    public String time;
    public LocalDate date;

    public MeetingSchedule(String name, String time, LocalDate date) {
        this.name = name;
        this.time = time;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Meeting wih Managing Director" + "\n" + "Department: " + name + "\nTime: " + time + "\nDate: " + date + '\n'+ '-'+'-'+'-'+'-'+'-'
                +'-'+'-'+'-'+'-'+'-'+'-'+'-'+'-'+'-'+'-'+'-'+'-'
                +'-'+'-'+'-'+'-'+'-'+'-'+'-'+ '\n';
    }
    
}
