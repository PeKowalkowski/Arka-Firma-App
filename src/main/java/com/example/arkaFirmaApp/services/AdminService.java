package com.example.arkaFirmaApp.services;

import com.example.arkaFirmaApp.entities.Role;
import com.example.arkaFirmaApp.entities.User;
import com.example.arkaFirmaApp.repositories.RoleRepository;
import com.example.arkaFirmaApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        User user = null;
        if (userOptional.isPresent()){
            user = userOptional.get();
        }else {
            throw new RuntimeException("Użytkownik o id : " + id + " nie istnieje.");
        }
        return user;
    }
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
