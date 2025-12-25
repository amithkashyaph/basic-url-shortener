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
    public boolean existsByEmail(String email) {
        String sql = "SELECT count(*) > 0 FROM users WHERE email = :email";
        return jdbcClient
                .sql(sql)
                .param("email", email)
                .query(Boolean.class)
                .single();
    }
    public User save(User user) {
        String sql = """
                INSERT INTO users (email, password, name, role, created_at)
                VALUES (:email, :password, :name, :role, :createdAt)
                """;
        var keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(sql)
                .param("email", user.getEmail())
                .param("password", user.getPassword())
                .param("name", user.getName())
                .param("role", user.getRole().name())
                .param("createdAt", user.getCreatedAt())
                .update(keyHolder);
        Number key = keyHolder.getKey();
        if (key != null) {
            user.setId(key.longValue());
        }
        return user;
    }


    static class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            var user = new User();
            user.setId(rs.getLong("id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setRole(Role.valueOf(rs.getString("role")));
            user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            return user;
        }
    }
}
