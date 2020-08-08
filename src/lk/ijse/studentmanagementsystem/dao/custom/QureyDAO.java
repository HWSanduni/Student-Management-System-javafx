package lk.ijse.studentmanagementsystem.dao.custom;

import lk.ijse.studentmanagementsystem.dao.SuperDAO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity;
import lk.ijse.studentmanagementsystem.entity.CustomEntity1;

public interface QureyDAO extends SuperDAO {

    CustomEntity getStudentDetails(String key)throws Exception;
    CustomEntity1 getExamDetails (String key)throws Exception;
}
