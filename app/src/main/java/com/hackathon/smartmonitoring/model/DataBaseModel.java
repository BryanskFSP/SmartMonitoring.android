package com.hackathon.smartmonitoring.model;

import com.hackathon.smartmonitoring.network.DataProvider;
import com.hackathon.smartmonitoring.network.response.KillLogResponse;
import com.hackathon.smartmonitoring.network.response.LogFullResponse;
import com.hackathon.smartmonitoring.network.response.LoginPasswordData;
import com.hackathon.smartmonitoring.network.response.LoginResponse;
import com.hackathon.smartmonitoring.network.response.LogsResponse;

import java.util.List;

import rx.Observable;


public class DataBaseModel extends DataProvider {

    public Observable<List<LogsResponse>> getLog() {
        return service.getLogs().compose(applySchedulers());
    }

    public Observable<KillLogResponse> killLogProccess(String idDb){
        return service.fixProcess(idDb).compose(applySchedulers());
    }

    public Observable<List<LogFullResponse>> getLogFull(){
        return service.getLogFull().compose(applySchedulers());
    }
    public Observable<LoginResponse> authUser(LoginPasswordData data){
        return service.getUserAuth(data).compose(applySchedulers());
    }
}
