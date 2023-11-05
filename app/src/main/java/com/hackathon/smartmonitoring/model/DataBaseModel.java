package com.hackathon.smartmonitoring.model;

import com.hackathon.smartmonitoring.network.DataProvider;
import com.hackathon.smartmonitoring.network.response.DataBaseResponse;
import com.hackathon.smartmonitoring.network.response.FixResponse;
import com.hackathon.smartmonitoring.network.response.KillLogResponse;
import com.hackathon.smartmonitoring.network.response.LogFullResponse;
import com.hackathon.smartmonitoring.network.response.LoginPasswordData;
import com.hackathon.smartmonitoring.network.response.LoginResponse;
import com.hackathon.smartmonitoring.network.response.LogsResponse;
import com.hackathon.smartmonitoring.network.response.OtchetIndexOldResponse;
import com.hackathon.smartmonitoring.network.response.OtchetIndexResponse;

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
    public Observable<LoginResponse> authUser(String login, String password){
        return service.getUserAuth(new LoginPasswordData(login, password)).compose(applySchedulers());
    }

    public Observable<FixResponse> checkMemory(String id){
        return service.checkMemory(id).compose(applySchedulers());
    }

    public Observable<FixResponse> checkStates(String id){
        return service.checkStates(id).compose(applySchedulers());
    }

    public Observable<FixResponse> checkChachingratio(String id){
        return service.checkChachingratio(id).compose(applySchedulers());
    }
    public Observable<FixResponse> checkChachingratioIndex(String id){
        return service.checkChachingratioIndex(id).compose(applySchedulers());
    }
    public Observable<FixResponse> checkFull(String id){
        return service.checkFull(id).compose(applySchedulers());
    }

    public Observable<FixResponse> fixFull(String id){
        return service.fixFull(id).compose(applySchedulers());
    }

    public Observable<List<DataBaseResponse>> getDataBase(){
        return service.getDataBase().compose(applySchedulers());
    }

    public Observable<OtchetIndexResponse> getIndexOtchet(String id){
        return service.getOtchetIndex(id).compose(applySchedulers());
    }

    public Observable<OtchetIndexOldResponse> getIndexOldOtchet(String id){
        return service.getOtcheOldIndex(id).compose(applySchedulers());
    }
}
