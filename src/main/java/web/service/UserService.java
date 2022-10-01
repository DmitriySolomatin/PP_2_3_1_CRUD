package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User getUserById(long id);
    List<User> getUserList(int count);
    void deleteUser(long id);
    void addUser(User user);

    void updateUser(User user);

}
