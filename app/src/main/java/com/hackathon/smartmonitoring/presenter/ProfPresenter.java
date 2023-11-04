package com.hackathon.smartmonitoring.presenter;

import com.hackathon.smartmonitoring.model.DataBaseModel;
import com.hackathon.smartmonitoring.network.response.LogFullResponse;
import com.hackathon.smartmonitoring.view.ProfView;

import java.util.List;

import rx.Subscriber;

public class ProfPresenter {

    public ProfView view;
    public DataBaseModel model = new DataBaseModel();

    public ProfPresenter(ProfView view) {
        this.view = view;
    }

    public void getFullLogInfo(){
        model.getLogFull().subscribe(new Subscriber<List<LogFullResponse>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(List<LogFullResponse> logFullResponse) {
                if(logFullResponse.get(0)!=null)
                    view.getLogInfo(logFullResponse.get(0));
            }
        });
    }
}
