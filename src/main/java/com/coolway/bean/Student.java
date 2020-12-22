package com.coolway.bean;

public class Student {
    String id;
    String name;
    String sex;
    int age;
    String clazz;
    String tel;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void havaClass() {
        System.out.println("上课");
    }

    public void playGame() {
        System.out.println("娱乐");
    }

    public void eat() {
        System.out.println("吃饭");
    }
}
