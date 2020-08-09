package lk.ijse.studentmanagementsystem.util;

public class ExamResultDetailsTM {

    private int marsk;
    private String studentName;
    private int tel;
    private String batchName;
    private String courseName;


    public ExamResultDetailsTM() {
    }

    public ExamResultDetailsTM(int marsk, String studentName, int tel, String batchName, String courseName) {
        this.marsk = marsk;
        this.studentName = studentName;
        this.tel = tel;
        this.batchName = batchName;
        this.courseName = courseName;
    }

    public int getMarsk() {
        return marsk;
    }

    public void setMarsk(int marsk) {
        this.marsk = marsk;
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

    @Override
    public String toString() {
        return "ExamResultDetailsTM{" +
                "marsk=" + marsk +
                ", studentName='" + studentName + '\'' +
                ", tel=" + tel +
                ", batchName='" + batchName + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
