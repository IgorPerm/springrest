package com.example.springrest.controller;

import com.example.springrest.model.Profile;
import com.example.springrest.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)

public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController (ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping (value = "/{personId:\\d+}")
    public Profile getProfile (@PathVariable int personId) {
        return profileService.getProfile(personId);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody Profile profile) {
        profileService.createProfile(profile.getName(), profile.getAge(), profile.getBirthday(),
                profile.getExperience(), profile.getSalary());
    }

    @DeleteMapping (value = "/{personId:\\d+}")
    public void deleteProfile(@PathVariable int personId) {
        profileService.deleteProfile(personId);
    }
}
