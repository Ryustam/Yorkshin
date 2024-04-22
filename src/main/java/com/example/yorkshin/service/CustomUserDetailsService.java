package com.example.yorkshin.service;

import com.example.yorkshin.model.CustomUserDetails;
import com.example.yorkshin.entity.UserEntity;
import com.example.yorkshin.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //조회
        UserEntity userData = userRepository.findByUsername(username);

        //검증
        if(userData != null){
            return new CustomUserDetails(userData);
        }
        return null;
    }
}
