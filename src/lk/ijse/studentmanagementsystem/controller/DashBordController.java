package lk.ijse.studentmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBordController {

    public AnchorPane rootpane;

    public void StudentOnMouseClicked(ActionEvent actionEvent) throws IOException {


    }

    public void RegistraionOnMouseClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/RegistrationFrom.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(rootpane.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }

    public void BatchOnMouseClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/BatchForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(rootpane.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }

    public void CourseOnMouseClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/CourseForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(rootpane.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }

    public void SubjectOnMouseClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/studentmanagementsystem/view/SubjectForm.fxml"));
        Scene scene = new Scene(root);
        Stage mainStage = (Stage)(rootpane.getScene().getWindow());
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
    }
}
