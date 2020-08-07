package lk.ijse.studentmanagementsystem.dao;

import lk.ijse.studentmanagementsystem.dao.custom.impl.*;

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
            case BATCH:
                return (T) new BatchDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case EXAM:
                return (T) new ExamDAOImpl();
            case REGISTATION:
                return (T) new RegistationDAOImpl();
            case EXAMDETAILS:
                return (T) new ExamDetailsDAOImpl();
            case EXAMRESULT:
                return (T) new ExamResultDAOImpl();
             default:
                 return null;
        }
    }


}
