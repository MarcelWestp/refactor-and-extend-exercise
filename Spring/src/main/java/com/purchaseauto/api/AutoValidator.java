package com.purchaseauto.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutoValidator {

    private AutoRepository autoRepository;

    public boolean validateAuto(String make, int year) {
        AcceptanceRuleList ruleList = autoRepository.findByMake(make);
        return !ruleList.isEmpty() && ruleList.getAcceptanceRuleList().stream().anyMatch(
                rule -> year >= rule.getFromYear() && year <= rule.getToYear());
    }

      /*  String make = "mazda";
        String year = "1999";
        Automobile new¸Auto = new Automobile(make, year);
        Integer numYear;
        try {
            numYear = Integer.parseInt(year);
        } catch (Exception e) {
            newAuto.setAccepted(false);
            return newAuto;
        }

        if (year.length() != 2 && year.length() != 4) {
            newAuto.setAccepted(false);
            return newAuto;
        }

        if (make.toLowerCase() == "mazda") {
            if (year.length() == 2) {
                if (numYear < 97 && numYear > 17) {
                    newAuto.setAccepted(false);
                    return newAuto;
                } else {
                    newAuto.setAccepted(true);
                    return newAuto;
                }
            } else if (year.length() == 4) {
                if (numYear < 1997) {
                    newAuto.setAccepted(false);
                    return newAuto;
                } else {
                    newAuto.setAccepted(true);
                    return newAuto;
                }
            } else {
                newAuto.setAccepted(false);
                return newAuto;
            }
        } else if (make.toLowerCase() == "toyota") {
            if (year.length() == 2) {
                if (numYear >= 6 && numYear <= 18) {
                    newAuto.setAccepted(false);
                    return newAuto;
                } else if (numYear <= 98) {
                    newAuto.setAccepted(false);
                    return newAuto;
                } else {
                    newAuto.setAccepted(true);
                    return newAuto;
                }
            } else if (year.length() == 4) {
                if (numYear >= 2006) {
                    newAuto.setAccepted(false);
                    return newAuto;
                } else if (numYear <= 1998) {
                    newAuto.setAccepted(false);
                    return newAuto;
                } else {
                    newAuto.setAccepted(true);
                    return newAuto;
                }
            } else {
                newAuto.setAccepted(false);
                return newAuto;
            }
        } else {
            newAuto.setAccepted(false);
            return newAuto;
        }
        }
        */
}
