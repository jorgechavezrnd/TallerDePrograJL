package com.example.BlogRestaurante.services;

import com.example.BlogRestaurante.entities.Restaurant;

/**
 * Created by alexcuiza on 4/11/17.
 */
public interface RestaurantService {
    void saveRestaurant(Restaurant restaurant);
    Iterable<Restaurant> listAllRestaurants();
    Restaurant getRestaurantById(Integer id);
    void deleteRestaurant(Integer id);
    void saveRestaurantEdited(Restaurant restaurant);
}