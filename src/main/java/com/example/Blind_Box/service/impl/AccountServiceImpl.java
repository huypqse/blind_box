package com.example.Blind_Box.service.impl;

import com.example.Blind_Box.pojo.request.LoginRequest;
import com.example.Blind_Box.pojo.response.LoginResponse;
import com.example.Blind_Box.repository.AccountRepository;
import com.example.Blind_Box.security.JwtUtil;
import com.example.Blind_Box.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
     private AccountRepository accountRepository;
//    @Autowired
//     private PasswordEncoder passwordEncoder;

    @Autowired
     private JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        if (loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
            throw new IllegalArgumentException("Email and password must not be null");
        }

        var account = accountRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        if(!account.getActive()) {
            throw new IllegalArgumentException("Account is not active");
        }
//        if (!passwordEncoder.matches(loginRequest.getPassword(), account.getPassword())) {
//            throw new IllegalArgumentException("Invalid password");
//        }
        if(!loginRequest.getPassword().equals(account.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        LoginResponse response = new LoginResponse();
        response.setToken(jwtUtil.generateToken(account.getEmail()));

        return response;
    }

}
