package com.filmvee.moviefinder.domain.service;

import com.filmvee.moviefinder.entities.User;
import com.filmvee.moviefinder.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserAuthService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepo.findByEmail(username);
        try {
            return buildUserDetails(user);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }
    public UserDetails buildUserDetails(User user) {
        return org.springframework.security.core.userdetails.User.builder().username(user.getEmail())
                .password(user.getPassword())
                .authorities(buildAuthorities(user.getRole().getRole())).build();
    }
    public List<GrantedAuthority> buildAuthorities(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}
