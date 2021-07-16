package com.neu;


import com.neu.controller.LogInFrameController;
import com.neu.controller.MainFrameController1;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @FXML
    private Stage primaryStage;

    @FXML
    private HBox rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("东软颐养社区中心");
        // 启动界面即为登录界面
        initLogInFrame();
    }

    public static void main(String[] args) {
        launch(args);//args似乎可以去掉
    }

    /**
     * 登录界面
     */
//    public void initLogInFrame() {
//        try {
//            // 加载登录界面的fxml文件
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("NursingManageSystem/view/LogInFrame.fxml"));
//            AnchorPane root = loader.load();
//
//            Scene scene = new Scene(root);
//            primaryStage.setTitle("登录");
//            primaryStage.setScene(scene);
//            primaryStage.setResizable(false);
//
//            // 获取登录界面的控制器类
//            LogInFrameController controller = loader.getController();
//            // 将stage作为参数传递到控制器中
//            controller.setLogInStage(primaryStage);
//
//            // 展示舞台
//            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public Scene initLogInFrame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            System.out.println(getClass().getResource("view/loginFrame.fxml"));
            loader.setLocation(getClass().getResource("view/loginFrame.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);

            LogInFrameController controller = loader.getController();
            controller.setLogInStage(primaryStage);

            primaryStage.show();
            return scene;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 管理员主界面
     */
    public void initMainFrame1() {
        try {
            // 加载主界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getClassLoader().getResource("view/mainFrame1.fxml"));
            SplitPane root = loader.load();

            // 设置stage舞台的属性
            Stage mainFrameStage = new Stage();
            mainFrameStage.setTitle("管理员主界面");
            mainFrameStage.setResizable(true);
            mainFrameStage.setAlwaysOnTop(false);
            mainFrameStage.initModality(Modality.APPLICATION_MODAL);
            mainFrameStage.initOwner(primaryStage);

            Scene scene = new Scene(root);
            mainFrameStage.setScene(scene);

            MainFrameController1 controller = loader.getController();
            controller.setPrimaryStage(mainFrameStage);

            mainFrameStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 普通用户主界面
     */
    public void initMainFrame2() {
        try {
            // 加载主界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/mainFrame2.fxml"));
            AnchorPane root = loader.load();

            // 设置stage舞台的属性
            Stage mainFrameStage = new Stage();
            mainFrameStage.setTitle("工作人员主界面");
            mainFrameStage.setResizable(true);
            mainFrameStage.setAlwaysOnTop(false);
            mainFrameStage.initModality(Modality.APPLICATION_MODAL);
            mainFrameStage.initOwner(primaryStage);

            Scene scene = new Scene(root);
            mainFrameStage.setScene(scene);

            mainFrameStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
