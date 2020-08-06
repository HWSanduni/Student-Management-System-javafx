package lk.ijse.studentmanagementsystem.business;

import lk.ijse.studentmanagementsystem.business.custom.impl.*;

public class BOFactroy {

    private static BOFactroy boFactroy;


    private BOFactroy() {
    }

    public static BOFactroy getInstance(){
        return (boFactroy == null) ?  boFactroy = new BOFactroy() : boFactroy;
    }


    public <T extends SuperBO> T getBO (BOType boType){
        switch (boType){
            case COURSE:
                return (T) new CourseBOImpl();
            case SUBJECT:
                return (T) new SubjectBOImpl();
            case BATCH:
                return (T) new BatchBOImpl();
            case STUDENT:
                return (T) new StudentBOImpl();
            case EXAM:
                return (T) new ExamBOImpl();
            case EXAMRESULT:
                return (T) new ExamResultBOImpl();
            case REGISTATION:
                return (T) new RegistationBOImpl();
                default:
                    return null;
        }
    }

}
