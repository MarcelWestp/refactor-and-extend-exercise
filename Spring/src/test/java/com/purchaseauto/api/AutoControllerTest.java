package com.purchaseauto.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.purchaseauto.api.entities.AcceptanceRule;
import com.purchaseauto.api.entities.Make;
import com.purchaseauto.api.services.AcceptanceRuleService;
import com.purchaseauto.api.services.AutoValidator;
import com.purchaseauto.api.services.MakeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

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

    @MockBean
    AcceptanceRuleService acceptanceRuleService;

    @MockBean
    MakeService makeService;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void validAuto_make_year_returnsAcceptedAuto() throws Exception {
        // Arrage
        when(makeService.getMakeFromString(anyString())).thenReturn(new Make("mazda"));
        when(autoValidator.validateAuto(any(Make.class), anyInt())).thenReturn(true);
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
        when(makeService.getMakeFromString(anyString())).thenReturn(new Make("mazda"));
        when(autoValidator.validateAuto(any(Make.class), anyInt())).thenReturn(false);

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

    @Test
    void getAcceptanceRules_noParam_returnsAcceptanceRuleList() throws Exception {
        // Arrage
        AcceptanceRuleList ruleList = new AcceptanceRuleList(
                Arrays.asList(
                        new AcceptanceRule("mazda", 1998, 2002),
                        new AcceptanceRule("mazda", 2009, 2021),
                        new AcceptanceRule("toyota", 1998, 2013)
                ));
        when(acceptanceRuleService.getAcceptanceRules()).thenReturn(ruleList);
        // Act
        mockMvc.perform(get("/rules"))
                // Assert
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.acceptanceRules").isArray())
                .andDo(print());
    }

    @Test
    void getAcceptanceRules_noParam_returnsEmptyList() throws Exception {
        // Arrage
        when(acceptanceRuleService.getAcceptanceRules()).thenReturn(new AcceptanceRuleList());
        // Act
        mockMvc.perform(get("/rules"))
                // Assert
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.acceptanceRules").isEmpty())
                .andDo(print());
    }

    @Test
    void addAcceptanceRule_make_fromYear_toYear_returnsAcceptanceRule() throws Exception {
        // Arrage
        AcceptanceRule acceptanceRule = new AcceptanceRule("mazda", 1998, 2013);
        when(acceptanceRuleService.addAcceptanceRule(any(AcceptanceRule.class))).thenReturn(acceptanceRule);

        String json = mapper.writeValueAsString(acceptanceRule);
        // Act
        mockMvc.perform(post("/rule")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                // Assert
                .andExpect(status().isOk())
                .andExpect(jsonPath("make").value(acceptanceRule.getMake()))
                .andDo(print());
    }

    @Test
    void addAcceptanceRule_make_fromYear_returnsBadRequest() throws Exception {
        // Arrage
        String json = "{\"make\": \"mazda\", \"fromYear\": 1999}";
        when(acceptanceRuleService.addAcceptanceRule(any(AcceptanceRule.class))).thenThrow(InvalidAcceptanceRuleException.class);

        // Act
        mockMvc.perform(post("/rule")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                // Assert
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    void deleteAcceptanceRule_validId_returnsAcceptanceRule() throws Exception {
        // Arrage
        AcceptanceRule acceptanceRule = new AcceptanceRule("mazda", 1999, 2013);
        when(acceptanceRuleService.deleteAcceptanceRule(anyInt())).thenReturn(acceptanceRule);
        String json = mapper.writeValueAsString(acceptanceRule);

        // Act
        mockMvc.perform(delete("/rule/1"))
                // Assert
                .andExpect(status().isOk())
                .andExpect(content().json(json))
                .andDo(print());
    }

    @Test
    void deleteAcceptanceRule_invalidId_returnsNotFound() throws Exception {
        // Arrage
        when(acceptanceRuleService.deleteAcceptanceRule(anyInt())).thenReturn(null);

        // Act
        mockMvc.perform(delete("/rule/22"))
                // Assert
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void deleteAcceptanceRule_invalidUrl_returnsBadRequest() throws Exception {
        // Act
        mockMvc.perform(delete("/rule/aa"))
                // Assert
                .andExpect(status().isBadRequest());
    }

}