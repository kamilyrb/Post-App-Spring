package com.kamilyrb.post_app.DataAccess;

import com.kamilyrb.post_app.Entities.User;

public interface IUserDal {
    User findByUsernameOrEmail(String userNameOrEmail);
    User findById(long userId);
}
