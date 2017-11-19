package com.example.BlogRestaurante.repositories;

import com.example.BlogRestaurante.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alexcuiza on 4/11/17.
 */
@Repository("RestaurantRepository")
public interface RestaurantRepository extends CrudRepository <Restaurant,Integer> {

    Restaurant findById(Integer id);

}
