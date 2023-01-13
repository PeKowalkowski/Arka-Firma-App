package com.example.arkaFirmaApp.repositories;

import com.example.arkaFirmaApp.entities.Role;
import com.example.arkaFirmaApp.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    Role findAllByName(RoleEnum roleEnum);

}
