package lk.ijse.studentmanagementsystem.business.custom;

import lk.ijse.studentmanagementsystem.business.SuperBO;
import lk.ijse.studentmanagementsystem.entity.Batch;
import lk.ijse.studentmanagementsystem.entity.Student;
import lk.ijse.studentmanagementsystem.util.BatchTM;
import lk.ijse.studentmanagementsystem.util.StudentTM;

import java.sql.Date;
import java.util.List;

public interface StudentBO extends SuperBO {

    public List<StudentTM> getAllStudent() throws Exception;
    public Student findStudent (String id) throws Exception;
    public  boolean saveStudent(String id, String fName , String lName, String address, int tel,String nic,int age,String mail)throws Exception;
    public  boolean deleteStudent(String studentId)throws Exception;
    public  boolean updateStudent(String fName , String lName, String address, int tel,String nic,int age,String mail,String id)throws Exception;
    public  String getNewStudentId()throws Exception;
}