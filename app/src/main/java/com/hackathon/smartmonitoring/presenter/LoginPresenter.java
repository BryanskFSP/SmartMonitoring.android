package com.hackathon.smartmonitoring.presenter;

import com.hackathon.smartmonitoring.model.DataBaseModel;
import com.hackathon.smartmonitoring.network.response.DataBaseResponse;
import com.hackathon.smartmonitoring.network.response.LoginPasswordData;
import com.hackathon.smartmonitoring.network.response.LoginResponse;
import com.hackathon.smartmonitoring.util.SharedPref;
import com.hackathon.smartmonitoring.view.LoginView;

import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethodsIf;

import java.util.List;

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
                    SharedPref.setToken(loginResponse.getToken());
                    SharedPref.setIdDataBase(loginResponse.getData().getEntityJSON().getId());
                    getDbONUserId(loginResponse.getData().getEntityJSON().getOrganizationID());
                    view.successMessage("Успешно авторизованы");
                }
            }
        });

    }

    public  void getDbONUserId(String id){
        model.getDataBase().subscribe(new Subscriber<List<DataBaseResponse>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(List<DataBaseResponse> dataBaseResponse) {
                for(int i = 0; i < dataBaseResponse.size(); i++){
                    if(dataBaseResponse.get(i).getOrganizationID().equals(id)){
                        SharedPref.setIdDataBase(dataBaseResponse.get(i).getId());
                    }
                }
            }
        });
    }
}
