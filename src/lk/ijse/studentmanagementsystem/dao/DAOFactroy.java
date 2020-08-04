package lk.ijse.studentmanagementsystem.dao;

import lk.ijse.studentmanagementsystem.dao.custom.impl.CourseDAOImpl;
import lk.ijse.studentmanagementsystem.dao.custom.impl.SubjectDAOImpl;

public class DAOFactroy {

    private static  DAOFactroy daoFactroy;

    private DAOFactroy() {
    }

    public static DAOFactroy getInstance(){
        return (daoFactroy == null) ? daoFactroy = new DAOFactroy() : daoFactroy;
    }


    public <T extends SuperDAO> T getDAO (DAOType daoType){
        switch (daoType){
            case COURSE:
             return (T) new CourseDAOImpl();
            case SUBJECT:
                return (T) new SubjectDAOImpl();
             default:
                 return null;
        }
    }


}
