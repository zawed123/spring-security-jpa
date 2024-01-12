package com.security.springsecurityjpa.services;

import com.security.springsecurityjpa.model.User;
import com.security.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailsServices implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repository.findByUser(username);
        CustomeUserDetails customeUserDetails=null;
        if(user!=null) {
            customeUserDetails = new CustomeUserDetails();
            customeUserDetails.setUser(user);
        } else {
            throw new UsernameNotFoundException("User not exist with name : " + username);
        }
        return customeUserDetails;
    }
}
