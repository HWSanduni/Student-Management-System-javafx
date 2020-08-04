package lk.ijse.studentmanagementsystem.entity;

import java.sql.Date;

public class Batch implements SuperEntity {
    private String Bid;
    private String courseId;
    private String name;
    private String type;
    private int year;
    private Date startDate;
    private Date endDate;

    public Batch() {
    }

    public Batch(String bid, String courseId, String name, String type, int year, Date startDate, Date endDate) {
        Bid = bid;
        this.courseId = courseId;
        this.name = name;
        this.type = type;
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Batch( String courseId, String name, String type, int year, Date startDate, Date endDate,String bid) {

        this.courseId = courseId;
        this.name = name;
        this.type = type;
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
        Bid = bid;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String bid) {
        Bid = bid;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "Bid='" + Bid + '\'' +
                ", courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
