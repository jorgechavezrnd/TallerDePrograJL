package com.example.BlogRestaurante.services;

import com.example.BlogRestaurante.entities.Pedido;


public interface PedidoService {

    Iterable<Pedido> listAllOptions();
    Pedido getRestaurantById(Integer id);
    Pedido saveRestaurant(Pedido option);
    void deleteRestaurant(Integer id);
}
