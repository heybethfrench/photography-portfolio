package com.bethfrench.photographyportfolio.models.navbar;

import com.bethfrench.photographyportfolio.models.MyUserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;


import java.util.ArrayList;

public class NavBarData <T extends NavBarLink> {

    public static NavBarLink login = new NavBarLink("Login", "/login");
    public static NavBarLink categories = new NavBarLink("Categories", "/categories");
    public static NavBarLink signup = new NavBarLink("Signup", "/signup");
    public static NavBarLink logout = new NavBarLink("Logout", "/logout");
    public static NavBarLink fileUpload = new NavBarLink("Upload Photo", "/file");
    public static NavBarLink profile = new NavBarLink("My Profile", "/profile");


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
            navBarYo.add(profile);
        } if (username.equals("admin@admin.com")){
            navBarYo.add(fileUpload);
        }




    }

}
