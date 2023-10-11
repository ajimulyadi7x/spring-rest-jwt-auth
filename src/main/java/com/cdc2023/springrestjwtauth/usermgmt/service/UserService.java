package com.cdc2023.springrestjwtauth.usermgmt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
}
