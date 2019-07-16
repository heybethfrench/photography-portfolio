package com.bethfrench.photographyportfolio.controllers;

import com.bethfrench.photographyportfolio.models.MyUserPrincipal;
import com.bethfrench.photographyportfolio.models.navbar.NavBarLink;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

import static com.bethfrench.photographyportfolio.models.navbar.NavBarData.makeMyNavBar;

@Controller
public class ProfileController {

    @GetMapping(value = "/profile")
    public String mainPage(Model model) {

        ArrayList<NavBarLink> navBarYo = new ArrayList<>();
        String thisAddress;
        String thisUsername;
        String thisPhoneNumber;

        makeMyNavBar(navBarYo);
        model.addAttribute("navBarYo", navBarYo);


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof MyUserPrincipal) {
            thisUsername = ((MyUserPrincipal) principal).getUsername();
            thisAddress = ((MyUserPrincipal) principal).getAddress();
            thisPhoneNumber = ((MyUserPrincipal) principal).getPhoneNumber();
            System.out.println(thisAddress);
            model.addAttribute("thisAddress", thisAddress);
            model.addAttribute("thisUsername", thisUsername);
        } else {
            thisUsername = principal.toString();

        }


        return "profile";

    }

}
