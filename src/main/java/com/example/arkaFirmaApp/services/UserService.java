package com.example.arkaFirmaApp.services;

import com.example.arkaFirmaApp.entities.Registration;
import com.example.arkaFirmaApp.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(Registration registration);
}
