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
import lk.ijse.studentmanagementsystem.business.custom.ExamResultBO;
import lk.ijse.studentmanagementsystem.util.ExamResultDetailsTM;
import lk.ijse.studentmanagementsystem.util.StudentPaymentTM;

import java.io.IOException;
import java.util.List;

public class ExamDetailsController {

    public AnchorPane root;
    public TextField txtExamId;
    public TextField txtExamId1;
    public TextField txtExamId2;
    public Button btnSearchPass;
    public Button btnSearchFail;
    public Button btnSearchAttendance;
    public TableView<ExamResultDetailsTM> tblStudent;

    ExamResultBO examResultBO = BOFactroy.getInstance().getBO(BOType.EXAMRESULT);

    public void initialize() {
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("marsk"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("tel"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("batchName"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("courseName"));

    }

    public void AddExamREsultOnActionCliced(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/ExamResultForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage) (this.root.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();

    }

    public void btnSearchPass_OnAction(ActionEvent actionEvent) {

        if (txtExamId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Exam Id can't be empty").show();
            return;
        } else {
            try {

                tblStudent.getItems().clear();
                List<ExamResultDetailsTM> examResultDetailsTMList = null;
                try {
                    examResultDetailsTMList = examResultBO.getExamResult("pass",txtExamId.getText());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("//////////");
                System.out.println(examResultDetailsTMList.toString());
                ObservableList<ExamResultDetailsTM> resulList = FXCollections.observableArrayList(examResultDetailsTMList);

                tblStudent.setItems(resulList);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void btnSearchFail_OnAction(ActionEvent actionEvent) {
        if (txtExamId1.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Exam Id can't be empty").show();
            return;
        } else {
            try {

                tblStudent.getItems().clear();
                List<ExamResultDetailsTM> examResultDetailsTMList = null;
                try {
                    examResultDetailsTMList = examResultBO.getExamResult("fail",txtExamId1.getText());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("//////////");
                System.out.println(examResultDetailsTMList.toString());
                ObservableList<ExamResultDetailsTM> resulList = FXCollections.observableArrayList(examResultDetailsTMList);

                tblStudent.setItems(resulList);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void btnSearchAttendance_OnAction(ActionEvent actionEvent) {
    }

    public void BackOnActionCliced(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/StudentForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage) (this.root.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }


}
