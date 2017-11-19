package com.example.BlogRestaurante.services;

import com.example.BlogRestaurante.entities.Choice;

/**
 * Created by alexcuiza on 4/11/17.
 */
public interface ChoiceService {

    Iterable<Choice> listAllOptions();
    //Iterable<Choice> listOptionsById(Integer id);
    Choice getRestaurantById(Integer id);
    Choice saveRestaurant(Choice option);
    void deleteRestaurant(Integer id);
}
