package com.example.arkaFirmaApp.repositories;

import com.example.arkaFirmaApp.entities.Technologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologistRepository extends JpaRepository<Long, Technologist> {
}
