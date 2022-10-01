package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    public List<User> getUserList(int count) {
        return userDao.getUserList(count);
    }

    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
