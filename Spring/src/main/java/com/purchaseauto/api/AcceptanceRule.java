package com.purchaseauto.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AcceptanceRule {

    private String make;
    private int fromYear;
    private int toYear;

}
