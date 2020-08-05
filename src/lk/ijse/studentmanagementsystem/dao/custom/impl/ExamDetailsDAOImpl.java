package lk.ijse.studentmanagementsystem.dao.custom.impl;
import lk.ijse.studentmanagementsystem.dao.CrudUtil;
import lk.ijse.studentmanagementsystem.dao.custom.ExamDetailsDAO;
import lk.ijse.studentmanagementsystem.entity.ExamDetails;
import lk.ijse.studentmanagementsystem.entity.ExamDetailsPK;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExamDetailsDAOImpl implements ExamDetailsDAO {


    @Override
    public List<ExamDetails> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM examdetails");

        List<ExamDetails> examDetails = new ArrayList<>();
        while (rst.next()) {
            examDetails.add(new ExamDetails(rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3)));
        }
        return examDetails;
    }

    @Override
    public ExamDetails find(ExamDetailsPK key) throws Exception {
        ExamDetailsPK examDetailsPK = key;
        ResultSet rst = CrudUtil.execute("SELECT * FROM `examdetails` WHERE batchId=? AND studentId=?",examDetailsPK.getExamId(),examDetailsPK.getCoruseId());
        if(rst.next()){
            return (new ExamDetails(rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3)));
        }


        return null;
    }

    @Override
    public boolean save(ExamDetails examDetails) throws Exception {
        return CrudUtil.execute("INSERT INTO `examdetails` VALUES (?,?,?)",examDetails.getExamDetailsPK().getExamId(),examDetails.getExamDetailsPK().getCoruseId(),examDetails.getPassMarks());
    }

    @Override
    public boolean update(ExamDetails examDetails) throws Exception {
        return CrudUtil.execute("UPDATE examdetails SET passMarks=?,WHERE  examId=? AND coruseId=? ",examDetails.getPassMarks(),examDetails.getExamDetailsPK().getCoruseId(),examDetails.getExamDetailsPK().getExamId());
    }

    @Override
    public boolean delete(ExamDetailsPK examDetailsPK) throws Exception {
        return CrudUtil.execute("DELETE FROM `examdetails` WHERE examId=? AND coruseId=?",examDetailsPK.getExamId(),examDetailsPK.getCoruseId());
    }
}
