package lk.ijse.studentmanagementsystem.entity;

public class ExamDetails  implements SuperEntity{

    private ExamDetailsPK examDetailsPK;
    private String subjectId;
    private int passMarks;


    public ExamDetails() {
    }

    public ExamDetails(ExamDetailsPK examDetailsPK,String subjectId, int passMarks) {
        this.examDetailsPK = examDetailsPK;
        this.subjectId = subjectId;
        this.passMarks = passMarks;
    }

    public ExamDetails(String examId,String corseId,String subjectId, int passMarks) {
        this.examDetailsPK = new ExamDetailsPK(examId,corseId);
        this.subjectId = subjectId;
        this.passMarks = passMarks;
    }

    public ExamDetailsPK getExamDetailsPK() {
        return examDetailsPK;
    }

    public void setExamDetailsPK(ExamDetailsPK examDetailsPK) {
        this.examDetailsPK = examDetailsPK;
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
        return "ExamDetails{" +
                "examDetailsPK=" + examDetailsPK +
                ", subjectId='" + subjectId + '\'' +
                ", passMarks=" + passMarks +
                '}';
    }
}
