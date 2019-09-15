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
        return session.createQuery("from User where user.userName =: user_name_or_email or user.email =: user_name_or_email",User.class)
                .setParameter("user_name_or_email", userNameOrEmail).getSingleResult();
    }

    @Override
    @Transactional
    public User findById(long userId) {
        Session session = entityManager.unwrap(Session.class);
       return session.get(User.class, userId);
    }
}
