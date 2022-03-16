package com.purchaseauto.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan("com.purchaseauto.api")
public class AutoController {

    AutoValidator autoValidator;

    public AutoController(AutoValidator autoValidator) {
        this.autoValidator = autoValidator;
    }

    @GetMapping("validate/{make}/{year}")
    public Automobile validAuto(@PathVariable String make, @PathVariable int year) {
        boolean isValid = autoValidator.validateAuto(make, year);
        return new Automobile(make, year, isValid);
    }

    @GetMapping(value = {"validate/{value}", "validate"})
    public ResponseEntity<Automobile> invalidAuto(@PathVariable(required = false) String value) {
        return ResponseEntity.badRequest().build();
    }

  /*  @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void InvalidAutoFormExceptionHandler(InvalidAutoFormException e) {
    }*/

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void NumberFormatExceptionHandler(NumberFormatException e) {
    }

}
