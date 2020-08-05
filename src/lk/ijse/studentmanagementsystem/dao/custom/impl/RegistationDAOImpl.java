package lk.ijse.studentmanagementsystem.dao.custom.impl;

import lk.ijse.studentmanagementsystem.dao.CrudUtil;
import lk.ijse.studentmanagementsystem.dao.custom.RegistationDAO;
import lk.ijse.studentmanagementsystem.entity.Registation;
import lk.ijse.studentmanagementsystem.entity.RegistationPK;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistationDAOImpl implements RegistationDAO {

    @Override
    public List<Registation> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM registation");

        List<Registation> registations = new ArrayList<>();
        while (rst.next()) {
            registations.add(new Registation(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getBigDecimal(4),
                    rst.getString(5),
                    rst.getDate(6),
                    rst.getDate(7)));
        }
        return registations;

    }

    @Override
    public Registation find(RegistationPK key) throws Exception {


        RegistationPK registationPK = key;
        ResultSet rst = CrudUtil.execute("SELECT * FROM `registation` WHERE batchId=? AND studentId=?",registationPK.getBatchId(),registationPK.getStudentId());
        if(rst.next()){
            return new Registation(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getBigDecimal(4),
                    rst.getString(5),
                    rst.getDate(6),
                    rst.getDate(7));
        }


        return null;
    }

    @Override
    public boolean save(Registation registation) throws Exception {
        return CrudUtil.execute("INSERT INTO `registation` VALUES (?,?,?,?,?,?,?)",registation.getRegistationPK().getBatchId(),registation.getRegistationPK().getStudentId(),registation.getRegistartionFee(),registation.getCourseFee(),registation.getStatus(),registation.getReg_Date(),registation.getCourseFeeGi_Date());
    }

    @Override
    public boolean update(Registation registation) throws Exception {
        return CrudUtil.execute("UPDATE registation SET RegistationFee=?, CourseFee=? Stastus=? Reg_Date=? CourseFeeGi_Date=? WHERE  batchId=? AND studentId=? ",registation.getRegistartionFee(),registation.getCourseFee(),registation.getStatus(),registation.getReg_Date(),registation.getCourseFeeGi_Date(),registation.getRegistationPK().getBatchId(),registation.getRegistationPK().getStudentId());
    }

    @Override
    public boolean delete(RegistationPK registationPK) throws Exception {
        return CrudUtil.execute("DELETE FROM `registation` WHERE batchId=? AND studentId=?",registationPK.getBatchId(),registationPK.getStudentId());
    }
}
