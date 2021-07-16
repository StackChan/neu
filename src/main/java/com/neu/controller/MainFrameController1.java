package com.neu.controller;



import com.neu.MainApp;
import com.neu.dao.FileDao;
import com.neu.model.User;
import com.neu.model.UserTableData;
import com.neu.tools.DateTools;
import com.neu.tools.SimpleTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class MainFrameController1 {

    private User user = LogInFrameController.user;
    private SimpleTools simpleTools = new SimpleTools();

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    //该HBox与primaryStage是否被创建尚未知

    @FXML
    private Stage primaryStage;

    @FXML
    private HBox layout;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField majorTextField;

    @FXML
    private Button deleteButton;


    @FXML
    private TableColumn<UserTableData, String> bookAuthorTableColumn;

    @FXML
    private TableView<UserTableData> bookManageTableView;
    @FXML
    private TableColumn<UserTableData, String> idTableColumn;

    //TODO:tree有待处理
    @FXML
    private TreeView<?> treeView;

    @FXML
    private TableColumn<UserTableData, String> nameTableColumn;

    @FXML
    private TableColumn<UserTableData, String> majorTableColumn;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TableView<UserTableData> tableView;

    @FXML
    private Button addButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableColumn<UserTableData, String> titleTableColumn;

    @FXML
    private TextField birthdayTextField;

    @FXML
    private Button exitButton;

    @FXML
    private Button fixButton;

    @FXML
    private TableColumn<UserTableData, String> checkTableColumn;

    @FXML
    private TableColumn<UserTableData, String> identityCardTableColumn;

    @FXML
    private TableColumn<UserTableData, String> birthdayTableColumn;
    @FXML
    private TableColumn<UserTableData, String> phoneTableColumn;
    @FXML
    private TextField identityCardTextField;
    @FXML
    private ComboBox<?> titleComboBox;

    private FileDao<User> fileDao = new FileDao<>();
    private static List<User> list;
    /**
     * 初始化启动
     */
    public void initialize() {
        // 设置显示id号的文本框不可编辑
        idTextField.setText(user.getId());
        idTextField.setDisable(true);
        String[] titles = new String[]{"医生", "护士", "护工"};
        // 初始化下拉列表框的选项
        simpleTools.addComboBoxItems(titleComboBox, titles);
        //TODO:展示,加载到列表
    }


    /**
     * “退出”菜单项的事件处理
     *
     * @param event 事件
     */
    public void exitButtonEvent(ActionEvent event) {
        //TODO:是否需要logUpStage.close();类似操作,未知,看运行结果,问干哥
        // 注销的事件处理
        primaryStage.close();

        new MainApp().start(primaryStage);
    }


    // 【新增】按钮的事件监听器
    public void do_addButton_event(ActionEvent event) {
        String name = nameTextField.getText();
        String major = majorTextField.getText();
        String title = (String) titleComboBox.getSelectionModel().selectedItemProperty().getValue();

        String phone = phoneTextField.getText();
        String birthday = birthdayTextField.getText();
        String identityCard = identityCardTextField.getText();

        String id = "空";
        String password = "空";

        //加载注册界面
        try {
            FXMLLoader loader = new FXMLLoader();
            System.out.println(MainApp.class.getResource("view/loginFrame.fxml"));
            loader.setLocation(MainApp.class.getResource("view/loginFrame.fxml"));

            layout = loader.load();

            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);

            //TODO:primaryStage被两个Scene占用,查看情况
            LogUpFrameController controller = loader.getController();
            controller.setLogUpStage(primaryStage);

            primaryStage.show();
            id = controller.getId();
            password = controller.getPassWord();
            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = User.getInstance(id, name,password,new DateTools().stringToDate(birthday,"yyyy-MM-dd"),title, major, identityCard, phone);

        list = fileDao.loadJsonToList("UsersInfo.json", User.class);
        list.add(user);
        fileDao.writeListToJson("UsersInfo.json", list);
        // 添加成功则重置用户输入并弹出提示框
        resetContent();
        // 对结果进行判断
        simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "添加成功！");

    }

