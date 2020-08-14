package lk.ijse.studentmanagementsystem.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.studentmanagementsystem.business.BOFactroy;
import lk.ijse.studentmanagementsystem.business.BOType;
import lk.ijse.studentmanagementsystem.business.custom.CourseBO;
import lk.ijse.studentmanagementsystem.business.custom.SubjectBO;
import lk.ijse.studentmanagementsystem.entity.Course;
import lk.ijse.studentmanagementsystem.util.CourseTM;
import lk.ijse.studentmanagementsystem.util.SubjectTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class SubjectController {

    public AnchorPane root;
    public TextField txtSubjectId;
    public TextField txtSubjectName;
    public TextField txtType;
    public ComboBox<String> cmbCourseId;
    public TextField txtCourseName;
    public TextField txtCourseDescription;
    public Button btnSave;
    public Button btnRemove;
    public TableView<SubjectTM> tblSubject;
    private boolean readOnly;

    SubjectBO subjectBO = BOFactroy.getInstance().getBO(BOType.SUBJECT);
    CourseBO courseBO = BOFactroy.getInstance().getBO(BOType.COURSE);

    public void initialize() {
        tblSubject.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("subId"));
        tblSubject.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblSubject.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Type"));
        tblSubject.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("courseId"));


        txtSubjectId.setDisable(false);
        txtSubjectName.setDisable(false);
        txtType.setDisable(false);
        txtCourseName.setDisable(false);
        txtCourseDescription.setDisable(false);

        loadAllSubjects();
        loadAllCourse();
//        cmbCourseId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CourseTM>() {
//            @Override
//            public void changed(ObservableValue<? extends CourseTM> observable, CourseTM oldValue, CourseTM newValue) {
//                if (newValue == null) {
//                    txtCourseName.clear();
//                    txtCourseDescription.clear();
//                    return;
//                }
//                txtCourseName.setText(newValue.getName());
//                txtCourseDescription.setText(newValue.getDescription());
//            }
//        });
        tblSubject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SubjectTM>() {

            @Override
            public void changed(ObservableValue<? extends SubjectTM> observable, SubjectTM oldValue, SubjectTM selectedSubject) {

                if (selectedSubject == null) {
                    return;
                }
                String selectedCourseId = selectedSubject.getCourseId();
               ObservableList<String> courseTMS = cmbCourseId.getItems();
                for (String courseTM: courseTMS) {
                    if(courseTM.equals(selectedCourseId)){
                       cmbCourseId.getSelectionModel().select(courseTM);
                        Course course =loadCourse(courseTM);
                        txtCourseName.setText(course.getName());
                        txtCourseDescription.setText(course.getDescription());
                        txtSubjectId.setText(selectedSubject.getSubId());
                        txtSubjectName.setText(selectedSubject.getName());
                        txtType.setText(selectedSubject.getType());

                        if (!readOnly) {
                            btnSave.setText("Update");
                        }
                        if (readOnly) {
                            btnSave.setDisable(true);
                        }

                        break;
                    }


               }
            }
        });
    }

    private Course loadCourse(String courseTM) {
        try {
           Course course = courseBO.findSubject(courseTM);
            return course;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    private void loadAllSubjects() {
        try {

            tblSubject.getItems().clear();
            List<SubjectTM> subjectTMS = null;
            try {
                subjectTMS =  subjectBO.getAllSubject();
                System.out.println(subjectTMS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ObservableList<SubjectTM> subjects = FXCollections.observableArrayList(subjectTMS);
            System.out.println(subjects);
            tblSubject.setItems(subjects);

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
            txtSubjectId.clear();
            btnSave.setText("Save");
            txtSubjectName.clear();
            txtType.clear();
            txtCourseName.clear();
            cmbCourseId.getSelectionModel().clearSelection();
            txtCourseDescription.clear();
            txtSubjectId.setText(subjectBO.getNewSubjectId());
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


        if(txtSubjectName.getText().trim().isEmpty() || txtType.getText().trim().isEmpty() || txtCourseName.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Subject Name, Subject Type or Course Name can't be empty").show();
            return;
        }
        if(btnSave.getText().equals("Save")){
            try {
                subjectBO.saveSubject(txtSubjectId.getText(),
                        cmbCourseId.getSelectionModel().getSelectedItem(),
                        txtSubjectName.getText(),
                        txtType.getText());

               // System.out.println( cmbCourseId.getValue().getCid());
                txtSubjectName.clear();
                txtSubjectId.clear();
                txtType.clear();
                txtCourseName.clear();
                cmbCourseId.getSelectionModel().clearSelection();
                txtCourseDescription.clear();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully Added Subject!");
                alert.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            btnAddNew_OnAction(actionEvent);
        }else{
            SubjectTM subjectTM = tblSubject.getSelectionModel().getSelectedItem();
            boolean result = false;

            try {
                System.out.println("upadte");
                result = subjectBO.updateSubject(cmbCourseId.getSelectionModel().getSelectedItem(),txtSubjectName.getText(),txtType.getText(),subjectTM.getSubId());

               // System.out.println(cmbCourseId);

               // System.out.println(cmbCourseId.getValue().getCid()+""+txtSubjectName.getText()+""+txtType.getText()+""+txtSubjectId.getText());

                txtSubjectName.clear();
                txtSubjectId.clear();
                txtType.clear();
                txtCourseName.clear();
                cmbCourseId.getSelectionModel().clearSelection();
                txtCourseDescription.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully Update Subject!");
            alert.show();
            } catch (Exception e) {
                e.printStackTrace();
            }


            if (!result) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the Subject").show();
            }
            tblSubject.refresh();
            btnAddNew_OnAction(actionEvent);
        }
        loadAllSubjects();
        }


    public void btnDelete_OnAction(ActionEvent actionEvent) {
        if(txtSubjectId.getText().trim().length() == 0 || txtCourseName.getText().trim().length()==0) {
            new Alert(Alert.AlertType.ERROR, "If You want Delete you scud select table row").show();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure whether you want to delete this Subject?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            SubjectTM subjectTM = tblSubject.getSelectionModel().getSelectedItem();

            boolean result = false;
            try {
                result = subjectBO.deleteSubject(subjectTM.getSubId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Alert aler = new Alert(Alert.AlertType.INFORMATION, "Successfully Delete Subject!");
            aler.show();
            if (!result) {
                new Alert(Alert.AlertType.ERROR, "Failed to delete the Subject", ButtonType.OK).show();
            } else {
                tblSubject.getItems().remove(subjectTM);
                tblSubject.getSelectionModel().clearSelection();
            }
        }

    }

    public void SelectionChange_OnAction(ActionEvent actionEvent) {

        String courseId = cmbCourseId.getSelectionModel().getSelectedItem();
        try {

            if(courseId != null){
                Course course = courseBO.findSubject(courseId);
                txtCourseName.setText(course.getName());
                txtCourseDescription.setText(course.getDescription());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

