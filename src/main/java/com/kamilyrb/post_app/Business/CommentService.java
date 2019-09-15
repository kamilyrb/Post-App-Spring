package com.kamilyrb.post_app.Business;

import com.kamilyrb.post_app.DataAccess.ICommentDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {
    private ICommentDal commentDal;

    @Autowired
    public CommentService(ICommentDal commentDal) {
        this.commentDal = commentDal;
    }
}
