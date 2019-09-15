package com.kamilyrb.post_app.Business;

import com.kamilyrb.post_app.DataAccess.IPostDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements  IPostService {
    private IPostDal postDal;

    @Autowired
    public PostService(IPostDal postDal) {
        this.postDal = postDal;
    }
}
