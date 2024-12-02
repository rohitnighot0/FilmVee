package com.filmvee.moviefinder.entities;

public class JwtResponse {
    private String username;
    private String jwtToken;

    public JwtResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
