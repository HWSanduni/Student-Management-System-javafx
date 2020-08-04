package lk.ijse.studentmanagementsystem.business.custom.impl;

import lk.ijse.studentmanagementsystem.business.custom.ExamBO;
import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.ExamDAO;
import lk.ijse.studentmanagementsystem.entity.Exam;
import lk.ijse.studentmanagementsystem.util.ExamTM;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ExamBOImpl implements ExamBO {

    ExamDAO examDAO = DAOFactroy.getInstance().getDAO(DAOType.EXAM);

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
    public boolean saveExam(String id, String name, Date date, String time, int passmarks, String status) throws Exception {
        return false;
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
}
