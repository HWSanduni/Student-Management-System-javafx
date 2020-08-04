package lk.ijse.studentmanagementsystem.entity;

import java.sql.Date;

public class Exam implements SuperEntity {

    private String eid;
    private String name;
    private Date date;
    private String time;
    private int passMarks;
    private String status;

    public Exam() {
    }

    public Exam(String eid, String name, Date date, String time, int passMarks, String status) {
        this.eid = eid;
        this.name = name;
        this.date = date;
        this.time = time;
        this.passMarks = passMarks;
        this.status = status;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPassMarks() {
        return passMarks;
    }

    public void setPassMarks(int passMarks) {
        this.passMarks = passMarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "eid='" + eid + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", passMarks=" + passMarks +
                ", status='" + status + '\'' +
                '}';
    }
}
