package com.kamilyrb.post_app.RestApi;

import com.kamilyrb.post_app.Business.ICommentService;
import com.kamilyrb.post_app.Business.IPostService;
import com.kamilyrb.post_app.Business.IUserService;
import com.kamilyrb.post_app.Payload.UserSummary;
import com.kamilyrb.post_app.security.CurrentUser;
import com.kamilyrb.post_app.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private IUserService userService;
    private ICommentService commentService;
    private IPostService postService;


    @Autowired
    public UserController(IUserService userService, ICommentService commentService, IPostService postService) {
        this.userService = userService;
        this.commentService = commentService;
        this.postService = postService;
    }


    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
    }


}
