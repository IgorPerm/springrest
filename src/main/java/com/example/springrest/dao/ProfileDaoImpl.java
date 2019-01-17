package com.example.springrest.dao;

import com.example.springrest.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class ProfileDaoImpl implements ProfileDao {

    private static final String SQl_GET_PROFILE_BY_ID =
            "select id, name, age, birthday, experience, salary from profiles where id = :id";
    private static final String SQL_INSERT_PROFILE =
            "insert into profiles (name, age, birthday, experience, salary) " +
                    "values (:name, :age, :birthday, :experience, :salary)";
    private static final String SQL_DELETE_PROFILE =
            "delete from profiles where id = :id";

    private final ProfileMapper profileMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ProfileDaoImpl(
            ProfileMapper profileMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.profileMapper = profileMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Profile getProfileById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        try {
            return jdbcTemplate.queryForObject(SQl_GET_PROFILE_BY_ID, params, profileMapper);
        }catch (EmptyResultDataAccessException e) {}
        return null;
    }

    @Override
    public void insertProfile(String name, int age, Date birthday, short experience, long salary) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        params.addValue("age", age);
        params.addValue("birthday", birthday);
        params.addValue("experience", experience);
        params.addValue("salary", salary);
        jdbcTemplate.update(SQL_INSERT_PROFILE, params);
    }

    @Override
    public void deleteProfileById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(SQL_DELETE_PROFILE, params);
    }
}
