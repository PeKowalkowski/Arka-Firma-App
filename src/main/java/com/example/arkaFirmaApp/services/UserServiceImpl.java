package com.example.arkaFirmaApp.services;

import com.example.arkaFirmaApp.entities.Registration;
import com.example.arkaFirmaApp.entities.Role;
import com.example.arkaFirmaApp.entities.User;
import com.example.arkaFirmaApp.enums.RoleEnum;
import com.example.arkaFirmaApp.repositories.RoleRepository;
import com.example.arkaFirmaApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public User save(Registration registration){
        User user = new User(registration.getFirstname(), registration.getLastname(), registration. getLogin(),
                passwordEncoder.encode(registration.getPassword()), Arrays.asList(new Role(RoleEnum.ROLE_USER)));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        if(user == null){
            throw new UsernameNotFoundException("Niepoprawny login lub hasło");
        }
        return new com.example.arkaFirmaApp.services.UserDetails(user);
    }
    public Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.userRepository.findAll(pageable);
    }
}
