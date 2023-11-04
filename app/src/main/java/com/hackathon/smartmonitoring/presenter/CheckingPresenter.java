package com.hackathon.smartmonitoring.presenter;

import com.hackathon.smartmonitoring.model.DataBaseModel;
import com.hackathon.smartmonitoring.network.response.FixResponse;
import com.hackathon.smartmonitoring.view.ChekingView;

import rx.Subscriber;

public class CheckingPresenter {
    public ChekingView view;
    public DataBaseModel model = new DataBaseModel();

    public CheckingPresenter(ChekingView view) {
        this.view = view;
    }

    public void checkMemory(String id){
        model.checkMemory(id).subscribe(new Subscriber<FixResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(FixResponse fixResponse) {

            }
        });
    }
}
