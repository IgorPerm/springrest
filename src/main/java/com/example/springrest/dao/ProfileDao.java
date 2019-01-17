package com.example.springrest.dao;

import com.example.springrest.model.Profile;

import java.util.Date;

public interface ProfileDao {
    Profile getProfileById (int id);
    void insertProfile (String name, int age, Date birthday, short experience, long salary);
    void deleteProfileById (int id);
}
