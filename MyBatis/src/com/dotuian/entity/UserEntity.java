package com.dotuian.entity;

import java.io.Serializable;
import java.sql.Date;

public class UserEntity implements Serializable {

    private static final long serialVersionUID = -458045724375300041L;

    private long id;
    private String username;
    private String password;
    private Date birthday;
    private double salary;
    private int age;
    private String sex;
    private String hobby;
    private String memo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return String
                .format("UserEntity [id=%s, username=%s, password=%s, birthday=%s, salary=%s, age=%s, sex=%s, hobby=%s, memo=%s]",
                        id, username, password, birthday, salary, age, sex,
                        hobby, memo);
    }

}
