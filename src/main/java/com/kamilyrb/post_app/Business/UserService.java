package com.kamilyrb.post_app.Business;

import com.kamilyrb.post_app.DataAccess.IUserDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private IUserDal userDal;


    @Autowired
    public UserService(IUserDal userDal) {
        this.userDal = userDal;
    }
}
