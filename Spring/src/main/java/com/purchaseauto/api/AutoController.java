package com.purchaseauto.api;

import com.purchaseauto.api.entities.AcceptanceRule;
import com.purchaseauto.api.entities.Automobile;
import com.purchaseauto.api.entities.Make;
import com.purchaseauto.api.services.AcceptanceRuleService;
import com.purchaseauto.api.services.AutoValidator;
import com.purchaseauto.api.services.MakeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class AutoController {

    MakeService makeService;
    AutoValidator autoValidator;
    AcceptanceRuleService acceptanceRuleService;

    @GetMapping("validate/{make}/{year}")
    public ResponseEntity<String> validAuto(@PathVariable String make, @PathVariable int year) {
        if (String.valueOf(year).length() < 4)
            return ResponseEntity.badRequest().build();

        Make makeFromString = makeService.getMakeFromString(make);
        boolean isValid = autoValidator.validateAuto(makeFromString, year);

        String json = String.format("{\"make\": %1$s, \"year\": %2$d, \"accepted\": %3$b}", make, year, isValid);
        return ResponseEntity.ok(json);
    }

    @GetMapping(value = {"validate/{value}", "validate"})
    public ResponseEntity<Automobile> invalidAuto(@PathVariable(required = false) String value) {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("rules")
    public AcceptanceRuleList getAcceptanceRules() {
        return acceptanceRuleService.getAcceptanceRules();
    }

    @PostMapping("rule")
    public AcceptanceRule addAcceptanceRule(@RequestBody AcceptanceRule acceptanceRule) {

        return acceptanceRuleService.addAcceptanceRule(acceptanceRule);
    }

    @DeleteMapping("rule/{id}")
    public ResponseEntity<AcceptanceRule> deleteAcceptanceRule(@PathVariable int id) {
        AcceptanceRule acceptanceRule = acceptanceRuleService.deleteAcceptanceRule(id);
        return acceptanceRule == null ?
                ResponseEntity.notFound().build() : ResponseEntity.ok(acceptanceRule);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void InvalidAcceptanceRuleExceptionHandler(InvalidAcceptanceRuleException e) {
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void NumberFormatExceptionHandler(NumberFormatException e) {
    }

}
