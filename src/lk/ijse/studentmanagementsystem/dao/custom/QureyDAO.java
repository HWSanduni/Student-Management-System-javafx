package lk.ijse.studentmanagementsystem.dao.custom;

import lk.ijse.studentmanagementsystem.dao.SuperDAO;
import lk.ijse.studentmanagementsystem.entity.*;

import java.util.List;

public interface QureyDAO extends SuperDAO {

    CustomEntity getStudentDetails(String key)throws Exception;
    CustomEntity1 getExamDetails (String key)throws Exception;
    List<CustomEntity2> getAllRegisterStudent (String status)throws Exception;
    List<Course> getCourseDetails (String key)throws Exception;
    List<Subject> getSubjectDetails (String key)throws Exception;
    List<Batch> getBatcDetails (String key)throws Exception;
    List<CustomEntity2> getAllBatchStudent (String status)throws Exception;

    List<CustomEntity2> getExamResult (String status,String key)throws Exception;

}
