package com.example.arkaFirmaApp.entities;

import com.example.arkaFirmaApp.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    public Role() {
    }

    public Role(RoleEnum name) {
        this.name = RoleEnum.valueOf(String.valueOf(name));
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public RoleEnum getName() {
        return RoleEnum.valueOf(String.valueOf(name));
    }
    public void setName(RoleEnum name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "" + name;
    }
}
