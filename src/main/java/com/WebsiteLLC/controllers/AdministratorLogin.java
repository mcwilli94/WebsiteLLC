package com.WebsiteLLC.controllers;


import com.WebsiteLLC.data.ClientsDao;
import com.WebsiteLLC.data.AdministratorDao;
import com.WebsiteLLC.forms.ClientType;
import com.WebsiteLLC.forms.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;


@Controller
@RequestMapping("/admin")
public class AdministratorLogin {

    @Autowired
    private ClientsDao clientsDao;

    @Autowired
    private AdministratorDao adminDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Attorney Lisl King Williams, LLC");

        return "admin/administratorLogin";
    }

    @RequestMapping(value = "clients", method = RequestMethod.GET)
    public String login(Model model)       {

        model.addAttribute("title", "Attorney Lisl King Williams, LLC");

        return "admin/clients";
    }


    @RequestMapping(value = "clients", method = RequestMethod.POST)
    public String validateLogin(Model model, @Valid String username, @Valid String password){

        if (username.equals(adminDao.findOne(1).getAdministrator())&& password.equals(adminDao.findOne(1).getPassword())){
            model.addAttribute("clients", clientsDao.findAll());
            model.addAttribute("title", "Attorney Lisl King Williams, LLC");

            return "admin/clients";
        }
        else {
            model.addAttribute("title","Attorney Lisl King Williams, LLC");
            model.addAttribute("error", "Username or password is incorrect");
            return "admin/administratorLogin";
        }
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String createNewClient(Model model){

        model.addAttribute(new Clients());
        model.addAttribute("title", "Attorney Lisl King Williams, LLC");
        model.addAttribute("clientStatus", ClientType.values());

        return "admin/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addClient(Model model, @ModelAttribute @Valid Clients newClient, Errors errors){

        System.out.println("running");
        System.out.println(errors);
        System.out.println(newClient);

        if (errors.hasErrors()) {
            model.addAttribute("title", "Attorney Lisl King Williams, LLC");
            return "admin/add";
        }

        model.addAttribute("title", "Attorney Lisl King Williams, LLC");
        clientsDao.save(newClient);

        return "admin/clients";
    }


}

