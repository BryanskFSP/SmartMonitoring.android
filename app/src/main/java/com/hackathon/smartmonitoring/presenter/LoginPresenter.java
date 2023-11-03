package com.hackathon.smartmonitoring.presenter;

import com.hackathon.smartmonitoring.model.DataBaseModel;
import com.hackathon.smartmonitoring.view.LoginView;

public class LoginPresenter {
    private LoginView view;
    public DataBaseModel model;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    public void loginPerson(String login, String password){

    }
}
