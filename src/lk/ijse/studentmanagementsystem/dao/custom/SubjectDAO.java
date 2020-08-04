package lk.ijse.studentmanagementsystem.dao.custom;

import lk.ijse.studentmanagementsystem.dao.CrudDAO;
import lk.ijse.studentmanagementsystem.entity.Subject;

public interface SubjectDAO extends CrudDAO<Subject,String> {

    String getLastSubjectId()throws Exception;
}
