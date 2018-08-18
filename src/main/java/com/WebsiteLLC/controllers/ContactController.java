package com.WebsiteLLC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping("/contact")
public class ContactController {


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Attorney Lisl King Williams, LLC");

        return "contact";
    }

}
