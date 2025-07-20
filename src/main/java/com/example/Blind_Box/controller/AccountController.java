package com.example.Blind_Box.controller;

import com.example.Blind_Box.pojo.request.LoginRequest;
import com.example.Blind_Box.pojo.response.LoginResponse;
import com.example.Blind_Box.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // Create a request object
        loginRequest.setEmail(loginRequest.getEmail());
        loginRequest.setPassword(loginRequest.getPassword());

        // Call the service to perform the login
        LoginResponse response = accountService.login(loginRequest);

        // Return the response entity
        return ResponseEntity.ok(response);
    }
}
