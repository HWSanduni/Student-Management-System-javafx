package lk.ijse.studentmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.studentmanagementsystem.util.StudentPaymentTM;

import java.io.IOException;

public class ExamDetailsController {

    public AnchorPane root;
    public TextField txtExamId;
    public TextField txtExamId1;
    public TextField txtExamId2;
    public Button btnSearchPass;
    public Button btnSearchFail;
    public Button btnSearchAttendance;
    public TableView<StudentPaymentTM> tblStudent;


    public void initialize() {
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Sid"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("tel"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("batchName"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("courseName"));

    }

    public void AddExamREsultOnActionCliced(ActionEvent actionEvent) {
    }

    public void btnSearchPass_OnAction(ActionEvent actionEvent) {
    }

    public void btnSearchFail_OnAction(ActionEvent actionEvent) {
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
