package com.example.Blind_Box.entity;

import jakarta.persistence.*;

@Entity(name = "system_accounts")
public class SystemAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AccountID;
    @Column(name = "username", length = 100, nullable = false)
    private String username;
    @Column(name = "email", length = 255, nullable = false)
    private String email;
    @Column(name = "password", length = 255, nullable = false)
    private String password;
    private Integer role;
    private Boolean isActive;

    public Integer getAccountID() {
        return AccountID;
    }

    public void setAccountID(Integer accountID) {
        AccountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}