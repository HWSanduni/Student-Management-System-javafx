package lk.ijse.studentmanagementsystem.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.studentmanagementsystem.business.BOFactroy;
import lk.ijse.studentmanagementsystem.business.BOType;
import lk.ijse.studentmanagementsystem.business.custom.BatchBO;
import lk.ijse.studentmanagementsystem.business.custom.CourseBO;
import lk.ijse.studentmanagementsystem.business.custom.RegistationBO;
import lk.ijse.studentmanagementsystem.business.custom.StudentBO;
import lk.ijse.studentmanagementsystem.entity.Course;
import lk.ijse.studentmanagementsystem.util.BatchTM;
import lk.ijse.studentmanagementsystem.util.RegistraionTM;
import lk.ijse.studentmanagementsystem.util.StudentTM;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class RegistrationController {

    public AnchorPane root;
    public TextField txtStudentId;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtAddress;
    public TextField txtNic;
    public TextField txtAge;
    public TextField txtEmail;
    public TextField txtTel;
    public TextField txtCourseName;
    public TextField txtCourseFee;
    public TextField txtBatchName;
    public TextField txtRegistrationFee;
    public Button btnAddNewStudent;
    public Button btnSave;
    public Button btnCancel;
    public RadioButton rdFemale;
    public RadioButton rdMale;
    public DatePicker picDateOfBirth;
    public ComboBox<BatchTM> cmbBatchId;
    public ToggleGroup group;

    private String gender;

    StudentBO studentBO = BOFactroy.getInstance().getBO(BOType.STUDENT);
    BatchBO batchBO = BOFactroy.getInstance().getBO(BOType.BATCH);
    CourseBO courseBO = BOFactroy.getInstance().getBO(BOType.COURSE);
    RegistationBO registationBO = BOFactroy.getInstance().getBO(BOType.REGISTATION);

    public void initialize() {
        group = new ToggleGroup();

        rdMale.setToggleGroup(group);
        rdFemale.setToggleGroup(group);

        loadAllBatch();

        cmbBatchId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BatchTM>() {
            @Override
            public void changed(ObservableValue<? extends BatchTM> observable, BatchTM oldValue, BatchTM newValue) {
                if (newValue == null) {
                    txtBatchName.clear();
                    return;
                }
                Course course=findCourse(newValue.getCourseId());
                txtBatchName.setText(newValue.getName());
                txtCourseName.setText(course.getName());
                txtCourseFee.setText(course.getCourseFee()+"");

            }
        });

    }

    private Course findCourse (String id){
        Course course =null;
        try {
             course = courseBO.findSubject(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }

    private void loadAllBatch() {
        cmbBatchId.getItems().clear();
        try {
            cmbBatchId.setItems(FXCollections.observableArrayList(batchBO.getAllBatch()));
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
        txtStudentId.clear();
        try {
            txtStudentId.setText(studentBO.getNewStudentId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnGender_OnAction(ActionEvent actionEvent) {
        gender = ((RadioButton) actionEvent.getSource()).getText();

    }

    public void btnSave_OnAction(ActionEvent actionEvent) {

        if (txtStudentId.getText().trim().isEmpty() || txtBatchName.getText().trim().isEmpty() || txtAddress.getText().trim().isEmpty()
                || txtAge.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty() || txtFirstName.getText().trim().isEmpty() ||
                txtLastName.getText().trim().isEmpty() || txtNic.getText().trim().isEmpty() || txtRegistrationFee.getText().trim().isEmpty()
              ) {
            new Alert(Alert.AlertType.ERROR, "can't be empty Field").show();
            return;
        }

        int age = Integer.parseInt(txtAge.getText().trim());
        int tel = Integer.parseInt(txtTel.getText().trim());
        double regFee = Double.parseDouble(txtRegistrationFee.getText());
        double courseFee = 0.00;

        LocalDate localStartDate = picDateOfBirth.getValue();
        Date birthdate = Date.valueOf(localStartDate);

        if (age < 0) {
            new Alert(Alert.AlertType.ERROR, "Invalid Year").show();
            return;
        }

        if(btnSave.getText().equals("Save")){

            StudentTM studentTM = new StudentTM();
            studentTM.setSid(txtStudentId.getText());
            studentTM.setFirstName(txtFirstName.getText());
            studentTM.setLastName(txtLastName.getText());
            studentTM.setAddress(txtAddress.getText());
            studentTM.setTel(tel);
            studentTM.setNic(txtNic.getText());
            studentTM.setBirthDay(birthdate);
            studentTM.setAge(age);
            studentTM.setMail(txtEmail.getText());
            studentTM.setGender(gender);

            RegistraionTM registraionTM = new RegistraionTM();
            registraionTM.setBatchId(cmbBatchId.getValue().getBid());
            registraionTM.setStudentId(txtStudentId.getText());
            registraionTM.setRegistartionFee(regFee);
            registraionTM.setCourseFee(courseFee);
            registraionTM.setStatus("");
            registraionTM.setReg_Date(Date.valueOf(LocalDate.now()));
//            registraionTM.setCourseFeeGi_Date(Date.valueOf(""));

            txtStudentId.clear();
            txtFirstName.clear();
            txtLastName.clear();
            txtAddress.clear();
            txtNic.clear();
            txtAge.clear();
            txtEmail.clear();
            txtCourseName.clear();
            txtCourseFee.clear();
            txtBatchName.clear();
            txtRegistrationFee.clear();
            cmbBatchId.getSelectionModel().clearSelection();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully Student Registration!");
            alert.show();

            try {
                registationBO.registation(studentTM,registraionTM);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }





    }


}
