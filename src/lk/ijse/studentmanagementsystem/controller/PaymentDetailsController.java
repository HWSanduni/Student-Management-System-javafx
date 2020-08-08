package lk.ijse.studentmanagementsystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.studentmanagementsystem.business.BOFactroy;
import lk.ijse.studentmanagementsystem.business.BOType;
import lk.ijse.studentmanagementsystem.business.custom.StudentBO;
import lk.ijse.studentmanagementsystem.util.StudentPaymentTM;


import java.io.IOException;
import java.util.List;

public class PaymentDetailsController {

    public AnchorPane root;
    public TextField txtComplete;
    public TextField txtReg;
    public Button btnSearch;
    public Button btnComplete;
    public TableView<StudentPaymentTM> tblStudent;


    StudentBO studentBO = BOFactroy.getInstance().getBO(BOType.STUDENT);

    public void initialize() {

        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("tel"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("batchName"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("courseName"));

        loadAllStudent();
    }

    private void loadAllStudent() {

        try {

            tblStudent.getItems().clear();
            List<StudentPaymentTM> studentList = null;
            try {
                studentList =studentBO.getAllRegisterStudent("");
                System.out.println(studentList);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(studentList.toString());
           ObservableList<StudentPaymentTM> studentPaymentTMS = FXCollections.observableArrayList(studentList);
            tblStudent.setItems(studentPaymentTMS);

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

    public void btnSearchCopmplete_OnAction(ActionEvent actionEvent) {

        try {

            tblStudent.getItems().clear();
            List<StudentPaymentTM> studentList = null;
            try {
                studentList =studentBO.getAllRegisterStudent("COMPLETE");
                System.out.println(studentList);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(studentList.toString());
            ObservableList<StudentPaymentTM> studentPaymentTMS = FXCollections.observableArrayList(studentList);
            tblStudent.setItems(studentPaymentTMS);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void btnSearchCopmpleteNot_OnAction(ActionEvent actionEvent) {
        try {

            tblStudent.getItems().clear();
            List<StudentPaymentTM> studentList = null;
            try {
                studentList =studentBO.getAllRegisterStudent("REGESTER");
                System.out.println(studentList);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(studentList.toString());
            ObservableList<StudentPaymentTM> studentPaymentTMS = FXCollections.observableArrayList(studentList);
            tblStudent.setItems(studentPaymentTMS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
