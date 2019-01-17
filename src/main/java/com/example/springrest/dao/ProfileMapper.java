package com.example.springrest.dao;

import com.example.springrest.model.Profile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProfileMapper implements RowMapper<Profile> {

    @Override
    public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
        Profile profile = new Profile();
        profile.setId(rs.getInt("id"));
        profile.setName(rs.getString("name"));
        profile.setAge(rs.getInt("age"));
        profile.setBirthday(rs.getDate("birthday"));
        profile.setExperience(rs.getShort("experience"));
        profile.setSalary(rs.getLong("salary"));
        return profile;
    }
}
