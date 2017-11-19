package com.example.BlogRestaurante.controllers;

import com.example.BlogRestaurante.entities.Choice;
import com.example.BlogRestaurante.entities.Pedido;

import com.example.BlogRestaurante.services.ChoiceService;
import com.example.BlogRestaurante.services.PedidoService;


import com.example.BlogRestaurante.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ChoiceService choiceService;

    @RequestMapping(value="/pedidos",method = RequestMethod.GET)
    public String listas (Model model)
    {
        model.addAttribute("pedidos", pedidoService.listAllOptions());

        return "optionsPedidos";
    }


    @RequestMapping(value = "/pedido/new", method = RequestMethod.GET)
    public String newPedido(Model model) {

        model.addAttribute("pedido", new Pedido());
        model.addAttribute("restaurants", restaurantService.listAllRestaurants());
        model.addAttribute("choices", choiceService.listAllOptions());

        return "newPedido";
    }


    @RequestMapping(value = "/pedido", method = RequestMethod.POST)
    public String save(@Valid Pedido pedido, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("restaurants", restaurantService.listAllRestaurants());
            return "newPedido";
        }
        pedidoService.saveRestaurant(pedido);

        return "redirect:/pedidos";
    }

    @RequestMapping(value = "/pedido/edit/{id}", method = RequestMethod.GET)
    public String editPedido(@PathVariable Integer id, Model model) {
        model.addAttribute("pedido", pedidoService.getRestaurantById(id));

        return "editDireccion";
    }

/*
    @RequestMapping(value = "/pedido/{id}", method = RequestMethod.GET)
    public String showChoice(@PathVariable Integer id, Model model) {

        model.addAttribute("pedido", pedidoService.getRestaurantById(id));
        model.addAttribute("choise",choiceService.getRestaurantById(id));
        return "mostrarChoices";
    }


*/
















}
