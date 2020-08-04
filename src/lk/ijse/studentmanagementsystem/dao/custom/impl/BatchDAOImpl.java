package lk.ijse.studentmanagementsystem.dao.custom.impl;

import lk.ijse.studentmanagementsystem.dao.CrudUtil;
import lk.ijse.studentmanagementsystem.dao.custom.BatchDAO;
import lk.ijse.studentmanagementsystem.entity.Batch;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BatchDAOImpl implements BatchDAO {
    @Override
    public List<Batch> findAll() throws Exception {
        ResultSet rest=CrudUtil.execute("SELECT * FROM batch");
        List<Batch> batches = new ArrayList<>();
        while (rest.next()){
            batches.add(new Batch(rest.getString(1),
                    rest.getString(2),
                    rest.getString(3),
                    rest.getString(4),
                    rest.getInt(5),
                    rest.getDate(6),
                    rest.getDate(7)));
        }
        return batches;
    }

    @Override
    public Batch find(String key) throws Exception {
       ResultSet rest = CrudUtil.execute("SELECT * FROM batch WHERE Bid=?", key);
       if(rest.next()){
           return new Batch(rest.getString(1),
                   rest.getString(2),
                   rest.getString(3),
                   rest.getString(4),
                   rest.getInt(5),
                   rest.getDate(6),
                   rest.getDate(7));
       }
        return null;
    }

    @Override
    public boolean save(Batch batch) throws Exception {
        return CrudUtil.execute("INSERT INTO batch VALUES (?,?,?,?,?,?,?)",batch.getBid(),batch.getCourseId(),batch.getName(),batch.getType(),batch.getYear(),batch.getStartDate(),batch.getEndDate());

    }

    @Override
    public boolean update(Batch batch) throws Exception {
        return CrudUtil.execute("UPDATE batch SET courseId=?,Name=?, Type=?,Year=?,StartDate=?,EndDate=? WHERE Bid=?",batch.getCourseId(),batch.getName(),batch.getType(),batch.getYear(),batch.getStartDate(),batch.getEndDate(),batch.getBid());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM batch WHERE Bid=?",key);
    }

    @Override
    public String getLastBatchId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM batch ORDER BY Bid DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }
}
