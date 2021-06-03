package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();

    void removeUser(User user);

    User getUserById(long id);

    void updateUser(User user);
}
