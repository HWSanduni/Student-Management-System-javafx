package lk.ijse.studentmanagementsystem.business.custom;

import lk.ijse.studentmanagementsystem.business.SuperBO;
import lk.ijse.studentmanagementsystem.entity.Course;
import lk.ijse.studentmanagementsystem.util.CourseTM;

import java.math.BigDecimal;
import java.util.List;

public interface CourseBO extends SuperBO {

    public List<CourseTM> getAllCourse() throws Exception;
    public Course findSubject (String id) throws Exception;
    public  boolean saveCourse(String id, String name, double fee, String description)throws Exception;
    public  boolean deleteCourse(String courseId)throws Exception;
    public  boolean updateCourse(String name, double fee, String description,String id)throws Exception;
    public  String getNewCourseId()throws Exception;


}
