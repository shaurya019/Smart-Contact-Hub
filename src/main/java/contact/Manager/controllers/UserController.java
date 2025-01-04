package contact.Manager.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import contact.Manager.entities.User;
import contact.Manager.helpers.Helper;
import contact.Manager.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // user dashbaord page

    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        System.out.println("User dashboard");
        return "user/dashboard";
    }

    // user profile page

    @RequestMapping(value = "/profile")
    public String userProfile(Authentication authentication) {
        String user = Helper.getEmailOfLoggedInUser(authentication);
        return "user/profile";
    }

    // user add contacts page

    // user view contacts

    // user edit contact

    // user delete contact

}