package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();

    public void removeUserById(Long id);

    User getUserById(long id);

    void updateUser(User user);
}
