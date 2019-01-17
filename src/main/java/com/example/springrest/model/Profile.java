package com.example.springrest.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Profile {

    private int id;

    @NotNull
    private String name;

    @NotNull
    private int age;

    @NotNull
    private Date birthday;

    @NotNull
    private short experience;

    @NotNull
    private long salary;

    public Profile() {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.experience = experience;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId (int id)  {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public short getExperience() { return experience; }

    public void setExperience(short experience) {
        this.experience = experience;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
