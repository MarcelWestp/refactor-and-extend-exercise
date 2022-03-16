package com.purchaseauto.api;

import com.purchaseauto.api.entities.AcceptanceRule;
import com.purchaseauto.api.entities.Automobile;
import com.purchaseauto.api.services.AcceptanceRuleService;
import com.purchaseauto.api.services.AutoValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class AutoController {

    AutoValidator autoValidator;
    AcceptanceRuleService acceptanceRuleService;

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

    @PostMapping("rule")
    public AcceptanceRule addAcceptanceRule(@RequestBody AcceptanceRule acceptanceRule) {
      return acceptanceRuleService.addAcceptanceRule(acceptanceRule);
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
