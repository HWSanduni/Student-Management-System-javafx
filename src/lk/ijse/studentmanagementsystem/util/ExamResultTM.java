package lk.ijse.studentmanagementsystem.util;

public class ExamResultTM {

    private String id;
    private String examId;
    private String studentId;
    private int marks;

    public ExamResultTM() {
    }

    public ExamResultTM(String id, String examId, String studentId, int marks) {
        this.id = id;
        this.examId = examId;
        this.studentId = studentId;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ExamResultTM{" +
                "id='" + id + '\'' +
                ", examId='" + examId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", marks=" + marks +
                '}';
    }
}
