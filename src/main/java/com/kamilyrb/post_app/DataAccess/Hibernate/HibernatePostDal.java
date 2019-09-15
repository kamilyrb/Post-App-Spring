package com.kamilyrb.post_app.DataAccess.Hibernate;

import com.kamilyrb.post_app.DataAccess.IPostDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class HibernatePostDal implements IPostDal {

    private EntityManager entityManager;

    @Autowired
    public HibernatePostDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
