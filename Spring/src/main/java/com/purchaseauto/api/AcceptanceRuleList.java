package com.purchaseauto.api;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcceptanceRuleList {

    private List<AcceptanceRule> acceptanceRuleList;

    public boolean isEmpty() {
        return this.acceptanceRuleList == null || this.acceptanceRuleList.isEmpty();
    }
}
