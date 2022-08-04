package com.example.arkaFirmaApp.repositories;

import com.example.arkaFirmaApp.entities.MainProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainProjectRepository extends JpaRepository<MainProject, Long> {

}
