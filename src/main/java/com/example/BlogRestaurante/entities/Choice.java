package com.example.BlogRestaurante.entities;

import javax.persistence.*;

/**
 * Created by alexcuiza on 4/11/17.
 */
@Entity
@Table(name = "choice")
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nombre")
    private String nombre_Opcion;
    @Column(name = "precio")
    private Integer precio_Opcion;



    @ManyToOne
    @JoinColumn(name = "category_restaurant")
    private Restaurant category_restaurant;

    public Restaurant getCategory_restaurant() {
        return category_restaurant;
    }

    public void setCategory_restaurant(Restaurant category_restaurant) {
        this.category_restaurant = category_restaurant;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_Opcion() {
        return nombre_Opcion;
    }

    public void setNombre_Opcion(String nombre_Opcion) {
        this.nombre_Opcion = nombre_Opcion;
    }

    public Integer getPrecio_Opcion() {
        return precio_Opcion;
    }

    public void setPrecio_Opcion(Integer precio_Opcion) {
        this.precio_Opcion = precio_Opcion;
    }
}
