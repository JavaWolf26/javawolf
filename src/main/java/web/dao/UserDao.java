package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    public User getUserById(int id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id=?", new BeanPropertyRowMapper<>(User.class),
                        new Object[]{id})
                .stream()
                .findAny()
                .orElse(null);
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO users (firstName, lastName, age, email) VALUES(?, ?, ?, ?)",
                user.getFirstName(), user.getLastName(), user.getAge(), user.getEmail());
    }

    public void update(int id, User updateUser) {
        jdbcTemplate.update("UPDATE users SET firstName=?, lastName=?, age=?, email=? WHERE id=?",
                updateUser.getFirstName(), updateUser.getLastName(), updateUser.getAge(),
                updateUser.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }
}
