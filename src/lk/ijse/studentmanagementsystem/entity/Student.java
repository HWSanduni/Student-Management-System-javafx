package lk.ijse.studentmanagementsystem.entity;

public class Student implements SuperEntity {

    private String Sid;
    private String firstName;
    private String lastName;
    private String address;
    private int tel;
    private String nic;
    private int age;
    private String mail;

    public Student() {
    }

    public Student(String sid, String firstName, String lastName, String address, int tel, String nic, int age, String mail) {
        Sid = sid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.tel = tel;
        this.nic = nic;
        this.age = age;
        this.mail = mail;
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

    @Override
    public String toString() {
        return "Student{" +
                "Sid='" + Sid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", tel=" + tel +
                ", nic='" + nic + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                '}';
    }
}
