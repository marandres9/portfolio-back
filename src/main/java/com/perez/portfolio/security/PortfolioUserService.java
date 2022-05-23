package com.perez.portfolio.security;

import com.perez.portfolio.repository.PortfolioUserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PortfolioUserService implements UserDetailsService {
    
    @Autowired
    PortfolioUserRepository userRepo;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }
}
