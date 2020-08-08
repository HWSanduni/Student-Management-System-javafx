package lk.ijse.studentmanagementsystem.entity;

import java.sql.Date;

public class Student implements SuperEntity {

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

    public Student() {
    }

    public Student(String sid, String firstName) {
        Sid = sid;
        this.firstName = firstName;
    }

    public Student(String sid, String firstName, String lastName, String address, int tel, String nic, Date birthDay, int age, String mail, String gender) {
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
    }

    public Student(String firstName, String lastName, String address, int tel, String nic,Date birthDay ,int age, String mail, String gender, String sid) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.tel = tel;
        this.nic = nic;
        this.birthDay = birthDay;
        this.age = age;
        this.mail = mail;
        this.gender = gender;
        Sid = sid;
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

    @Override
    public String toString() {
        return "Student{" +
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
                '}';
    }
}
