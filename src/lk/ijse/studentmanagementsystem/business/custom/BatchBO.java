package lk.ijse.studentmanagementsystem.business.custom;

import lk.ijse.studentmanagementsystem.business.SuperBO;
import lk.ijse.studentmanagementsystem.entity.Batch;
import lk.ijse.studentmanagementsystem.entity.CustomEntity4;
import lk.ijse.studentmanagementsystem.util.BatchCourseTM;
import lk.ijse.studentmanagementsystem.util.BatchTM;

import java.sql.Date;
import java.util.List;

public interface BatchBO extends SuperBO {

    public List<BatchTM> getAllBatch() throws Exception;
    public Batch findBatch (String id) throws Exception;
    public  boolean saveBatch(String id, String courseId , String name, String type, int year, Date startDate,Date endDate)throws Exception;
    public  boolean deleteBatch(String batchId)throws Exception;
    public  boolean updateBatch(String courseId , String name, String type, int year, Date startDate,Date endDate,String id)throws Exception;
    public  String getNewBatchId()throws Exception;

    List<BatchTM> getBatcDetails(String key) throws Exception;

    int getBatchCount ()throws Exception;

    BatchCourseTM getBatchCourseDeatils(String id)throws Exception;

}
