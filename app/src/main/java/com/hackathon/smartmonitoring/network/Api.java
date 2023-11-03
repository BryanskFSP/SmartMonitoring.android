package com.hackathon.smartmonitoring.network;



import com.hackathon.smartmonitoring.network.request.LoginRequest;
import com.hackathon.smartmonitoring.network.response.LogsResponse;

import java.util.List;

import rx.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET(Const.LOGS)
    Observable<LogsResponse> getAddressForDialog(@Query("query") String query);
    @GET(Const.LOGS)
    Observable<List<LogsResponse>> getLogs();
}
