package lk.ijse.studentmanagementsystem.dao.custom;

import lk.ijse.studentmanagementsystem.dao.SuperDAO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity;

public interface QureyDAO extends SuperDAO {

    CustomEntity getStudentAllDetails(String key)throws Exception;
}
