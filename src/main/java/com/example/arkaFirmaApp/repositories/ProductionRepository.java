package com.example.arkaFirmaApp.repositories;

import com.example.arkaFirmaApp.entities.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {
}
