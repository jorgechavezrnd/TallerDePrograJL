package com.example.BlogRestaurante.services;

import com.example.BlogRestaurante.entities.Restaurant;
import com.example.BlogRestaurante.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alexcuiza on 4/11/17.
 */
@Service("RestaurantService")
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Iterable<Restaurant> listAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }



    @Override
    public Restaurant getRestaurantById(Integer id) {
        return restaurantRepository.findOne(id);
    }

    @Override
    public void deleteRestaurant(Integer id) {
        restaurantRepository.delete(id);
    }

    @Override
    public void saveRestaurantEdited(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

}
