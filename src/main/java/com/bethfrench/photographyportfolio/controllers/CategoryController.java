package com.bethfrench.photographyportfolio.controllers;

import com.bethfrench.photographyportfolio.models.MyUserPrincipal;
import com.bethfrench.photographyportfolio.models.Photograph;
import com.bethfrench.photographyportfolio.models.dao.PhotographRepository;
import com.bethfrench.photographyportfolio.models.navbar.NavBarLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static com.bethfrench.photographyportfolio.models.navbar.NavBarData.makeMyNavBar;

@Controller
public class CategoryController {

    @Autowired
    PhotographRepository photographRepository;

    @RequestMapping (value="categories")
    public String displayCategories(Model model, HttpServletRequest request) {

            HttpSession mySession = request.getSession();
            model.addAttribute("session", mySession);

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username;
            if (principal instanceof MyUserPrincipal) {
                username = ((MyUserPrincipal) principal).getUsername();
            } else {
                username = principal.toString();
            }

            model.addAttribute("username", username);
            ArrayList<NavBarLink> navBarYo = new ArrayList<>();
            makeMyNavBar(navBarYo);
            model.addAttribute("navBarYo", navBarYo);

        return "display-categories";

        }

    @RequestMapping (value="categories/red")
    public String displayCategoriesRed(Model model, HttpServletRequest request) {
        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("username", username);

        ArrayList<NavBarLink> navBarYo = new ArrayList<>();
        makeMyNavBar(navBarYo);
        model.addAttribute("navBarYo", navBarYo);

        Iterable<Photograph> photographs = photographRepository.findAll();
        ArrayList<Photograph> redPhotographs = new ArrayList<Photograph>();
        for (Photograph photograph : photographs) {
            if (photograph.color.equals("red")) {
                redPhotographs.add(photograph);
            }
        }

        model.addAttribute("photographs", redPhotographs);

        return "category-page";
    }

    @RequestMapping (value="categories/black")
    public String displayCategoriesBlack(Model model, HttpServletRequest request) {

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("username", username);


        ArrayList<NavBarLink> navBarYo = new ArrayList<>();
        makeMyNavBar(navBarYo);
        model.addAttribute("navBarYo", navBarYo);

        Iterable<Photograph> photographs = photographRepository.findAll();
        ArrayList<Photograph> blackPhotographs = new ArrayList<Photograph>();
        for (Photograph photograph : photographs) {
            if (photograph.color.equals("black")) {
                blackPhotographs.add(photograph);
            }
        }

        model.addAttribute("photographs", blackPhotographs);

        return "category-page";
    }

    @RequestMapping (value="categories/blue")
    public String displayCategoriesBlue(Model model, HttpServletRequest request) {

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("username", username);


        ArrayList<NavBarLink> navBarYo = new ArrayList<>();
        makeMyNavBar(navBarYo);
        model.addAttribute("navBarYo", navBarYo);
        model.addAttribute("navBarYo", navBarYo);


        Iterable<Photograph> photographs = photographRepository.findAll();
        ArrayList<Photograph> bluePhotographs = new ArrayList<Photograph>();
        for (Photograph photograph : photographs) {
            if (photograph.color.equals("blue")) {
                bluePhotographs.add(photograph);
            }
        }

        model.addAttribute("photographs", bluePhotographs);

        return "category-page";
    }

    @RequestMapping (value="categories/brown")
    public String displayCategoriesBrown(Model model, HttpServletRequest request) {

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("username", username);


        ArrayList<NavBarLink> navBarYo = new ArrayList<>();
        makeMyNavBar(navBarYo);
        model.addAttribute("navBarYo", navBarYo);


        Iterable<Photograph> photographs = photographRepository.findAll();
        ArrayList<Photograph> brownPhotographs = new ArrayList<Photograph>();
        for (Photograph photograph : photographs) {
            if (photograph.color.equals("brown")) {
                brownPhotographs.add(photograph);
            }
        }

        model.addAttribute("photographs", brownPhotographs);
        return "category-page";
    }

    @RequestMapping (value="categories/green")
    public String displayCategoriesGreen(Model model, HttpServletRequest request) {

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("username", username);

        ArrayList<NavBarLink> navBarYo = new ArrayList<>();
        makeMyNavBar(navBarYo);
        model.addAttribute("navBarYo", navBarYo);


        Iterable<Photograph> photographs = photographRepository.findAll();
        ArrayList<Photograph> greenPhotographs = new ArrayList<Photograph>();
        for (Photograph photograph : photographs) {
            if (photograph.color.equals("green")) {
                greenPhotographs.add(photograph);
            }
        }

        model.addAttribute("photographs", greenPhotographs);
        return "category-page";
    }

    @RequestMapping (value="categories/orange")
    public String displayCategoriesOrange(Model model, HttpServletRequest request) {

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("username", username);


        ArrayList<NavBarLink> navBarYo = new ArrayList<>();
        makeMyNavBar(navBarYo);
        model.addAttribute("navBarYo", navBarYo);

        Iterable<Photograph> photographs = photographRepository.findAll();
        ArrayList<Photograph> orangePhotographs = new ArrayList<Photograph>();
        for (Photograph photograph : photographs) {
            if (photograph.color.equals("orange")) {
                orangePhotographs.add(photograph);
            }
        }

        model.addAttribute("photographs", orangePhotographs);
        return "category-page";
    }

    @RequestMapping (value="categories/pink")
    public String displayCategoriesPink(Model model, HttpServletRequest request) {

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("username", username);


        ArrayList<NavBarLink> navBarYo = new ArrayList<>();
        makeMyNavBar(navBarYo);
        model.addAttribute("navBarYo", navBarYo);

        Iterable<Photograph> photographs = photographRepository.findAll();
        ArrayList<Photograph> pinkPhotographs = new ArrayList<Photograph>();
        for (Photograph photograph : photographs) {
            if (photograph.color.equals("pink")) {
                pinkPhotographs.add(photograph);
            }
        }

        model.addAttribute("photographs", pinkPhotographs);

        return "category-page";
    }

    @RequestMapping (value="categories/white")
    public String displayCategoriesWhite(Model model, HttpServletRequest request) {

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("username", username);


        ArrayList<NavBarLink> navBarYo = new ArrayList<>();
        makeMyNavBar(navBarYo);
        model.addAttribute("navBarYo", navBarYo);


        Iterable<Photograph> photographs = photographRepository.findAll();
        ArrayList<Photograph> whitePhotographs = new ArrayList<Photograph>();
        for (Photograph photograph : photographs) {
            if (photograph.color.equals("white")) {
                whitePhotographs.add(photograph);
            }
        }

        model.addAttribute("photographs", whitePhotographs);

        return "category-page";
    }

    @RequestMapping (value="categories/yellow")
    public String displayCategoriesYellow(Model model, HttpServletRequest request) {

        HttpSession mySession = request.getSession();
        model.addAttribute("session", mySession);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("username", username);

        ArrayList<NavBarLink> navBarYo = new ArrayList<>();
        makeMyNavBar(navBarYo);
        model.addAttribute("navBarYo", navBarYo);


        Iterable<Photograph> photographs = photographRepository.findAll();
        ArrayList<Photograph> yellowPhotographs = new ArrayList<Photograph>();
        for (Photograph photograph : photographs) {
            if (photograph.color.equals("yellow")) {
                yellowPhotographs.add(photograph);
            }
        }

        model.addAttribute("photographs", yellowPhotographs);

        return "category-page";
    }
}
