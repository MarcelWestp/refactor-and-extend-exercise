package com.purchaseauto.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AutoController.class)
class AutoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AutoValidator autoValidator;

    @Test
    void validAuto_make_year_returnsAcceptedAuto() throws Exception {
        // Arrage
        when(autoValidator.validateAuto(anyString(), anyInt())).thenReturn(true);

        // Act
        mockMvc.perform(get("/validate/mazda/1999"))
                // Assert
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accepted").value(true))
                .andDo(print());
    }

    @Test
    void validAuto_make_year_returnsNotAcceptedAuto() throws Exception {
        // Arrage
        when(autoValidator.validateAuto(anyString(), anyInt())).thenReturn(false);

        // Act
        mockMvc.perform(get("/validate/mazda/1966"))
                // Assert
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accepted").value(false))
                .andDo(print());
    }

    @Test
    void invalidAuto_make_returnsBadRequest() throws Exception {
        // Act
        mockMvc.perform(get("/validate/mazda"))
                // Assert
                .andExpect(status().isBadRequest());
    }

    @Test
    void invalidAuto_noParams_returnsBadRequest() throws Exception {
        // Act
        mockMvc.perform(get("/validate"))
                // Assert
                .andExpect(status().isBadRequest());
    }

    @Test
    void invalidAuto_invalidYear_returnsBadRequest() throws Exception {
        // Act
        mockMvc.perform(get("/validate/mazda/202a"))
                // Assert
                .andExpect(status().isBadRequest());
    }

    @Test
    void invalidAuto_invalidTwoDigitYear_returnsBadRequest() throws Exception {
        // Act
        mockMvc.perform(get("/validate/mazda/98"))
                // Assert
                .andExpect(status().isBadRequest());
    }

}