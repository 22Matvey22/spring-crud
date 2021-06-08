package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();

    void removeUserById(Long id);

    User getUserById(long id);

    User getUserByUsername(String username);

    void updateUser(User user);
}
