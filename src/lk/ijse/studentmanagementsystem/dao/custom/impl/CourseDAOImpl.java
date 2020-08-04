package lk.ijse.studentmanagementsystem.dao.custom.impl;

import lk.ijse.studentmanagementsystem.dao.CrudUtil;
import lk.ijse.studentmanagementsystem.dao.custom.CourseDAO;
import lk.ijse.studentmanagementsystem.entity.Course;

import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public List<Course> findAll() throws Exception {
        return null;
    }

    @Override
    public Course find(String key) throws Exception {
        return null;
    }

    @Override
    public boolean save(Course course) throws Exception {
        return CrudUtil.execute("INSERT INTO course VALUES (?,?,?,?)",course.getCid(),course.getName(),course.getCourseFee(),course.getDescription());
    }

    @Override
    public boolean update(Course entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }
}
