package lk.ijse.studentmanagementsystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.studentmanagementsystem.business.BOFactroy;
import lk.ijse.studentmanagementsystem.business.BOType;
import lk.ijse.studentmanagementsystem.business.custom.BatchBO;
import lk.ijse.studentmanagementsystem.business.custom.CourseBO;
import lk.ijse.studentmanagementsystem.business.custom.StudentBO;
import lk.ijse.studentmanagementsystem.business.custom.SubjectBO;
import lk.ijse.studentmanagementsystem.util.BatchTM;
import lk.ijse.studentmanagementsystem.util.CourseTM;
import lk.ijse.studentmanagementsystem.util.StudentDetailsTM;
import lk.ijse.studentmanagementsystem.util.SubjectTM;


import java.io.IOException;
import java.util.List;

public class BatchAndCourseDetailsController {

    public AnchorPane root;
    public TextField txtBatchId;
    public Button btnSearchCourse;
    public TextField txtCourseId;
    public Button btnSearchSubject;
    public TextField txtCourseId1;
    public Button btnSearchBatch;
    public TextField txtBatchId1;
    public Button btnSearchStudent;
    public TableView<CourseTM> tblCourse;
    public TableView<SubjectTM> tblSubject;
    public TableView<BatchTM> tblBatch;
    public TableView<StudentDetailsTM> tblStudent;


    CourseBO courseBO = BOFactroy.getInstance().getBO(BOType.COURSE);
    SubjectBO subjectBO = BOFactroy.getInstance().getBO(BOType.SUBJECT);
    BatchBO batchBO = BOFactroy.getInstance().getBO(BOType.BATCH);
    StudentBO studentBO = BOFactroy.getInstance().getBO(BOType.STUDENT);


    public void initialize() {
        tblCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Cid"));
        tblCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("CourseFee"));
        tblCourse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Description"));


        tblSubject.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("subId"));
        tblSubject.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblSubject.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Type"));
        tblSubject.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("courseId"));

        tblBatch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Bid"));
        tblBatch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblBatch.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblBatch.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("year"));
        tblBatch.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("startDate"));
        tblBatch.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("endDate"));
        tblBatch.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("courseId"));

        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Sid"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("tel"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("courseName"));


    }

    public void BackOnActionCliced(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/StudentForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage) (this.root.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }

    public void btnSearchCourse_OnAction(ActionEvent actionEvent) {
        if (txtBatchId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Batch Id can't be empty").show();
            return;
        } else {
            try {

                tblCourse.getItems().clear();
                List<CourseTM> courseTMS = null;
                try {
                    courseTMS = courseBO.getCourseDetails(txtBatchId.getText());
                    System.out.println(courseTMS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ObservableList<CourseTM> courses = FXCollections.observableArrayList(courseTMS);
                System.out.println(courses);
                tblCourse.setItems(courses);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void btnSearchSubject_OnAction(ActionEvent actionEvent) {

        if (txtCourseId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Course Id can't be empty").show();
            return;
        } else {
            try {

                tblSubject.getItems().clear();
                List<SubjectTM> subjectTMS = null;
                try {
                    subjectTMS = subjectBO.getSubjectDetails(txtCourseId.getText());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                ObservableList<SubjectTM> subjectTMS1 = FXCollections.observableArrayList(subjectTMS);

                tblSubject.setItems(subjectTMS1);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void btnSearchBatch_OnAction(ActionEvent actionEvent) {

        if (txtCourseId1.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Course Id can't be empty").show();
            return;
        } else {
            try {

                tblBatch.getItems().clear();
                List<BatchTM> batchTMS = null;
                try {
                    batchTMS = batchBO.getBatcDetails(txtCourseId1.getText());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                ObservableList<BatchTM> batchTMS1 = FXCollections.observableArrayList(batchTMS);

                tblBatch.setItems(batchTMS1);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void btnSearchStudent_OnAction(ActionEvent actionEvent) {

        if (txtBatchId1.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Batch Id can't be empty").show();
            return;
        } else {
            try {

                tblStudent.getItems().clear();
                List<StudentDetailsTM> studentDetailsTMS = null;
                try {
                    studentDetailsTMS = studentBO.getAllBatchStudent(txtBatchId1.getText());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                ObservableList<StudentDetailsTM> studentDetailsTMS1 = FXCollections.observableArrayList(studentDetailsTMS);

                tblStudent.setItems(studentDetailsTMS1);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
