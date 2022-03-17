package com.purchaseauto.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.purchaseauto.api.entities.AcceptanceRule;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AcceptanceRuleList {

    private List<AcceptanceRule> acceptanceRules;

    @JsonIgnore
    public boolean isEmpty() {
        return this.acceptanceRules == null || this.acceptanceRules.isEmpty();
    }


}
