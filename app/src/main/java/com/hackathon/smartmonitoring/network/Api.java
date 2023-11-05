package com.hackathon.smartmonitoring.network;



import com.hackathon.smartmonitoring.network.response.DataBaseResponse;
import com.hackathon.smartmonitoring.network.response.FixResponse;
import com.hackathon.smartmonitoring.network.response.KillLogResponse;
import com.hackathon.smartmonitoring.network.response.LogFullResponse;
import com.hackathon.smartmonitoring.network.response.LoginPasswordData;
import com.hackathon.smartmonitoring.network.response.LoginResponse;
import com.hackathon.smartmonitoring.network.response.LogsResponse;

import java.util.List;

import retrofit2.http.Body;
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

    @POST(Const.AUTH)
    Observable<LoginResponse> getUserAuth(@Body LoginPasswordData data);

    @POST(Const.CHECK_FULL)
    Observable<FixResponse> checkFull(@Path("id") String id);

    @POST(Const.CHECK_MEMORY)
    Observable<FixResponse> checkMemory(@Path("id") String id);

    @POST(Const.CHECK_STATES)
    Observable<FixResponse> checkStates(@Path("id") String id);
    @POST(Const.CHECK_CHAHINGRATIO)
    Observable<FixResponse> checkChachingratio(@Path("id") String id);

    @POST(Const.CHECK_CHAHINGR_INDEX)
    Observable<FixResponse> checkChachingratioIndex(@Path("id") String id);

    @POST(Const.FIX_FULL)
    Observable<FixResponse> fixFull(@Path("id") String id);

    @GET(Const.GET_DB_ON_ID)
    Observable<List<DataBaseResponse>> getDataBase();

}
