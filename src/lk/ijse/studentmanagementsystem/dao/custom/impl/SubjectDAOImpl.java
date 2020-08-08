package lk.ijse.studentmanagementsystem.dao.custom.impl;

import lk.ijse.studentmanagementsystem.dao.CrudUtil;
import lk.ijse.studentmanagementsystem.dao.custom.SubjectDAO;
import lk.ijse.studentmanagementsystem.entity.Subject;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public String getLastSubjectId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM subject ORDER BY Subid DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }

    @Override
    public List<Subject> getFindAllSubject(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM subject WHERE courseId=?",id);
        List<Subject> subjects = new ArrayList<>();
        while (rst.next()) {
            subjects.add(new Subject(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)));
        }
        return subjects;
    }

    @Override
    public List<Subject> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM subject");
        List<Subject> subjects = new ArrayList<>();
        while (rst.next()) {
            subjects.add(new Subject(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)));
        }
        return subjects;
    }

    @Override
    public Subject find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM subject WHERE Subid=?",key);
        if (rst.next()) {
            return new Subject(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4));
        }
        return null;
    }

    @Override
    public boolean save(Subject subject) throws Exception {
        return CrudUtil.execute("INSERT INTO subject VALUES (?,?,?,?)",subject.getSubId(),subject.getCourseId(),subject.getName(),subject.getType());
    }

    @Override
    public boolean update(Subject subject) throws Exception {
       // System.out.println("---------");
       // System.out.println(subject);
        return CrudUtil.execute("UPDATE subject SET courseId=?,Name=?, Type=? WHERE Subid=?",subject.getCourseId(),subject.getName(),subject.getType(),subject.getSubId());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM subject WHERE Subid=?",key);
    }
}
