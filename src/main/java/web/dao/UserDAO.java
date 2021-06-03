package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    List<User> getAllUsers();

    void removeUser(User user);

    User getUserById(long id);

    void updateUser(User user);
}
