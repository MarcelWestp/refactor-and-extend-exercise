package com.purchaseauto.api.repositories;

import com.purchaseauto.api.entities.Make;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakesRepository extends JpaRepository<Make, Integer> {

    Make findByName(String name);

}
