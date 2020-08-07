package lk.ijse.studentmanagementsystem.util;

public class ExamDetailsTM {

    private String examId;
    private String corseId;
    private String subjectId;
    private int passMarks;

    public ExamDetailsTM() {
    }

    public ExamDetailsTM(String examId, String corseId, String subjectId, int passMarks) {
        this.examId = examId;
        this.corseId = corseId;
        this.subjectId = subjectId;
        this.passMarks = passMarks;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getCorseId() {
        return corseId;
    }

    public void setCorseId(String corseId) {
        this.corseId = corseId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getPassMarks() {
        return passMarks;
    }

    public void setPassMarks(int passMarks) {
        this.passMarks = passMarks;
    }

    @Override
    public String toString() {
        return "ExamDetailsTM{" +
                "examId='" + examId + '\'' +
                ", corseId='" + corseId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", passMarks=" + passMarks +
                '}';
    }
}
