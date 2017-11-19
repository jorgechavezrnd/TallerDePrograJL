package com.example.BlogRestaurante.controllers;

import com.example.BlogRestaurante.entities.Restaurant;
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
public class RestaurantController {
    private RestaurantService restaurantService;

    /** MUESTRA EL DETALLE DE UN RESTAURANTE **/
    @Autowired
    public void setRestaurantService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    /** MUESTRA LA LISTA DE LOS RESTAURANTES REGISTRADOS **/
    @RequestMapping(value = "/admin/restaurants",  method = RequestMethod.GET)
    public String listRestaurants(Model model) {
        model.addAttribute("restaurants", restaurantService.listAllRestaurants());
        return "restauranteLista";
    }

    /** MUESTRA UN DETALLE DE RESTAURANTE REGISTRO **/
    @RequestMapping(value = "/admin/restaurant/{id}", method = RequestMethod.GET)
    public String showRestaurant(@PathVariable Integer id, Model model) {
        Restaurant restaurant=restaurantService.getRestaurantById(id);
        model.addAttribute("restaurant", restaurant);
        return "restaurant";
    }

    /** ELMINA UN REGISTRO DE RESTAURANTE **/
    @RequestMapping(value = "/admin/restaurant/delete/{id}", method = RequestMethod.GET)
    public String deleteRestaurant(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
        return "redirect:/admin/restaurants";
    }

    /** REGISTRA UN NUEVO RESTAURANTE **/
    @RequestMapping(value = "/admin/restaurant/new", method = RequestMethod.GET)
    public String newRestaurant(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "restauranteNewFormulario";
    }
    /** MODIFICA REGISTRO DE RESTAURANTE **/
    @RequestMapping(value = "/admin/restaurant/edit/{id}", method = RequestMethod.GET)
    public String editRestaurant(@PathVariable Integer id, Model model) {
        model.addAttribute("restaurant", restaurantService.getRestaurantById(id));
        return "restauranteNewFormulario";
    }

    /** ALMACENA EL REGISTRO DE UN RESTAURANTE EN LA BDS **/
    @RequestMapping(value = "/admin/restaurant", method = RequestMethod.POST)
    public String saveRestaurant(@Valid Restaurant restaurant, BindingResult bindingResult,Model model) {
        if(bindingResult.hasErrors()){
            return "restauranteNewFormulario";
        }
        restaurantService.saveRestaurant(restaurant);
        return "redirect:/admin/restaurants";
    }
}
