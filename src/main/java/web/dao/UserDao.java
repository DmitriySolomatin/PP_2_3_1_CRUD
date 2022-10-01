package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(long id);
    List<User> getUserList(int count);
    void deleteUser(User user);
    void addUser(User user);
}
