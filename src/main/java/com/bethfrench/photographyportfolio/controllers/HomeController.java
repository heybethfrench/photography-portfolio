package com.bethfrench.photographyportfolio.controllers;


import com.bethfrench.photographyportfolio.models.navbar.NavBarLink;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

import static com.bethfrench.photographyportfolio.models.navbar.NavBarData.makeMyNavBar;

@Controller
public class HomeController {


    @RequestMapping(value = "")
    public String mainPage(Model model) {

        ArrayList<NavBarLink> navBarYo = new ArrayList<>();
        makeMyNavBar(navBarYo);
        model.addAttribute("navBarYo", navBarYo);


        return "index";

    }

}

