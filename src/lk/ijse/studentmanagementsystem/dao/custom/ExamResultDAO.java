package lk.ijse.studentmanagementsystem.dao.custom;

import lk.ijse.studentmanagementsystem.dao.CrudDAO;
import lk.ijse.studentmanagementsystem.entity.ExamResult;

public interface ExamResultDAO extends CrudDAO<ExamResult,String> {

    String getLastExamResultId()throws Exception;
}
