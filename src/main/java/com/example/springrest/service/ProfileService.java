package com.example.springrest.service;

import com.example.springrest.model.Profile;

import java.util.Date;

public interface ProfileService {
    Profile getProfile (int personId);
    void createProfile (String name, int age, Date birthday, short experience, long salary);
    void deleteProfile (int id);
}
