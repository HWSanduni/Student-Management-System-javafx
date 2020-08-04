import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.BatchDAO;
import lk.ijse.studentmanagementsystem.entity.Batch;

import java.sql.Date;

public class BatchDAOImpl {

    public static void main (String [] args) throws Exception {
        BatchDAO batchDAO = DAOFactroy.getInstance().getDAO(DAOType.BATCH);

        Date sdate = new Date(2020-01-01);
        Date edate = new Date(2020-12-01);

        boolean save = batchDAO.save(new Batch("B001", "C001","41","Diploma",2020,sdate,edate));
        System.out.println(save);
    }
}
