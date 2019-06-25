package com.bethfrench.photographyportfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping(value="signup")
    public String signUp() {
        return "signup";
    }

    @RequestMapping(value="login")
    public String logIn() {
        return "login";
    }

    @RequestMapping(value="logout")
    public String logOut() {
        return "logout";
    }


}
