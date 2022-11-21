package com.example.arkaFirmaApp.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String login;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(
    name = "role_id", referencedColumnName = "id"))
    Collection<Role> roles;

    public User() {
    }

    public User(String firstname, String lastname, String login, String password, Collection<Role> roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
