package lk.ijse.studentmanagementsystem.dao.custom;

import lk.ijse.studentmanagementsystem.dao.CrudDAO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity;
import lk.ijse.studentmanagementsystem.entity.Student;

public interface StudentDAO extends CrudDAO<Student,String> {

    CustomEntity get(String key)throws Exception;
    String getLastStudntId()throws Exception;
}
