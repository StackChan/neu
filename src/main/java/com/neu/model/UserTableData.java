package com.neu.model;

import NursingManageSystem.tools.DateTools;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class UserTableData {
    private DateTools dateTools = new DateTools();

    private SimpleStringProperty id;
    private  SimpleStringProperty name;
    private  SimpleStringProperty birthday;
    private SimpleStringProperty title;
    private SimpleStringProperty major;
    private SimpleStringProperty identityCard;



    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    private SimpleStringProperty phone;

    public UserTableData() {}

    public UserTableData(String id, String name, Date birthday, String title, String major, String identityCard,String phone) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.birthday = new SimpleStringProperty(dateTools.dateFormat(birthday,"yyyy-MM-dd"));
        this.title = new SimpleStringProperty(title);
        this.major = new SimpleStringProperty(major);
        this.identityCard = new SimpleStringProperty(identityCard);
        this.phone = new SimpleStringProperty(phone);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getBirthday() {
        return birthday.get();
    }

    public SimpleStringProperty birthdayProperty() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getMajor() {
        return major.get();
    }

    public SimpleStringProperty majorProperty() {
        return major;
    }

    public void setMajor(String major) {
        this.major.set(major);
    }

    public String getIdentityCard() {
        return identityCard.get();
    }

    public SimpleStringProperty identityCardProperty() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard.set(identityCard);
    }
    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }
}
