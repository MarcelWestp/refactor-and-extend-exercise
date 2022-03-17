package com.purchaseauto.api.services;

import com.purchaseauto.api.AcceptanceRuleList;
import com.purchaseauto.api.entities.AcceptanceRule;
import com.purchaseauto.api.entities.Automobile;
import com.purchaseauto.api.entities.Make;
import com.purchaseauto.api.repositories.AcceptanceRulesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AutoValidatorTest {

    AutoValidator autoValidator;

    @Mock
    AcceptanceRulesRepository acceptanceRulesRepository;

    @BeforeEach
    void setUp() {
        autoValidator = new AutoValidator(acceptanceRulesRepository);
    }

    @Test
    void validateAuto_make_year_returnsTrue() throws Exception {
        // Arrage
        Make make = new Make("mazda");
        Automobile mazda = new Automobile(make, 1999);
        List<AcceptanceRule> list = new ArrayList<>();
        list.add(new AcceptanceRule("mazda", 2006, 2022));
        list.add(new AcceptanceRule("mazda", 1970, 1999));

        when(acceptanceRulesRepository.findByMake(any(Make.class))).thenReturn(new AcceptanceRuleList(list));
        // Act
        boolean result = autoValidator.validateAuto(mazda.getMake(), mazda.getYear());
        // Assert
        assertTrue(result);
    }

    @Test
    void validateAuto_make_year_returnsFalse() throws Exception {
        // Arrage
        Make make = new Make("mazda");
        Automobile mazda = new Automobile(make, 1999);
        List<AcceptanceRule> list = new ArrayList<>();
        list.add(new AcceptanceRule("mazda", 2006, 2022));
        list.add(new AcceptanceRule("mazda", 1970, 1998));

        when(acceptanceRulesRepository.findByMake(any(Make.class))).thenReturn(new AcceptanceRuleList(list));
        // Act
        boolean result = autoValidator.validateAuto(mazda.getMake(), mazda.getYear());
        // Assert
        assertFalse(result);
    }

    @Test
    void validateAuto_noValidMake_returnsFalse() throws Exception {
        // Arrage
        Make make = new Make("mazda");
        Automobile mazda = new Automobile(make, 1999);
        when(acceptanceRulesRepository.findByMake(any(Make.class))).thenReturn(new AcceptanceRuleList());
        // Act
        boolean result = autoValidator.validateAuto(mazda.getMake(), mazda.getYear());
        // Assert
        assertFalse(result);
    }

    @Test
    void validateAuto_makeFromStringIsNull_returnsFalse() throws Exception {
        // Act
        boolean result = autoValidator.validateAuto(null, 1999);
        // Assert
        assertFalse(result);
    }

}