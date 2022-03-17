package com.purchaseauto.api.services;

import com.purchaseauto.api.AcceptanceRuleList;
import com.purchaseauto.api.entities.AcceptanceRule;
import com.purchaseauto.api.entities.Make;
import com.purchaseauto.api.repositories.AutomobilesRepository;
import com.purchaseauto.api.repositories.MakesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MakeServiceTest {

    MakeService makeService;

    @Mock
    MakesRepository makesRepository;

    @BeforeEach
    void setUp() {
        makeService = new MakeService(makesRepository);
    }

    @Test
    void getMake_name_returnsMake() throws Exception {
        // Arrange
        Make make = new Make("mazda");
        when(makesRepository.findByName(anyString())).thenReturn(make);
        // Act
        Make result = makeService.getMakeFromString("mazda");
        // Assert
        assertEquals(make, result);
    }

    @Test
    void getMake_nameNotExists_returnsNull() throws Exception {
        // Arrange
        when(makesRepository.findByName(anyString())).thenReturn(null);
        // Act
        Make result = makeService.getMakeFromString("mazda");
        // Assert
        assertNull(result);
    }

}