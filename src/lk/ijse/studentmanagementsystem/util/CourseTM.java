package lk.ijse.studentmanagementsystem.util;

import java.math.BigDecimal;

public class CourseTM {

    private String Cid;
    private String Name;
    private double CourseFee;
    private String Description;


    public CourseTM() {
    }

    public CourseTM(String cid, String name, double courseFee, String description) {
        Cid = cid;
        Name = name;
        CourseFee = courseFee;
        Description = description;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getCourseFee() {
        return CourseFee;
    }

    public void setCourseFee(double courseFee) {
        CourseFee = courseFee;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "CourseTM{" +
                "Cid='" + Cid + '\'' +
                ", Name='" + Name + '\'' +
                ", CourseFee=" + CourseFee +
                ", Description='" + Description + '\'' +
                '}';
    }
}
