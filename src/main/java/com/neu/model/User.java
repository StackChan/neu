package com.neu.model;

import NursingManageSystem.tools.Functional;

import java.util.Date;
import java.util.List;

public class User implements Functional<User> {
    private String id;
    private String name;
    private String password;//不在show中展示


    private Date birthday;
    private String title;
    private String major;
    private String identityCard;
    private String phone;


    private boolean isAdministrator;//判断是否为超管


    private static User instance;


    private User() {
    }

    private User(String id, String name, String password, Date birthday, String title, String major, String identityCard,String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.title = title;
        this.major = major;
        this.identityCard = identityCard;
        this.phone = phone;
        this.isAdministrator = false;
    }

    //饿汉式单例模式
    public static User getInstance(String id, String name, String password,Date birthday, String title, String major, String identityCard,String phone) {
        instance = new User(id, name, password,birthday, title, major, identityCard,phone);
        return instance;
    }


    //增删改查方法将由接口实现:分隔

    //TODO:可能使用到,提交前处理

//
//    //普通用户:改
//    public void fix(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("您现在的信息是：\n"+ this.toString());
//        System.out.println("请输入要修改的姓名");
//        this.setName(scanner.next());
//        System.out.println("请输入要修改的密码");
//        String newPassword = scanner.next();
//        System.out.println("请输入要修改的邮箱");
//        this.setEmail(scanner.next());
//        System.out.println("修改成功");
//    }

//TODO:可能使用到,提交前处理

//    管理员:
//    查
//    public void search(Map<Integer, User> users) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("查询全部用户------------1");
//        System.out.println("根据ID查询用户----------2");
//        System.out.println("根据姓名查询用户---------3");
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                //TODO:华点,用的好啊
//                users.forEach((member, user) ->
//                        System.out.println(user.toString() + "\n========================"));
//                break;
//            case 2:
//                System.out.println("请输入要查询的用户的ID号码");
//                Integer ID = scanner.nextInt();
//                System.out.println(users.get(ID).toString() + "\n========================");
//                break;
//            case 3:
//                System.out.println("请输入要查询的用户的姓名");
//                String name = scanner.next();
//
//                for (User u : users.values()) {
//                    if (name.equals(u.getName()))
//                        System.out.println(u.toString() + "\n========================");
//                }
//                break;
//        }
//    }

    //TODO:超管修改功能待用
//    //修改
//    public void fix(Map<Integer, User> users) {
//        Boolean isAd = scanner.next().equals("管理员")?true:false;
//        User u = users.get(ID);
//        u.setName(userName);
//        u.setPassword(password);
//        u.setEmail(eMail);
//        u.setIsAdministrator(isAd);
//    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", major='" + major + '\'' +
                ", identityCard='" + identityCard + '\'' +
                '}';
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public boolean getIsAdministrator() {
        return isAdministrator;
    }

    public void setIsAdministrator(boolean b) {
        isAdministrator = b;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    //重写Functionanl接口方法
    @Override
    public void add(List<User> list, String id) {

    }

    @Override
    public void delete(List<User> list, String id) {

    }

    @Override
    public void fix(List<User> list, String id) {

    }

    @Override
    public User search(List<User> list, String id) {
        for (User u : list) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

}
