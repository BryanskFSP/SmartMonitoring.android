package com.hackathon.smartmonitoring.network.request;

public class LoginRequest {
    final private String login;
    final private String password;

    public LoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
