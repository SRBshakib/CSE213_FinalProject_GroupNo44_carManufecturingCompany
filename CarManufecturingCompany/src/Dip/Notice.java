/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dip;

import java.time.LocalDate;

/**
 *
 * @author DIPAYON
 */
public class Notice {
    private LocalDate noticeDate;
    private String dept;
    private String msg;

    public Notice(LocalDate noticeDate, String dept, String msg) {
        this.noticeDate = noticeDate;
        this.dept = dept;
        this.msg = msg;
    }

    public LocalDate getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(LocalDate noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Notice{" + "noticeDate=" + noticeDate + ", dept=" + dept + ", msg=" + msg + '}';
    }
    
    
}
