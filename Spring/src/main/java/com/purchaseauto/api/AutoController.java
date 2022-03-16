package com.purchaseauto.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutoController {

    AutoValidator autoValidator;

    public AutoController(AutoValidator autoValidator) {
        this.autoValidator = autoValidator;
    }

    @GetMapping("validate/{make}/{year}")
    public ResponseEntity<Automobile> validAuto(@PathVariable String make, @PathVariable int year) {
        if (String.valueOf(year).length() < 4)
            return ResponseEntity.badRequest().build();

        boolean isValid = autoValidator.validateAuto(make, year);
        return ResponseEntity.ok(new Automobile(make, year, isValid));
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
