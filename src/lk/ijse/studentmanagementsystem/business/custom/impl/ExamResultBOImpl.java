package lk.ijse.studentmanagementsystem.business.custom.impl;

import lk.ijse.studentmanagementsystem.business.custom.ExamResultBO;
import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.ExamResultDAO;
import lk.ijse.studentmanagementsystem.entity.ExamResult;
import lk.ijse.studentmanagementsystem.util.ExamResultTM;

import java.util.ArrayList;
import java.util.List;

public class ExamResultBOImpl implements ExamResultBO {

    ExamResultDAO examResultDAO = DAOFactroy.getInstance().getDAO(DAOType.EXAMRESULT);

    @Override
    public List<ExamResultTM> getAllExamResult() throws Exception {

        List<ExamResult> examResults = examResultDAO.findAll();
        List<ExamResultTM> examResultTMS = new ArrayList<>();

        for (ExamResult examResult: examResults) {
            examResultTMS.add(new ExamResultTM(examResult.getId(),examResult.getExamId(),examResult.getStudentId(),examResult.getMarks()));
        }

        return examResultTMS;
    }

    @Override
    public ExamResult findExamResult(String id) throws Exception {

        ExamResult examResult = examResultDAO.find(id);
        return examResult;
    }

    @Override
    public boolean saveExamResult(List<ExamResultTM> examResultTMS) throws Exception {

        for (ExamResultTM examResultTM: examResultTMS){
            return examResultDAO.save(new ExamResult(
                    examResultTM.getId(),
                    examResultTM.getExamId(),
                    examResultTM.getStudentId(),
                    examResultTM.getMarks()
            ));
        }

        return false;
    }

    @Override
    public boolean deleteExamResult(String id) throws Exception {
        return examResultDAO.delete(id);
    }

    @Override
    public boolean updateExamResult(String id, String examId, String studentId, int marks) throws Exception {
        return examResultDAO.update(new ExamResult(examId,studentId,marks,id));
    }

    @Override
    public String getNewExamResultId() throws Exception {
        String lastExamResultId = null;

        lastExamResultId = examResultDAO.getLastExamResultId();

        if (lastExamResultId == null) {
            return "ER001";
        } else {
            int maxId = Integer.parseInt(lastExamResultId.replace("ER", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "ER00" + maxId;
            } else if (maxId < 100) {
                id = "ER0" + maxId;
            } else {
                id = "ER" + maxId;
            }
            return id;
        }
    }
}
