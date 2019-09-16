package com.kamilyrb.post_app.DataAccess;

import com.kamilyrb.post_app.Entities.User;

public interface IUserDal {
    User findByUsernameOrEmail(String userNameOrEmail);
    User findById(long userId);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User save(User user);


}
