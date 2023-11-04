package com.hackathon.smartmonitoring.model;

import com.hackathon.smartmonitoring.network.DataProvider;
import com.hackathon.smartmonitoring.network.response.KillLogResponse;
import com.hackathon.smartmonitoring.network.response.LoginResponse;
import com.hackathon.smartmonitoring.network.response.LogsResponse;

import java.util.List;

import rx.Observable;


public class DataBaseModel extends DataProvider {

    public Observable<List<LogsResponse>> getLog() {
        return service.getLogs().compose(applySchedulers());
    }

    public Observable<KillLogResponse> killLogProccess(String idDb){
        return service.killProcessor(idDb).compose(applySchedulers());
    }

}
