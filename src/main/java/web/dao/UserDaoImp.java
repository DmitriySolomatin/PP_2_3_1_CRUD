package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import web.model.User;
import web.service.UserService;

import javax.persistence.EntityManager;
import javax.transaction.TransactionManager;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {
    @Autowired
    private EntityManager entityManager;

    UserDaoImp(){
        entityManager.persist(new User("Tony", "Stark", 50));
        entityManager.persist(new User("Thor", "Odinson", 1500));
        entityManager.persist(new User("Steven", "Rogers", 92));
    }

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getUserList(int count) {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void deleteUser(long id) {

    }

    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    public void addUser(User user) {
        entityManager.persist(user);
    }
}
