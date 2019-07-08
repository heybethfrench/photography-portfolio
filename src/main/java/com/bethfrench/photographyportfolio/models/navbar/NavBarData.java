package com.bethfrench.photographyportfolio.models.navbar;

import com.bethfrench.photographyportfolio.models.MyUserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;


import java.util.ArrayList;

public class NavBarData <T extends NavBarLink> {

    public static NavBarLink login = new NavBarLink("login", "/login");
    public static NavBarLink categories = new NavBarLink("categories", "/categories");
    public static NavBarLink signup = new NavBarLink("signup", "/signup");
    public static NavBarLink logout = new NavBarLink("logout", "/logout");
    public static NavBarLink fileUpload = new NavBarLink("file", "/file");


    public static void makeMyNavBar(ArrayList<NavBarLink> navBarYo) {




        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }

        if (username.equals("anonymousUser")) {
            navBarYo.add(categories);
            navBarYo.add(login);
            navBarYo.add(signup);
        }if (!username.equals("anonymousUser")) {
            navBarYo.add(categories);
            navBarYo.add(logout);
        } if (username.equals("admin@admin")){
            navBarYo.add(fileUpload);
        }




    }

}
