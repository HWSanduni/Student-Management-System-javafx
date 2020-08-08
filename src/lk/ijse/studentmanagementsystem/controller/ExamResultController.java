package lk.ijse.studentmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.studentmanagementsystem.business.BOFactroy;
import lk.ijse.studentmanagementsystem.business.BOType;
import lk.ijse.studentmanagementsystem.business.custom.ExamBO;
import lk.ijse.studentmanagementsystem.entity.CustomEntity;
import lk.ijse.studentmanagementsystem.entity.CustomEntity1;

public class ExamResultController {

    ExamBO examBO = BOFactroy.getInstance().getBO(BOType.EXAM);

    public void BackOnActionCliced(MouseEvent mouseEvent) {
    }

    public void btnSearch_OnAction(ActionEvent actionEvent) {

        try {
            CustomEntity1 customEntity = examBO.getExamDetails("E001");
            System.out.println("+++++++++++++++++++++++++");

            System.out.println(customEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
