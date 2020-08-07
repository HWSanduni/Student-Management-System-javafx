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

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Date getReg_Date() {
        return reg_Date;
    }

    public void setReg_Date(Date reg_Date) {
        this.reg_Date = reg_Date;
    }

    public BigDecimal getRegistartionFee() {
        return registartionFee;
    }

    public void setRegistartionFee(BigDecimal registartionFee) {
        this.registartionFee = registartionFee;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(BigDecimal courseFee) {
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
