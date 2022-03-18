package com.purchaseauto.api;

import com.purchaseauto.api.entities.AcceptanceRule;
import com.purchaseauto.api.entities.Automobile;
import com.purchaseauto.api.entities.Make;
import com.purchaseauto.api.repositories.AcceptanceRulesRepository;
import com.purchaseauto.api.repositories.AutomobilesRepository;
import com.purchaseauto.api.repositories.MakesRepository;
import com.purchaseauto.api.repositories.UsersRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations= "classpath:application-test.properties")
class ApiApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    AcceptanceRulesRepository acceptanceRulesRepository;
    AutomobilesRepository automobilesRepository;
    MakesRepository ResponseEntity;
    com.purchaseauto.api.repositories.UsersRepository UsersRepository;


    List<AcceptanceRule> acceptedRules;
    List<Automobile> testAutos;

    @BeforeEach
    void setUp() {
        acceptedRules = new ArrayList<>();
        testAutos = new ArrayList<>();
        generateRandomData();
    }

    @Test
	void contextLoads() {
	}

    private void generateRandomData() {
        acceptedRules = Arrays.asList(
                new AcceptanceRule(new Make("mazda"), 1998, 2002),
                new AcceptanceRule(new Make("mazda"), 2009, 2021),
                new AcceptanceRule(new Make("toyota"), 1998, 2013)
        );
//        acceptanceRulesRepository.saveAll(acceptanceRules);



    }


}
