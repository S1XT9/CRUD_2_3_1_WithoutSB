package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryClass implements UserRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void create(User user) {
        em.persist(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User read(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        User removeUser = em.find(User.class, id);
        em.remove(removeUser);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> allUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}
