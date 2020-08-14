package lk.ijse.studentmanagementsystem.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.studentmanagementsystem.business.BOFactroy;
import lk.ijse.studentmanagementsystem.business.BOType;
import lk.ijse.studentmanagementsystem.business.custom.CourseBO;
import lk.ijse.studentmanagementsystem.business.custom.ExamBO;
import lk.ijse.studentmanagementsystem.business.custom.SubjectBO;
import lk.ijse.studentmanagementsystem.entity.Course;
import lk.ijse.studentmanagementsystem.entity.Subject;
import lk.ijse.studentmanagementsystem.util.CourseTM;
import lk.ijse.studentmanagementsystem.util.SubjectTM;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ExamController {

    public AnchorPane root;
    public TextField txtExamId;
    public TextField txtExamName;
    public TextField txtTime;
    public TextField txtSubjectName;
    public TextField txtCourseName;
    public TextField txtPassMarks;
    public DatePicker picExamDate;
    public ComboBox<String> cmbCourseId;
    public ComboBox<String> cmbSubjectID;
    public Button btnAddNewStudent;
    public Button btnSave;
    public Button btnCancel;



    CourseBO courseBO = BOFactroy.getInstance().getBO(BOType.COURSE);
    SubjectBO subjectBO = BOFactroy.getInstance().getBO(BOType.SUBJECT);
    ExamBO examBO = BOFactroy.getInstance().getBO(BOType.EXAM);

    public void initialize() {
        loadAllCourse();
//        cmbCourseId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CourseTM>() {
//            @Override
//            public void changed(ObservableValue<? extends CourseTM> observable, CourseTM oldValue, CourseTM selectCourse) {
//                if (selectCourse == null) {
//                    txtCourseName.clear();
//                    return;
//                }
//                txtCourseName.setText(selectCourse.getName());
//                laodAllSubject(selectCourse.getCid());
//
//            }
//        });

//        cmbSubjectID.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SubjectTM>() {
//
//            @Override
//            public void changed(ObservableValue<? extends SubjectTM> observable, SubjectTM oldValue, SubjectTM selectSubject) {
//                if (selectSubject == null) {
//                    txtSubjectName.clear();
//                    return;
//                }
//                txtSubjectName.setText(selectSubject.getName());
//            }
//        });

    }

    private void laodAllSubject(String cid) {

        cmbSubjectID.getItems().clear();
        try {
            List<SubjectTM> subjectTMS = subjectBO.getFindAllSubject(cid);
            System.out.println("///////////");
            System.out.println(subjectTMS.toString());
            if(subjectTMS != null){
                ObservableList observableList = FXCollections.observableArrayList();
                for (SubjectTM subjectTM: subjectTMS){
                    observableList.add(subjectTM.getSubId());
                    cmbSubjectID.setItems(observableList);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadAllCourse() {

        cmbCourseId.getItems().clear();
        try {
            List<CourseTM> courseTMS = courseBO.getAllCourse();
            if(courseTMS != null){
                ObservableList observableList = FXCollections.observableArrayList();
                for (CourseTM courseTM: courseTMS){
                    observableList.add(courseTM.getCid());
                    cmbCourseId.setItems(observableList);
                }
            }

            //  cmbCourseId.setItems(FXCollections.observableArrayList(courseBO.getAllCourse()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void HomeOnActionCliced(MouseEvent mouseEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/DashbordForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(this.root.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }

    public void btnAddNew_OnAction(ActionEvent actionEvent) {

        try {
            txtExamId.clear();
            txtExamName.clear();
            txtTime.clear();
            txtCourseName.clear();
            txtPassMarks.clear();;
            txtSubjectName.clear();
            cmbCourseId.getSelectionModel().clearSelection();
            cmbSubjectID.getSelectionModel().clearSelection();
            txtExamId.setText(examBO.getNewExamId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {

        if (cmbCourseId.getSelectionModel().getSelectedIndex() == -1) {
            new Alert(Alert.AlertType.ERROR, "You need to select a Course", ButtonType.OK).show();
            cmbCourseId.requestFocus();
            return;
        }


        if(txtExamId.getText().trim().isEmpty() || txtExamName.getText().trim().isEmpty() || txtTime.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Can't be empty File's").show();
            return;
        }

        LocalDate localStartDate = picExamDate.getValue();
        Date examDate = Date.valueOf(localStartDate);

        int passmarks = Integer.parseInt(txtPassMarks.getText().trim());

        if (btnSave.getText().equals("Save")) {
            try {
                examBO.save(txtExamId.getText(),
                        cmbCourseId.getSelectionModel().getSelectedItem(),
                        txtExamName.getText(),
                        examDate,
                        txtTime.getText(),
                        cmbSubjectID.getSelectionModel().getSelectedItem(),passmarks,"ACTIVE");


                txtExamId.clear();
                txtExamName.clear();
                txtTime.clear();
                txtCourseName.clear();
                txtPassMarks.clear();;
                txtSubjectName.clear();
                cmbCourseId.getSelectionModel().clearSelection();
                cmbSubjectID.getSelectionModel().clearSelection();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully Added Exam!");
                alert.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void SelectionChange_OnAction(ActionEvent actionEvent) {

        String courseId = cmbCourseId.getSelectionModel().getSelectedItem();
        try {

            if(courseId != null){
                Course course = courseBO.findSubject(courseId);
                txtCourseName.setText(course.getName());
                laodAllSubject(courseId);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void SelectionChangeSubject_OnAction(ActionEvent actionEvent) {

       String id = cmbSubjectID.getSelectionModel().getSelectedItem();

       if(id != null){
           Subject subject = null;
           try {
               subject = subjectBO.findSubject(id);
           } catch (Exception e) {
               e.printStackTrace();
           }
           txtSubjectName.setText(subject.getName());

       }
    }
}
