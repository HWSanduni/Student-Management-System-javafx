package lk.ijse.studentmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import lk.ijse.studentmanagementsystem.business.BOFactroy;
import lk.ijse.studentmanagementsystem.business.BOType;
import lk.ijse.studentmanagementsystem.business.custom.RegistationBO;
import lk.ijse.studentmanagementsystem.business.custom.StudentBO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity;
import lk.ijse.studentmanagementsystem.util.RegistraionTM;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class CoursePaymentController {

    public AnchorPane root;
    public TextField txtStudentId;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtAddress;
    public TextField txtNic;
    public TextField txtDateOfBirth;
    public TextField txtEmail;
    public TextField txtBatchName;
    public TextField txtBatchId;
    public TextField txtGender;
    public TextField txtRegDate;
    public TextField txtTel;
    public TextField txtCourseName;
    public TextField txtCourseFee;
    public TextField txtMail;
    public TextField txtAge;
    public TextField txtFee;
    public TextField txtRegistrationFee;
    public Button btnSave;
    public Button btnSearch;

    StudentBO studentBO = BOFactroy.getInstance().getBO(BOType.STUDENT);
    RegistationBO registationBO = BOFactroy.getInstance().getBO(BOType.REGISTATION);

    public void BackOnActionCliced(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/StudentForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(this.root.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }

    public void btnSearch_OnAction(ActionEvent actionEvent) {
        try {
            CustomEntity customEntity = studentBO.getAllStudentDetails(txtStudentId.getText());
            if(!(customEntity == null)){
                System.out.println(customEntity);
                txtFirstName.setText(customEntity.getFirstName());
                txtLastName.setText(customEntity.getLastName());
                txtAddress.setText(customEntity.getAddress());
                txtTel.setText(String.valueOf(customEntity.getTel()));
                txtNic.setText(customEntity.getNic());
                txtDateOfBirth.setText(String.valueOf(customEntity.getBirthDay()));
                txtMail.setText(customEntity.getMail());
                txtGender.setText(customEntity.getGender());
                txtAge.setText(String.valueOf(customEntity.getAge()));
                txtBatchId.setText(customEntity.getBatchId());
                txtBatchName.setText(customEntity.getBatchName());
                txtRegDate.setText(String.valueOf(customEntity.getReg_Date()));
                txtRegistrationFee.setText(String.valueOf(customEntity.getRegistartionFee()));
                txtCourseName.setText(customEntity.getCourseName());
                txtCourseFee.setText(String.valueOf(customEntity.getCourseFee()));


                txtFirstName.setDisable(true);
                txtFirstName.setDisable(true);
                txtLastName.setDisable(true);
                txtAddress.setDisable(true);
                txtTel.setDisable(true);
                txtNic.setDisable(true);
                txtDateOfBirth.setDisable(true);
                txtMail.setDisable(true);
                txtGender.setDisable(true);
                txtAge.setDisable(true);
                txtBatchId.setDisable(true);
                txtBatchName.setDisable(true);
                txtRegDate.setDisable(true);
                txtRegistrationFee.setDisable(true);
                txtCourseName.setDisable(true);
                txtCourseFee.setDisable(true);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "sorry,no this student..Try again");
                alert.show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnSave_OnAction(ActionEvent actionEvent) {


        double regFee = Double.parseDouble(txtRegistrationFee.getText());
        double courseFee = Double.parseDouble(txtFee.getText());

        RegistraionTM registraionTM = new RegistraionTM();
        registraionTM.setStudentId(txtStudentId.getText());
        registraionTM.setBatchId(txtBatchId.getText());
        registraionTM.setRegistartionFee(regFee);
        registraionTM.setCourseFee(courseFee);
        registraionTM.setStatus("COMPLETE");
        registraionTM.setReg_Date(Date.valueOf(txtRegDate.getText()));
        registraionTM.setCourseFeeGi_Date(Date.valueOf(LocalDate.now()));


        try {
            registationBO.registationUpdate(registraionTM);

            txtFirstName.clear();
            txtFirstName.clear();
            txtLastName.clear();
            txtAddress.clear();
            txtTel.clear();
            txtNic.clear();
            txtDateOfBirth.clear();
            txtMail.clear();
            txtGender.clear();
            txtAge.clear();
            txtBatchId.clear();
            txtBatchName.clear();
            txtRegDate.clear();
            txtRegistrationFee.clear();
            txtCourseName.clear();
            txtCourseFee.clear();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully Payment");
            alert.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
