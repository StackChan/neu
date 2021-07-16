package com.neu.controller;


import com.neu.model.User;
import com.neu.tools.SimpleTools2;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * 注册控制器
 */
public class LogUpFrameController {
    private Stage LogUpStage;

    public Stage getLogUpStage() {
        return LogUpStage;
    }

    public void setLogUpStage(Stage logUpStage) {
        this.LogUpStage = logUpStage;
    }

    public static User user = null;


    @FXML
    private TextField idTextField;

    @FXML
    private PasswordField passwordTextField;



    /**
     * “注册”按钮事件监听器
     */
    @FXML
    void logUpButtonEvent() {
        // 判断用户是否输入用户名和密码
        if (idTextField.getText().equals("") || passwordTextField.getText().equals("")) {
            SimpleTools2.informationDialog(Alert.AlertType.WARNING, "提示", "Warning", "填写不规范,请重填！");
        }
        // 关闭注册界面
        LogUpStage.close();
    }

    public String getId() {
        return idTextField.getText();
    }

    public String getPassWord() {
        return passwordTextField.getText();
    }

}

