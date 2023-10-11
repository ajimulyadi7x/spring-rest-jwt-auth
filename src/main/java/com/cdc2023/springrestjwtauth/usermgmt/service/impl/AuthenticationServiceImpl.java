package com.cdc2023.springrestjwtauth.usermgmt.service.impl;

import com.cdc2023.springrestjwtauth.usermgmt.entiity.Role;
import com.cdc2023.springrestjwtauth.usermgmt.entiity.User;
import com.cdc2023.springrestjwtauth.usermgmt.model.request.SignInRequest;
import com.cdc2023.springrestjwtauth.usermgmt.model.request.SignUpRequest;
import com.cdc2023.springrestjwtauth.usermgmt.model.response.JwtAuthResponse;
import com.cdc2023.springrestjwtauth.usermgmt.repository.UserRepository;
import com.cdc2023.springrestjwtauth.usermgmt.service.AuthenticationService;
import com.cdc2023.springrestjwtauth.usermgmt.service.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository  userRepository;
    private final PasswordEncoder       passwordEncoder;
    private final JwtService            jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    @Transactional
    public JwtAuthResponse signup(SignUpRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).recordStatusId(1).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmailAndRecordStatusId(request.getEmail(), 1)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(jwt).build();
    }
}
