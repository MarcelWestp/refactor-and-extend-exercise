package com.purchaseauto.api.services;

import com.purchaseauto.api.AcceptanceRuleList;
import com.purchaseauto.api.InvalidAcceptanceRuleException;
import com.purchaseauto.api.entities.AcceptanceRule;
import com.purchaseauto.api.repositories.AcceptanceRulesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AcceptanceRuleService {

    AcceptanceRulesRepository acceptanceRulesRepository;

    public AcceptanceRuleList getAcceptanceRules() {
        return new AcceptanceRuleList(acceptanceRulesRepository.findAll());
    }

    public AcceptanceRule addAcceptanceRule(AcceptanceRule acceptanceRule) {
        if (isInvalidAcceptanceRule(acceptanceRule))  {
            throw new InvalidAcceptanceRuleException("invalid acceptance rule");
        }
        return acceptanceRulesRepository.save(acceptanceRule);
    }

    private boolean isInvalidAcceptanceRule(AcceptanceRule acceptanceRule) {
        return acceptanceRule.getMake() == null || acceptanceRule.getFromYear() == 0 || acceptanceRule.getToYear() == 0
                || acceptanceRule.getToYear() < acceptanceRule.getFromYear();
    }

}
