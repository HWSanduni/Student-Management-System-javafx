package lk.ijse.studentmanagementsystem.dao.custom;

import lk.ijse.studentmanagementsystem.dao.CrudDAO;
import lk.ijse.studentmanagementsystem.entity.Student;

public interface StudentDAO extends CrudDAO<Student,String> {

    String getLastBatchId()throws Exception;
}
