package com.purchaseauto.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "Makes")
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

}
