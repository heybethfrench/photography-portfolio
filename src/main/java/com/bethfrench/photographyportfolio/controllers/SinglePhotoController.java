package com.bethfrench.photographyportfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SinglePhotoController {

        @RequestMapping(value="photo")
        public String singlePhoto() {
        return "singlephoto";

    }

}
