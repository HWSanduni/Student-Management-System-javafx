package lk.ijse.studentmanagementsystem.util;

import java.math.BigDecimal;

public class CourseTM {

    private String Cid;
    private String name;
    private BigDecimal courseFee;
    private String description;


    public CourseTM() {
    }

    public CourseTM(String cid, String name, BigDecimal courseFee, String description) {
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

    public BigDecimal getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(BigDecimal courseFee) {
        this.courseFee = courseFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourseTM{" +
                "Cid='" + Cid + '\'' +
                ", name='" + name + '\'' +
                ", courseFee=" + courseFee +
                ", description='" + description + '\'' +
                '}';
    }
}
