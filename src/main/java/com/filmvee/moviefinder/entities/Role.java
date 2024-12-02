package com.filmvee.moviefinder.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    @Column(unique = true)
    private String role;
    @OneToMany(mappedBy = "role", cascade = CascadeType.DETACH)
    private List<User> users;
    public Role() {
    }

    public Role(Integer roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
