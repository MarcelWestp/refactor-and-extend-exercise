package com.purchaseauto.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        return new Automobile(make, year, isValid);
    }

    @GetMapping(value = {"validate/{value}", "validate"})
    public ResponseEntity<Automobile> invalidAuto(@PathVariable(required = false) String value) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void InvalidAutoFormExceptionHandler(InvalidAutoFormException e) {
    }

}
