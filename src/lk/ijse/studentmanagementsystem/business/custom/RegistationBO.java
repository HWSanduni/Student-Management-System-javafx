package lk.ijse.studentmanagementsystem.business.custom;

import lk.ijse.studentmanagementsystem.business.SuperBO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity2;
import lk.ijse.studentmanagementsystem.util.RegistraionTM;
import lk.ijse.studentmanagementsystem.util.StudentTM;

import java.util.List;

public interface RegistationBO extends SuperBO {

   // public  String getNewStudentId()throws Exception;
    public boolean registation (StudentTM studentTM, RegistraionTM registraionTM)throws Exception;

    public boolean registationUpdate (RegistraionTM registraionTM)throws Exception;



}
