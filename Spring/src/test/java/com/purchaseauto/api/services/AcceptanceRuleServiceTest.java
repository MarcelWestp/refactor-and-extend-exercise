package com.purchaseauto.api.services;

import com.purchaseauto.api.AcceptanceRuleList;
import com.purchaseauto.api.InvalidAcceptanceRuleException;
import com.purchaseauto.api.entities.AcceptanceRule;
import com.purchaseauto.api.entities.Make;
import com.purchaseauto.api.repositories.AcceptanceRulesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AcceptanceRuleServiceTest {

    AcceptanceRuleService acceptanceRuleService;

    @Mock
    AcceptanceRulesRepository acceptanceRulesRepository;



    @BeforeEach
    void setUp() {
        acceptanceRuleService = new AcceptanceRuleService(acceptanceRulesRepository);
    }

    @Test
    void getAcceptanceRules_noParam_returnsAcceptanceRuleList() throws Exception {
        // Arrange
        List<AcceptanceRule> ruleList = Arrays.asList(
                new AcceptanceRule(new Make("mazda"), 1998, 2002),
                new AcceptanceRule(new Make("mazda"), 2009, 2021),
                new AcceptanceRule(new Make("toyota"), 1998, 2013)
        );
        when(acceptanceRulesRepository.findAll()).thenReturn(ruleList);
        // Act
        AcceptanceRuleList result = acceptanceRuleService.getAcceptanceRules();
        // Assert
        assertEquals(ruleList, result.getAcceptanceRules());
    }

    @Test
    void getAcceptanceRules_noParam_returnsEmptyAcceptanceRuleList() throws Exception {
        // Arrange
        List<AcceptanceRule> ruleList = new ArrayList<>();
        when(acceptanceRulesRepository.findAll()).thenReturn(ruleList);
        // Act
        AcceptanceRuleList result = acceptanceRuleService.getAcceptanceRules();
        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    void addAcceptanceRule_make_fromYear_toYear_returnsAcceptanceRule() throws Exception {
        // Arrange
        Make make = new Make("mazda");
        AcceptanceRule rule = new AcceptanceRule(make, 1999, 2013);
        when(acceptanceRulesRepository.save(rule)).thenReturn(rule);
        // Act
        AcceptanceRule result = acceptanceRuleService.addAcceptanceRule(rule);
        // Assert
        assertEquals(rule, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"mazda,1999,0", "mazda,0,2013", "'',1999,2013", "mazda, 2013, 1997"})
    void addAcceptanceRule_missingParam_throwsInvalidAcceptanceRuleException(String makeString, int fromYear, int toYear) throws Exception {
        // Arrange
//        makeString = makeString.isEmpty() ? "" : makeString;
       Make make = new Make(makeString);
        AcceptanceRule acceptanceRule = new AcceptanceRule(make, fromYear, toYear);
        // Act // Assert
        Throwable exception = assertThrows(InvalidAcceptanceRuleException.class, () -> {
            acceptanceRuleService.addAcceptanceRule(acceptanceRule);
        }, "Exception was expected");
        assertEquals("invalid acceptance rule", exception.getMessage());
    }

    @Test
    void deleteAcceptanceRule_validId_returnsAcceptanceRule() throws Exception {
        // Arrange
        Make make = new Make("mazda");
        AcceptanceRule rule = new AcceptanceRule(make, 1999, 2013);
        when(acceptanceRulesRepository.deleteById(anyInt())).thenReturn(rule);
        // Act
        AcceptanceRule result = acceptanceRuleService.deleteAcceptanceRule(1);
        // Assert
        assertEquals(rule, result);
    }

    @Test
    void deleteAcceptanceRule_invalidId_returnsNull() throws Exception {
        // Arrange
        when(acceptanceRulesRepository.deleteById(anyInt())).thenReturn(null);
        // Act
        AcceptanceRule result = acceptanceRuleService.deleteAcceptanceRule(1);
        // Assert
        assertNull(result);
    }

}