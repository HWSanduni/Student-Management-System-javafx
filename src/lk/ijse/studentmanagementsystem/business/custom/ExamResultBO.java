package lk.ijse.studentmanagementsystem.business.custom;

import lk.ijse.studentmanagementsystem.business.SuperBO;
import lk.ijse.studentmanagementsystem.entity.ExamResult;
import lk.ijse.studentmanagementsystem.util.ExamResultTM;

import java.util.List;

public interface ExamResultBO extends SuperBO {

    public List<ExamResultTM> getAllExamResult() throws Exception;
    public ExamResult findExamResult (String id) throws Exception;
    public  boolean saveExamResult(String id, String examId,String studentId,int marks)throws Exception;
    public  boolean deleteExamResult(String courseId)throws Exception;
    public  boolean updateExamResult(String id, String examId,String studentId,int marks)throws Exception;
    public  String getNewExamResultId()throws Exception;
}
