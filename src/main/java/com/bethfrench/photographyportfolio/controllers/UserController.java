package com.bethfrench.photographyportfolio.controllers;

import com.bethfrench.photographyportfolio.SignupForm.SignupForm;
import com.bethfrench.photographyportfolio.models.MyGrantAuthority;
import com.bethfrench.photographyportfolio.models.MyUserPrincipal;
import com.bethfrench.photographyportfolio.models.User;
import com.bethfrench.photographyportfolio.models.dao.MyGrantAuthorityRepository;
import com.bethfrench.photographyportfolio.models.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyGrantAuthorityRepository grantRepo;

    @GetMapping("/login")
    public String getLoginPage(Model model, HttpServletRequest request) {

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);

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
        } if (!username.equals("anonymousUser")) {
            navBarYo.add("/categories");
            navBarYo.add("/logout");
        } if (username.equals("admin@admin")){
            navBarYo.add("/file");
        }

        model.addAttribute("navBarYo", navBarYo);


        return "login";
    }

    @GetMapping("/signup")
    public String getSignupPage(Model model, HttpServletRequest request) {
        model.addAttribute(new SignupForm());

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);

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
        } if (!username.equals("anonymousUser")) {
            navBarYo.add("/categories");
            navBarYo.add("/logout");
        } if (username.equals("admin@admin")){
            navBarYo.add("/file");
        }

        model.addAttribute("navBarYo", navBarYo);


        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(
            HttpServletRequest request,
            @ModelAttribute @Valid SignupForm form,
            Errors errors,
            Model model
    ) {

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);

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



        if (errors.hasErrors()) {
            model.addAttribute("signupForm", form);
            return "signup";
        }

        if (!form.passwordsMatch()) {
            model.addAttribute("signupForm", form);
            model.addAttribute("error", "Passwords do not match");
            return "signup";
        }

        if (userRepository.findByUsername(form.getUsername()) != null) {
            model.addAttribute("signupForm", form);
            model.addAttribute("error", "User already exists");
            return "signup";
        }


        // Create user
        Set<MyGrantAuthority> grants = new HashSet<>();
        grants.add(grantRepo.getByRole("USER"));
        User user = new User(form.getUsername(), grants, form.getPassword());
        userRepository.save(user);

        // Add user to session
        try {
            request.login(form.getUsername(), form.getPassword());
        } catch (ServletException e) {
            System.out.println("Failed to add user to session: " + e.toString());
        }
        return "redirect:/";


    }
    @GetMapping("/logout")
    public String processLogout(Model model, HttpServletRequest request) {

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);

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
        } if (!username.equals("anonymousUser")) {
            navBarYo.add("categories");
            navBarYo.add("logout");
        } if (username.equals("admin@admin")){
            navBarYo.add("file");
        }

        model.addAttribute("navBarYo", navBarYo);

        return "logout";
    }

    @PostMapping("/logout")
    public String successfulLogout() {



        return "redirect:";
    }

}

