package lk.ijse.studentmanagementsystem.business.custom.impl;

import lk.ijse.studentmanagementsystem.business.custom.StudentBO;
import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.StudentDAO;
import lk.ijse.studentmanagementsystem.entity.Student;
import lk.ijse.studentmanagementsystem.util.StudentTM;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = DAOFactroy.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public List<StudentTM> getAllStudent() throws Exception {

        List<Student> students = studentDAO.findAll();
        List<StudentTM> studentTMS = new ArrayList<>();
        for (Student student: students) {
            studentTMS.add(new StudentTM(student.getSid(),student.getFirstName(),student.getLastName(),student.getAddress(),student.getTel(),student.getNic(),student.getAge(),student.getMail()));
        }

        return studentTMS;
    }

    @Override
    public Student findStudent(String id) throws Exception {

        Student student = studentDAO.find(id);
        return student;
    }

    @Override
    public boolean saveStudent(String id, String fName, String lName, String address, int tel, String nic, int age, String mail) throws Exception {
        return studentDAO.save(new Student(id,fName,lName,address,tel,nic,age,mail));
    }

    @Override
    public boolean deleteStudent(String studentId) throws Exception {
        return studentDAO.delete(studentId);
    }

    @Override
    public boolean updateStudent(String fName, String lName, String address, int tel, String nic, int age, String mail, String id) throws Exception {
        return studentDAO.update(new Student(fName,lName,address,tel,nic,age,mail,id));
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
}
