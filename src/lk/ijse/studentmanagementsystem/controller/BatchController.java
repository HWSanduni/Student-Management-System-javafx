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
import lk.ijse.studentmanagementsystem.business.custom.BatchBO;
import lk.ijse.studentmanagementsystem.business.custom.CourseBO;
import lk.ijse.studentmanagementsystem.util.BatchTM;
import lk.ijse.studentmanagementsystem.util.CourseTM;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BatchController {


    public AnchorPane root;
    public TextField txtBatchId;
    public TextField txtBatchName;
    public TextField txtCourseName;
    public TextField txtBatchType;
    public TextField txtYear;
    public Button btnSave;
    public Button btnRemove;
    public DatePicker picStartDate;
    public DatePicker picEndDate;
    public TableView<BatchTM> tblBatch;
    public ComboBox<CourseTM> cmbCourseId;
    private boolean readOnly;

    BatchBO batchBO = BOFactroy.getInstance().getBO(BOType.BATCH);
    CourseBO courseBO = BOFactroy.getInstance().getBO(BOType.COURSE);

    public void initialize() {
        tblBatch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Bid"));
        tblBatch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblBatch.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblBatch.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("year"));
        tblBatch.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("startDate"));
        tblBatch.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("endDate"));
        tblBatch.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("courseId"));

        loadAllBatch();
        loadAllCourse();

        cmbCourseId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CourseTM>() {
            @Override
            public void changed(ObservableValue<? extends CourseTM> observable, CourseTM oldValue, CourseTM newValue) {
                if (newValue == null) {
                    txtCourseName.clear();
                    return;
                }
                txtCourseName.setText(newValue.getName());
            }
        });


        tblBatch.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BatchTM>() {

            @Override
            public void changed(ObservableValue<? extends BatchTM> observable, BatchTM oldValue, BatchTM selectedBatch) {

                if (selectedBatch == null) {
                    return;
                }

                String selectedCourseId = selectedBatch.getCourseId();
                ObservableList<CourseTM> courseTMS = cmbCourseId.getItems();
                for (CourseTM courseTM: courseTMS) {
                    if(courseTM.getCid().equals(selectedCourseId)){
                        cmbCourseId.getSelectionModel().select(courseTM);
                        txtCourseName.setText(courseTM.getName());
                        txtBatchId.setText(selectedBatch.getBid());
                        txtBatchName.setText(selectedBatch.getName());
                        txtBatchType.setText(selectedBatch.getType());
                        txtYear.setText(String.valueOf(selectedBatch.getYear()));
                        picStartDate.setValue(selectedBatch.getStartDate().toLocalDate());
                        picEndDate.setValue(selectedBatch.getEndDate().toLocalDate());

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

    private void loadAllCourse() {

        cmbCourseId.getItems().clear();
        try {
            cmbCourseId.setItems(FXCollections.observableArrayList(courseBO.getAllCourse()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAllBatch() {
        try {

            tblBatch.getItems().clear();
            List<BatchTM> batchTMList = null;
            try {
                batchTMList = batchBO.getAllBatch();
                System.out.println(batchTMList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ObservableList<BatchTM> batchTMS = FXCollections.observableArrayList(batchTMList);
            tblBatch.setItems(batchTMS);

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
            txtBatchId.clear();
            txtBatchId.setText(batchBO.getNewBatchId());
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


        if (txtBatchId.getText().trim().isEmpty() || txtBatchName.getText().trim().isEmpty() || txtBatchType.getText().trim().isEmpty()
                || txtYear.getText().trim().isEmpty() || txtCourseName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Name, Description or Course Fee can't be empty").show();
            return;
        }

        int year = Integer.parseInt(txtYear.getText().trim());


        LocalDate localStartDate = picStartDate.getValue();
        Date startDate = Date.valueOf(localStartDate);
        LocalDate localEndDate = picEndDate.getValue();
        Date endDate = Date.valueOf(localEndDate);


        if (year < 0) {
            new Alert(Alert.AlertType.ERROR, "Invalid Year").show();
            return;
        }

        if (btnSave.getText().equals("Save")) {
            try {
                batchBO.saveBatch(txtBatchId.getText(),
                        cmbCourseId.getValue().getCid(),
                        txtBatchName.getText(),
                        txtBatchType.getText(),
                        year,
                        startDate,
                        endDate);
                txtBatchId.clear();
                txtBatchName.clear();
                txtBatchType.clear();
                txtCourseName.clear();
                txtYear.clear();
                picEndDate.getEditor().clear();
                picStartDate.getEditor().clear();
                cmbCourseId.getSelectionModel().clearSelection();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully Added Batch!");
                alert.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            BatchTM batchTM = tblBatch.getSelectionModel().getSelectedItem();

            boolean result = false;

            try {
                result = batchBO.updateBatch(cmbCourseId.getValue().getCid(),
                        txtBatchName.getText(),
                        txtBatchType.getText(),
                        year,
                        startDate,
                        endDate,
                        batchTM.getBid());
                txtBatchId.clear();
                txtBatchName.clear();
                txtBatchType.clear();
                txtCourseName.clear();
                txtYear.clear();
                picEndDate.getEditor().clear();
                picStartDate.getEditor().clear();
                cmbCourseId.getSelectionModel().clearSelection();

            } catch (Exception e) {
                e.printStackTrace();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully Update Batch!");
            alert.show();
            if (!result) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the Batch").show();
            }
            tblBatch.refresh();
            btnAddNew_OnAction(actionEvent);
        }
        loadAllBatch();
    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure whether you want to delete this Batch?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
           BatchTM batchTM= tblBatch.getSelectionModel().getSelectedItem();

            boolean result = false;
            try {
                result = batchBO.deleteBatch(batchTM.getBid());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Alert aler = new Alert(Alert.AlertType.INFORMATION, "Successfully Delete Batch!");
            aler.show();
            if (!result) {
                new Alert(Alert.AlertType.ERROR, "Failed to delete the Batch", ButtonType.OK).show();
            } else {
                tblBatch.getItems().remove(batchTM);
                tblBatch.getSelectionModel().clearSelection();
            }
        }
    }
}
