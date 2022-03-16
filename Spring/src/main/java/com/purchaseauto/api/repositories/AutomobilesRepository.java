package com.purchaseauto.api.repositories;

import com.purchaseauto.api.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileRepository extends JpaRepository<Automobile, Integer> {



}
