package com.cdc2023.springrestjwtauth.usermgmt.controller;

import com.cdc2023.springrestjwtauth.usermgmt.model.request.SignInRequest;
import com.cdc2023.springrestjwtauth.usermgmt.model.request.SignUpRequest;
import com.cdc2023.springrestjwtauth.usermgmt.model.response.JwtAuthResponse;
import com.cdc2023.springrestjwtauth.usermgmt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signin(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
