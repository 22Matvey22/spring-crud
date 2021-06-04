package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDAO userDAO;

    public UserServiceImp() {
    }

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void removeUserById(Long id) {
        userDAO.removeUserById(id);
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}
