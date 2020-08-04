package lk.ijse.studentmanagementsystem.dao.custom;

import lk.ijse.studentmanagementsystem.dao.CrudDAO;
import lk.ijse.studentmanagementsystem.entity.Batch;

public interface BatchDAO extends CrudDAO<Batch,String> {
    String getLastBatchId()throws Exception;
}
