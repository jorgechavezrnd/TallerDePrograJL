package com.example.BlogRestaurante.entities;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by alexcuiza on 4/11/17.
 */
@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1,max = 20,message = "Debe ser mayor a 1 y menor a 20 letras")
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(min = 1,max = 20,message = "Debe ser mayor a 1 y menor a 20 letras")
    @Column(name = "address")
    private String address;

    @NotNull
    @Size(min = 1,max = 20,message = "Debe ser mayor a 1 y menor a 20 letras")
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(min = 1,max = 100,message = "Debe ser mayor a 1 y menor a 100 letras")
    @Column(name = "description")
    private String description;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "cell")
    private Integer cell;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getCell() {
        return cell;
    }

    public void setCell(Integer cell) {
        this.cell = cell;
    }
}
