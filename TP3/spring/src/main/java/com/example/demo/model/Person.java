package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Person {

    @Id
    private int dni;
    @Column
    private String name;
    @Column
    private String surname;
    @ManyToOne
    private Address address;


    public Person() {
    }

    public Person(int dni, String name, String surname, String address) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
    }

}
