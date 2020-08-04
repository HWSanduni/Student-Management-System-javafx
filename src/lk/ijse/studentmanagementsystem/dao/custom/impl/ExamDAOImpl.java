package lk.ijse.studentmanagementsystem.dao.custom.impl;

import lk.ijse.studentmanagementsystem.dao.CrudUtil;
import lk.ijse.studentmanagementsystem.dao.custom.ExamDAO;
import lk.ijse.studentmanagementsystem.entity.Exam;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExamDAOImpl implements ExamDAO {
    @Override
    public String getLastExamId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM exam ORDER BY Eid DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }

    @Override
    public List<Exam> findAll() throws Exception {
        ResultSet rest=CrudUtil.execute("SELECT * FROM exam");
        List<Exam> exams = new ArrayList<>();
        while (rest.next()){
            exams.add(new Exam(rest.getString(1),
                    rest.getString(2),
                    rest.getDate(3),
                    rest.getString(4),
                    rest.getInt(5),
                    rest.getString(6)));
        }
        return exams;
    }

    @Override
    public Exam find(String key) throws Exception {
        ResultSet rest = CrudUtil.execute("SELECT * FROM exam WHERE Eid=?", key);
        if(rest.next()){
            return new Exam(rest.getString(1),
                    rest.getString(2),
                    rest.getDate(3),
                    rest.getString(4),
                    rest.getInt(5),
                    rest.getString(6));
        }
        return null;
    }

    @Override
    public boolean save(Exam exam) throws Exception {
        return CrudUtil.execute("INSERT INTO exam VALUES (?,?,?,?,?,?)",exam.getEid(),exam.getName(),exam.getDate(),exam.getTime(),exam.getPassMarks(),exam.getStatus());
    }

    @Override
    public boolean update(Exam exam) throws Exception {
        return CrudUtil.execute("UPDATE exam SET Name=?, Date=?,Time=?,PassMarks=?,Status=? WHERE Eid=?",exam.getName(),exam.getDate(),exam.getTime(),exam.getPassMarks(),exam.getStatus(),exam.getEid());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM exam WHERE Eid=?",key);
    }
}
