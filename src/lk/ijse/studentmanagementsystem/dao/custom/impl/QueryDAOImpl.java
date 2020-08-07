package lk.ijse.studentmanagementsystem.dao.custom.impl;

import lk.ijse.studentmanagementsystem.dao.CrudUtil;
import lk.ijse.studentmanagementsystem.dao.custom.QureyDAO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity;

import java.sql.ResultSet;

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


}
