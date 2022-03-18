package com.purchaseauto.api.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Makes")
@Getter
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*@OneToMany
    @JoinColumn(name = "make_id")
    private Set<Automobile> automobiles;*/
    @Column(unique = true)
    private String name;

    public Make(String name) {
        this.name = name;
    }

    public Make() {

    }
}
