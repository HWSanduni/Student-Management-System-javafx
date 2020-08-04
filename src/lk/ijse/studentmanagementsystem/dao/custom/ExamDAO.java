package lk.ijse.studentmanagementsystem.dao.custom;

import lk.ijse.studentmanagementsystem.dao.CrudDAO;
import lk.ijse.studentmanagementsystem.entity.Exam;

public interface ExamDAO extends CrudDAO<Exam,String> {
    String getLastExamId()throws Exception;
}
