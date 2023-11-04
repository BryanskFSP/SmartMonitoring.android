package com.hackathon.smartmonitoring.presenter;

import com.hackathon.smartmonitoring.model.DataBaseModel;
import com.hackathon.smartmonitoring.network.response.LoginPasswordData;
import com.hackathon.smartmonitoring.network.response.LoginResponse;
import com.hackathon.smartmonitoring.objects.TokenStorage;
import com.hackathon.smartmonitoring.util.SharedPref;
import com.hackathon.smartmonitoring.view.LoginView;

import rx.Subscriber;

public class LoginPresenter {
    private LoginView view;
    public DataBaseModel model = new DataBaseModel();

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    public void loginPerson(String login, String password){
        model.authUser(login, password).subscribe(new Subscriber<LoginResponse>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(LoginResponse loginResponse) {
                if(loginResponse.getStatus()){
                    SharedPref.setAuthUser(true);
                    TokenStorage.INSTANCE.setToken(loginResponse.getToken());
                    System.out.println("------------token" + loginResponse.getToken());
                    SharedPref.setToken(loginResponse.getToken());
                    SharedPref.setIdDataBase(loginResponse.getData().getEntityJSON().getId());
                    view.successMessage("вы успешо авторизировались");
                }
            }
        });

    }
}
