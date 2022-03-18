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
    @ManyToOne
    @JoinColumn(name="make_id", insertable = false, updatable = false)
    private Make make;
    private int year;

    @Setter
    private Boolean accepted;

    public Automobile(Make make, int year) {
        super();
        this.make = make;
        this.year = year;
    }

    public Automobile(Make make, int year, boolean accepted) {
        super();
        this.make = make;
        this.year = year;
        this.accepted = accepted;
    }

    public Automobile() {

    }
}
