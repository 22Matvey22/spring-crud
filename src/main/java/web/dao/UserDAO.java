package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    List<User> getAllUsers();

    public void removeUserById(Long id);

    User getUserById(long id);

    User getUserByUsername(String username);

    void updateUser(User user);
}
