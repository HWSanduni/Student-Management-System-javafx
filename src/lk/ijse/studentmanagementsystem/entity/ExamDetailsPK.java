package lk.ijse.studentmanagementsystem.entity;

public class ExamDetailsPK implements SuperEntity{

    private String examId;
    private String coruseId;


    public ExamDetailsPK() {
    }

    public ExamDetailsPK(String examId, String coruseId) {
        this.examId = examId;
        this.coruseId = coruseId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getCoruseId() {
        return coruseId;
    }

    public void setCoruseId(String coruseId) {
        this.coruseId = coruseId;
    }

    @Override
    public String toString() {
        return "ExamDetailsPK{" +
                "examId='" + examId + '\'' +
                ", coruseId='" + coruseId + '\'' +
                '}';
    }
}
