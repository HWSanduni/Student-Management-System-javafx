package lk.ijse.studentmanagementsystem.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.studentmanagementsystem.business.BOFactroy;
import lk.ijse.studentmanagementsystem.business.BOType;
import lk.ijse.studentmanagementsystem.business.custom.CourseBO;
import lk.ijse.studentmanagementsystem.util.CourseTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class CourseController {

    CourseBO courseBO = BOFactroy.getInstance().getBO(BOType.COURSE);

    public TextField txtCourseId;
    public TextField txtCourseName;
    public TextField txtType;
    public TextField txtCourseFee;
    public TextField txtDescription;
    public Button btnAddNewCourse;
    public Button btnSave;
    public Button btnRemove;
    public TableView<CourseTM> tblCourse;
    public AnchorPane root;



    public void initialize() {
        tblCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Cid"));
        tblCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("CourseFee"));
        tblCourse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Description"));


        txtCourseId.setDisable(false);
        txtCourseFee.setDisable(false);
        txtDescription.setDisable(false);
        txtCourseName.setDisable(false);

        loadAllCourses();

        tblCourse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CourseTM>() {

            @Override
            public void changed(ObservableValue<? extends CourseTM> observable, CourseTM oldValue, CourseTM newValue) {
                CourseTM selectedCourse = tblCourse.getSelectionModel().getSelectedItem();
                if(selectedCourse == null){
                    btnSave.setText("Save");
                    btnRemove.setDisable(true);
                    txtCourseId.clear();
                    txtCourseFee.clear();
                    txtDescription.clear();
                    txtCourseName.clear();
                    return;
                }
                btnSave.setText("Update");
               btnSave.setDisable(false);
               btnRemove.setDisable(false);
                txtCourseFee.setDisable(false);
                txtDescription.setDisable(false);
                txtCourseName.setDisable(false);
                txtCourseId.setText(selectedCourse.getCid());
                txtCourseFee.setText(selectedCourse.getCourseFee()+"");
                txtDescription.setText(selectedCourse.getDescription());
                txtCourseName.setText(selectedCourse.getName());
            }
        });

    }

    public void HomeOnActionCliced(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/DashbordForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(this.root.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }


    private void loadAllCourses(){
        try {

            tblCourse.getItems().clear();
            List<CourseTM> courseTMS = null;
            try {
                courseTMS =  courseBO.getAllCourse();
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

    public void btnAddNew_OnAction(ActionEvent actionEvent) {

        try {
            txtCourseId.clear();
           txtCourseId.setText(courseBO.getNewCourseId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {

        if (txtCourseName.getText().trim().isEmpty() || txtCourseName.getText().trim().isEmpty() || txtCourseFee.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Name, Description or Course Fee can't be empty").show();
            return;
        }

        double fee = Double.parseDouble(txtCourseFee.getText().trim());

        if (fee < 0) {
            new Alert(Alert.AlertType.ERROR, "Invalid Course Fee").show();
            return;
        }


        if (btnSave.getText().equals("Save")) {
            try {
                courseBO.saveCourse(txtCourseId.getText(),
                        txtCourseName.getText(),
                        fee,
                        txtDescription.getText());

                txtCourseId.clear();
                txtCourseFee.clear();
                txtDescription.clear();
                txtCourseName.clear();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully Added Course!");
                alert.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

            btnAddNew_OnAction(actionEvent);
        } else {
            CourseTM selectedCourse = tblCourse.getSelectionModel().getSelectedItem();
            boolean result = false;

            try {
                result = courseBO.updateCourse(txtCourseName.getText(), fee, txtDescription.getText(), selectedCourse.getCid());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully Update Course!");
            alert.show();
            if (!result) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the Course").show();
            }
            tblCourse.refresh();
            btnAddNew_OnAction(actionEvent);
        }
        loadAllCourses();
    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure whether you want to delete this course?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            CourseTM selectedCourse = tblCourse.getSelectionModel().getSelectedItem();

            boolean result = false;
            try {
                result = courseBO.deleteCourse(selectedCourse.getCid());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Alert aler = new Alert(Alert.AlertType.INFORMATION, "Successfully Delete Course!");
            aler.show();
            if (!result) {
                new Alert(Alert.AlertType.ERROR, "Failed to delete the course", ButtonType.OK).show();
            } else {
                tblCourse.getItems().remove(selectedCourse);
                tblCourse.getSelectionModel().clearSelection();
            }
        }
    }
}
