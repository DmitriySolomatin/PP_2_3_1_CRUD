package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import web.model.User;
import web.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getUserList(int count) {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Transactional
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void updateUser(User user) {
        //Не пойму как тут реализовать без сеттеров, persist(user) не работает
        User needUpdate = entityManager.find(User.class, user.getId());
        needUpdate.setName(user.getName());
        needUpdate.setLastName(user.getLastName());
        needUpdate.setAge(user.getAge());
    }
}
