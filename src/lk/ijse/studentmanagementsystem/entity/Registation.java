package lk.ijse.studentmanagementsystem.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Registation implements SuperEntity {


    private RegistationPK registationPK;
    private BigDecimal registartionFee;
    private BigDecimal courseFee;
    private String status;
    private Date reg_Date;
    private Date courseFeeGi_Date;


    public Registation() {
    }

    public Registation(RegistationPK registationPK, BigDecimal registartionFee, BigDecimal courseFee, String status, Date reg_Date, Date courseFeeGi_Date) {
        this.registationPK = registationPK;
        this.registartionFee = registartionFee;
        this.courseFee = courseFee;
        this.status = status;
        this.reg_Date = reg_Date;
        this.courseFeeGi_Date = courseFeeGi_Date;
    }

    public Registation(String batchId, String studentId, BigDecimal registartionFee, BigDecimal courseFee, String status, Date reg_Date, Date courseFeeGi_Date) {
        this.registationPK = new RegistationPK(batchId,studentId);
        this.registartionFee = registartionFee;
        this.courseFee = courseFee;
        this.status = status;
        this.reg_Date = reg_Date;
        this.courseFeeGi_Date = courseFeeGi_Date;
    }


    public RegistationPK getRegistationPK() {
        return registationPK;
    }

    public void setRegistationPK(RegistationPK registationPK) {
        this.registationPK = registationPK;
    }

    public BigDecimal getRegistartionFee() {
        return registartionFee;
    }

    public void setRegistartionFee(BigDecimal registartionFee) {
        this.registartionFee = registartionFee;
    }

    public BigDecimal getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(BigDecimal courseFee) {
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
        return "Registation{" +
                "registationPK=" + registationPK +
                ", registartionFee=" + registartionFee +
                ", courseFee=" + courseFee +
                ", status='" + status + '\'' +
                ", reg_Date=" + reg_Date +
                ", courseFeeGi_Date=" + courseFeeGi_Date +
                '}';
    }
}
