package lk.ijse.studentmanagementsystem.dao.custom.impl;

import lk.ijse.studentmanagementsystem.dao.CrudUtil;
import lk.ijse.studentmanagementsystem.dao.custom.ExamResultDAO;
import lk.ijse.studentmanagementsystem.entity.ExamResult;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExamResultDAOImpl implements ExamResultDAO {

    @Override
    public List<ExamResult> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM examresult");
        List<ExamResult> examResults = new ArrayList<>();
        while (rst.next()) {
            examResults.add(new ExamResult(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4)));
        }
        return examResults;
    }

    @Override
    public ExamResult find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM examresult WHERE id=?",key);
        if (rst.next()) {
            return new ExamResult(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4));
        }
        return null;
    }

    @Override
    public boolean save(ExamResult examResult) throws Exception {

        System.out.println("DAO");
        System.out.println(examResult);
        UUID id = UUID.randomUUID();
        return CrudUtil.execute("INSERT INTO examresult VALUES (?,?,?,?)", examResult.getId(),examResult.getExamId(),examResult.getStudentId(),examResult.getMarks());
    }

    @Override
    public boolean update(ExamResult examResult) throws Exception {
        return CrudUtil.execute("UPDATE examresult SET studentId=?, marks=? WHERE examId=?",examResult.getExamId(),examResult.getStudentId(),examResult.getMarks(),examResult.getId());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM examresult WHERE id=?",key);
    }

    @Override
    public String getLastExamResultId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM examresult ORDER BY id DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }
}
