package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import web.model.User;
import web.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getUserList(int count) {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(User user) {
        //Не пойму как тут реализовать без сеттеров, persist(user) не работает
//        User needUpdate = entityManager.find(User.class, user.getId());
        entityManager.merge(user);
//        needUpdate.setName(user.getName());
//        needUpdate.setLastName(user.getLastName());
//        needUpdate.setAge(user.getAge());
    }
}
