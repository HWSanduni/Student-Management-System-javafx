package lk.ijse.studentmanagementsystem.util;

import java.sql.Date;

public class RegistraionTM {

    private String batchId;
    private String studentId;
    private double registartionFee;
    private double courseFee;
    private String status;
    private Date reg_Date;
    private Date courseFeeGi_Date;


    public RegistraionTM() {
    }


    public RegistraionTM(String batchId, String studentId, double registartionFee, double courseFee, String status, Date reg_Date, Date courseFeeGi_Date) {
        this.batchId = batchId;
        this.studentId = studentId;
        this.registartionFee = registartionFee;
        this.courseFee = courseFee;
        this.status = status;
        this.reg_Date = reg_Date;
        this.courseFeeGi_Date = courseFeeGi_Date;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getRegistartionFee() {
        return registartionFee;
    }

    public void setRegistartionFee(double registartionFee) {
        this.registartionFee = registartionFee;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReg_Date() {
        return reg_Date;
    }

    public void setReg_Date(Date reg_Date) {
        this.reg_Date = reg_Date;
    }

    public Date getCourseFeeGi_Date() {
        return courseFeeGi_Date;
    }

    public void setCourseFeeGi_Date(Date courseFeeGi_Date) {
        this.courseFeeGi_Date = courseFeeGi_Date;
    }

    @Override
    public String toString() {
        return "RegistraionTM{" +
                "batchId='" + batchId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", registartionFee=" + registartionFee +
                ", courseFee=" + courseFee +
                ", status='" + status + '\'' +
                ", reg_Date=" + reg_Date +
                ", courseFeeGi_Date=" + courseFeeGi_Date +
                '}';
    }
}
