package com.example.BlogRestaurante.controllers;

import com.example.BlogRestaurante.entities.Choice;
import com.example.BlogRestaurante.services.ChoiceService;
import com.example.BlogRestaurante.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by alexcuiza on 4/11/17.
 */
@Controller
public class OptionController {
    @Autowired
    private ChoiceService choiceService;
    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value="/choices",method = RequestMethod.GET)
    public String listas (Model model)
    {
        model.addAttribute("choices", choiceService.listAllOptions());

        return "options";
    }
    @RequestMapping(value = "/choice/{id}", method = RequestMethod.GET)
    public String showChoice(@PathVariable Integer id, Model model) {
        //choice es un objeto que hace referencia al html
        model.addAttribute("choice", choiceService.getRestaurantById(id));
        return "mostrarChoices";
    }

    @RequestMapping(value = "/choice/new", method = RequestMethod.GET)
    public String newChoice(Model model) {
        model.addAttribute("choice", new Choice());
        model.addAttribute("restaurants", restaurantService.listAllRestaurants());

        return "newChoice";
    }

    @RequestMapping(value = "/choice", method = RequestMethod.POST)
    public String save(@Valid Choice choice, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("restaurants", restaurantService.listAllRestaurants());
            return "newChoice";
        }
        choiceService.saveRestaurant(choice);
        return "redirect:/choices";
    }

    @RequestMapping(value = "/choice/edit/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable Integer id, Model model) {
        model.addAttribute("choice", choiceService.getRestaurantById(id));
        model.addAttribute("restaurants", restaurantService.listAllRestaurants());
        return "newChoice";
    }
    @RequestMapping(value = "/choice/delete/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable Integer id, Model model) {
        choiceService.deleteRestaurant(id);
        return "redirect:/choices";
    }

}
