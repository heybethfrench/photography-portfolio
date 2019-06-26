package com.bethfrench.photographyportfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @RequestMapping (value="categories")
    public String displayCategories() {
        return "display-categories";

    }

    @RequestMapping (value="categories/red")
    public String displayCategoriesRed() {
        return "category-page";
    }

    @RequestMapping (value="categories/black")
    public String displayCategoriesBlack() {
        return "category-page";
    }

    @RequestMapping (value="categories/blue")
    public String displayCategoriesBlue() {
        return "category-page";
    }

    @RequestMapping (value="categories/brown")
    public String displayCategoriesBrown() {
        return "category-page";
    }

    @RequestMapping (value="categories/green")
    public String displayCategoriesGreen() {
        return "category-page";
    }

    @RequestMapping (value="categories/orange")
    public String displayCategoriesOrange() {
        return "category-page";
    }

    @RequestMapping (value="categories/pink")
    public String displayCategoriesPink() {
        return "category-page";
    }

    @RequestMapping (value="categories/white")
    public String displayCategoriesWhite() {
        return "category-page";
    }

    @RequestMapping (value="categories/yellow")
    public String displayCategoriesYellow() {
        return "category-page";
    }
}