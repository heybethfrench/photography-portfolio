package com.bethfrench.photographyportfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @RequestMapping (value="categories")
    public String displayCategories() {
        return "display-categories";

    }
}