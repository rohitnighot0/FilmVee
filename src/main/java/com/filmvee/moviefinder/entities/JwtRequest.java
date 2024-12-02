package com.filmvee.moviefinder.entities;

import lombok.*;

@Data
public class JwtRequest {
    private String email;
    private String password;

    public JwtRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
