package com.neu.model;

import NursingManageSystem.tools.Functional;

import java.util.ArrayList;
import java.util.List;

public class Template implements Functional<Template> {
    String id;
    String name;
    String type;
    List<Question> questionsList = new ArrayList<>();
    private Template(){}

    public Template(String id, String name, String type, List<Question> questionsList) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.questionsList = questionsList;
    }
    private static Template instance;
    private static Template getInstance(String id, String name, String type, List<Question> questionsList){
        instance = new Template(id, name, type, questionsList);
        return instance;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }


    @Override
    public void add(List<Template> list, String id) {

    }

    @Override
    public void delete(List<Template> list, String id) {

    }

    @Override
    public void fix(List<Template> list, String id) {

    }

    @Override
    public Template search(List<Template> list, String id) {
        for (Template t:list) {
            if (t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }
}
