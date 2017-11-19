package com.example.BlogRestaurante.repositories;

import com.example.BlogRestaurante.entities.Choice;
import com.example.BlogRestaurante.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

@Transactional
public interface PedidoRepository extends JpaRepository<Pedido,Integer>{

    Pedido findById(Integer id);
}
