package lk.ijse.studentmanagementsystem.entity;

public class CustomEntity2 {

    private String studentId;
    private String studentName;
    private int tel;
    private String batchName;
    private String courseName;
    private int marsk;
    private int passMasks;


    public CustomEntity2() {
    }

    public CustomEntity2(int marsk,String studentName, int tel, String batchName, String courseName) {
        this.marsk = marsk;
        this.studentName = studentName;
        this.tel = tel;
        this.batchName = batchName;
        this.courseName = courseName;


    }

    public CustomEntity2(String studentId, String studentName, int tel, String courseName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.tel = tel;
        this.courseName = courseName;
    }


    public CustomEntity2(String studentId, String studentName, int tel, String batchName, String courseName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.tel = tel;
        this.batchName = batchName;
        this.courseName = courseName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
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

    public int getMarsk() {
        return marsk;
    }

    public void setMarsk(int marsk) {
        this.marsk = marsk;
    }

    public int getPassMasks() {
        return passMasks;
    }

    public void setPassMasks(int passMasks) {
        this.passMasks = passMasks;
    }

    @Override
    public String toString() {
        return "CustomEntity2{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", tel=" + tel +
                ", batchName='" + batchName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", marsk=" + marsk +
                ", passMasks=" + passMasks +
                '}';
    }
}
