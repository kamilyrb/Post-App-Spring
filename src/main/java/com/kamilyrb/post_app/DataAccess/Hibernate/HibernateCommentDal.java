package com.kamilyrb.post_app.DataAccess.Hibernate;

import com.kamilyrb.post_app.DataAccess.ICommentDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class HibernateCommentDal implements ICommentDal {
    private EntityManager entityManager;

    @Autowired
    public HibernateCommentDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
