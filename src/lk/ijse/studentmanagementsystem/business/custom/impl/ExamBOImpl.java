package lk.ijse.studentmanagementsystem.business.custom.impl;

import lk.ijse.studentmanagementsystem.business.custom.ExamBO;
import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.ExamDAO;
import lk.ijse.studentmanagementsystem.dao.custom.ExamDetailsDAO;
import lk.ijse.studentmanagementsystem.db.DBConnection;
import lk.ijse.studentmanagementsystem.entity.Exam;
import lk.ijse.studentmanagementsystem.entity.ExamDetails;
import lk.ijse.studentmanagementsystem.util.ExamTM;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamBOImpl implements ExamBO {

    ExamDAO examDAO = DAOFactroy.getInstance().getDAO(DAOType.EXAM);
    ExamDetailsDAO examDetailsDAO = DAOFactroy.getInstance().getDAO(DAOType.EXAMDETAILS);

    @Override
    public List<ExamTM> getAllExam() throws Exception {

        List<Exam> exams = examDAO.findAll();
        List<ExamTM> examTMS = new ArrayList<>();

        for (Exam exam:exams) {
            examTMS.add(new ExamTM(exam.getEid(),exam.getName(),exam.getDate(),exam.getTime(),exam.getPassMarks(),exam.getStatus()));
        }

        return examTMS;
    }

    @Override
    public Exam findExam(String id) throws Exception {

        Exam exam = examDAO.find(id);

        return exam;
    }

    @Override
    public boolean deleteExam(String examId) throws Exception {
        return examDAO.delete(examId);
    }

    @Override
    public boolean updateExam(String name, Date date, String time, int passmarks, String status, String id) throws Exception {
        return examDAO.update(new Exam(name,date,time,passmarks,status,id));
    }

    @Override
    public String getNewExamId() throws Exception {
        String lastExamId = null;

        lastExamId = examDAO.getLastExamId();

        if (lastExamId == null) {
            return "E001";
        } else {
            int maxId = Integer.parseInt(lastExamId.replace("E", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "E00" + maxId;
            } else if (maxId < 100) {
                id = "E0" + maxId;
            } else {
                id = "E" + maxId;
            }
            return id;
        }
    }

    @Override
    public boolean save(String id, String courseId, String name, Date date, String time,String subjectId, int passmarks, String status) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();

        try{
        connection.setAutoCommit(false);
        boolean result = examDAO.save(new Exam(id,name,date,time,passmarks,status));

        if (!result) {
            connection.rollback();
            return false;
        }

        result = examDetailsDAO.save(new ExamDetails(id,courseId,subjectId,passmarks));

        if (!result) {
            connection.rollback();
            return false;
        }

        connection.commit();
        return true;
        } catch (Throwable throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }
    }
}
