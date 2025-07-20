package com.example.Blind_Box.config;

import com.example.Blind_Box.entity.SystemAccounts;
import com.example.Blind_Box.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (accountRepository.findAll().isEmpty()) {
            SystemAccounts adminAccount = new SystemAccounts();
            adminAccount.setEmail("admin@gmail.com");
//            adminAccount.setPassword(passwordEncoder.encode("1"));
            adminAccount.setPassword("1");
            adminAccount.setActive(true);
            adminAccount.setUsername("admin");
            adminAccount.setRole(1);
            accountRepository.save(adminAccount);
            System.out.println("Default admin account created with email: " + adminAccount.getEmail());

            SystemAccounts userAccount = new SystemAccounts();
            userAccount.setEmail("huypqse@gmail.com");
//            userAccount.setPassword(passwordEncoder.encode("1"));
            userAccount.setPassword("1");
            userAccount.setActive(true);
            userAccount.setUsername("huypqse");
            userAccount.setRole(2);
            accountRepository.save(userAccount);
        }
    }
}