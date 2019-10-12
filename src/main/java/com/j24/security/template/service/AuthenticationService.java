package com.j24.security.template.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")) {
            return User.builder()
                    .username("admin")
                    .password("$2a$10$b3PMb.8gtGmbFIoCIYd70.wk98KVRGJbqQHDNdvVjM26GZdUgnopG")
                    .roles("ADMIN")
                    .build();
        }
        throw new UsernameNotFoundException("User not found.");
    }
}
