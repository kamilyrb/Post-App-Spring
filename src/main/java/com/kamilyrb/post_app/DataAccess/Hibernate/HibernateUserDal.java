package com.kamilyrb.post_app.DataAccess.Hibernate;

import com.kamilyrb.post_app.DataAccess.IUserDal;
import com.kamilyrb.post_app.Entities.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class HibernateUserDal implements IUserDal {
    private EntityManager entityManager;

    @Autowired
    public HibernateUserDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public User findByUsernameOrEmail(String userNameOrEmail) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from User as u where u.userName =: user_name_or_email or u.email =: user_name_or_email", User.class)
                .setParameter("user_name_or_email", userNameOrEmail).getSingleResult();
    }

    @Override
    @Transactional
    public User findById(long userId) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, userId);
    }

    @Override
    @Transactional
    public boolean existsByUsername(String username) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from User as u where u.userName =: user_name",User.class).setParameter("user_name", username).uniqueResult() != null;
    }

    @Override
    @Transactional
    public boolean existsByEmail(String email) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from User as u where u.email =: email",User.class).setParameter("email", email).uniqueResult() != null;
    }

    @Override
    @Transactional
    public User save(User user) {
        Session session = entityManager.unwrap(Session.class);
        Long userId =  (Long) session.save(user);
        user.setId(userId);
        return user;
    }
}
