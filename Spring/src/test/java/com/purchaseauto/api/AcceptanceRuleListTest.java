package com.purchaseauto.api;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AcceptanceRuleListTest {

    @Test
    void isEmpty_null_returnsTrue() {
        // Arrange
        AcceptanceRuleList ruleList = new AcceptanceRuleList();
        // Act
        boolean result = ruleList.isEmpty();
        // Assert
        assertTrue(result);
    }

    @Test
    void isEmpty_empty_returnsTrue() {
        // Arrange
        AcceptanceRuleList ruleList = new AcceptanceRuleList(new ArrayList<AcceptanceRule>());
        // Act
        boolean result = ruleList.isEmpty();
        // Assert
        assertTrue(result);
    }

    @Test
    void isEmpty_notEmpty_returnsTrue() {
        // Arrange
        List<AcceptanceRule> list = new ArrayList<>();
        list.add(new AcceptanceRule("mazda", 2006, 2022));

        AcceptanceRuleList ruleList = new AcceptanceRuleList(list);
        // Act
        boolean result = ruleList.isEmpty();
        // Assert
        assertFalse(result);
    }

}