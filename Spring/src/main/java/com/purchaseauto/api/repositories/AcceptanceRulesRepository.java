package com.purchaseauto.api.repositories;

import com.purchaseauto.api.entities.AcceptanceRule;
import com.purchaseauto.api.AcceptanceRuleList;
import com.purchaseauto.api.entities.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcceptanceRulesRepository extends JpaRepository<AcceptanceRule, Integer> {

    AcceptanceRuleList findByMake(Make make);

    AcceptanceRule deleteById(int id);

}
