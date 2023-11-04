package com.hackathon.smartmonitoring.presenter;

import com.hackathon.smartmonitoring.model.DataBaseModel;
import com.hackathon.smartmonitoring.network.response.LogsResponse;
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
                for(int i = 0 ; i < logsResponses.size(); i++){
                    if(logsResponses.get(i)!=null){
                        if(data.size()>25){
                            view.getLogsFromService(data);
                        } else data.add(logsResponses.get(i));
                    }
                }
               // view.getLogsFromService(data);
            }
        });
    }
}
