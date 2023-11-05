package com.hackathon.smartmonitoring.presenter;

import com.hackathon.smartmonitoring.model.DataBaseModel;
import com.hackathon.smartmonitoring.network.response.FixResponse;
import com.hackathon.smartmonitoring.network.response.LogFullResponse;
import com.hackathon.smartmonitoring.network.response.LogsResponse;
import com.hackathon.smartmonitoring.util.SharedPref;
import com.hackathon.smartmonitoring.view.GetLogView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import rx.Subscriber;

public class GetLogPresenter {
    private GetLogView view;
    public DataBaseModel model = new DataBaseModel();

    public GetLogPresenter(GetLogView view) {
        this.view = view;
    }

    public void getLogs(){
        model.getLog().subscribe(new Subscriber<List<LogsResponse>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(List<LogsResponse> logsResponses) {
                List<LogsResponse> data = new ArrayList<>();
                Collections.reverse(logsResponses);
                logsResponses.subList(0, 15);
                for(int i = 0 ; i < logsResponses.size(); i++){
                    if(logsResponses.get(i)!=null)
                        data.add(logsResponses.get(i));
                    }
                    getNameDb();
                    view.getLogsFromService(data);
                }
               // view.getLogsFromService(data);

        });
    }

    private void getNameDb(){
        model.getLogFull().subscribe(new Subscriber<List<LogFullResponse>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(List<LogFullResponse> logFullResponses) {
                Collections.reverse(logFullResponses);
                SharedPref.setNameDataBase(logFullResponses.get(0).getDataBase().getName());
            }
        });
    }

    public void fixAllError(String id){
        model.fixFull(id).subscribe(new Subscriber<FixResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(FixResponse fixResponse) {
                view.errorMessage(fixResponse.getNane());
            }
        });
    }
}
