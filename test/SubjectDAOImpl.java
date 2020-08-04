import lk.ijse.studentmanagementsystem.dao.DAOFactroy;
import lk.ijse.studentmanagementsystem.dao.DAOType;
import lk.ijse.studentmanagementsystem.dao.custom.SubjectDAO;
import lk.ijse.studentmanagementsystem.entity.Subject;


public class SubjectDAOImpl {

    public static void main (String [] args) throws Exception {

       SubjectDAO subjectDAO = DAOFactroy.getInstance().getDAO(DAOType.SUBJECT);
        boolean save = subjectDAO.save(new Subject("S001", "C001","JDBC","Database"));
        System.out.println(save);

    }
}
