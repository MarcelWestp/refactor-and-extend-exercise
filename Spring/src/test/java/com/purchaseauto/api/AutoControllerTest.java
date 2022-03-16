package com.purchaseauto.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AutoController.class)
class AutoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AutoValidator autoValidator;

    @Test
    void validateAuto_make_year_returnsAcceptedAuto() throws Exception {
        // Arrage
        Mockito.when(autoValidator.validateCar(ArgumentMatchers.any(Automobile.class))).thenReturn(true);

        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/validate/mazda/99"))
        // Assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accepted").value(true));

       /* // Arrange
        List<Automobile> automobiles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            automobiles.add(new Automobile(1967 + i, "Ford", "Mustang", "AABB" + i));
        }
        when(autosService.getAutos()).thenReturn(new AutosList(automobiles));

        // Act
        mockMvc.perform(get("/api/autos"))
                // Assert
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.automobiles", hasSize(5)));*/
    }





}