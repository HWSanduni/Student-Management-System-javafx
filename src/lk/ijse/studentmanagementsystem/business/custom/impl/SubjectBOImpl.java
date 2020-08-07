package lk.ijse.studentmanagementsystem.business.custom.impl;

import lk.ijse.studentmanagementsystem.business.custom.SubjectBO;
import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.SubjectDAO;
import lk.ijse.studentmanagementsystem.entity.Subject;
import lk.ijse.studentmanagementsystem.util.SubjectTM;

import java.util.ArrayList;
import java.util.List;

public class SubjectBOImpl implements SubjectBO {

    SubjectDAO subjectDAO = DAOFactroy.getInstance().getDAO(DAOType.SUBJECT);

    @Override
    public List<SubjectTM> getAllSubject() throws Exception {

        List<Subject> subjects = subjectDAO.findAll();
        List<SubjectTM> subjectTMS = new ArrayList<>();

        for (Subject subject:subjects) {
            subjectTMS.add(new SubjectTM(subject.getSubId(),subject.getCourseId(),subject.getName(),subject.getType()));
        }

        return subjectTMS;
    }

    @Override
    public Subject findSubject(String id) throws Exception {

        Subject subject = subjectDAO.find(id);

        return subject;
    }

    @Override
    public boolean saveSubject(String id, String courseId, String name, String type) throws Exception {
        return subjectDAO.save(new Subject(id,courseId,name,type));
    }

    @Override
    public boolean deleteSubject(String subId) throws Exception {
        return subjectDAO.delete(subId);
    }

    @Override
    public boolean updateSubject(String courseId, String name, String type, String id) throws Exception {
       // System.out.println("c"+courseId);
       // System.out.println("Bo"+new Subject(courseId,name,type,id));
        return subjectDAO.update(new Subject(id,courseId,name,type));
    }

    @Override
    public String getNewSubjectId() throws Exception {
        String lastSubjectId = null;

        lastSubjectId = subjectDAO.getLastSubjectId();

        if(lastSubjectId == null){
            return "SUB001";
        }else{
            int maxId = Integer.parseInt(lastSubjectId.replace("SUB", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "SUB00" + maxId;
            } else if (maxId < 100) {
                id = "SUB0" + maxId;
            } else {
                id = "SUB" + maxId;
            }
            return id;
        }
    }

    @Override
    public List<SubjectTM> getFindAllSubject(String id) throws Exception {
        List<Subject> subjects = subjectDAO.getFindAllSubject(id);
        List<SubjectTM> subjectTMS = new ArrayList<>();

        for (Subject subject:subjects) {
            subjectTMS.add(new SubjectTM(subject.getSubId(),subject.getCourseId(),subject.getName(),subject.getType()));
        }

        return subjectTMS;
    }
}
