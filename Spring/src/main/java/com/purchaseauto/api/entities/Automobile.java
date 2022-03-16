package com.purchaseauto.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "Automobiles")
public class Automobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String make;
    private int year;

    @Setter
    private Boolean accepted;

    public Automobile(String make, int year) {
        super();
        this.make = make;
        this.year = year;
    }

    public Automobile(String make, int year, Boolean accepted) {
        super();
        this.make = make;
        this.year = year;
        this.accepted = accepted;
    }

}
