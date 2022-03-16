package com.purchaseauto.api;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AcceptanceRuleList {

    private List<AcceptanceRule> acceptanceRuleList;

    public boolean isEmpty() {
        return this.acceptanceRuleList == null || this.acceptanceRuleList.isEmpty();
    }
}
