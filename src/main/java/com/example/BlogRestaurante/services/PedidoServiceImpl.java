package com.example.BlogRestaurante.services;

import com.example.BlogRestaurante.entities.Pedido;
import com.example.BlogRestaurante.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    PedidoRepository pedidoRepository;


    @Override
    public Iterable<Pedido> listAllOptions(){return pedidoRepository.findAll();}

    @Override
    public Pedido getRestaurantById(Integer id){return pedidoRepository.findById(id);}

    @Override
    public Pedido saveRestaurant(Pedido option){return pedidoRepository.save(option);}

    @Override
    public void deleteRestaurant(Integer id){
        pedidoRepository.delete(id);
    }


}
