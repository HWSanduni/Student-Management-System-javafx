package lk.ijse.studentmanagementsystem.entity;

public class ExamDetails {

    private ExamDetailsPK examDetailsPK;
    private int passMarks;


    public ExamDetails() {
    }

    public ExamDetails(ExamDetailsPK examDetailsPK, int passMarks) {
        this.examDetailsPK = examDetailsPK;
        this.passMarks = passMarks;
    }

    public ExamDetails(String examId,String corseId, int passMarks) {
        this.examDetailsPK = new ExamDetailsPK(examId,corseId);
        this.passMarks = passMarks;
    }

    public ExamDetailsPK getExamDetailsPK() {
        return examDetailsPK;
    }

    public void setExamDetailsPK(ExamDetailsPK examDetailsPK) {
        this.examDetailsPK = examDetailsPK;
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
                ", passMarks=" + passMarks +
                '}';
    }
}
