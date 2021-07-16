package com.neu.model;

import NursingManageSystem.tools.Functional;

import java.util.Date;
import java.util.List;

public class Patient implements Functional <Patient> {
    private String id;//以身份证号作为id
    private String name;

    private String sex;
    private Date birthday;
    private String phone;
    private String vitalContact;
    private String vitalContactPhone;

    private static Patient instance;

    private Patient(String id, String name, String sex, Date birthday, String phone, String vitalContact, String vitalContactPhone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.phone = phone;
        this.vitalContact = vitalContact;
        this.vitalContactPhone = vitalContactPhone;
    }

    private Patient() {
    }

    //饿汉式单例模式
    public static Patient getInstance(String id, String name, String sex, Date birthday, String phone, String vitalContact, String vitalContactPhone) {
        instance = new Patient(id, name, sex, birthday, phone, vitalContact, vitalContactPhone);
        return instance;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", vitalContact='" + vitalContact + '\'' +
                ", vitalContactPhone='" + vitalContactPhone + '\'' +
                '}';
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVitalContact() {
        return vitalContact;
    }

    public void setVitalContact(String vitalContact) {
        this.vitalContact = vitalContact;
    }

    public String getVitalContactPhone() {
        return vitalContactPhone;
    }

    public void setVitalContactPhone(String vitalContactPhone) {
        this.vitalContactPhone = vitalContactPhone;
    }

    public static Patient getInstance() {
        return instance;
    }

    public static void setInstance(Patient instance) {
        Patient.instance = instance;
    }

    @Override
    public void add(List list, String id) {

    }

    @Override
    public void delete(List list, String id) {

    }

    @Override
    public void fix(List list, String id) {

    }

    @Override
    public Patient search (List<Patient> list, String id) {
        for (Patient p : list) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
