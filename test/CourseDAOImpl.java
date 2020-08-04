import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.CourseDAO;
import lk.ijse.studentmanagementsystem.entity.Course;

import java.math.BigDecimal;

public class CourseDAOImpl {

    public static void main (String [] args) throws Exception {

     CourseDAO courseDAO = DAOFactroy.getInstance().getDAO(DAOType.COURSE);
        BigDecimal bigDecimal = new BigDecimal("1200000");
        boolean save = courseDAO.save(new Course("C001", "GDSE",  bigDecimal,"Deploma"));
        System.out.println(save);

    }

}
