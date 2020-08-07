package lk.ijse.studentmanagementsystem.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class CustomEntity implements SuperEntity {

    private String Sid;
    private String firstName;
    private String lastName;
    private String address;
    private int tel;
    private String nic;
    private Date birthDay;
    private String mail;
    private String gender;
    private int age;
    private String batchId;
    private Date reg_Date;
    private BigDecimal registartionFee;
    private String batchName;
    private String courseName;
    private BigDecimal courseFee;

    public CustomEntity() {
    }

    public CustomEntity(String sid, String firstName, String lastName, String address, int tel, String nic, Date birthDay, String mail, String gender, int age, String batchId, Date reg_Date, BigDecimal registartionFee, String batchName, String courseName, BigDecimal courseFee) {
        Sid = sid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.tel = tel;
        this.nic = nic;
        this.birthDay = birthDay;
        this.mail = mail;
        this.gender = gender;
        this.age = age;
        this.batchId = batchId;
        this.reg_Date = reg_Date;
        this.registartionFee = registartionFee;
        this.batchName = batchName;
        this.courseName = courseName;
        this.courseFee = courseFee;
    }

    @Override
    public String toString() {
        return "CustomEntity{" +
                "Sid='" + Sid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", tel=" + tel +
                ", nic='" + nic + '\'' +
                ", birthDay=" + birthDay +
                ", mail='" + mail + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", batchId='" + batchId + '\'' +
                ", reg_Date=" + reg_Date +
                ", registartionFee=" + registartionFee +
                ", batchName='" + batchName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseFee=" + courseFee +
                '}';
    }
}
