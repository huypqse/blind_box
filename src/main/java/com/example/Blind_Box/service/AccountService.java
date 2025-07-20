package com.example.Blind_Box.service;

import com.example.Blind_Box.pojo.request.LoginRequest;
import com.example.Blind_Box.pojo.response.LoginResponse;

public interface AccountService {
    LoginResponse login(LoginRequest loginRequest);
}
