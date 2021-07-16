package com.neu.tools;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class SimpleTools2 {

    /**
     * 操作结果：自定义一个JavaFX的对话框
     *
     * @param alterType 对话框类型
     * @param title     对话框标题
     * @param header    对话框头信息
     * @param message   对话框显示内容
     * @return boolean 如果点击了”确定“那么就返回true，否则返回false
     */
    public static boolean informationDialog(Alert.AlertType alterType, String title, String header, String message) {
        // 按钮部分可以使用预设的也可以像这样自己 new 一个
        Alert alert = new Alert(alterType, message, new ButtonType("取消", ButtonBar.ButtonData.CANCEL_CLOSE),
                new ButtonType("确定", ButtonBar.ButtonData.YES));
        // 设置对话框的标题
        alert.setTitle(title);
        alert.setHeaderText(header);
        // showAndWait() 将在对话框消失以前不会执行之后的代码
        Optional<ButtonType> buttonType = alert.showAndWait();
        // 根据点击结果返回, 如果点击了“确定”就返回true
        return buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES);
    }

    /**
     * 操作结果：读取配置属性文件
     *
     * @param propertiesFilePath 配置属性文件路径
     * @return String 根据键获取的内容值
     */
    static List readPropertiesFile(String propertiesFilePath) {
        Properties properties = new Properties();
        String returnValue;
        List list = new ArrayList();
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(propertiesFilePath));
            properties.load(inputStream);
            Iterator<String> iterator = properties.stringPropertyNames().iterator();
            while (iterator.hasNext()) {
                returnValue = properties.getProperty(iterator.next());
                list.add(returnValue);
            }
            inputStream.close();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 操作结果：操作结果：生成属性文件
     *
     * @param fileName 文件路径
     * @param maps     数据集合
     */
    public static void dataWriteProperties(String fileName, Map<String, String> maps) {
        Properties properties = new Properties();
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            // 写入文件
            for (String key : maps.keySet()) {
                properties.setProperty(key, String.valueOf(maps.get(key)));
            }
            FileOutputStream fos = new FileOutputStream(file);
            // store(...)指定的流仍保持打开状态
            properties.store(fos, null);
            fos.flush();
            fos.close();// 关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 操作结果：将一段字符串按某种分隔符号分割成数组
     *
     * @param str  字符串
     * @param mark 分割标志，如逗号
     * @return String[] 字符串数组
     */
    public static String[] convertStrToArray(String str, String mark) {
        String[] array = null;
        array = str.split(mark);
        return array;
    }

    /**
     * Object类型转换为String类型，高阶类型向低阶转会提示错误
     *
     * @param obj
     * @return
     */
    public static String[][] objectTwoArrayToTwoArrayString(Object[][] obj) {
        String[][] str = new String[obj.length][obj[0].length];
        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj[i].length; j++) {
                str[i][j] = obj[i][j].toString();
            }
        }
        return str;
    }

    /**
     * 操作结果：数组转换成List集合
     *
     * @param strings 数组
     * @return List 集合
     */
    public List arrayToList(String[] strings) {
        List list = new ArrayList();
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }
        return list;
    }

    /**
     * 操作结果：将一维Object数组转换成一维String数组
     *
     * @param obj 一维Object数组
     * @return String[] 一维String数组
     */
    public static String[] objectOneArrayToOneArrayString(Object[] obj) {
        String[] array = new String[obj.length];
        for (int i = 0; i < obj.length; i++) {
            array[i] = obj[i].toString();
        }
        return array;
    }


}
