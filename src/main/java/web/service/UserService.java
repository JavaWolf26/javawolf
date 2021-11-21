package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    void save(User user);
    void update(int id, User updateUser);
    void delete(int id);
}
