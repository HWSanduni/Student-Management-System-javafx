package lk.ijse.studentmanagementsystem.business.custom.impl;

import lk.ijse.studentmanagementsystem.business.custom.CourseBO;
import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.CourseDAO;
import lk.ijse.studentmanagementsystem.entity.Course;
import lk.ijse.studentmanagementsystem.util.CourseTM;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    CourseDAO courseDAO = DAOFactroy.getInstance().getDAO(DAOType.COURSE);



    @Override
    public List<CourseTM> getAllCourse() throws Exception {

        List<Course> courses = courseDAO.findAll();

        List<CourseTM> courseTMS = new ArrayList<>();
        for (Course course:courses) {
            courseTMS.add(new CourseTM(course.getCid(),course.getName(),course.getCourseFee(),course.getDescription()));
        }

        return courseTMS;
    }

    @Override
    public Course findSubject(String id) throws Exception {

        Course course = courseDAO.find(id);
        return course;
    }

    @Override
    public boolean saveCourse(String id, String name, BigDecimal fee, String description) throws Exception {


        return courseDAO.save(new Course(id,name,fee,description));
    }

    @Override
    public boolean deleteCourse(String courseId) throws Exception {
       return courseDAO.delete(courseId);
    }

    @Override
    public boolean updateCourse(String name, BigDecimal fee, String description, String id) throws Exception {
        return courseDAO.update(new Course(name,fee,description,id));
    }

    @Override
    public String getNewCourseId() throws Exception {

        String lastCourseId = null;

        lastCourseId = courseDAO.getLastCourseId();

        if(lastCourseId == null){
            return "C001";
        }else{
            int maxId = Integer.parseInt(lastCourseId.replace("C", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "C00" + maxId;
            } else if (maxId < 100) {
                id = "C0" + maxId;
            } else {
                id = "C" + maxId;
            }
            return id;
        }
    }
}
