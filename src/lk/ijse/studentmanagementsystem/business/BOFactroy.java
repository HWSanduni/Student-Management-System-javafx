package lk.ijse.studentmanagementsystem.business;

import lk.ijse.studentmanagementsystem.business.custom.impl.CourseBOImpl;
import lk.ijse.studentmanagementsystem.business.custom.impl.SubjectBOImpl;

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
                default:
                    return null;
        }
    }

}
