package lk.ijse.studentmanagementsystem.business.custom.impl;

import lk.ijse.studentmanagementsystem.business.custom.CourseBO;
import lk.ijse.studentmanagementsystem.util.CourseTM;

import java.math.BigDecimal;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    @Override
    public List<CourseTM> getAllCourse() throws Exception {
        return null;
    }

    @Override
    public boolean saveCourse(String id, String name, BigDecimal fee, String description) throws Exception {
        return false;
    }

    @Override
    public boolean deleteCourse(String courseId) throws Exception {
        return false;
    }

    @Override
    public boolean updateCourse(String name, BigDecimal fee, String description, String id) throws Exception {
        return false;
    }

    @Override
    public String getNewCourseId() throws Exception {
        return null;
    }
}
