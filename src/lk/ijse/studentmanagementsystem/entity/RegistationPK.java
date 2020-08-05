package lk.ijse.studentmanagementsystem.entity;

public class RegistationPK {

    private String batchId;
    private String studentId;

    public RegistationPK() {
    }

    public RegistationPK(String batchId, String studentId) {
        this.batchId = batchId;
        this.studentId = studentId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "RegistationPK{" +
                "batchId='" + batchId + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
