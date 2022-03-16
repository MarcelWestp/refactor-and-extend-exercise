package com.purchaseauto.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("com.purchaseauto.api")
public class AutoController {

    AutoValidator autoValidator;

    public AutoController(AutoValidator autoValidator) {
        this.autoValidator = autoValidator;
    }

    @GetMapping("validate/{make}/{year}")
    public Automobile validAuto(@PathVariable String make, @PathVariable String year) {
        boolean isValid = autoValidator.validateCar(make, year);
        Automobile automobile = new Automobile(make, year);
        automobile.setAccepted(isValid);
        return automobile;
    }

}
