package com.WebsiteLLC.controllers;


import com.WebsiteLLC.data.ClientsDao;
import com.WebsiteLLC.data.AdministratorDao;
import com.WebsiteLLC.forms.ClientType;
import com.WebsiteLLC.forms.Clients;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.aspectj.weaver.ast.Var;
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


    /*public void sortTable(Model model, @RequestParam Var clientList){

        var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
        table = document.getElementById("myTable2");
        switching = true;
        // Set the sorting direction to ascending:
        dir = "asc";
          *//* Make a loop that will continue until
          no switching has been done: *//*
        while (switching) {
            // Start by saying: no switching is done:
            switching = false;
            rows = table.rows;
            *//* Loop through all table rows (except the
            first, which contains table headers): *//*
            for (i = 1; i < (rows.length - 1); i++) {
                // Start by saying there should be no switching:
                shouldSwitch = false;
      *//* Get the two elements you want to compare,
      one from current row and one from the next: *//*
                x = rows[i].getElementsByTagName("TD")[n];
                y = rows[i + 1].getElementsByTagName("TD")[n];
      *//* Check if the two rows should switch place,
      based on the direction, asc or desc: *//*
                if (dir == "asc") {
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                } else if (dir == "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                }
            }
            if (shouldSwitch) {
      *//* If a switch has been marked, make the switch
      and mark that a switch has been done: *//*
                rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                switching = true;
                // Each time a switch is done, increase this count by 1:
                switchcount ++;
            } else {
      *//* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. *//*
                if (switchcount == 0 && dir == "asc") {
                    dir = "desc";
                    switching = true;
                }
            }
        }
    }*/
}

