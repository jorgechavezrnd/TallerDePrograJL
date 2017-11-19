package com.example.BlogRestaurante.controllers;

import com.example.BlogRestaurante.entities.User;
import com.example.BlogRestaurante.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("user", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
        User userExists = userService.findUserByEmail(user.getEmail());

        if (userExists != null) {
            bindingResult.rejectValue("email", "error.user", "There is already a user registered with the email provided");
        }

        user.setActive(true);
        userService.saveUser(user);
        model.addAttribute("successMessage", "El usuario se registro correctamente");
        model.addAttribute("user", new User());

        return "registration";
    }

    @RequestMapping(value="/default", method = RequestMethod.GET)
    public String defaultAfterLogin()
    {
        Set<String> roles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        if (roles.contains("ADMIN")) {
            return "redirect:/admin/home";
        }
        return "redirect:/user/home";
    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public String home(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("userName", "Bienvenido " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        model.addAttribute("userList", userService.listAllUsers());
        model.addAttribute("user", user);

        return "/admin/home";
    }

    @RequestMapping(value="/user/home", method = RequestMethod.GET)
    public String homeExclusive(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        if (user == null) {
            return "redirect:/";
        }

        return "/user/home";
    }
}