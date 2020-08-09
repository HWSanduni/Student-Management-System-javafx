package lk.ijse.studentmanagementsystem.business.custom;

import lk.ijse.studentmanagementsystem.business.SuperBO;
import lk.ijse.studentmanagementsystem.entity.Subject;
import lk.ijse.studentmanagementsystem.util.SubjectTM;

import java.util.List;

public interface SubjectBO extends SuperBO {

    public List<SubjectTM> getAllSubject() throws Exception;
    public Subject findSubject (String id) throws Exception;
    public  boolean saveSubject(String id, String courseId, String name, String type)throws Exception;
    public  boolean deleteSubject(String subId)throws Exception;
    public  boolean updateSubject(String courseId, String name, String type,String subid)throws Exception;
    public  String getNewSubjectId()throws Exception;
    public List<SubjectTM> getFindAllSubject(String id) throws Exception;
    List<SubjectTM> getSubjectDetails(String key)throws Exception;

    int getSubjectCount()throws Exception;


}
