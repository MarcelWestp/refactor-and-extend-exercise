package com.purchaseauto.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AcceptanceRule {

    private String make;
    private int fromYear;
    private int toYear;

}
