package com.WebsiteLLC.controllers;


import com.WebsiteLLC.data.ClientsDao;
import com.WebsiteLLC.data.AdministratorDao;
import com.WebsiteLLC.forms.ClientType;
import com.WebsiteLLC.forms.Clients;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "clients")
    public String login(Model model)       {

        model.addAttribute("clients", clientsDao.findAll());
        model.addAttribute("title", "Attorney Lisl King Williams, LLC");

        return "admin/clients";
    }

    @RequestMapping(value = "login-error")
    public String loginError(Model model){

        model.addAttribute("title", "Attorney Lisl King Williams, LLC");
        model.addAttribute("error", "The username or password you entered was invalid");

        return "admin/clients";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String createNewClient(Model model){

        model.addAttribute(new Clients());
        model.addAttribute("title", "Attorney Lisl King Williams, LLC");
        model.addAttribute("statuses", ClientType.values());

        return "admin/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addClient(Model model, @ModelAttribute @Valid Clients clients, Errors errors){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Attorney Lisl King Williams, LLC");
            return "admin/add";
        }

        model.addAttribute("title", "Attorney Lisl King Williams, LLC");
        clientsDao.save(clients);

        return "admin/clients";
    }


    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(Model model){

        return "redirect:/";
    }
}

