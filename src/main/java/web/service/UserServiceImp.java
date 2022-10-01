package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDaoImp userDao;

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    public List<User> getUserList(int count) {
        return userDao.getUserList(count);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }
}
