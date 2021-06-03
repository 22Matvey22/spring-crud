package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class JPAUserDAO implements UserDAO {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void removeUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public User getUserById(long id) {
        TypedQuery<User> userTypedQuery = entityManager.createQuery("select  u from User u where u.id = : id", User.class);
        userTypedQuery.setParameter("id", id);
        return userTypedQuery.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
