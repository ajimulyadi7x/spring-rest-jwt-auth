package com.cdc2023.springrestjwtauth.usermgmt.service.impl;

import com.cdc2023.springrestjwtauth.usermgmt.repository.UserRepository;
import com.cdc2023.springrestjwtauth.usermgmt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmailAndRecordStatusId(username, 1)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
            }
        };
    }
}
