package lk.ijse.studentmanagementsystem.business.custom.impl;

import lk.ijse.studentmanagementsystem.business.custom.BatchBO;
import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.BatchDAO;
import lk.ijse.studentmanagementsystem.dao.custom.QureyDAO;
import lk.ijse.studentmanagementsystem.entity.Batch;
import lk.ijse.studentmanagementsystem.entity.CustomEntity4;
import lk.ijse.studentmanagementsystem.util.BatchCourseTM;
import lk.ijse.studentmanagementsystem.util.BatchTM;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BatchBOImpl implements BatchBO {

    BatchDAO batchDAO = DAOFactroy.getInstance().getDAO(DAOType.BATCH);
    QureyDAO qureyDAO = DAOFactroy.getInstance().getDAO(DAOType.QUREY);


    @Override
    public List<BatchTM> getAllBatch() throws Exception {

        List<Batch> batches = batchDAO.findAll();
        List<BatchTM> batchTMS = new ArrayList<>();

        for (Batch batch: batches) {
            batchTMS.add(new BatchTM(batch.getBid(),batch.getCourseId(),batch.getName(),batch.getType(),batch.getYear(),batch.getStartDate(),batch.getEndDate()));
        }


        return batchTMS;
    }

    @Override
    public Batch findBatch(String id) throws Exception {

        Batch batch = batchDAO.find(id);

        return batch;
    }

    @Override
    public boolean saveBatch(String id, String courseId, String name, String type, int year, Date startDate, Date endDate) throws Exception {

        return  batchDAO.save(new Batch(id,courseId,name,type,year,startDate,endDate));
    }

    @Override
    public boolean deleteBatch(String batchId) throws Exception {
        return batchDAO.delete(batchId);
    }

    @Override
    public boolean updateBatch(String courseId, String name, String type, int year, Date startDate, Date endDate, String id) throws Exception {
        return batchDAO.update(new Batch(id,courseId,name,type,year,startDate,endDate));
    }

    @Override
    public String getNewBatchId() throws Exception {
        String lastBatchId = null;

        lastBatchId = batchDAO.getLastBatchId();

        if(lastBatchId == null){
            return "B001";
        }else{
            int maxId = Integer.parseInt(lastBatchId.replace("B", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "B00" + maxId;
            } else if (maxId < 100) {
                id = "B0" + maxId;
            } else {
                id = "B" + maxId;
            }
            return id;
        }
    }

    @Override
    public List<BatchTM> getBatcDetails(String key) throws Exception{


        List<Batch> batches = qureyDAO.getBatcDetails(key);
        List<BatchTM> batchTMS = new ArrayList<>();

        for (Batch batch: batches) {
            batchTMS.add(new BatchTM(batch.getBid(),batch.getCourseId(),batch.getName(),batch.getType(),batch.getYear(),batch.getStartDate(),batch.getEndDate()));
        }


        return batchTMS;

    }

    @Override
    public int getBatchCount() throws Exception {
        int count = batchDAO.getBatchCount();

        return count;
    }

    @Override
    public BatchCourseTM getBatchCourseDeatils(String id) throws Exception {

        CustomEntity4 customEntity = qureyDAO.getBatchCourseDeatils(id);

        BatchCourseTM batchCourseTM = new BatchCourseTM();
        batchCourseTM.setBid(customEntity.getBid());
        batchCourseTM.setName(customEntity.getName());
        batchCourseTM.setCoursName(customEntity.getCoursName());
        batchCourseTM.setCourseFee(customEntity.getCourseFee());

        return batchCourseTM;
    }
}
