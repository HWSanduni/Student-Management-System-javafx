package lk.ijse.studentmanagementsystem.dao.custom;

import lk.ijse.studentmanagementsystem.dao.SuperDAO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity;

public interface QureyDAO extends SuperDAO {

    CustomEntity getStudentDetails(String key)throws Exception;

}
