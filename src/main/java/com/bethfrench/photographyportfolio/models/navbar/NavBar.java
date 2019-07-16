package com.bethfrench.photographyportfolio.models.navbar;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class NavBar {

    @Id
    @GeneratedValue
    private int id;

    private NavBarLink login;
    private NavBarLink logout;
    private NavBarLink categories;
    private NavBarLink file;
    private NavBarLink profile;

    private static NavBar ourInstance = new NavBar();

    public static NavBar getInstance() {
        return ourInstance;
    }

    public NavBar() {
    }

    public NavBar(NavBarLink login, NavBarLink logout, NavBarLink categories, NavBarLink file, NavBarLink profile) {
        this.login = login;
        this.logout = logout;
        this.categories = categories;
        this.file = file;
        this.profile = profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NavBarLink getLogin() {
        return login;
    }

    public void setLogin(NavBarLink login) {
        this.login = login;
    }

    public NavBarLink getLogout() {
        return logout;
    }

    public void setLogout(NavBarLink logout) {
        this.logout = logout;
    }

    public NavBarLink getCategories() {
        return categories;
    }

    public void setCategories(NavBarLink categories) {
        this.categories = categories;
    }

    public NavBarLink getFile() {
        return file;
    }

    public void setFile(NavBarLink file) {
        this.file = file;
    }

    public static NavBar getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(NavBar ourInstance) {
        NavBar.ourInstance = ourInstance;
    }
}
