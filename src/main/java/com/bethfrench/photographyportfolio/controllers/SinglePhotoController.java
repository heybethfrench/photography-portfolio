package com.bethfrench.photographyportfolio.controllers;

import com.bethfrench.photographyportfolio.models.Photograph;
import com.bethfrench.photographyportfolio.models.dao.PhotographRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class SinglePhotoController {

    @Autowired
    private PhotographRepository photographRepository;

        @RequestMapping(value="photo")
        public String singlePhoto(Model model) {
            Iterable<Photograph> photographs = photographRepository.findAll();

            model.addAttribute("photographs", photographs);

            return "singlephoto";

    }

}
