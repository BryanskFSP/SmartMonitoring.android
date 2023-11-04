package com.hackathon.smartmonitoring.presenter;

import com.hackathon.smartmonitoring.model.DataBaseModel;
import com.hackathon.smartmonitoring.network.response.LogsResponse;
import com.hackathon.smartmonitoring.view.InfoErrorView;

import java.util.List;

import rx.Subscriber;

public class InfoErrorPresenter {
    public InfoErrorView view;
    public DataBaseModel model = new DataBaseModel();

    public InfoErrorPresenter(InfoErrorView view) {
        this.view = view;
    }

    public void getInfoError(String id){
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
                for(int i = 0 ; i < logsResponses.size(); i++){
                    if (logsResponses.get(i).getId().equals(id)){
                        view.showInfo(logsResponses.get(i));
                    }
                }

            }
        });
    }

}
