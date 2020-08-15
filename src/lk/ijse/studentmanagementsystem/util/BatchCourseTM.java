package lk.ijse.studentmanagementsystem.util;

import java.math.BigDecimal;

public class BatchCourseTM {

    private String Bid;
    private String name;
    private String coursName;
    private BigDecimal courseFee;


    public BatchCourseTM() {
    }

    public BatchCourseTM(String bid, String name, String coursName, BigDecimal courseFee) {
        Bid = bid;
        this.name = name;
        this.coursName = coursName;
        this.courseFee = courseFee;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String bid) {
        Bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoursName() {
        return coursName;
    }

    public void setCoursName(String coursName) {
        this.coursName = coursName;
    }

    public BigDecimal getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(BigDecimal courseFee) {
        this.courseFee = courseFee;
    }

    @Override
    public String toString() {
        return "BatchCourseTM{" +
                "Bid='" + Bid + '\'' +
                ", name='" + name + '\'' +
                ", coursName='" + coursName + '\'' +
                ", courseFee=" + courseFee +
                '}';
    }
}
