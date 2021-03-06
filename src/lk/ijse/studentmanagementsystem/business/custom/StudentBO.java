package lk.ijse.studentmanagementsystem.business.custom;

import lk.ijse.studentmanagementsystem.business.SuperBO;
import lk.ijse.studentmanagementsystem.entity.Batch;
import lk.ijse.studentmanagementsystem.entity.CustomEntity;
import lk.ijse.studentmanagementsystem.entity.CustomEntity2;
import lk.ijse.studentmanagementsystem.entity.Student;
import lk.ijse.studentmanagementsystem.util.*;

import java.sql.Date;
import java.util.List;

public interface StudentBO extends SuperBO {

    public List<StudentTM> getAllStudent() throws Exception;
    public Student findStudent (String id) throws Exception;
    public  boolean saveStudent(String id, String fName , String lName, String address, int tel,String nic,Date birthday,int age,String mail,String gender)throws Exception;
    public  boolean deleteStudent(String studentId)throws Exception;
    public  boolean updateStudent(String fName , String lName, String address, int tel,String nic,Date birthday,int age,String mail,String gender,String id)throws Exception;
    public  String getNewStudentId()throws Exception;

    public CustomEntity getAllStudentDetails(String key)throws Exception;

    public List<StudentPaymentTM> getAllRegisterStudent (String status)throws Exception;

    public List<StudentDetailsTM> getAllBatchStudent(String status) throws Exception;

    int getStudentCount() throws Exception;
}
