package lk.ijse.studentmanagementsystem.business.custom;

import lk.ijse.studentmanagementsystem.business.SuperBO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity;
import lk.ijse.studentmanagementsystem.entity.CustomEntity1;
import lk.ijse.studentmanagementsystem.entity.Exam;
import lk.ijse.studentmanagementsystem.util.ExamTM;


import java.sql.Date;
import java.util.List;

public interface ExamBO extends SuperBO {

    public List<ExamTM> getAllExam() throws Exception;
    public Exam findExam (String id) throws Exception;
    public  boolean deleteExam(String studentId)throws Exception;
    public  boolean updateExam(String name , Date date, String time, int passmarks, String status,String id)throws Exception;
    public  String getNewExamId()throws Exception;

    public  boolean save(String id, String courseId,String name , Date date, String time,String subjectId, int passmarks, String status)throws Exception;

    CustomEntity1 getExamDetails (String key)throws Exception;

}
