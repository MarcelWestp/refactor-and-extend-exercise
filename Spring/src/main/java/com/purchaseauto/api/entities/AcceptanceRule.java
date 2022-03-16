package com.purchaseauto.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "AcceptanceRules")
public class AcceptanceRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String make;
    private int fromYear;
    private int toYear;

    public AcceptanceRule(String make, int fromYear, int toYear) {
        this.make = make;
        this.fromYear = fromYear;
        this.toYear = toYear;
    }

}
