package com.bethfrench.photographyportfolio.controllers;


import com.bethfrench.photographyportfolio.models.MyUserPrincipal;
import com.bethfrench.photographyportfolio.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class HomeController {


    @RequestMapping(value = "")
    public String mainPage(Model model, HttpServletRequest request) {

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);

        System.out.println(mySession);

        ArrayList<String> navBarYo = new ArrayList<String>();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("username", username);


        if (username.equals("anonymousUser")) {
            navBarYo.add("categories");
            navBarYo.add("login");
            navBarYo.add("signup");
        }if (!username.equals("anonymousUser")) {
                navBarYo.add("categories");
                navBarYo.add("logout");
        } if (username.equals("admin@admin")){
                navBarYo.add("file");
        }

        model.addAttribute("navBarYo", navBarYo);
        System.out.println(navBarYo);
        return "index";

        }


    }

