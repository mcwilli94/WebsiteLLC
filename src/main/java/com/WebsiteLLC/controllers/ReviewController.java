package com.WebsiteLLC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.WebsiteLLC.data.UsersDao;
import com.WebsiteLLC.forms.Users;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("reviews")

public class ReviewController {

    @Autowired
    private UsersDao usersDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("users", usersDao.findAll());
        model.addAttribute("title", "Attorney Lisl King Williams, LLC");

        return "reviews";
    }

    @RequestMapping(value = "newPost", method = RequestMethod.GET)
    public String createNewPost(Model model){

        model.addAttribute(new Users());
        model.addAttribute("title", "Attorney Lisl King Williams, LLC");

        return "reviews/newPost";
    }

    @RequestMapping(value = "newPost", method = RequestMethod.POST)
    public String processNewPost(Model model, @ModelAttribute @Valid Users users, Errors errors) {

        model.addAttribute("title", "Attorney Lisl King Williams, LLC");

        if (errors.hasErrors()){
            return "reviews/newPost";
        }

        for (Users reviewers : usersDao.findAll()) {
            if (reviewers.getUsername() == users.getUsername()) {
                model.addAttribute("error", "The number of posts per user is limited to one");
                return "reviews/newPost";
            }
        }

        usersDao.save(users);

        return "redirect:";
    }
}
