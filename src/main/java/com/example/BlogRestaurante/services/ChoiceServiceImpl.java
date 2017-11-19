package com.example.BlogRestaurante.services;

import com.example.BlogRestaurante.entities.Choice;
import com.example.BlogRestaurante.repositories.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alexcuiza on 4/11/17.
 */
@Service
public class ChoiceServiceImpl implements ChoiceService {

    @Autowired
    ChoiceRepository choiceRepository;

    @Override
    public Iterable<Choice> listAllOptions() {
        return choiceRepository.findAll();
    }

    /*
    @Autowired
    public Iterable<Choice> listOptionsById(Integer id) {return choiceRepository.findAll(); }
*/
    @Override
    public Choice getRestaurantById(Integer id) {
        return choiceRepository.findById(id);
    }

    @Override
    public Choice saveRestaurant(Choice option) {
        return choiceRepository.save(option);
    }

    @Override
    public void deleteRestaurant(Integer id) {

        choiceRepository.delete(id);
    }
}
