package lk.ijse.studentmanagementsystem.dao.custom.impl;

import lk.ijse.studentmanagementsystem.dao.CrudUtil;
import lk.ijse.studentmanagementsystem.dao.custom.CourseDAO;
import lk.ijse.studentmanagementsystem.entity.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public List<Course> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM course");
        List<Course> courses = new ArrayList<>();
        while (rst.next()) {
            courses.add(new Course(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getString(4)));
        }
        return courses;
    }

    @Override
    public Course find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM course WHERE Cid=?",key);
        if (rst.next()) {
            return new Course(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getString(4));
        }
        return null;
    }

    @Override
    public boolean save(Course course) throws Exception {
        return CrudUtil.execute("INSERT INTO course VALUES (?,?,?,?)",course.getCid(),course.getName(),course.getCourseFee(),course.getDescription());
    }

    @Override
    public boolean update(Course course) throws Exception {


        return CrudUtil.execute("UPDATE course SET name=?,courseFee=?, description=? WHERE Cid=?",course.getName(),course.getCourseFee(),course.getDescription(),course.getCid());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM course WHERE Cid=?",key);
    }

    @Override
    public String getLastCourseId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM course ORDER BY Cid DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }

    @Override
    public int getCourseCount() throws Exception {

        int count=0;
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) from course");

        if (rst.next()) {
            count=rst.getInt(1);
        }
        return count;
    }
}
