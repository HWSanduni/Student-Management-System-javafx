package lk.ijse.studentmanagementsystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.studentmanagementsystem.business.BOFactroy;
import lk.ijse.studentmanagementsystem.business.BOType;
import lk.ijse.studentmanagementsystem.business.custom.BatchBO;
import lk.ijse.studentmanagementsystem.util.BatchTM;

import java.io.IOException;
import java.util.List;

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

    BatchBO batchBO = BOFactroy.getInstance().getBO(BOType.BATCH);

    public void initialize() {
        tblBatch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Bid"));
        tblBatch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblBatch.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblBatch.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("year"));
        tblBatch.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("startDate"));
        tblBatch.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("endDate"));
        tblBatch.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("courseId"));

        loadAllBatch();
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
}
