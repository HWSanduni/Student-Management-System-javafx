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
import lk.ijse.studentmanagementsystem.business.custom.ExamBO;
import lk.ijse.studentmanagementsystem.business.custom.ExamResultBO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity1;
import lk.ijse.studentmanagementsystem.util.ExamResultTM;
import lk.ijse.studentmanagementsystem.util.StudentTM;

import java.io.IOException;
import java.util.List;

public class ExamResultController {

    public AnchorPane root;
    public TextField txtExamId;
    public TextField txtFirstName;
    public TextField txtMask;
    public TextField txtCourseName;
    public TextField txtBatchName;
    public TextField txtExamName;
    public TextField txtSubjectId;
    public TextField txtSubjectName;
    public TextField txtId;
    public ComboBox<StudentTM> cmbStudentId;
    public Button btnSave;
    public Button btnAddNewReult;
    public Button btnAdd;
    public Button btnCancel;
    public TableView<ExamResultTM> tblResult;



    ExamBO examBO = BOFactroy.getInstance().getBO(BOType.EXAM);
    ExamResultBO examResultBO = BOFactroy.getInstance().getBO(BOType.EXAMRESULT);

    public void initialize() {

        tblResult.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("examId"));
        tblResult.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblResult.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("marks"));


        cmbStudentId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StudentTM>() {
            @Override
            public void changed(ObservableValue<? extends StudentTM> observable, StudentTM oldValue, StudentTM newValue) {
                if (newValue == null) {
                    txtFirstName.clear();
                    return;
                }
               txtFirstName.setText(newValue.getFirstName());
            }
        });

    }


    public void btnSearch_OnAction(ActionEvent actionEvent) {

        try {
            CustomEntity1 customEntity = examBO.getExamDetails(txtExamId.getText());
            txtExamName.setText(customEntity.getExamName());
            txtBatchName.setText(customEntity.getBatchName());
            txtCourseName.setText(customEntity.getCourseName());
            txtSubjectId.setText(customEntity.getSubjectId());
            txtSubjectName.setText(customEntity.getSubjectName());

            List<StudentTM> studentList = customEntity.getStudentList();

            cmbStudentId.setItems(FXCollections.observableArrayList(studentList));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void BackOnActionCliced(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/StudentForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(this.root.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }


    public void btnAdd_OnAction(ActionEvent actionEvent) {

        if (cmbStudentId.getSelectionModel().getSelectedIndex() == -1) {
            new Alert(Alert.AlertType.ERROR, "You need to select a Student", ButtonType.OK).show();
            cmbStudentId.requestFocus();
            return;
        }

        ObservableList<ExamResultTM> examResults = tblResult.getItems();


        String examId = txtExamId.getText();
        String studentId = cmbStudentId.getValue().getSid();
        int mask = Integer.parseInt(txtMask.getText());

        if(examResults.isEmpty()){
            examResults.add(new ExamResultTM(txtId.getText(),examId,studentId,mask));
            txtExamName.clear();
            txtExamId.clear();
            txtBatchName.clear();
            txtCourseName.clear();
            txtSubjectId.clear();
            txtSubjectName.clear();
            txtMask.clear();
            txtFirstName.clear();
            cmbStudentId.getSelectionModel().clearSelection();
        }else {
            for (ExamResultTM examResultTM: examResults) {
                if(examResultTM.getStudentId().equals(studentId)){
                    new Alert(Alert.AlertType.ERROR, "All Ready Add This Student").show();
                   return;
                }
            }
        }

        }


    public void btnSave_OnAction(ActionEvent actionEvent) {

        ObservableList<ExamResultTM> examResults = tblResult.getItems();

//        for (ExamResultTM examResultTM: examResults) {
                try {
                examResultBO.saveExamResult(tblResult.getItems());

                new Alert(Alert.AlertType.ERROR, "Successfully Added Student Result").show();
                return;

            } catch (Exception e) {
                e.printStackTrace();
            }
        //}
        examResults.add(new ExamResultTM());


    }

    public void btnAddNew_OnAction(ActionEvent actionEvent) {
        try {
            txtId.clear();
            txtId.setText(examResultBO.getNewExamResultId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

