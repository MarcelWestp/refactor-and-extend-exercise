package com.purchaseauto.api.repositories;

import com.purchaseauto.api.entities.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobilesRepository extends JpaRepository<Automobile, Integer> {



}
