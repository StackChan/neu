package com.neu.dao;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;


import java.io.File;
import java.io.IOException;
import java.util.*;


//运用了泛型,E为参数化类型
public class FileDao<E> {
    //把给定类型写入给定json文件,写入结果为一个list
    public void writeListToJson(String jsonName, List<E> list) {
        ObjectMapper om = new ObjectMapper();
        File jsonFile = new File(jsonName);
        if (!jsonFile.exists()) {
            //TODO:这些sout可能需要加对话框
            System.out.println("文件不存在,正在创建...");
            try {
                if (jsonFile.createNewFile()) {
                    System.out.println("文件创建成功");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            om.writeValue(jsonFile, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //    //从改json文件中读取list
    public List<E> loadJsonToList(String jsonName, Class c) {
        List<E> list = null;
        ObjectMapper om = new ObjectMapper();
        File jsonFile = new File(jsonName);
        try {
//            TODO:读取结果异常,读出非User,而是linkedHashMap
            JavaType type = om.getTypeFactory().
                    constructCollectionType(List.class, c);
            list = om.readValue(jsonFile, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}