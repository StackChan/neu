package com.neu.model;

public class Question {
    String id;//问题id
    String name;

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

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public static Question getInstance() {
        return instance;
    }

    public static void setInstance(Question instance) {
        Question.instance = instance;
    }

    String type;
    String[] answer = new String[3];

    private Question(String id, String name, String type, String[] answer) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.answer = answer;
    }
    private Question(){}
    private static Question instance;

    public static Question getInstance(String id, String name, String type, String[] answer) {
        instance = new Question(id,name,type,answer);
        return instance;
    }
}
