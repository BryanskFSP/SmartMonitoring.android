package com.hackathon.smartmonitoring.network;



import com.hackathon.smartmonitoring.network.request.LoginRequest;
import com.hackathon.smartmonitoring.network.response.KillLogResponse;
import com.hackathon.smartmonitoring.network.response.LogsResponse;
import com.hackathon.smartmonitoring.util.SharedPref;

import java.util.List;

import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET(Const.LOGS)
    Observable<LogsResponse> getAddressForDialog(@Query("query") String query);
    @GET(Const.LOGS)
    Observable<List<LogsResponse>> getLogs();
    @POST("log/{id}")
    Observable<KillLogResponse> killProcessor(@Path("id") String id);
}
