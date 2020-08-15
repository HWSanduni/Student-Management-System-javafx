package lk.ijse.studentmanagementsystem.dao.custom.impl;

import lk.ijse.studentmanagementsystem.dao.CrudUtil;
import lk.ijse.studentmanagementsystem.dao.custom.StudentDAO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity;
import lk.ijse.studentmanagementsystem.entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM student");
        List<Student> students = new ArrayList<>();
        while (rst.next()) {
            students.add(new Student(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5),
                    rst.getString(6),
                    rst.getDate(7),
                    rst.getInt(8),
                    rst.getString(9),
                    rst.getString(10)));
        }
        return students;

    }

    @Override
    public Student find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM student WHERE Sid=?",key);
        if (rst.next()) {

//            private String Sid;
//            private String firstName;
//            private String lastName;
//            private String address;
//            private int tel;
//            private String nic;
//            private Date birthDay;
//            private int age;
//            private String mail;
//            private String gender;

            System.out.println("DAO");
            System.out.println(rst.getString(8));
            System.out.println(rst.getString(9));
            return new Student(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5),
                    rst.getString(6),
                    rst.getDate(7),
                    rst.getInt(10),
                    rst.getString(8),
                    rst.getString(9));
        }




        return null;
    }

    @Override
    public boolean save(Student student) throws Exception {
        return CrudUtil.execute("INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?,?)",student.getSid(),student.getFirstName(),student.getLastName(),student.getAddress(),student.getTel(),student.getNic(),student.getBirthDay(),student.getMail(),student.getGender(),student.getAge());
    }

    @Override
    public boolean update(Student student) throws Exception {
        return CrudUtil.execute("UPDATE student SET FirstName=?,LastName=?, Address=? Tel=?,Nic=?,BirthDay=?,Mail=?,Gender=?Age=? WHERE Sid=?",student.getFirstName(),student.getLastName(),student.getAddress(),student.getTel(),student.getNic(),student.getBirthDay(),student.getMail(),student.getGender(),student.getAge(),student.getSid());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM student WHERE id=?",key);
    }

    @Override
    public String getLastStudntId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM student ORDER BY Sid DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }

    @Override
    public int getStudentCount() throws Exception {

        int count=0;
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) from student");

        if (rst.next()) {
            count=rst.getInt(1);
        }
        return count;
    }

    @Override
    public CustomEntity get(String key) throws Exception {

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
}
