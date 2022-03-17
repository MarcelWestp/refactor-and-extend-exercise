package com.purchaseauto.api.services;

import com.purchaseauto.api.entities.Make;
import com.purchaseauto.api.repositories.MakesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MakeService {

    MakesRepository makesRepository;

    public Make getMakeFromString(String name) {
        return makesRepository.findByName(name);
    }
}
