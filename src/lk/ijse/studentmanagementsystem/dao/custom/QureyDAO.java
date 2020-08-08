package lk.ijse.studentmanagementsystem.dao.custom;

import lk.ijse.studentmanagementsystem.dao.SuperDAO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity;
import lk.ijse.studentmanagementsystem.entity.CustomEntity1;
import lk.ijse.studentmanagementsystem.entity.CustomEntity2;

import java.util.List;

public interface QureyDAO extends SuperDAO {

    CustomEntity getStudentDetails(String key)throws Exception;
    CustomEntity1 getExamDetails (String key)throws Exception;
    List<CustomEntity2> getAllRegisterStudent (String status)throws Exception;
}