//    /**
//     * “用户修改”菜单项的事件处理
//     *
//     * @param event 事件
//     */
//    public void do_userManageMenuItem_event(ActionEvent event) {
//        // 当点击“用户维护”菜单项后，加载用户维护面板
//        AnchorPane pane = new MainApp().initBookManageFrame();
//        // 清空界面上原有的控件
//        mainFrameAnchorPane.getChildren().clear();
//        // 将用户维护面板添加到界面上
//        mainFrameAnchorPane.getChildren().add(pane);
//    }
//
//    public void do_aboutSoftMenuItem_event(ActionEvent event) {
//        // 当点击“关于软件”菜单项后，加载弹出框
//        new MainApp().initAboutSoftFrame();
//    }
//
//
//---------------------    ------------------------
//    // 【搜索】框的事件监听器
//    public void do_searchTextField_event(ActionEvent event) {
//        // 获取用户输入的登录名
//        String id = searchTextField.getText();
//        // 组装查询SQL
//        String checkSQL = "";
//        // 判断用户是否输入图书类别，如果没有输入即为空字符串，那么就查询所有数据，否则按条件将那些查询
//        if (simpleTools.isEmpty(bookTypeName)) {
//            checkSQL = "select * from tb_booktype";
//        } else {
//            checkSQL = "select * from tb_booktype where btName='" + bookTypeName + "';";
//        }
//        // 重新绘制表格数据
//        simpleTools.setUserTableViewData(tableView
//                , simpleTools.getBookTableViewData("UsersInfo.json")
//                , idTableColumn,nameTableColumn,
//                birthdayTableColumn, titleTableColumn,
//                majorTableColumn, identityCardTableColumn, phoneTableColumn
//
//        );
//    }
//
//    // 【修改】按钮的事件监听器
//    public void do_alterButton_event(ActionEvent event) {
//        // 获取用户输入的内容
//        String id = idTextField.getText();
//        String name = bookTypeNameTextField2.getText();
//        String description = descriptionTextArea.getText();
//        // 组装更新SQL
//        String alterSQL = "update tb_booktype set btName='" + name + "',btDescription='" + description + "' where " +
//                "btId=" + id + ";";
//        // 执行更新操作并获取操作结果
//        boolean isOK = bookTypeDao.dataChange(alterSQL);
//        // 对操作结果进行判断
//        if (isOK) {
//            // 更新成功则界面并清空各文本框及弹出提示框
//            initialize();
//            simpleTools.clearTextField(idTextField, bookTypeNameTextField2, descriptionTextArea);
//            simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "修改成功！");
//        } else {
//            // 更新失败弹出提示框
//            simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "修改失败！");
//        }
//    }
//
//    // 【删除】按钮的事件监听器
//    public void do_deleteButton_event(ActionEvent event) {
//        // 获取要删除的id
//        String id = idTextField.getText();
//        // 组装删除的SQL语句
//        String sql1 = "set FOREIGN_KEY_CHECKS=0;";
//        String deleteSQL = "delete from tb_booktype where btId=" + id + ";";
//        String sql2 = "set FOREIGN_KEY_CHECKS=1;";
//        // 弹出确认框获取用户是否确认删除
//        boolean is = simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "是否删除？");
//        // 对删除结果进行判断
//        if (is) {
//            // 执行删除操作
//            bookTypeDao.dataChange(sql1);
//            boolean isOK = bookTypeDao.dataChange(deleteSQL);
//            bookTypeDao.dataChange(sql2);
//            // 对删除结果进行判断
//            if (isOK) {
//                // 删除成功则初始化表格数据，刷新表格
//                initialize();
//                // 清空用户输入
//                idTextField.setText("");
//                bookTypeNameTextField2.setText("");
//                descriptionTextArea.setText("");
//                // 弹出删除成功的提示框
//                simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "删除成功！");
//            } else {
//                // 弹出删除失败的提示框
//                simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "删除失败！");
//            }
//        } else {
//            return;
//        }
//
//    }
//
//    // 选中行后将选中行内容显示在下面的文本框中
//    public void showBookTypeDetails(BookTypeBeanTableData bookTypeBeanTableData) {
//        // 判断是否选中
//        if (bookTypeBeanTableData == null) {
//            return;
//        } else {
//            // 如果表格行被选中，则将数据显示在下面的文本框中
//            idTextField.setText(bookTypeBeanTableData.getBookTypeId());
//            bookTypeNameTextField2.setText(bookTypeBeanTableData.getBookTypeName());
//            descriptionTextArea.setText(bookTypeBeanTableData.getBookTypeDesciption());
//        }
//    }

    /**
     * 重置文本框、单选按钮和下拉列表框
     */
    private void resetContent() {
        simpleTools.clearTextField(nameTextField, majorTextField, phoneTextField, birthdayTextField,identityCardTextField);
        simpleTools.clearSelectedComboBox(titleComboBox);
    }
}


