package lk.ijse.studentmanagementsystem.dao.custom.impl;

import lk.ijse.studentmanagementsystem.dao.CrudUtil;
import lk.ijse.studentmanagementsystem.dao.custom.StudentDAO;
import lk.ijse.studentmanagementsystem.entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM student");
        List<Student> students = new ArrayList<>();
        while (rst.next()) {
            students.add(new Student(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5),
                    rst.getString(6),
                    rst.getDate(7),
                    rst.getInt(8),
                    rst.getString(9),
                    rst.getString(10)));
        }
        return students;

    }

    @Override
    public Student find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM student WHERE Sid=?",key);
        if (rst.next()) {
            return new Student(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5),
                    rst.getString(6),
                    rst.getDate(7),
                    rst.getInt(8),
                    rst.getString(9),
                    rst.getString(10));
        }
        return null;
    }

    @Override
    public boolean save(Student student) throws Exception {
        return CrudUtil.execute("INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?,?)",student.getSid(),student.getFirstName(),student.getLastName(),student.getAddress(),student.getTel(),student.getNic(),student.getBirthDay(),student.getMail(),student.getGender(),student.getAge());
    }

    @Override
    public boolean update(Student student) throws Exception {
        return CrudUtil.execute("UPDATE student SET FirstName=?,LastName=?, Address=? Tel=?,Nic=?,BirthDay=?,Mail=?,Gender=?Age=? WHERE Sid=?",student.getFirstName(),student.getLastName(),student.getAddress(),student.getTel(),student.getNic(),student.getBirthDay(),student.getMail(),student.getGender(),student.getAge(),student.getSid());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM student WHERE id=?",key);
    }

    @Override
    public String getLastStudntId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM student ORDER BY Sid DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }
}
