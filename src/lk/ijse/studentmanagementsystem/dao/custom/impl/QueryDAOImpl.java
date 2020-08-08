package lk.ijse.studentmanagementsystem.dao.custom.impl;

import lk.ijse.studentmanagementsystem.dao.CrudUtil;
import lk.ijse.studentmanagementsystem.dao.custom.QureyDAO;
import lk.ijse.studentmanagementsystem.entity.*;
import lk.ijse.studentmanagementsystem.util.StudentTM;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QureyDAO {
    @Override
    public CustomEntity getStudentDetails(String key) throws Exception {

        System.out.println("//////");
        ResultSet rst = CrudUtil.execute("SELECT s.Sid,s.FirstName,s.LastName,s.Address,s.Tel,s.Nic,s.BirthDay,s.Mail,s.Gender,s.Age,r.batchId,r.Reg_Date,r.RegistationFee,b.Name,c.Name,c.CourseFee from student s INNER join registation r ON s.Sid = r.studentId INNER\n" +
                "JOIN batch b on r.batchId = b.Bid INNER JOIN course c on b.courseId = c.Cid\n" +
                "WHERE  s.Sid=?",key);
        System.out.println("---------");
        System.out.println("rst"+rst);
        if (rst.next()){
            return new CustomEntity(
             rst.getString(1),
             rst.getString(2),
             rst.getString(3),
             rst.getString(4),
              rst.getInt(5),
                    rst.getString(6),
                    rst.getDate(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getInt(10),
                    rst.getString(11),
                    rst.getDate(12),
                    rst.getBigDecimal(13),
                    rst.getString(14),
                    rst.getString(15),
                    rst.getBigDecimal(16)

            );
        }

        return null;
    }

    @Override
    public CustomEntity1 getExamDetails(String key) throws Exception {

        ResultSet rst = CrudUtil.execute("SELECT  s.Sid,s.FirstName,b.Name,c.Name,s2.Subid,s2.Name,e2.Name from student s\n" +
                "INNER JOIN registation r ON s.Sid = r.studentId\n" +
                "INNER JOIN batch b on r.batchId = b.Bid\n" +
                "INNER JOIN course c on b.courseId = c.Cid\n" +
                "INNER JOIN subject s2 on c.Cid = s2.courseId\n" +
                "INNER JOIN examdetails e on c.Cid = e.coruseId\n" +
                "INNER JOIN exam e2 on e.examId = e2.Eid where e2.Eid=?",key);


        List<StudentTM> students = new ArrayList<>();
        CustomEntity1 customEntity = new CustomEntity1();
        while (rst.next()) {
            System.out.println(rst.toString());
            students.add(new StudentTM(rst.getString(1),rst.getString(2)));

            customEntity.setBatchName(rst.getString(3));
            customEntity.setCourseName(rst.getString(4));
            customEntity.setSubjectId(rst.getString(5));
            customEntity.setSubjectName(rst.getString(6));
            customEntity.setExamName(rst.getString(7));
            customEntity.setStudentList(students);
        }

        System.out.println(customEntity);

        return customEntity;

    }

    @Override
    public List<CustomEntity2> getAllRegisterStudent(String status) throws Exception {
        ResultSet resultSet = null;
        List<CustomEntity2> customEntity2s = new ArrayList<>();


        if(status==""){
            resultSet = CrudUtil.execute("SELECT s.Sid,s.FirstName,s.Tel,b.Name,c.Name from student s INNER JOIN registation r on s.Sid = r.studentId \n" +
                    "INNER JOIN batch b on r.batchId = b.Bid INNER JOIN course c on b.courseId = c.Cid");
        }else if(status.equals("COMPLETE")){
            resultSet = CrudUtil.execute("SELECT s.Sid,s.FirstName,s.Tel,b.Name,c.Name from student s INNER JOIN registation r on s.Sid = r.studentId\n" +
                    "INNER JOIN batch b on r.batchId = b.Bid INNER JOIN course c on b.courseId = c.Cid where r.Stastus=?",status);
        }else {
            resultSet = CrudUtil.execute("SELECT s.Sid,s.FirstName,s.Tel,b.Name,c.Name from student s INNER JOIN registation r on s.Sid = r.studentId\n" +
                    "INNER JOIN batch b on r.batchId = b.Bid INNER JOIN course c on b.courseId = c.Cid where r.Stastus=?",status);
        }

        while (resultSet.next()){
            customEntity2s.add(new CustomEntity2(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5)));
        }

        return customEntity2s;
    }

    @Override
    public List<Course> getCourseDetails(String key) throws Exception {

        ResultSet rst = CrudUtil.execute("SELECT c.Cid,c.Name,c.CourseFee,c.Description from batch b inner JOIN course c on b.courseId = c.Cid where b.Bid=?",key);
        List<Course> courses = new ArrayList<>();
        while (rst.next()) {
            courses.add(new Course(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getString(4)));
        }
        return courses;

    }

    @Override
    public List<Subject> getSubjectDetails(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT s.Subid,s.courseId,s.Name,s.Type from course c INNER JOIN subject s on c.Cid = s.courseId where c.Cid=?",key);
        List<Subject> subjects = new ArrayList<>();
        while (rst.next()) {
            subjects.add(new Subject(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)));
        }
        return subjects;
    }


}
