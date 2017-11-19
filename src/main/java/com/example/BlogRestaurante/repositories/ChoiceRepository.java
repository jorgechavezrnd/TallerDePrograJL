package com.example.BlogRestaurante.repositories;

import com.example.BlogRestaurante.entities.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by alexcuiza on 4/11/17.
 */
@Transactional
public interface ChoiceRepository extends JpaRepository<Choice, Integer>{
    Choice findById(Integer id);
}


