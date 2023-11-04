package com.hackathon.smartmonitoring.network;



import com.hackathon.smartmonitoring.network.response.KillLogResponse;
import com.hackathon.smartmonitoring.network.response.LogFullResponse;
import com.hackathon.smartmonitoring.network.response.LoginPasswordData;
import com.hackathon.smartmonitoring.network.response.LoginResponse;
import com.hackathon.smartmonitoring.network.response.LogsResponse;

import java.util.List;

import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET(Const.LOGS)
    Observable<List<LogsResponse>> getLogs();
    @POST("log/{id}")
    Observable<KillLogResponse> fixProcess(@Path("id") String id);

    @GET(Const.FULL_LOG_WITH_INFO)
    Observable<List<LogFullResponse>> getLogFull();

    @GET(Const.AUTH)
    Observable<LoginResponse> getUserAuth(LoginPasswordData data);
}
