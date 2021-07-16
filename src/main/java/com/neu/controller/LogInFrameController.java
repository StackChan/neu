package com.neu.controller;


import com.neu.MainApp;
import com.neu.dao.FileDao;
import com.neu.model.User;
import com.neu.tools.SimpleTools2;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.codehaus.jackson.type.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录控制器
 *
 * @author lck100
 */
public class LogInFrameController {
    private Stage LogInStage;

    public Stage getLogInStage() {
        return LogInStage;
    }

    public void setLogInStage(Stage LogInStage) {
        this.LogInStage = LogInStage;
    }

    public static User user = null;


    @FXML
    private TextField idTextField;

    @FXML
    private PasswordField passwordTextField;


    /**
     * “登录”按钮事件监听器
     */
    @FXML
    void LogInButtonEvent() {
        // 判断用户是否输入用户名和密码
        if (idTextField.getText().equals("") || passwordTextField.getText().equals("")) {
            SimpleTools2.informationDialog(Alert.AlertType.WARNING, "提示", "Warning", "填写不规范,请重填！");
        } else {
            List<User> users = new ArrayList<>();
            //进行读取操作
            FileDao<User> fileDao = new FileDao();
            users = fileDao.loadJsonToList("UsersInfo.json",User.class);

            String idWord = idTextField.getText();
            for (User u:users) {
                if(u.getId().equals(idWord)){
                    user = u;
                }
            }
            if (user.getPassword().equals(passwordTextField.getText())) {
                boolean b = SimpleTools2.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "恭喜" + "，登录成功，欢迎使用本系统！");
                // 如果用户确定登录，则跳转到主界面
                if (b) {
                    // 关闭登录界面
                    LogInStage.close();
                    // 打开主窗口
                    if (user.getIsAdministrator()){
                        new MainApp().initMainFrame1();
                    }else new MainApp().initMainFrame2();

                }
            } else {
                SimpleTools2.informationDialog(Alert.AlertType.ERROR, "错误", "错误", "用户名或密码错误！");
            }
        }
    }

}

