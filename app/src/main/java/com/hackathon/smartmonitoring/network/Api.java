package com.hackathon.smartmonitoring.network;



import com.hackathon.smartmonitoring.network.request.LoginRequest;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET(Const.HEAD_URL)
    Observable<LoginRequest> loginPerson(@Query("login") String login, @Query("password") String password);  //todo example
}
