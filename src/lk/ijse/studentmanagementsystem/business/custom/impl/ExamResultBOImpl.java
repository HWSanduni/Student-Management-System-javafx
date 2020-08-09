package lk.ijse.studentmanagementsystem.business.custom.impl;

import lk.ijse.studentmanagementsystem.business.custom.ExamResultBO;
import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.ExamResultDAO;
import lk.ijse.studentmanagementsystem.dao.custom.QureyDAO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity2;
import lk.ijse.studentmanagementsystem.entity.ExamResult;
import lk.ijse.studentmanagementsystem.util.ExamResultDetailsTM;
import lk.ijse.studentmanagementsystem.util.ExamResultTM;

import java.util.ArrayList;
import java.util.List;

public class ExamResultBOImpl implements ExamResultBO {

    ExamResultDAO examResultDAO = DAOFactroy.getInstance().getDAO(DAOType.EXAMRESULT);
    QureyDAO qureyDAO = DAOFactroy.getInstance().getDAO(DAOType.QUREY);

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
        System.out.println("11111111111111");
        System.out.println(examResultTMS.toString());

        ExamResult examResult = new ExamResult();

        boolean result;


        for (ExamResultTM examResultTM: examResultTMS){

           result = examResultDAO.save(new ExamResult(
                   examResultTM.getId(),
                    examResultTM.getExamId(),
                    examResultTM.getStudentId(),
                    examResultTM.getMarks()

            ));
           if(!result){
               return  false;
           }

        }


       return true;
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

    @Override
    public List<ExamResultDetailsTM> getExamResult(String status, String key) throws Exception {

        List<CustomEntity2> customEntity2s = qureyDAO.getExamResult(status,key);
        List<ExamResultDetailsTM> examResultDetailsTMS = new ArrayList<>();

        System.out.println("-------------------------");
        System.out.println(customEntity2s.toString());

        for (CustomEntity2 customEntity2:customEntity2s){
            examResultDetailsTMS.add(new ExamResultDetailsTM(customEntity2.getMarsk(),
                    customEntity2.getStudentName(),customEntity2.getTel(),customEntity2.getBatchName(),customEntity2.getCourseName()));
        }


        return examResultDetailsTMS;
    }
}
