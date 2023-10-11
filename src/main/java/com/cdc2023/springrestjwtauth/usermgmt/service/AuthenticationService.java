package com.cdc2023.springrestjwtauth.usermgmt.service;

import com.cdc2023.springrestjwtauth.usermgmt.model.request.SignInRequest;
import com.cdc2023.springrestjwtauth.usermgmt.model.request.SignUpRequest;
import com.cdc2023.springrestjwtauth.usermgmt.model.response.JwtAuthResponse;

public interface AuthenticationService {
    JwtAuthResponse signup(SignUpRequest request);

    JwtAuthResponse signin(SignInRequest request);
}
