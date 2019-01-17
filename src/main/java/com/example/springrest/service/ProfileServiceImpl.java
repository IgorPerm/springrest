package com.example.springrest.service;

import com.example.springrest.dao.ProfileDao;
import com.example.springrest.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileDao profileDao;

    @Autowired
    public ProfileServiceImpl(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @Override
    public Profile getProfile(int personId) {
        Profile p = profileDao.getProfileById(personId);
        if (p == null) {
            throw new ProfileNotFoundException(personId);
        }
        else return p;
    }

    @Override
    public void createProfile(String name, int age, Date birthday, short experience, long salary) {
        profileDao.insertProfile(name, age, birthday, experience, salary);
    }

    @Override
    public void deleteProfile(int id) {
        Profile profile = profileDao.getProfileById(id);
        if (profile == null) throw new ProfileNotFoundException(id);
        else profileDao.deleteProfileById(profile.getId());
    }
}
