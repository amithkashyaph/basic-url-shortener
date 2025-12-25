package com.project.url_shortener.repositories;

import com.project.url_shortener.entities.User;
import com.project.url_shortener.enums.Role;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Repository
public class UserRepositoryJdbcClient {

    private JdbcClient jdbcClient;

    public UserRepositoryJdbcClient(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Optional<User> findById(Long id) {
        String sql = "SELECT id, email, password, name, role, created_at FROM users WHERE id = :id";
        return jdbcClient
                .sql(sql)
                .param("id", id)
                .query(new UserRowMapper())
                .optional();
    }

    public Optional<User> findByEmail(String email) {
        String sql = "SELECT id, email, password, name, role, created_at FROM users WHERE email = :email";
        return jdbcClient
                .sql(sql)
                .param("email", email)
                //.query(User.class)
                .query(new UserRowMapper())
                .optional();
    }

}
