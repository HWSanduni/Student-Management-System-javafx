package lk.ijse.studentmanagementsystem.entity;

import java.math.BigDecimal;

public class Course implements SuperEntity{

    private String Cid;
    private String name;
    private BigDecimal courseFee;
    private String description;


    public Course() {
    }

    public Course(String cid, String name, BigDecimal courseFee, String description) {
        Cid = cid;
        this.name = name;
        this.courseFee = courseFee;
        this.description = description;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(BigDecimal courseFee) {
        this.courseFee = courseFee;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Cid='" + Cid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", courseFee=" + courseFee +
                '}';
    }
}
