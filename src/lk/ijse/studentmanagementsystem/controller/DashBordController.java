package lk.ijse.studentmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.studentmanagementsystem.business.BOFactroy;
import lk.ijse.studentmanagementsystem.business.BOType;
import lk.ijse.studentmanagementsystem.business.custom.BatchBO;
import lk.ijse.studentmanagementsystem.business.custom.CourseBO;
import lk.ijse.studentmanagementsystem.business.custom.StudentBO;
import lk.ijse.studentmanagementsystem.business.custom.SubjectBO;

import java.io.IOException;

public class DashBordController {

    public AnchorPane rootpane;
    public Label lblStudent;
    public Label lblBatch;
    public Label lblCourses;
    public Label lblSubject;


    CourseBO courseBO = BOFactroy.getInstance().getBO(BOType.COURSE);
    SubjectBO subjectBO = BOFactroy.getInstance().getBO(BOType.SUBJECT);
    BatchBO batchBO = BOFactroy.getInstance().getBO(BOType.BATCH);
    StudentBO studentBO = BOFactroy.getInstance().getBO(BOType.STUDENT);


    public void initialize() {
        getCountStudent();
        getCountBatch();
        getCountCourse();
        getCountSubject();

    }

    private void getCountStudent() {

        try {
            int count =studentBO.getStudentCount();
            lblStudent.setText(String.valueOf(count));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getCountBatch() {
        int count = 0;
        try {
            count = batchBO.getBatchCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        lblBatch.setText(String.valueOf(count));
    }

    private void getCountCourse() {

        int count = 0;
        try {
            count = courseBO.getCourseCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        lblCourses.setText(String.valueOf(count));

    }

    private void getCountSubject() {

        int count = 0;
        try {
            count = subjectBO.getSubjectCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        lblSubject.setText(String.valueOf(count));
    }



    public void StudentOnMouseClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/StudentForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(rootpane.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();

    }

    public void RegistraionOnMouseClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/RegistrationFrom.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(rootpane.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }

    public void BatchOnMouseClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/BatchForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(rootpane.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }

    public void CourseOnMouseClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/CourseForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(rootpane.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }

    public void SubjectOnMouseClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/SubjectForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(rootpane.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }

    public void ExamOnMouseClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/ExamForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(rootpane.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }
}
