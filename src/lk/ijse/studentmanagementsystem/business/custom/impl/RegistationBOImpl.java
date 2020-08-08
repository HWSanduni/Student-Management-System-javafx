package lk.ijse.studentmanagementsystem.business.custom.impl;

import lk.ijse.studentmanagementsystem.business.custom.RegistationBO;
import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.RegistationDAO;
import lk.ijse.studentmanagementsystem.dao.custom.StudentDAO;
import lk.ijse.studentmanagementsystem.db.DBConnection;
import lk.ijse.studentmanagementsystem.entity.Registation;
import lk.ijse.studentmanagementsystem.entity.Student;
import lk.ijse.studentmanagementsystem.util.RegistraionTM;
import lk.ijse.studentmanagementsystem.util.StudentTM;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class RegistationBOImpl implements RegistationBO {

    StudentDAO studentDAO = DAOFactroy.getInstance().getDAO(DAOType.STUDENT);
    RegistationDAO registationDAO = DAOFactroy.getInstance().getDAO(DAOType.REGISTATION);


    @Override
    public boolean registation(StudentTM studentTM, RegistraionTM registraionTM) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            boolean result = studentDAO.save(new Student(studentTM.getSid(),
                    studentTM.getFirstName(),
                    studentTM.getLastName(),
                    studentTM.getAddress(),
                    studentTM.getTel(),
                    studentTM.getNic(),
                    studentTM.getBirthDay(),
                    studentTM.getAge(),
                    studentTM.getMail(),
                    studentTM.getGender()
                    ));
            System.out.println(studentTM);
            if (!result) {
                connection.rollback();
                return false;
            }

            BigDecimal courseFee = BigDecimal.valueOf(registraionTM.getCourseFee());
            BigDecimal regFee = BigDecimal.valueOf(registraionTM.getRegistartionFee());
            result = registationDAO.save(new Registation(registraionTM.getBatchId(),
                    registraionTM.getStudentId(),
                    regFee,
                    courseFee,
                    registraionTM.getStatus(),
                    registraionTM.getReg_Date(),
                    registraionTM.getCourseFeeGi_Date()));

            if (!result) {
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;
        } catch (Throwable throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public boolean registationUpdate(RegistraionTM registraionTM) throws Exception {

        System.out.println("---bnb-"+registraionTM);

        BigDecimal courseFee = BigDecimal.valueOf(registraionTM.getCourseFee());
        BigDecimal regFee = BigDecimal.valueOf(registraionTM.getRegistartionFee());
        return registationDAO.update(new Registation(regFee,
                courseFee,
                registraionTM.getStatus(),
                registraionTM.getReg_Date(),
                registraionTM.getCourseFeeGi_Date(),
                registraionTM.getBatchId(),
                registraionTM.getStudentId()));

    }
}
