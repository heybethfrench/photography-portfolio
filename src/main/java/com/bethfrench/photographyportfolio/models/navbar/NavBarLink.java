package com.bethfrench.photographyportfolio.models.navbar;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class NavBarLink {

    @Id
    @GeneratedValue
    private int id;

    public String name;
    public String path;

    public NavBarLink(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
