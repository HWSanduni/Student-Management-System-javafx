package lk.ijse.studentmanagementsystem.business.custom.impl;

import lk.ijse.studentmanagementsystem.business.custom.StudentBO;
import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.QureyDAO;
import lk.ijse.studentmanagementsystem.dao.custom.StudentDAO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity;
import lk.ijse.studentmanagementsystem.entity.Student;
import lk.ijse.studentmanagementsystem.util.CustomTM;
import lk.ijse.studentmanagementsystem.util.StudentTM;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = DAOFactroy.getInstance().getDAO(DAOType.STUDENT);
    QureyDAO qureyDAO = DAOFactroy.getInstance().getDAO(DAOType.QUREY);


    @Override
    public List<StudentTM> getAllStudent() throws Exception {

        List<Student> students = studentDAO.findAll();
        List<StudentTM> studentTMS = new ArrayList<>();
        for (Student student: students) {
            studentTMS.add(new StudentTM(student.getSid(),student.getFirstName(),student.getLastName(),student.getAddress(),student.getTel(),student.getNic(),student.getBirthDay(),student.getAge(),student.getMail(),student.getGender()));
        }

        return studentTMS;
    }

    @Override
    public Student findStudent(String id) throws Exception {

        Student student = studentDAO.find(id);
        return student;
    }

    @Override
    public boolean saveStudent(String id, String fName, String lName, String address, int tel, String nic,Date birthday ,int age, String mail,String gender) throws Exception {
        return studentDAO.save(new Student(id,fName,lName,address,tel,nic,birthday,age,mail,gender));
    }

    @Override
    public boolean deleteStudent(String studentId) throws Exception {
        return studentDAO.delete(studentId);
    }

    @Override
    public boolean updateStudent(String fName, String lName, String address, int tel, String nic, Date birthday, int age, String mail, String gender, String id) throws Exception {
        return studentDAO.update(new Student(fName,lName,address,tel,nic,birthday,age,mail,gender,id));
    }

    @Override
    public String getNewStudentId() throws Exception {
        String lastStudentId = null;

        lastStudentId = studentDAO.getLastStudntId();

        if(lastStudentId == null){
            return "S001";
        }else{
            int maxId = Integer.parseInt(lastStudentId.replace("S", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "S00" + maxId;
            } else if (maxId < 100) {
                id = "S0" + maxId;
            } else {
                id = "S" + maxId;
            }
            return id;
        }
    }

    @Override
    public CustomEntity getAllStudentDetails(String key) throws Exception {
        System.out.println("BO");
        CustomEntity customEntity=qureyDAO.getStudentDetails(key);
        return customEntity;
    }
}
