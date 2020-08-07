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
    private int age;
    private String mail;
    private String gender;
    private String batchId;
    private String batchName;
    private String courseId;
    private String courseName;
    private BigDecimal registartionFee;
    private BigDecimal courseFee;
    private String status;
    private Date reg_Date;
    private Date courseFeeGi_Date;

    public CustomEntity() {
    }

    public CustomEntity(String sid, String firstName, String lastName, String address, int tel, String nic, Date birthDay, int age, String mail, String gender, String batchId, String batchName, String courseId, String courseName, BigDecimal registartionFee, BigDecimal courseFee, String status, Date reg_Date, Date courseFeeGi_Date) {
        Sid = sid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.tel = tel;
        this.nic = nic;
        this.birthDay = birthDay;
        this.age = age;
        this.mail = mail;
        this.gender = gender;
        this.batchId = batchId;
        this.batchName = batchName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.registartionFee = registartionFee;
        this.courseFee = courseFee;
        this.status = status;
        this.reg_Date = reg_Date;
        this.courseFeeGi_Date = courseFeeGi_Date;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
        return "CustomEntity{" +
                "Sid='" + Sid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", tel=" + tel +
                ", nic='" + nic + '\'' +
                ", birthDay=" + birthDay +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                ", gender='" + gender + '\'' +
                ", batchId='" + batchId + '\'' +
                ", batchName='" + batchName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", registartionFee=" + registartionFee +
                ", courseFee=" + courseFee +
                ", status='" + status + '\'' +
                ", reg_Date=" + reg_Date +
                ", courseFeeGi_Date=" + courseFeeGi_Date +
                '}';
    }
}
