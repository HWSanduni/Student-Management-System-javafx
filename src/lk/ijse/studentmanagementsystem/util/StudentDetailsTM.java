package lk.ijse.studentmanagementsystem.util;

public class StudentDetailsTM {

    private String Sid;
    private String firstName;
    private int tel;
    private String courseName;

    public StudentDetailsTM() {
    }

    public StudentDetailsTM(String sid, String firstName, int tel, String courseName) {
        Sid = sid;
        this.firstName = firstName;
        this.tel = tel;
        this.courseName = courseName;
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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "StudentDetailsTM{" +
                "Sid='" + Sid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", tel=" + tel +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
