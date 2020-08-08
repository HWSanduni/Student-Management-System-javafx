package lk.ijse.studentmanagementsystem.entity;

import lk.ijse.studentmanagementsystem.util.StudentTM;

import java.math.BigDecimal;
import java.util.List;

public class CustomEntity1 {

    private String batchName;
    private String courseName;
    private BigDecimal courseFee;
    private String subjectId;
    private String subjectName;
    private String examName;
    private List<StudentTM> studentList;

    public CustomEntity1() {
    }

    public CustomEntity1(String batchName, String courseName, String subjectId, String subjectName, String examName, List<StudentTM> studentList){
        this.batchName = batchName;
        this.courseName = courseName;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.examName = examName;
        this.studentList = studentList;

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

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public List<StudentTM> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentTM> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "CustomEntity1{" +
                "batchName='" + batchName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseFee=" + courseFee +
                ", subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", examName='" + examName + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
