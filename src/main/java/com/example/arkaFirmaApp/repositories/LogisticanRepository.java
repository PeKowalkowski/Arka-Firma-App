package com.example.arkaFirmaApp.repositories;

import com.example.arkaFirmaApp.entities.Logistican;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticanRepository extends JpaRepository<Long, Logistican> {
}
