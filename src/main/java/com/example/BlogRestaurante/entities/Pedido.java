package com.example.BlogRestaurante.entities;

import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombredepedido")
    private String nombre_Pedido;
    @Column(name = "preciopedido")
    private Integer precio_Pedido;

    @Column(name = "direccion")
    private String direccion;


    @ManyToOne
    @JoinColumn(name = "category_restaurant")
    private Restaurant category_restaurant = null;

    @ManyToOne
    @JoinColumn(name = "category_choice")
    private Choice category_choice;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_Pedido() {
        return nombre_Pedido;
    }

    public void setNombre_Pedido(String nombre_Pedido) {
        this.nombre_Pedido = nombre_Pedido;
    }

    public Integer getPrecio_Pedido() {
        return precio_Pedido;
    }

    public void setPrecio_Pedido(Integer precio_Pedido) {
        this.precio_Pedido = precio_Pedido;
    }

    public Restaurant getCategory_restaurant() {
        return category_restaurant;
    }

    public void setCategory_restaurant(Restaurant category_restaurant) {
        this.category_restaurant = category_restaurant;
    }


    public Choice getCategory_choice() {
        return category_choice;
    }

    public void setCategory_choice(Choice category_choice) {
        this.category_choice = category_choice;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
